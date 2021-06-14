package com.company.dao;

import com.company.domain.Route;
import com.company.domain.Transport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import static com.company.dao.TestConnection.statement;

public class RouteDAO {

    Route pathway = new Route();

    public Route getRouteById(Integer id) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Route WHERE id_r = '" + id + "'");

        resultSet.last();
        int rsSize = resultSet.getRow();

        if (rsSize == 0){
            return null;
        }

        int idRoute = resultSet.getInt(1);
        String startPoint = resultSet.getString(2);
        String finishPoint = resultSet.getString(3);

        return new Route(idRoute, startPoint, finishPoint);
    }

    public Set<Route> getAllRoutes() throws SQLException {

        Set<Route> setOfRoutes = new HashSet<Route>();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM ROUTE;");

        while(resultSet.next()){

            int idRoute = resultSet.getInt(1);
            String start = resultSet.getString(2);
            String finish = resultSet.getString(3);

            pathway = new Route(idRoute, start, finish);
            setOfRoutes.add(pathway);
        }
        return setOfRoutes;
    }

    public boolean deleteRoteById(int id) throws SQLException {

        ResultSet resultSet = statement.executeQuery("SELECT * FROM Route WHERE id_r = '" + id + "'");
        resultSet.last();
        int rsSize = resultSet.getRow();

        // there is no element with such ID
        if (rsSize == 0){
            return false;
        }

        int affectedRows = statement.executeUpdate("DELETE FROM Route WHERE id_r = '" + id + "'");
        //number of rows affected by the query
        if (affectedRows != 0){
            return true;
        }
        return true;
    }

    public boolean updateRouteByID(int id, String userInput, int rowNumber) throws SQLException {

        // if user made a wrong input we can't change the row
        if (rowNumber != 2 && rowNumber != 3){
            return false;
        }

        //search for the row we want to update
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Route WHERE id_r = '" + id + "'");
        resultSet.last();
        int rsSize = resultSet.getRow();

        // there is no element with such ID
        if (rsSize == 0){
            return false;
        }

        if (rowNumber == 2){
            int affectedRows = statement.executeUpdate("UPDATE Route SET startPoint = '" + userInput + "' WHERE id_r = '" + id + "'");
            if (affectedRows != 0){
                return true;
            }
        } else {
            int affectedRows = statement.executeUpdate("UPDATE Transport SET finishPoint = '" + userInput + "' WHERE id_r = '" + id + "'");
            if (affectedRows != 0){
                return true;
            }
        }
        return true;
    }
}
