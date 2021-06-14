package com.company.service;

import com.company.dao.RouteDAO;
import com.company.domain.Route;

import java.sql.SQLException;


public class RouteService {

    RouteDAO routeDAO = new RouteDAO();

    public Route get(Integer id) throws SQLException {

        return routeDAO.getRouteById(id);
    }
}
