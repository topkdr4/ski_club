package ru.vetoshkin.service;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.vetoshkin.bean.Game;
import ru.vetoshkin.bean.GameResult;
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

    public static List<Game> getGameList(long date, boolean sex, int age) throws SystemException {
        List<Game> result = new ArrayList<>();
        String method = "{? = call get_games(?, ?, ?)}";
        try (Connection connection = HikariPool.getSource().getConnection()) {
            connection.setAutoCommit(false);

            CallableStatement statement = connection.prepareCall(method);
            statement.registerOutParameter(1, Types.OTHER);
            statement.setDate(2, new Date(date));
            statement.setBoolean(3, sex);
            statement.setInt(4, age);

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


    public static List<GameResult> getSportsmans(int gameId) throws SystemException {
        try (Connection connection = HikariPool.getSource().getConnection()) {
            List<GameResult> result = new ArrayList<>();
            String method = "{? = call get_sportsmans_game(?)}";

            connection.setAutoCommit(false);
            CallableStatement statement = connection.prepareCall(method);
            statement.registerOutParameter(1, Types.OTHER);
            statement.setInt(2, gameId);

            logger.info(method);
            statement.execute();

            ResultSet set = (ResultSet) statement.getObject(1);
            while(set.next()) {
                result.add(createGameResult(set));
            }

            return result;
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }


    private static GameResult createGameResult(ResultSet set) throws SystemException {
        try {
            GameResult result = new GameResult();
            result.setFamily(set.getString(1));
            result.setSportsmanId(set.getInt(2));
            result.setJump(set.getDouble(3));

            double[] judge = new double[5];
            judge[0] = set.getDouble(4);
            judge[1] = set.getDouble(5);
            judge[2] = set.getDouble(6);
            judge[3] = set.getDouble(7);
            judge[4] = set.getDouble(8);

            result.setJudge(judge);
            result.setCompensation(set.getDouble(9));
            result.setWind(set.getDouble(10));
            result.setGameId(set.getInt(11));
            result.setResultGameId(set.getInt(12));

            return result;
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }


    public static void removeResult(int id) throws SystemException {
        try (Connection connection = HikariPool.getSource().getConnection()) {
            String method = "delete from t_games where t_games.id = " + id;
            connection.setAutoCommit(true);
            CallableStatement statement = connection.prepareCall(method);
            logger.info(method);
            statement.execute();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }


    public static void saveGame(String name, long date, boolean sex, int age) throws SystemException {
        try (Connection connection = HikariPool.getSource().getConnection()) {
            String method = "{call save_game(?, ?, ?, ?)}";
            connection.setAutoCommit(true);
            CallableStatement statement = connection.prepareCall(method);

            statement.setString(1, name);
            statement.setDate(2, new Date(date));
            statement.setBoolean(3, sex);
            statement.setInt(4, age);

            logger.info(method);
            statement.execute();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }


    public static void removeGame(int id) throws SystemException {
        try (Connection connection = HikariPool.getSource().getConnection()) {
            String method = "{call remove_game(?)}";
            connection.setAutoCommit(true);
            CallableStatement statement = connection.prepareCall(method);
            statement.setInt(1, id);

            logger.info(method);
            statement.execute();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
