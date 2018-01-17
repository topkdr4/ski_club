package ru.vetoshkin.service;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.postgresql.util.PGobject;
import ru.vetoshkin.bean.Record;
import ru.vetoshkin.core.HikariPool;
import ru.vetoshkin.core.SystemException;
import ru.vetoshkin.util.Jackson;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class Service {

    private static final Logger logger = LogManager.getLogger(Service.class);

    public static void save(Object arg, String method) throws SystemException {
        try (Connection connection = HikariPool.getSource().getConnection()) {
            connection.setAutoCommit(true);

            CallableStatement statement = connection.prepareCall(method);
            statement.registerOutParameter(1, Types.INTEGER);

            PGobject jsonObject = new PGobject();
            jsonObject.setType("json");
            jsonObject.setValue(Jackson.toJson(arg));

            statement.setObject(2, jsonObject);

            logger.info(method);
            logger.info(Jackson.toJson(arg));
            statement.execute();

        } catch (Exception e) {
            throw new SystemException(e);
        }
    }


    public static int getCount(String method) throws SystemException {
        try (Connection connection = HikariPool.getSource().getConnection()) {
            connection.setAutoCommit(true);

            CallableStatement statement = connection.prepareCall(method);
            statement.registerOutParameter(1, Types.INTEGER);

            logger.info(method);
            statement.execute();

            return statement.getInt(1);

        } catch (Exception e) {
            throw new SystemException(e);
        }
    }


    public static List<Record> getRecord(String method, boolean sex) throws SystemException {
        List<Record> result = new ArrayList<>();

        try (Connection connection = HikariPool.getSource().getConnection()) {
            connection.setAutoCommit(false);

            CallableStatement statement = connection.prepareCall(method);
            statement.registerOutParameter(1, Types.OTHER);
            statement.setBoolean(2, sex);

            logger.info(method);
            statement.execute();

            ResultSet set = (ResultSet) statement.getObject(1);
            while (set.next()) {
                result.add(createRecord(set));
            }

            set.close();
        } catch (SQLException e) {
            logger.warn(e);
            throw new SystemException(e);
        }

        return result;
    }


    private static Record createRecord(ResultSet set) throws SystemException {
        try {
            Record record = new Record();
            record.setId(set.getInt(1));
            record.setFamily(set.getString(2));
            record.setResult(set.getDouble(3));

            return record;
        } catch (SQLException e) {
            throw new SystemException(e);
        }
    }
}
