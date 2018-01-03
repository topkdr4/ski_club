package ru.vetoshkin.rest;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
@XmlAccessorType(XmlAccessType.FIELD)
public class IdentityRequest {

    private int id;


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }
}
