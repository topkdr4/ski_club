package ru.vetoshkin.service;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.postgresql.util.PGobject;
import ru.vetoshkin.core.HikariPool;
import ru.vetoshkin.core.SystemException;
import ru.vetoshkin.util.Jackson;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;





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

}
