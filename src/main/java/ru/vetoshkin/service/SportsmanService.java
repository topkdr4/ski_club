package ru.vetoshkin.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.vetoshkin.bean.Sportsman;

import java.util.Collections;
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


    public static Sportsman getSportsman(int key) {
        throw new UnsupportedOperationException("remove sportsman not supported");
    }


    public static List<Sportsman> getAllSportsmans() {
        return Collections.emptyList();
    }
}
