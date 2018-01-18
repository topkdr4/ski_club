package ru.vetoshkin.service;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.vetoshkin.bean.Game;
import ru.vetoshkin.core.HikariPool;
import ru.vetoshkin.core.SystemException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class GameService {

    private static final Logger logger = LogManager.getLogger(GameService.class);

    public static List<Game> getGameList(long date) throws SystemException {
        List<Game> result = new ArrayList<>();
        String method = "{? = call get_games(?)}";
        try (Connection connection = HikariPool.getSource().getConnection()) {
            connection.setAutoCommit(false);

            CallableStatement statement = connection.prepareCall(method);
            statement.registerOutParameter(1, Types.OTHER);
            statement.setDate(2, new Date(date));

            logger.info(method);
            statement.execute();

            ResultSet set = (ResultSet) statement.getObject(1);
            while(set.next()) {
                result.add(createGame(set));
            }

            set.close();
            return result;
        } catch (SQLException e) {
            throw new SystemException(e);
        }
    }


    private static Game createGame(ResultSet set) throws SystemException {
        try {
            Game result = new Game();
            result.setId(set.getInt(1));
            result.setName(set.getString(2));
            result.setGameDate(set.getDate(3));
            return result;
        } catch (SQLException e) {
            throw new SystemException(e);
        }
    }

}
