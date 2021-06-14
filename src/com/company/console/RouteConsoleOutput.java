package com.company.console;

import com.company.domain.Route;
import com.company.domain.Transport;
import com.company.service.RouteService;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class RouteConsoleOutput {

    RouteService routeService = new RouteService();

    public void outputRoute(Integer id) throws SQLException {

        if (routeService.get(id) == null){
            System.out.println("There is no such a route.");
            return;
        }
        System.out.println("Data about chosen route: ");
        System.out.println(routeService.get(id));
    }

    public void outputAllRoutes() throws SQLException {

        if (routeService.getAll() == null){
            System.out.println("There is no any route in your DB");
            return;
        }

        Set<Route> allRoutes = new HashSet<>();
        allRoutes = routeService.getAll();

        System.out.println("Data about routes: ");
        for (Route pathway : allRoutes) {
            System.out.println(routeService.get(pathway.getRouteid()));
        }
        return;
    }

    public void deleteRouteByID (Integer id) throws SQLException{

        boolean ifDeleted = routeService.deleteByID(id);
        if (ifDeleted == false){
            System.out.println("There is no element with this ID");
            return;
        }

        //routeService.deleteByID(id);
        System.out.println("Route with this ID was deleted");
        routeService.getAll();
    }
}
