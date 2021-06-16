package com.company.service;

import com.company.dao.RouteDAOImpl;
import com.company.domain.Route;
import com.company.domain.Transport;

import java.sql.SQLException;
import java.util.Set;


public class RouteService {

    RouteDAOImpl routeDAOImpl = new RouteDAOImpl();

    public Route get(Integer id) throws SQLException {

        return routeDAOImpl.getByID(id);
    }

    public Set<Route> getAll() throws SQLException {

        return routeDAOImpl.getAll();
    }

    public boolean deleteByID(Integer id) throws SQLException {

        return routeDAOImpl.deleteByID(id);
    }

    public boolean updateByID(Integer id, String userInput, Integer rowNumber) throws SQLException {

        return routeDAOImpl.updateByID(id, userInput, rowNumber);
    }

    public boolean create(Route route) throws SQLException {

        return routeDAOImpl.create(route);
    }
}
