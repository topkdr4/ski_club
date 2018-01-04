package ru.vetoshkin.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.Date;





@XmlAccessorType(XmlAccessType.FIELD)
public class Trainer {

    private String family;
    private String name;
    private String qualification;
    private Date dayOfBirth;
    private Integer id;


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


    public Date getDayOfBirth() {
        return dayOfBirth;
    }


    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

}
