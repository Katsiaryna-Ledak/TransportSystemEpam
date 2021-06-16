package com.company.dao;

import com.company.domain.Transport;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import static com.company.dao.TestConnection.statement;
import static com.company.dao.TestConnection.connection;

public class TransportDAOImpl implements TransportDAO<Transport> {

    Transport vehicle = new Transport();

    public Set<Transport> getAll() throws SQLException {

        Set<Transport> setOfTransport = new HashSet<Transport>();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM TRANSPORT;");

        while (resultSet.next()) {

            int idTransport = resultSet.getInt("id_t");
            String typeTransport = resultSet.getString("type");
            String modelTransport = resultSet.getString("model");

            vehicle = new Transport(idTransport, typeTransport, modelTransport);
            setOfTransport.add(vehicle);
        }
        return setOfTransport;
    }

    public Transport getByID(Integer id) throws SQLException {

        ResultSet resultSet = statement.executeQuery("SELECT * FROM Transport WHERE id_t = '" + id + "'");

        resultSet.last();
        int rsSize = resultSet.getRow();

        if (rsSize == 0) {
            return null;
        }

        int idTransport = resultSet.getInt(1);
        String typeTransport = resultSet.getString(2);
        String modelTransport = resultSet.getString(3);

        return new Transport(idTransport, typeTransport, modelTransport);
    }

    public boolean deleteByID(Integer id) throws SQLException {

        ResultSet resultSet = statement.executeQuery("SELECT * FROM Transport WHERE id_t = '" + id + "'");
        resultSet.last();
        int rsSize = resultSet.getRow();

        // there is no element with such ID
        if (rsSize == 0) {
            return false;
        }

        int affectedRows = statement.executeUpdate("DELETE FROM Transport WHERE id_t = '" + id + "'");
        //number of rows affected by the query
        if (affectedRows != 0) {
            return true;
        }
        return true;
    }

    public boolean updateByID(Integer id, String userInput, Integer rowNumber) throws SQLException {

        // if user made a wrong input we can't change the row
        if (rowNumber != 2 && rowNumber != 3) {
            return false;
        }

        //search for the row we want to update
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Transport WHERE id_t = '" + id + "'");
        resultSet.last();
        int rsSize = resultSet.getRow();

        // there is no element with such ID
        if (rsSize == 0) {
            return false;
        }

        if (rowNumber == 2) {
            int affectedRows = statement.executeUpdate("UPDATE Transport SET type = '" + userInput + "' WHERE id_t = '" + id + "'");
            if (affectedRows != 0) {
                return true;
            }
        } else {
            int affectedRows = statement.executeUpdate("UPDATE Transport SET model = '" + userInput + "' WHERE id_t = '" + id + "'");
            if (affectedRows != 0) {
                return true;
            }
        }
        return true;
    }

    public boolean create(Transport userTransport) throws SQLException {

        ResultSet resultSet = statement.executeQuery("SELECT * FROM Transport");
        resultSet.last();
        int rsSize = resultSet.getRow();

        resultSet.moveToInsertRow();
        resultSet.updateInt(1, rsSize + 1);
        resultSet.updateString(2, userTransport.getType());
        resultSet.updateString(3, userTransport.getModel());
        resultSet.insertRow();

        ResultSet rsAfterAdding = statement.executeQuery("SELECT * FROM Transport");
        rsAfterAdding.last();
        int rsSizeAfterAdding = rsAfterAdding.getRow();

        if (rsSizeAfterAdding > rsSize) {
            return true;
        } else {
            return false;
        }
    }
}


