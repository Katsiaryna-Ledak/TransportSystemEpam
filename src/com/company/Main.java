package com.company;

import com.company.console.RouteConsoleOutput;
import com.company.console.TransportConsoleOutput;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import static com.company.dao.TestConnection.statement;

public class Main {

    public static void main(String[] args) throws SQLException {

        TransportConsoleOutput transportConsoleOutput = new TransportConsoleOutput();
        RouteConsoleOutput routeConsoleOutput = new RouteConsoleOutput();

        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("======================================================================= ");
            System.out.println("Press 1 to work with TRANSPORT table // Press 2 to work with ROUTE table ");
            Integer choise = scanner.nextInt();

            boolean runDefault = false;

            switch (choise){
                case 1: {
                    System.out.println("======================================================================= ");
                    System.out.println("Press 1 to search through TRANSPORT // Press 2 to output all TRANSPORT // Press 3 to delete TRANSPORT by ID ");
                    int choiseTransport = scanner.nextInt();

                    //In this switch we work with TRANSPORT table
                    switch (choiseTransport){
                        case 1: {
                            System.out.println("Please, input Transport ID: ");
                            Integer transportID = scanner.nextInt();
                            transportConsoleOutput.outputTransport(transportID);
                            runDefault = true;
                            break;
                        }
                        case 2: {
                            //Data about all TRANSPORT:
                            transportConsoleOutput.outputAllTransport();
                            runDefault = true;
                            break;
                        }
                        case 3: {
                            System.out.println("Please, input Transport ID you want to delete: ");
                            Integer transportIDDelete = scanner.nextInt();
                            transportConsoleOutput.deleteTransportByID(transportIDDelete);
                            runDefault = true;
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("======================================================================= ");
                    System.out.println("Press 1 to search through ROUTE // Press 2 to output all ROUTES // Press 3 to delete ROUTE by ID ");
                    int choiseRoute = scanner.nextInt();
                    switch (choiseRoute){
                        case 1: {
                            System.out.println("Please, input Route ID: ");
                            Integer routeID = scanner.nextInt();
                            routeConsoleOutput.outputRoute(routeID);
                            runDefault = true;
                            break;
                        }
                        case 2: {
                            //Data about all ROUTES:
                            routeConsoleOutput.outputAllRoutes();
                            runDefault = true;
                            break;
                        }
                        case 3: {
                            System.out.println("Please, input Route ID you want to delete: ");
                            Integer routeIDDelete = scanner.nextInt();
                            routeConsoleOutput.deleteRouteByID(routeIDDelete);
                            runDefault = true;
                            break;
                        }
                    }
                    break;
                }
                default: {
                    runDefault = true;
                    break;
                }
            }
            if (runDefault) {
                System.out.println("\n======================= ");
                System.out.println("Do you want to continue? ");
                System.out.println("Press 1 to CONTINUE // Press 2 to EXIT ");
                choise = scanner.nextInt();
                if (choise == 1){
                    continue;
                } else return;
            }

        }
    }

    public static void init() throws ClassNotFoundException, SQLException, IOException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        statement.executeUpdate("CREATE TABLE if not exists TRANSPORT (" +
                "id_t INT(11) NOT NULL AUTO_INCREMENT primary key," +
                "type varchar(15) not null," +
                "model varchar(15) not null);");

        /*Class.forName("com.mysql.cj.jdbc.Driver");
        statement.executeUpdate("DROP TABLE ROUTE;");*/

        Class.forName("com.mysql.cj.jdbc.Driver");
        statement.executeUpdate("CREATE TABLE if not exists ROUTE (" +
                "id_r INT(11) NOT NULL AUTO_INCREMENT primary key," +
                "startPoint varchar(15) not null," +
                "finishPoint varchar(15) not null);");

        //statement.executeUpdate("INSERT INTO TRANSPORT (id_t, type, model) value (1, 'TRAM', 'TZXX');");
        //statement.executeUpdate("INSERT INTO TRANSPORT (id_t, type, model) value (2, 'BUS', 'Ikarus');");
        //statement.executeUpdate("INSERT INTO TRANSPORT (id_t, type, model) value (3, 'TROLLEYBUS', 'MAZ');");
        //statement.executeUpdate("DELETE FROM TRANSPORT");
        //statement.executeUpdate("DELETE FROM TRANSPORT WHERE id_t = 2");

        //statement.executeUpdate("INSERT INTO ROUTE (id_r, startPoint, finishPoint) value (1, 'Parnas', 'Ozerki');");
        //statement.executeUpdate("INSERT INTO ROUTE (id_r, startPoint, finishPoint) value (2, 'Minsk', 'Brest');");
        //statement.executeUpdate("INSERT INTO ROUTE (id_r, startPoint, finishPoint) value (3, 'Zvezdnaya', 'Nevsliy Ave');");
    }
}
