package com.company.console;

import com.company.service.TransportService;

import java.sql.SQLException;

public class TransportConsoleOutput {

    TransportService transportService = new TransportService();

    public void outputTransport(Integer id) throws SQLException {

        System.out.println(transportService.get(id));
    }

    public void outputAllTransport() throws SQLException {

        System.out.println(transportService.getAll());
    }
}
