package com.company.domain;

public class Transport {

    private int tid;
    private String type;
    private String model;

    public Transport(int id, String type, String model) {
        this.tid = id;
        this.type = type;
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String toString() {
        return tid + " " + type + " " + model;
    }
}
