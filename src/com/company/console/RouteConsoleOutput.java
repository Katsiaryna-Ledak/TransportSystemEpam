package com.company.console;

import com.company.service.RouteService;

import java.sql.SQLException;

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
}
