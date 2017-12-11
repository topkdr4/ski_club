package ru.vetoshkin;
/**
 * Ветошкин А.В. РИС-16бзу
 * */


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
public class Sprotsman {

    private String id;
    private String family;
    private Qualification qualification;
    private float weight;
    private long birthday;
    private int yearOfStart;
    private List<Standard> standards = Collections.emptyList();

}
