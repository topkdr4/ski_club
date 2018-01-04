package ru.vetoshkin;
/**
 * Ветошкин А.В. РИС-16бзу
 * */
public enum SportsmanQualification {

    FIRST("Первый"),
    SECOND("Второй"),
    THIRD("Третий"),
    MASTER_CANDIDATE("Кандидат в мастера спорта"),
    SPORT_MASTER("Мастер спорта"),
    INERNATIONAL_MASTER("Мастер спорта международного класса"),
    NONE("Без квалификации");


    private String qulification;


    private SportsmanQualification(String qulification) {
        this.qulification = qulification;
    }
}
