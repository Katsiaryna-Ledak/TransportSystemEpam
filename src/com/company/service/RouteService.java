package com.company.service;

import com.company.dao.RouteDAO;
import com.company.domain.Route;


public class RouteService {

    RouteDAO routeDAO = new RouteDAO();

    public Route get(Integer id){

        return routeDAO.get(id);
    }
}
