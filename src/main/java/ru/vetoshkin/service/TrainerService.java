package ru.vetoshkin.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.vetoshkin.TrainerQualification;
import ru.vetoshkin.bean.Trainer;
import ru.vetoshkin.core.HikariPool;
import ru.vetoshkin.core.SystemException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;





public class TrainerService {

    private static final Logger logger = LogManager.getLogger(TrainerService.class);


    private TrainerService() {
    }


    public static void saveTrainer(Trainer trainer) {
        throw new UnsupportedOperationException("save trainer not supported");
    }


    public static void removeTrainer(Trainer trainer) {
        throw new UnsupportedOperationException("remove trainer not supported");
    }


    public static void changeTrainer(Trainer trainer) {
        throw new UnsupportedOperationException("change trainer not supported");
    }


    public static Trainer getTrainer(int id) throws SystemException {
        String method = "{call get_trainer_info(?)}";
        Trainer trainer = null;

        try (Connection connection = HikariPool.getSource().getConnection()) {
            connection.setAutoCommit(false);

            CallableStatement statement = connection.prepareCall(method);
            statement.registerOutParameter(1, Types.OTHER);
            statement.setInt(2, id);

            logger.info(method);
            statement.execute();

            ResultSet set = (ResultSet) statement.getObject(1);
            if (set.first()) {
                trainer = create(set);
            }

        } catch (SQLException e) {
            throw new SystemException(e);
        }

        return trainer;
    }


    public static List<Trainer> getAllTrainers() throws SystemException {
        List<Trainer> result = new ArrayList<>();
        String method = "{call get_trainers()}";

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

        } catch (SQLException e) {
            throw new SystemException(e);
        }

        return result;
    }


    private static Trainer create(ResultSet set) throws SQLException {
        Trainer trainer = new Trainer();
        trainer.setId(set.getInt(1));
        trainer.setFamily(set.getString(2));
        trainer.setName(set.getString(3));
        trainer.setSubName(set.getString(4));
        trainer.setQualification(TrainerQualification.valueOf(set.getString(5)));
        trainer.setDayOfBirth(set.getDate(6));

        return trainer;
    }

}
