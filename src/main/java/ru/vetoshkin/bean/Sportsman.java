package ru.vetoshkin.bean;
/**
 * Ветошкин А.В. РИС-16бзу
 * */


import ru.vetoshkin.SportsmanQualification;
import ru.vetoshkin.Standard;

import java.util.Collections;
import java.util.List;





/**
 * фамилия,
 * разряд,
 * вес,
 * рост,
 * дата рождения,
 * год начала занятий,
 * даты выполнения спортивных нормативов
 * и физиологические характеристики спортсмена в это время)
 * */
public class Sportsman {

    private String id;
    private String family;
    private SportsmanQualification qualification;
    private float weight;
    private long birthday;
    private int yearOfStart;
    private List<Standard> standards = Collections.emptyList();

}
