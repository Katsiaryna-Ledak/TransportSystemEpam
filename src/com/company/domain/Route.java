package com.company.domain;

public class Route {

    private int rid;
    private String startPoint;
    private String finishPoint;

    public Route(int id, String start, String finish){

        this.rid = id;
        this.startPoint = start;
        this.finishPoint = finish;
    }

    public int getRid() { return rid; }

    public String getStart() {
        return startPoint;
    }

    public void setStart(String start) {
        this.startPoint = start;
    }

    public String getFinish() {
        return finishPoint;
    }

    public void setFinish(String finish) {
        this.finishPoint = finish;
    }

    public String toString() {
        return startPoint + " - " + finishPoint;
    }
}
