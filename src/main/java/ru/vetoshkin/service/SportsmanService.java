package ru.vetoshkin.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.vetoshkin.bean.Sportsman;

public class SportsmanService {

    private static final Logger logger = LogManager.getLogger(SportsmanService.class);

    private SportsmanService() {
    }


    public static void saveSportsman(Sportsman sportsman) {
        throw new UnsupportedOperationException("save sportsman not supported");
    }


    public static void removeSportsman(Sportsman sportsman) {
        throw new UnsupportedOperationException("remove sportsman not supported");
    }


    public static void changeSportsman(Sportsman sportsman) {
        throw new UnsupportedOperationException("change sportsman not supported");
    }


    public static Sportsman getSportsman(String key) {
        throw new UnsupportedOperationException("remove sportsman not supported");
    }

}
