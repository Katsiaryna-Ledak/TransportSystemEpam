package com.company.dao;

import com.company.domain.Transport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import static com.company.dao.TestConnection.statement;

public class TransportDAO {

    Transport vehicle = new Transport();

    public Set<Transport> getAllTransport() throws SQLException {

        Set<Transport> setOfTransport = new HashSet<Transport>();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM TRANSPORT;");

        while(resultSet.next()){

            int idTransport = resultSet.getInt("id_t");
            String typeTransport = resultSet.getString("type");
            String modelTransport = resultSet.getString("model");

            vehicle = new Transport(idTransport, typeTransport, modelTransport);
            setOfTransport.add(vehicle);
        }
        return setOfTransport;
    }

    public Transport getTransportById(int id) throws SQLException {

        ResultSet resultSet = statement.executeQuery("SELECT * FROM Transport WHERE id_t = '" + id + "'");

        resultSet.last();
        int rsSize = resultSet.getRow();

        if (rsSize == 0){
            return null;
        }

        int idTransport = resultSet.getInt(1);
        String typeTransport = resultSet.getString(2);
        String modelTransport = resultSet.getString(3);

        return new Transport(idTransport, typeTransport, modelTransport);
    }

    public boolean deleteTransportById(int id) throws SQLException {

        ResultSet resultSet = statement.executeQuery("SELECT * FROM Transport WHERE id_t = '" + id + "'");
        resultSet.last();
        int rsSize = resultSet.getRow();

        // there is no element with such ID
        if (rsSize == 0){
            return false;
        }

        int affectedRows = statement.executeUpdate("DELETE FROM Transport WHERE id_t = '" + id + "'");
        //number of rows affected by the query
        if (affectedRows != 0){
            return true;
        }
        return true;
    }
}
