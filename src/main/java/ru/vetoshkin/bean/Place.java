package ru.vetoshkin.bean;
import java.util.Date;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class Place {

    private String name;
    private Date date;
    private int place;


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Date getDate() {
        return date;
    }


    public void setDate(Date date) {
        this.date = date;
    }


    public int getPlace() {
        return place;
    }


    public void setPlace(int place) {
        this.place = place;
    }
}
