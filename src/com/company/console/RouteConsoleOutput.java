package com.company.console;

import com.company.service.RouteService;

public class RouteConsoleOutput {

    RouteService routeService = new RouteService();

    public void outputRoute(Integer id) {

        System.out.println(routeService.get(id));
    }
}
