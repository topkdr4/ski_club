package ru.vetoshkin.service;
import ru.vetoshkin.bean.Record;
import ru.vetoshkin.core.SystemException;

import java.util.List;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class RecordService {

    public static List<Record> getCompensation(boolean sex) throws SystemException {
        return Service.getRecord("{? = call get_compensation_record(?)}", sex);
    }


    public static List<Record> getWind(boolean sex) throws SystemException {
        return Service.getRecord("{? = call get_wind_record(?)}", sex);
    }


    public static List<Record> getJump(boolean sex) throws SystemException {
        return Service.getRecord("{? = call get_jump_range_record(?)}", sex);
    }


    public static List<Record> getJudge(boolean sex) throws SystemException {
        return Service.getRecord("{? = call get_judge_record(?)}", sex);
    }


    public static List<Record> getSum(boolean sex) throws SystemException {
        return Service.getRecord("{? = call get_sum_record(?)}", sex);
    }

}
