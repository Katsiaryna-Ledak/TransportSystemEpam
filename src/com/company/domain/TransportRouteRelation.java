package com.company.domain;

public class TransportRouteRelation {

    private Integer relationID;
    private Integer transportID;
    private Integer routeID;

    public TransportRouteRelation(){
        super();
    }

    public TransportRouteRelation(Integer relID, Integer trID, Integer rID) {
        this.relationID = relID;
        this.transportID = trID;
        this.routeID = rID;
    }

    public int getRelationID() { return relationID; }

    public int getTransportID() {
        return transportID;
    }

    public void setTransportID(int transpID) {
        this.transportID = transpID;
    }

    public int getRouteID() {
        return routeID;
    }

    public void setRouteID(int rID) {
        this.routeID = rID;
    }

    public String toString() {
        return "Relation " + relationID + ": Transport ID = " + transportID + ", Route ID = " + routeID;
    }
}
