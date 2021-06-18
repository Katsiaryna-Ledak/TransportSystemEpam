package com.company.dao;

import com.company.domain.Transport;
import com.company.domain.TransportRouteRelation;

import javax.management.relation.Relation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import static com.company.dao.Connection.statement;

public class RelationDAOImpl implements RelationDAO<TransportRouteRelation> {

    TransportRouteRelation relation = new TransportRouteRelation();

    public TransportRouteRelation getByID(Integer id) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM TRANSPORT_ROUTE_RELATION WHERE id_t = '" + id + "'");

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

        Set<TransportRouteRelation> setOfRelations = new HashSet<TransportRouteRelation>();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM TRANSPORT_ROUTE_RELATION;");

        while (resultSet.next()) {

            int idRelation = resultSet.getInt(1);
            int idTransport = resultSet.getInt(2);
            int idRoute = resultSet.getInt(3);

            relation = new TransportRouteRelation(idRelation, idTransport, idRoute);
            setOfRelations.add(relation);
        }
        return setOfRelations;
    }

    //relation One-to-Many: many transports can be assigned to 1 route
    public Set<TransportRouteRelation> getAllTransportOfTheRoute(Integer id) throws  SQLException {

        Set<TransportRouteRelation> setOfRelations = new HashSet<TransportRouteRelation>();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM TRANSPORT_ROUTE_RELATION WHERE id_r = '" + id + "'");

        while (resultSet.next()) {

            int idRelation = resultSet.getInt(1);
            int idTransport = resultSet.getInt(2);
            int idRoute = resultSet.getInt(3);

            relation = new TransportRouteRelation(idRelation, idTransport, idRoute);
            setOfRelations.add(relation);
        }
        return setOfRelations;
    }

    @Override
    public boolean updateByID(Integer id, String userInput, Integer rowNumber) throws SQLException {
        return false;
    }

    public boolean updateRelationByID(Integer idRelation, Integer userInput, Integer rowNumber) throws SQLException {
        // if user made a wrong input we can't change the row
        if (rowNumber != 2 && rowNumber != 3) {
            return false;
        }

        //search for the row we want to update
        ResultSet resultSet = statement.executeQuery("SELECT * FROM TRANSPORT_ROUTE_RELATION WHERE id_relation = '" + idRelation + "'");
        resultSet.last();
        int rsSize = resultSet.getRow();

        // there is no element with such ID
        if (rsSize == 0) {
            return false;
        }

        if (rowNumber == 2) {
            int affectedRows = statement.executeUpdate("UPDATE TRANSPORT_ROUTE_RELATION SET id_t = '" + userInput + "' WHERE id_relation = '" + idRelation + "'");
            if (affectedRows != 0) {
                return true;
            }
        } else {
            int affectedRows = statement.executeUpdate("UPDATE TRANSPORT_ROUTE_RELATION SET id_r = '" + userInput + "' WHERE id_relation = '" + idRelation + "'");
            if (affectedRows != 0) {
                return true;
            }
        }
        return true;
    }

    @Override
    public boolean create(TransportRouteRelation item) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM TRANSPORT_ROUTE_RELATION");
        resultSet.last();
        int rsSize = resultSet.getRow();

        resultSet.moveToInsertRow();
        resultSet.updateInt(1, rsSize + 1);
        resultSet.updateInt(2, item.getTransportID());
        resultSet.updateInt(3, item.getRouteID());
        resultSet.insertRow();

        ResultSet rsAfterAdding = statement.executeQuery("SELECT * FROM TRANSPORT_ROUTE_RELATION");
        rsAfterAdding.last();
        int rsSizeAfterAdding = rsAfterAdding.getRow();

        if (rsSizeAfterAdding > rsSize) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteByID(Integer id) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM TRANSPORT_ROUTE_RELATION WHERE id_relation = '" + id + "'");
        resultSet.last();
        int rsSize = resultSet.getRow();

        // there is no element with such ID
        if (rsSize == 0) {
            return false;
        }

        int affectedRows = statement.executeUpdate("DELETE FROM TRANSPORT_ROUTE_RELATION WHERE id_relation = '" + id + "'");
        //number of rows affected by the query
        if (affectedRows != 0) {
            return true;
        }
        return true;
    }
}
