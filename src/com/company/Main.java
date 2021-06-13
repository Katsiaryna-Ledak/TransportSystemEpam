package com.company;

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

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please, input Transport ID: ");
            Integer id = scanner.nextInt();

            transportConsoleOutput.outputTransport(id);
        }
    }

    public static void init() throws ClassNotFoundException, SQLException, IOException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        statement.executeUpdate("CREATE TABLE if not exists TRANSPORT (" +
                "id_t INT(11) NOT NULL AUTO_INCREMENT primary key," +
                "type varchar(15) not null," +
                "model varchar(15) not null);");

        //statement.executeUpdate("INSERT INTO TRANSPORT (id_t, type, model) value (1, 'TRAM', 'TZXX');");
        //statement.executeUpdate("INSERT INTO TRANSPORT (id_t, type, model) value (2, 'BUS', 'Ikarus');");

       //statement.executeUpdate("DELETE FROM TRANSPORT");

        //statement.executeUpdate("DELETE FROM TRANSPORT WHERE id_t = 2");

    }
}
