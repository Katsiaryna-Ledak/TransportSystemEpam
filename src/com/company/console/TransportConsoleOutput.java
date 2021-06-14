package com.company.console;

import com.company.domain.Transport;
import com.company.service.TransportService;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class TransportConsoleOutput {

    TransportService transportService = new TransportService();

    public void outputTransport(Integer id) throws SQLException {

        if (transportService.get(id) == null){
            System.out.println("There is no transport with this ID");
            return;
        }
        System.out.println("Data about chosen transport: ");
        System.out.println(transportService.get(id));
    }

    public void outputAllTransport() throws SQLException {

        if (transportService.getAll() == null){
            System.out.println("There is no any transport in your DB");
            return;
        }

        Set<Transport> allTransport = new HashSet<>();
        allTransport = transportService.getAll();

        System.out.println("Data about transport: ");
        for (Transport vehicle : allTransport) {
            System.out.println(transportService.get(vehicle.getID()));
        }
        return;
    }

    public void deleteTransportByID (Integer id) throws SQLException{

        boolean ifDeleted = transportService.deleteByID(id);
        if (ifDeleted == false){
            System.out.println("There is no element with this ID");
            return;
        }

        System.out.println("Transport with this ID was deleted");
        transportService.getAll();
    }
}
