package ru.vetoshkin.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;





@XmlAccessorType(XmlAccessType.FIELD)
public class Record {

    private int id;
    private String family;
    private double result;


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

}
