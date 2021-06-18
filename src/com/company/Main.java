package com.company;

import com.company.console.RelationConsoleOutput;
import com.company.console.RouteConsoleOutput;
import com.company.console.TransportConsoleOutput;
import com.company.domain.Route;
import com.company.domain.Transport;
import com.company.domain.TransportRouteRelation;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import static com.company.dao.Connection.statement;

public class Main {

    public static void main(String[] args) throws SQLException {

        TransportConsoleOutput transportConsoleOutput = new TransportConsoleOutput();
        RouteConsoleOutput routeConsoleOutput = new RouteConsoleOutput();
        RelationConsoleOutput relationConsoleOutput = new RelationConsoleOutput();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            Scanner sc = new Scanner(System.in); // for STRING

            System.out.println("==========WELCOME TO TRANSPORT SYSTEM==================================\n");
            System.out.println("Press 1 to work with TRANSPORT table // Press 2 to work with ROUTE table // Press 3 to work with RELATION table");
            Integer choise = scanner.nextInt();

            boolean runDefault = false;

            switch (choise) {
                case 1: {
                    System.out.println("==========TRANSPORT==================================================== ");
                    System.out.println("Press 1 to search through TRANSPORT // Press 2 to output all TRANSPORT\nPress 3 to delete TRANSPORT by ID   // Press 4 to update one row in TRANSPORT\nPress 5 to add new TRANSPORT ");
                    int choiseTransport = scanner.nextInt();

                    //In this switch we work with TRANSPORT table
                    switch (choiseTransport) {
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
                        case 4: {
                            System.out.println("Please, input Transport ID you want to update: ");
                            Integer transportIDUpdate = scanner.nextInt();
                            System.out.println("Please, press 2 if you want to update TYPE of the TRANSPORT or press 3 to update MODEL of the TRANSPORT: ");
                            Integer rowNumber = scanner.nextInt();
                            if (rowNumber == 2) {
                                System.out.println("Please, enter new transport TYPE: ");
                                String userInput = sc.nextLine();
                                transportConsoleOutput.updateTransportByID(transportIDUpdate, userInput, rowNumber);
                                runDefault = true;
                                break;
                            }
                            if (rowNumber == 3) {
                                System.out.println("Please, enter new transport MODEL: ");
                                String userInput = sc.nextLine();
                                transportConsoleOutput.updateTransportByID(transportIDUpdate, userInput, rowNumber);
                                runDefault = true;
                                break;
                            }
                            if (rowNumber != 2 && rowNumber != 3) {
                                System.out.println("Your input is incorrect ");
                                runDefault = true;
                                break;
                            }

                            break;
                        }
                        case 5: {
                            System.out.println("Please, enter new transport TYPE: ");
                            String userInputType = sc.nextLine();
                            System.out.println("Please, enter new transport MODEL: ");
                            String userInputModel = sc.nextLine();
                            Transport userCreation = new Transport(0, userInputType, userInputModel);
                            transportConsoleOutput.createTransport(userCreation);
                            runDefault = true;
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("==========ROUTE======================================================== ");
                    System.out.println("Press 1 to search through ROUTE // Press 2 to output all ROUTES\nPress 3 to delete ROUTE by ID   // Press 4 to update one row in ROUTE\nPress 5 to add new ROUTE ");
                    int choiseRoute = scanner.nextInt();
                    switch (choiseRoute) {
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
                        case 4: {
                            System.out.println("Please, input Route ID you want to update: ");
                            Integer routeIDUpdate = scanner.nextInt();
                            System.out.println("Please, press 2 if you want to update START of the ROUTE or press 3 to update FINISH of the ROUTE: ");
                            Integer rowNumber = scanner.nextInt();
                            if (rowNumber == 2) {
                                System.out.println("Please, enter new transport START: ");
                                String userInput = sc.nextLine();
                                routeConsoleOutput.updateRouteByID(routeIDUpdate, userInput, rowNumber);
                                runDefault = true;
                                break;
                            }
                            if (rowNumber == 3) {
                                System.out.println("Please, enter new transport FINISH: ");
                                String userInput = sc.nextLine();
                                transportConsoleOutput.updateTransportByID(routeIDUpdate, userInput, rowNumber);
                                runDefault = true;
                                break;
                            }
                            if (rowNumber != 2 && rowNumber != 3) {
                                System.out.println("Your input is incorrect ");
                                runDefault = true;
                                break;
                            }
                            break;
                        }
                        case 5: {
                            System.out.println("Please, enter new start of the ROUTE: ");
                            String userInputStart = sc.nextLine();
                            System.out.println("Please, enter new finish of the Route: ");
                            String userInputFinish = sc.nextLine();
                            Route userCreation = new Route(0, userInputStart, userInputFinish);
                            routeConsoleOutput.createRoute(userCreation);
                            runDefault = true;
                            break;
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.println("==========  RELATION  ===================================================== ");
                    System.out.println("Press 1 to search through RELATION // Press 2 to output all TRANSPORT for certain RELATION\nPress 3 to output just all the RELATIONS   // Press 4 to add new RELATION\nPress 5 to delete RELATION // Press 6 to update RELATION");
                    int choiseRelation = scanner.nextInt();
                    switch (choiseRelation) {
                        case 1: {
                            System.out.println("Please, input Relation ID: ");
                            Integer relationID = scanner.nextInt();
                            relationConsoleOutput.outputRelation(relationID);
                            runDefault = true;
                            break;
                        }
                        case 2: {
                            System.out.println("Please, input Route ID: ");
                            Integer routeID = scanner.nextInt();
                            relationConsoleOutput.outputAllRelationsForOneRoute(routeID);
                            runDefault = true;
                            break;
                        }
                        case 3: {
                            relationConsoleOutput.outputAllRelationsFromDB();
                            runDefault = true;
                            break;
                        }
                        case 4: {
                            System.out.println("Please, enter new TRANSPORT ID: ");
                            int userInputTRID = sc.nextInt();
                            System.out.println("Please, enter new ROUTE ID: ");
                            int userInputROUTERID = sc.nextInt();
                            TransportRouteRelation userCreation = new TransportRouteRelation(0, userInputTRID, userInputROUTERID);
                            relationConsoleOutput.createRelation(userCreation);
                            runDefault = true;
                            break;
                        }
                        case 5: {
                            System.out.println("Please, input Relation ID you want to delete: ");
                            Integer relationIDDelete = scanner.nextInt();
                            relationConsoleOutput.deleteRelationByID(relationIDDelete);
                            runDefault = true;
                            break;
                        }
                        case 6: {
                            System.out.println("Please, input Realtion ID you want to update: ");
                            Integer relIDUpdate = scanner.nextInt();
                            System.out.println("Please, press 2 if you want to update transport_ID of this RELATION or press 3 to update route_ID of this RELATION: ");
                            Integer rowNumber = scanner.nextInt();
                            if (rowNumber == 2) {
                                System.out.println("Please, enter new transport_ID of this RELATION: ");
                                int userInput = sc.nextInt();
                                relationConsoleOutput.updateRelationByID(relIDUpdate, userInput, rowNumber);
                                runDefault = true;
                                break;
                            }
                            if (rowNumber == 3) {
                                System.out.println("Please, enter new route_ID of this RELATION: ");
                                int userInput = sc.nextInt();
                                relationConsoleOutput.updateRelationByID(relIDUpdate, userInput, rowNumber);
                                runDefault = true;
                                break;
                            }
                            if (rowNumber != 2 && rowNumber != 3) {
                                System.out.println("Your input is incorrect ");
                                runDefault = true;
                                break;
                            }
                            break;
                        }
                    }

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
                    if (choise == 1) {
                        continue;
                    } else return;
                }
            }
        }


    public static void init() throws ClassNotFoundException, SQLException, IOException {

        /*Class.forName("com.mysql.cj.jdbc.Driver");
        statement.executeUpdate("DROP TABLE TRANSPORT;");*/

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
                "startPoint varchar(20) not null," +
                "finishPoint varchar(20) not null);");

        /*Class.forName("com.mysql.cj.jdbc.Driver");
        statement.executeUpdate("DROP TABLE TRANSPORT_ROUTE_RELATION;");*/

        Class.forName("com.mysql.cj.jdbc.Driver");
        statement.executeUpdate("CREATE TABLE if not exists TRANSPORT_ROUTE_RELATION (" +
                "id_relation INT(11) NOT NULL AUTO_INCREMENT primary key," +
                "id_t INT(11)," +
                "id_r INT(11)," +
                "foreign key(id_t) references Transport(id_t),"+
                "foreign key(id_r) references Route(id_r));");

        //statement.executeUpdate("INSERT INTO TRANSPORT (id_t, type, model) value (1, 'TRAM', 'TZXX');");
        //statement.executeUpdate("INSERT INTO TRANSPORT (id_t, type, model) value (2, 'BUS', 'Ikarus');");
        //statement.executeUpdate("INSERT INTO TRANSPORT (id_t, type, model) value (3, 'TROLLEYBUS', 'MAZ');");
        //statement.executeUpdate("DELETE FROM TRANSPORT");
        //statement.executeUpdate("DELETE FROM TRANSPORT WHERE id_t = 2");

        //statement.executeUpdate("INSERT INTO ROUTE (id_r, startPoint, finishPoint) value (1, 'Parnas', 'Ozerki');");
        //statement.executeUpdate("INSERT INTO ROUTE (id_r, startPoint, finishPoint) value (2, 'Minsk', 'Brest');");
        //statement.executeUpdate("INSERT INTO ROUTE (id_r, startPoint, finishPoint) value (3, 'Zvezdnaya', 'Nevsliy Ave');");

        //statement.executeUpdate("INSERT INTO TRANSPORT_ROUTE_RELATION (id_relation, id_t, id_r) value (1, 1, 3);");
        //statement.executeUpdate("INSERT INTO TRANSPORT_ROUTE_RELATION (id_relation, id_t, id_r) value (2, 2, 2);");
        //statement.executeUpdate("INSERT INTO TRANSPORT_ROUTE_RELATION (id_relation, id_t, id_r) value (3, 2, 4);");
        //statement.executeUpdate("INSERT INTO TRANSPORT_ROUTE_RELATION (id_relation, id_t, id_r) value (4, 3, 1);");


    }
}
