package ru.vetoshkin.bean;

import ru.vetoshkin.TrainerQualification;

import java.util.Date;

public class Trainer {

    private String family;
    private String name;
    private String subName;
    private TrainerQualification qualification;
    private Date dayOfBirth;
    private int id;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public TrainerQualification getQualification() {
        return qualification;
    }

    public void setQualification(TrainerQualification qualification) {
        this.qualification = qualification;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }
}
