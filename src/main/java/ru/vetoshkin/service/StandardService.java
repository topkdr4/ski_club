package ru.vetoshkin.service;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.postgresql.util.PGobject;
import ru.vetoshkin.bean.Sportsman;
import ru.vetoshkin.bean.Standard;
import ru.vetoshkin.bean.StandardResult;
import ru.vetoshkin.core.HikariPool;
import ru.vetoshkin.core.SystemException;
import ru.vetoshkin.util.Jackson;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class StandardService {

    private static final Logger logger = LogManager.getLogger(StandardService.class);


    public static List<Standard> getAll(boolean sex, int age) throws SystemException {
        try (Connection connection = HikariPool.getSource().getConnection()) {

            String method = "{? = call get_standard(?, ?)}";
            List<Standard> result = new ArrayList<>();

            connection.setAutoCommit(false);
            CallableStatement statement = connection.prepareCall(method);
            statement.registerOutParameter(1, Types.OTHER);

            statement.setBoolean(2, sex);
            statement.setInt(3, age);

            logger.info(method);
            statement.execute();

            ResultSet set = (ResultSet) statement.getObject(1);
            while (set.next()) {
                result.add(createStandard(set));
            }

            return result;
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }


    private static Standard createStandard(ResultSet set) throws SystemException {
        try {
            Standard result = new Standard();

            result.setId(set.getInt(1));
            result.setName(set.getString(2));
            result.setRequier(set.getDouble(3));
            result.setType(set.getString(4));
            result.setDesc(set.getString(5));

            return result;
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }


    public static void removeStandard(int id) throws SystemException {
        throw new UnsupportedOperationException("");
    }


    public static void save(Standard standard, boolean sex, int age) throws SystemException {
        String method = "{? = call save_standart(?, ?, ?)}";
        try (Connection connection = HikariPool.getSource().getConnection()) {
            connection.setAutoCommit(true);

            CallableStatement statement = connection.prepareCall(method);
            statement.registerOutParameter(1, Types.INTEGER);

            PGobject jsonObject = new PGobject();
            jsonObject.setType("json");
            jsonObject.setValue(Jackson.toJson(standard));

            statement.setObject(2, jsonObject);
            statement.setBoolean(3, sex);
            statement.setInt(4, age);

            logger.info(method);
            statement.execute();

        } catch (Exception e) {
            throw new SystemException(e);
        }
    }


    public static List<StandardResult> getFiltering(int idStd, long date) throws SystemException {
        String method = "{? = call get_standard_result(?, ?)}";
        List<StandardResult> result = new ArrayList<>();
        try (Connection connection = HikariPool.getSource().getConnection()) {
            connection.setAutoCommit(false);

            CallableStatement statement = connection.prepareCall(method);
            statement.registerOutParameter(1, Types.OTHER);

            statement.setInt(2, idStd);
            statement.setDate(3, new java.sql.Date(date));

            logger.info(method);
            statement.execute();

            ResultSet set = (ResultSet) statement.getObject(1);
            while (set.next()) {
                result.add(createResult(set));
            }

            return result;
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }


    private static StandardResult createResult(ResultSet set) throws SystemException {
        try {
            StandardResult result = new StandardResult();

            Sportsman sportsman = new Sportsman();
            sportsman.setId(set.getInt(1));
            sportsman.setFamily(set.getString(2));
            sportsman.setName(set.getString(3));
            sportsman.setWeight(set.getDouble(4));
            sportsman.setHeight(set.getDouble(5));
            sportsman.setBirthDay(set.getDate(6));
            sportsman.setYearOfStart(set.getInt(7));
            sportsman.setQualification(set.getString(8));
            sportsman.setSex(set.getBoolean(9));
            result.setSportsman(sportsman);

            result.setTrainerId(set.getInt(10));
            result.setResult(set.getDouble(11));
            result.setSuccess(set.getBoolean(12));
            result.setDate(set.getDate(13));
            result.setId(set.getInt(14));

            return result;
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }


    public static List<Sportsman> getSportsmans(boolean sex, int age) throws SystemException {
        String method = "{? = call get_sportsmens_category(?, ?)}";
        List<Sportsman> result = new ArrayList<>();
        try (Connection connection = HikariPool.getSource().getConnection()) {
            connection.setAutoCommit(false);

            CallableStatement statement = connection.prepareCall(method);
            statement.registerOutParameter(1, Types.OTHER);

            statement.setBoolean(2, sex);
            statement.setInt(3, age);

            logger.info(method);
            statement.execute();

            ResultSet set = (ResultSet) statement.getObject(1);
            while (set.next()) {
                result.add(SportsmanService.createSportsman(set));
            }

            return result;
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }


    public static void removeResult(int id) throws SystemException {
        String method = "{call remove_result(?)}";
        try (Connection connection = HikariPool.getSource().getConnection()) {
            connection.setAutoCommit(true);
            CallableStatement statement = connection.prepareCall(method);
            statement.setInt(1, id);
            logger.info(method);
            statement.execute();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }


    public static void saveResult(StandardResult result) throws SystemException {
        if (result.getTrainerId() == null)
            result.setTrainerId(0);

        if (result.getId() == null)
            result.setId(0);

        try (Connection connection = HikariPool.getSource().getConnection()) {
            connection.setAutoCommit(true);
            String method = "{call save_standrard_result(?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement statement = connection.prepareCall(method);

            statement.setInt(1, result.getTrainerId());
            statement.setInt(2, result.getSportsman().getId());
            statement.setInt(3, result.getStdId());
            statement.setDouble(4, result.getResult());
            statement.setBoolean(5, result.isSuccess());
            statement.setDate(6, new java.sql.Date(result.getDate().getTime()));
            statement.setInt(7, result.getId());

            logger.info(method);
            statement.execute();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
