package com.company.dao;

import com.company.domain.Route;
import com.company.domain.Transport;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.company.dao.TestConnection.statement;

public class RouteDAO {

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
}
