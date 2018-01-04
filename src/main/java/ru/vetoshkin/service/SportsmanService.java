package ru.vetoshkin.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.vetoshkin.bean.Sportsman;
import ru.vetoshkin.core.HikariPool;
import ru.vetoshkin.core.SystemException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;





public class SportsmanService {

    private static final Logger logger = LogManager.getLogger(SportsmanService.class);


    private SportsmanService() {
    }


    public static void saveSportsman(Sportsman sportsman) {
        throw new UnsupportedOperationException("save sportsman not supported");
    }


    public static void removeSportsman(int key) {
        throw new UnsupportedOperationException("remove sportsman not supported");
    }


    public static Sportsman getSportsman(int key) throws SystemException {
        String method = "{? = call get_sportsman_info(?)}";
        Sportsman sportsman = null;

        try (Connection connection = HikariPool.getSource().getConnection()) {
            connection.setAutoCommit(false);

            CallableStatement statement = connection.prepareCall(method);
            statement.registerOutParameter(1, Types.OTHER);
            statement.setInt(2, key);

            logger.info(method);
            statement.execute();

            ResultSet set = (ResultSet) statement.getObject(1);
            if (set.first()) {
                sportsman = createSportsman(set);
            }

            set.close();
        } catch (SQLException e) {
            throw new SystemException(e);
        }

        return sportsman;
    }


    public static List<Sportsman> getAllSportsmans() throws SystemException {
        List<Sportsman> result = new ArrayList<>();
        String method = "{? = call get_sportsmens()}";

        try (Connection connection = HikariPool.getSource().getConnection()) {
            connection.setAutoCommit(true);

            CallableStatement statement = connection.prepareCall(method);
            statement.registerOutParameter(1, Types.OTHER);

            logger.info(method);
            statement.execute();

            ResultSet set = (ResultSet) statement.getObject(1);
            while (set.next()) {
                result.add(createSportsman(set));
            }

            set.close();
        } catch (SQLException e) {
            logger.warn(e);
            throw new SystemException(e);
        }

        return result;
    }


    private static Sportsman createSportsman(ResultSet set) throws SQLException {
        Sportsman result = new Sportsman();

        result.setId(set.getInt(1));
        result.setFamily(set.getString(2));
        result.setName(set.getString(3));
        result.setWeight(set.getDouble(4));
        result.setHieght(set.getDouble(5));
        result.setBirthDay(set.getDate(6));
        result.setYearOfStart(set.getInt(7));
        result.setQualification(set.getString(8));

        return result;
    }
}
