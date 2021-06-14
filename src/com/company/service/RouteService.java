package com.company.service;

import com.company.dao.RouteDAO;
import com.company.domain.Route;

import java.sql.SQLException;
import java.util.Set;


public class RouteService {

    RouteDAO routeDAO = new RouteDAO();

    public Route get(Integer id) throws SQLException {

        return routeDAO.getRouteById(id);
    }

    public Set<Route> getAll() throws SQLException {

        return routeDAO.getAllRoutes();
    }

    public boolean deleteByID(Integer id) throws SQLException {

        return routeDAO.deleteRoteById(id);
    }

    public boolean updateByID(Integer id, String userInput, int rowNumber) throws SQLException {

        return routeDAO.updateRouteByID(id, userInput, rowNumber);
    }
}
