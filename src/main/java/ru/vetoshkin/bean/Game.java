package ru.vetoshkin.bean;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.Date;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
@XmlAccessorType(XmlAccessType.FIELD)
public class Game {

    private int id;
    private String name;
    private Date gameDate;


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Date getGameDate() {
        return gameDate;
    }


    public void setGameDate(Date gameDate) {
        this.gameDate = gameDate;
    }
}
