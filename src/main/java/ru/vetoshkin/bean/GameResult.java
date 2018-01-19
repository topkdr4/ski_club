package ru.vetoshkin.bean;
/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class GameResult {

    private String family;
    private int sportsmanId;
    private double jump;
    private double judge[];
    private double compensation;
    private double wind;
    private int gameId;


    public Integer getResultGameId() {
        return resultGameId;
    }


    public void setResultGameId(Integer resultGameId) {
        this.resultGameId = resultGameId;
    }


    private Integer resultGameId;


    public String getFamily() {
        return family;
    }


    public void setFamily(String family) {
        this.family = family;
    }


    public int getSportsmanId() {
        return sportsmanId;
    }


    public void setSportsmanId(int sportsmanId) {
        this.sportsmanId = sportsmanId;
    }


    public double getJump() {
        return jump;
    }


    public void setJump(double jump) {
        this.jump = jump;
    }


    public double[] getJudge() {
        return judge;
    }


    public void setJudge(double[] judge) {
        this.judge = judge;
    }


    public double getCompensation() {
        return compensation;
    }


    public void setCompensation(double compensation) {
        this.compensation = compensation;
    }


    public double getWind() {
        return wind;
    }


    public void setWind(double wind) {
        this.wind = wind;
    }


    public int getGameId() {
        return gameId;
    }


    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
}
