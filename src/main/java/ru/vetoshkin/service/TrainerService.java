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
        Service.save(trainer, "{? = call save_trainer(?)}");
    }


    public static int getAllTrainersCount() throws SystemException {
        return Service.getCount("{? = call get_trainers_count()}");
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


    public static void removeTrainer(int id) throws SystemException {
        try (Connection connection = HikariPool.getSource().getConnection()) {
            String method = "{call remove_trainer(?)}";
            connection.setAutoCommit(true);

            CallableStatement statement = connection.prepareCall(method);
            statement.setInt(1, id);

            logger.info(method);
            statement.execute();
        } catch (SQLException e) {
            throw new SystemException(e);
        }
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
            connection.setAutoCommit(false);

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
