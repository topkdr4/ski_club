package ru.vetoshkin.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.postgresql.util.PGobject;
import ru.vetoshkin.bean.Trainer;
import ru.vetoshkin.core.HikariPool;
import ru.vetoshkin.core.SystemException;
import ru.vetoshkin.util.Jackson;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;





public class TrainerService {

    private static final Logger logger = LogManager.getLogger(TrainerService.class);


    private TrainerService() {
    }


    public static void saveTrainer(Trainer trainer) throws SystemException {
        String method = "{? = call save_trainer(?)}";

        try (Connection connection = HikariPool.getSource().getConnection()) {
            connection.setAutoCommit(true);

            CallableStatement statement = connection.prepareCall(method);
            statement.registerOutParameter(1, Types.INTEGER);

            PGobject jsonObject = new PGobject();
            jsonObject.setType("json");
            jsonObject.setValue(Jackson.toJson(trainer));

            statement.setObject(2, jsonObject);

            logger.info(method);
            statement.execute();

        } catch (Exception e) {
            throw new SystemException(e);
        }
    }


    public static int getAllTrainersCount() throws SystemException {
        String method = "{? = call get_trainers_count()}";

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


    public static List<Trainer> getTrainers(int from, int to) throws SystemException {
        String method = "{? = call get_trainers_page(?, ?)}";
        List<Trainer> result = new ArrayList<>();

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
                result.add(create(set));
            }

            set.close();
        } catch (SQLException e) {
            throw new SystemException(e);
        }

        return result;
    }


    public static void removeTrainer(int id) {
        throw new UnsupportedOperationException("remove trainer not supported");
    }


    public static void removeTrainer(Trainer trainer) {
        throw new UnsupportedOperationException("remove trainer not supported");
    }


    public static Trainer getTrainer(int id) throws SystemException {
        String method = "{? = call get_trainer_info(?)}";
        Trainer trainer = null;

        try (Connection connection = HikariPool.getSource().getConnection()) {
            connection.setAutoCommit(false);

            CallableStatement statement = connection.prepareCall(method);
            statement.registerOutParameter(1, Types.OTHER);
            statement.setInt(2, id);

            logger.info(method);
            statement.execute();

            ResultSet set = (ResultSet) statement.getObject(1);
            if (set.next()) {
                trainer = create(set);
            }

            set.close();
        } catch (SQLException e) {
            throw new SystemException(e);
        }

        return trainer;
    }


    public static List<Trainer> getAllTrainers() throws SystemException {
        List<Trainer> result = new ArrayList<>();
        String method = "{? = call get_trainers()}";

        try (Connection connection = HikariPool.getSource().getConnection()) {
            connection.setAutoCommit(true);

            CallableStatement statement = connection.prepareCall(method);
            statement.registerOutParameter(1, Types.OTHER);

            logger.info(method);
            statement.execute();

            ResultSet set = (ResultSet) statement.getObject(1);
            while (set.next()) {
                Trainer trainer = create(set);
                result.add(trainer);
            }

            set.close();
        } catch (SQLException e) {
            logger.warn(e);
            throw new SystemException(e);
        }

        return result;
    }


    private static Trainer create(ResultSet set) throws SQLException {
        Trainer trainer = new Trainer();
        trainer.setId(set.getInt(1));
        trainer.setFamily(set.getString(2));
        trainer.setName(set.getString(3));
        trainer.setQualification(set.getString(4));
        trainer.setDayOfBirth(set.getDate(5));

        return trainer;
    }

}
