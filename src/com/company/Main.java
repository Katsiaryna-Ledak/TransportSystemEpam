package com.company;

import com.company.console.RouteConsoleOutput;
import com.company.console.TransportConsoleOutput;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import static com.company.dao.TestConnection.statement;

public class Main {

    public static void main(String[] args) throws SQLException {
	// тут делаем меню через Scanner и вечные циклы
        // например, 1 - работать с Транспортом, 2 - с Маршрутом

        TransportConsoleOutput transportConsoleOutput = new TransportConsoleOutput();
        RouteConsoleOutput routeConsoleOutput = new RouteConsoleOutput();

        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("======================================================================= ");
            System.out.println("Press 1 to search through TRANSPORT // Press 2 to search through ROUTE: ");
            Integer choise = scanner.nextInt();

            boolean runDefault = false;

            switch (choise){
                case 1: {
                    System.out.println("Please, input Transport ID: ");
                    Integer transportID = scanner.nextInt();
                    transportConsoleOutput.outputTransport(transportID);
                    runDefault = true;
                    break;
                }
                case 2: {
                    System.out.println("Please, input Route ID: ");
                    Integer routeID = scanner.nextInt();
                    routeConsoleOutput.outputRoute(routeID);
                    runDefault = true;
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

        Class.forName("com.mysql.cj.jdbc.Driver");
        statement.executeUpdate("DROP TABLE ROUTE;");

        Class.forName("com.mysql.cj.jdbc.Driver");
        statement.executeUpdate("CREATE TABLE ROUTE (" +
                "id_r INT(11) NOT NULL AUTO_INCREMENT primary key," +
                "startPoint varchar(15) not null," +
                "finishPoint varchar(15) not null);");

        //statement.executeUpdate("INSERT INTO TRANSPORT (id_t, type, model) value (1, 'TRAM', 'TZXX');");
        //statement.executeUpdate("INSERT INTO TRANSPORT (id_t, type, model) value (2, 'BUS', 'Ikarus');");
        //statement.executeUpdate("INSERT INTO TRANSPORT (id_t, type, model) value (3, 'TROLLEYBUS', 'MAZ');");
        //statement.executeUpdate("DELETE FROM TRANSPORT");
        //statement.executeUpdate("DELETE FROM TRANSPORT WHERE id_t = 2");

        //statement.executeUpdate("INSERT INTO ROUTE (id_r, startPoint, finishPoint) value (1, 'Parnas', 'Ozerki');");
    }
}
