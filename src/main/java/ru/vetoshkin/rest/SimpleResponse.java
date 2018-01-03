package ru.vetoshkin.rest;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
@XmlAccessorType(XmlAccessType.FIELD)
public class SimpleResponse {

    private Object result;


    public Object getResult() {
        return result;
    }


    public void setResult(Object result) {
        this.result = result;
    }
}
