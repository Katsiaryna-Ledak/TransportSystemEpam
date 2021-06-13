package com.company.dao;

import com.company.domain.Route;

public class RouteDAO {

    public Route get(Integer id){
        //идет в БД
        return new Route(1,"Parnas", "Ozerki");
    }
}
