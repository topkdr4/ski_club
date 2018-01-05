package ru.vetoshkin.rest;
import javax.xml.bind.annotation.XmlRootElement;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
@XmlRootElement
public class IdentityRequest {

    private int id;


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }
}
