package ru.vetoshkin.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.vetoshkin.bean.Trainer;

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


    public static Trainer getTrainer(String key) {
        throw new UnsupportedOperationException("remove trainer not supported");
    }

}
