package ru.vetoshkin.bean;
/**
 * Ветошкин А.В. РИС-16бзу
 * */


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.Date;





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
@XmlAccessorType(XmlAccessType.FIELD)
public class Sportsman {

    private Integer id;
    private String family;
    private String name;
    private String qualification;
    private double weight;
    private double height;
    private Date birthDay;
    private int yearOfStart;
    private boolean sex;


    public int getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getFamily() {
        return family;
    }


    public void setFamily(String family) {
        this.family = family;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getQualification() {
        return qualification;
    }


    public void setQualification(String qualification) {
        this.qualification = qualification;
    }


    public double getWeight() {
        return weight;
    }


    public void setWeight(double weight) {
        this.weight = weight;
    }


    public double getHeight() {
        return height;
    }


    public void setHeight(double height) {
        this.height = height;
    }


    public Date getBirthDay() {
        return birthDay;
    }


    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }


    public int getYearOfStart() {
        return yearOfStart;
    }


    public void setYearOfStart(int yearOfStart) {
        this.yearOfStart = yearOfStart;
    }


    public boolean isSex() {
        return sex;
    }


    public void setSex(boolean sex) {
        this.sex = sex;
    }
}
