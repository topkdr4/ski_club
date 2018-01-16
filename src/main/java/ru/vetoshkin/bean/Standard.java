package ru.vetoshkin.bean;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
@XmlAccessorType(XmlAccessType.FIELD)
public class Standard {

    private Integer id;
    private String name;
    private double requier;
    private String type;
    private String desc;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public double getRequier() {
        return requier;
    }


    public void setRequier(double requier) {
        this.requier = requier;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public String getDesc() {
        return desc;
    }


    public void setDesc(String desc) {
        this.desc = desc;
    }
}
