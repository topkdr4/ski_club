package ru.vetoshkin.bean;
import java.util.Date;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class SportsmanResult {

    private String name;
    private Date date;
    private boolean success;


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


    public boolean isSuccess() {
        return success;
    }


    public void setSuccess(boolean success) {
        this.success = success;
    }
}
