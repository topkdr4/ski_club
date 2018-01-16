package ru.vetoshkin.bean;

import java.util.Date;





public class Record {

    private int id;
    private String family;
    private double result;
    private Date game;


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getFamily() {
        return family;
    }


    public void setFamily(String family) {
        this.family = family;
    }


    public double getResult() {
        return result;
    }


    public void setResult(double result) {
        this.result = result;
    }


    public Date getGame() {
        return game;
    }


    public void setGame(Date game) {
        this.game = game;
    }
}
