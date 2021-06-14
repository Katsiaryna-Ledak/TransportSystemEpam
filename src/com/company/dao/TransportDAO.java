package com.company.dao;

import com.company.domain.Transport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import static com.company.dao.TestConnection.statement;

public class TransportDAO {

    public Set<Transport> getAll() throws SQLException {

        Set<Transport> setOfTransport = new HashSet<Transport>();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM TRANSPORT;");

        while(resultSet.next()){

            int idTransport = resultSet.getInt("id_t");
            String typeTransport = resultSet.getString("type");
            String modelTransport = resultSet.getString("model");

            //надо ли каждый раз создавать новый объект?
            Transport vehicle = new Transport(idTransport, typeTransport, modelTransport);
            setOfTransport.add(vehicle);
        }

        return setOfTransport;
    }

    public Transport getTransportById(int id) throws SQLException {

        ResultSet resultSet = statement.executeQuery("SELECT * FROM Transport WHERE id_t = '" + id + "'");

        resultSet.last();
        int rsSize = resultSet.getRow();

        if (rsSize == 0){
            //System.out.println("There is no transport with this ID");
            return null;
        }

        int idTransport = resultSet.getInt(1);
        String typeTransport = resultSet.getString(2);
        String modelTransport = resultSet.getString(3);

        return new Transport(idTransport, typeTransport, modelTransport);
    }
}
