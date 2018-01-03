package ru.vetoshkin.bean;

import ru.vetoshkin.TrainerQualification;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Calendar;
import java.util.Date;





@XmlAccessorType(XmlAccessType.FIELD)
public class Trainer {

    private String family;
    private String name;
    private String qualification;
    private XMLGregorianCalendar dayOfBirth;
    private Integer id;
/*
* "{family:"Фамилия","name":"Имя","qualification":"ТОп","dayOfBirth":"2018-01-24","id":null}"
* */

    public Integer getId() {
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


    public XMLGregorianCalendar getDayOfBirth() {
        return dayOfBirth;
    }


    public void setDayOfBirth(XMLGregorianCalendar dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }


    @Override public String toString() {
        return "Trainer{" +
                "family='" + family + '\'' +
                ", name='" + name + '\'' +
                ", qualification='" + qualification + '\'' +
                ", dayOfBirth=" + dayOfBirth +
                ", id=" + id +
                '}';
    }
}
