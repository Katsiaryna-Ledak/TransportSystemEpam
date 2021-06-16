package com.company.dao;

import com.company.domain.Transport;
import com.company.domain.TransportRouteRelation;

import javax.management.relation.Relation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import static com.company.dao.Connection.statement;

public class RelationDAOImpl implements RelationDAO<TransportRouteRelation> {
    
    public TransportRouteRelation getByID(Integer id) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Relation WHERE id_t = '" + id + "'");

        resultSet.last();
        int rsSize = resultSet.getRow();

        if (rsSize == 0) {
            return null;
        }

        int idRelation = resultSet.getInt(1);
        int idTransport = resultSet.getInt(2);
        int idRoute = resultSet.getInt(3);

        TransportRouteRelation relation = new TransportRouteRelation(idRelation, idTransport, idRoute);
        return relation;
    }

    @Override
    public Set<TransportRouteRelation> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean updateByID(Integer id, String userInput, Integer rowNumber) throws SQLException {
        return false;
    }

    @Override
    public boolean create(TransportRouteRelation item) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteByID(Integer id) throws SQLException {
        return false;
    }
}
