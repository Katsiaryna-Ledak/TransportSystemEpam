package com.company.console;

import com.company.domain.Transport;
import com.company.domain.TransportRouteRelation;
import com.company.service.RelationService;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class RelationConsoleOutput {

    RelationService relationService = new RelationService();

    public void outputRelation(Integer id) throws SQLException {

        if (relationService.get(id) == null){
            System.out.println("There is no relation with this ID");
            return;
        }
        System.out.println("Data about chosen relation: ");
        System.out.println(relationService.get(id));
    }

    public void outputAllRelationsForOneRoute (Integer idRoute) throws SQLException {

        if (relationService.getAllRelationForOneRoute(idRoute) == null){
            System.out.println("There is no any transport assigned to this route");
            return;
        }

        Set<TransportRouteRelation> allConnections = new HashSet<>();
        allConnections = relationService.getAllRelationForOneRoute(idRoute);

        System.out.println("Data about transport for certain route: ");
        for (TransportRouteRelation connection : allConnections) {
            System.out.println(relationService.get(connection.getRelationID()));
        }
        return;
    }

    public void outputAllRelationsFromDB() throws SQLException {

        if (relationService.getAll() == null){
            System.out.println("There is no any connection in your DB");
            return;
        }

        Set<TransportRouteRelation> allRelations = new HashSet<>();
        allRelations = relationService.getAll();

        System.out.println("Data about transport: ");
        for (TransportRouteRelation rel : allRelations) {
            System.out.println(relationService.get(rel.getRelationID()));
        }
        return;
    }

    public void createRelation (TransportRouteRelation relation) throws SQLException {

        boolean isCreated = relationService.create(relation);
        if (isCreated == false){
            System.out.println("The item was not created");
            return;
        }

        System.out.println("Relation between TRANSPORT and ROUTE was created and added to DB");
    }

    public void deleteRelationByID (Integer id) throws SQLException{

        boolean ifDeleted = relationService.deleteByID(id);
        if (ifDeleted == false){
            System.out.println("There is no element with this ID");
            return;
        }

        System.out.println("Transport with this ID was deleted");
        relationService.getAll();
    }

    public void updateRelationByID (Integer idRel, Integer userInput, Integer rowNumber) throws SQLException {
        boolean isUpdated = relationService.updateRelationByID(idRel, userInput, rowNumber);
        if (isUpdated == false){
            System.out.println("There is no element with this ID");
            return;
        }

        System.out.println("Transport with this ID was updated");
        System.out.println(relationService.get(idRel));
    }
}
