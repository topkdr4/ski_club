package ru.vetoshkin.bean;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.Date;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
@XmlAccessorType(XmlAccessType.FIELD)
public class StandardResult {

    private Sportsman sportsman;
    private Integer trainerId;
    private double result;
    private boolean success;
    private Date date;
    private Integer id;
    private Integer stdId;


    public Sportsman getSportsman() {
        return sportsman;
    }


    public void setSportsman(Sportsman sportsman) {
        this.sportsman = sportsman;
    }


    public Integer getTrainerId() {
        return trainerId;
    }


    public void setTrainerId(Integer trainerId) {
        this.trainerId = trainerId;
    }


    public double getResult() {
        return result;
    }


    public void setResult(double result) {
        this.result = result;
    }


    public boolean isSuccess() {
        return success;
    }


    public void setSuccess(boolean success) {
        this.success = success;
    }


    public Date getDate() {
        return date;
    }


    public void setDate(Date date) {
        this.date = date;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getStdId() {
        return stdId;
    }


    public void setStdId(Integer stdId) {
        this.stdId = stdId;
    }
}
