package ru.vetoshkin;

public enum TrainerQualification {

    PLATINUM_PERFECT("Тренер-преподаватель высшего уровня квалификации высшей категории"),
    PLATINUM_FIRST("Тренер-преподаватель высшего уровня квалификации первой категории"),
    PLATINUM_SECOND("Тренер-преподаватель высшего уровня квалификации второй категории"),
    PLATINUM_NONE("Тренер-преподаватель высшего уровня квалификации без категории"),
    
    GOLD_PERFECT("Тренер-преподаватель среднего уровня квалификации высшей категории"),
    GOLD_FIRST("Тренер-преподаватель среднего уровня квалификации первой категории"),
    GOLD_SECOND("Тренер-преподаватель среднего уровня квалификации второй категории"),
    GOLD_NONE("Тренер-преподаватель среднего уровня квалификации без категории"),

    SILVER_PERFECT("Инструктор, инструктор-методист высшего уровня квалификации высшей категории"),
    SILVER_FIRST("Инструктор, инструктор-методист высшего уровня квалификации первой категории"),
    SILVER_SECOND("Инструктор, инструктор-методист высшего уровня квалификации второй категории"),
    SILVER_NONE("Инструктор, инструктор-методист высшего уровня квалификации без категории"),

    BRONZE_PERFECT("Инструктор, инструктор-методист среднего уровня квалификации высшей категории"),
    BRONZE_FIRST("Инструктор, инструктор-методист среднего уровня квалификации первой категории"),
    BRONZE_SECOND("Инструктор, инструктор-методист среднего уровня квалификации второй категории"),
    BRONZE_NONE("Инструктор, инструктор-методист среднего уровня квалификации без категории");


    private String qualityName;

    public String getQualityName() {
        return qualityName;
    }

    private TrainerQualification(String quality) {
        this.qualityName = quality;
    }

}