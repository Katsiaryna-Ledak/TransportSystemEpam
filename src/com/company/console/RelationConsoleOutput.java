package com.company.console;

import com.company.service.RelationService;

import java.sql.SQLException;

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
}
