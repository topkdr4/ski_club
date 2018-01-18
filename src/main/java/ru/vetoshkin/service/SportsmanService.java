package ru.vetoshkin.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.postgresql.util.PGobject;
import ru.vetoshkin.bean.Sportsman;
import ru.vetoshkin.bean.Trainer;
import ru.vetoshkin.core.HikariPool;
import ru.vetoshkin.core.SystemException;
import ru.vetoshkin.util.Jackson;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;





public class SportsmanService {

    private static final Logger logger = LogManager.getLogger(SportsmanService.class);


    private SportsmanService() {
    }


    public static void saveSportsman(Sportsman sportsman) throws SystemException {
        Service.save(sportsman, "{? = call save_sportsman(?)}");
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
            if (set.next()) {
                sportsman = createSportsman(set);
            }

            set.close();
        } catch (Exception e) {
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
        } catch (Exception e) {
            logger.warn(e);
            throw new SystemException(e);
        }

        return result;
    }


    public static Sportsman createSportsman(ResultSet set) throws Exception {
        Sportsman result = new Sportsman();

        result.setId(set.getInt(1));
        result.setFamily(set.getString(2));
        result.setName(set.getString(3));
        result.setWeight(set.getDouble(4));
        result.setHeight(set.getDouble(5));
        result.setBirthDay(set.getDate(6));
        result.setYearOfStart(set.getInt(7));
        result.setQualification(set.getString(8));
        result.setSex(set.getBoolean(9));

        String method = "select get_places(?)";

        try (Connection connection = HikariPool.getSource().getConnection()) {
            connection.setAutoCommit(true);

            CallableStatement statement = connection.prepareCall(method);
            statement.setInt(1, result.getId());

            logger.info(method);
            ResultSet resSet = statement.executeQuery();
            if (resSet.next()) {
                Integer[] array = (Integer[]) resSet.getArray(1).getArray();
                for (int i = 0; i < array.length; i++) {
                    result.setPlaces(i, array[i]);
                }
            }

            resSet.close();
        } catch (Exception e) {
            logger.warn(e);
            throw new SystemException(e);
        }

        return result;
    }


    public static List<Sportsman> getSportsmans(int from, int to) throws SystemException {
        String method = "{? = call get_sportsmans_page(?, ?)}";
        List<Sportsman> result = new ArrayList<>();

        try (Connection connection = HikariPool.getSource().getConnection()) {
            connection.setAutoCommit(false);

            CallableStatement statement = connection.prepareCall(method);
            statement.registerOutParameter(1, Types.OTHER);
            statement.setInt(2, from);
            statement.setInt(3, to);

            logger.info(method);
            statement.execute();

            ResultSet set = (ResultSet) statement.getObject(1);
            while (set.next()) {
                result.add(createSportsman(set));
            }

            set.close();
        } catch (Exception e) {
            throw new SystemException(e);
        }

        return result;
    }


    public static int getAllSportsmansCount() throws SystemException {
        return Service.getCount("{? = call get_sportsmans_count()}");
    }
}
