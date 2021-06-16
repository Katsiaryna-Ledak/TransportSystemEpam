package com.company.service;

import com.company.dao.RelationDAOImpl;
import com.company.dao.TransportDAOImpl;
import com.company.domain.Transport;
import com.company.domain.TransportRouteRelation;

import javax.management.relation.Relation;
import java.sql.SQLException;
import java.util.Set;

public class RelationService {

    RelationDAOImpl relationDAOImpl = new RelationDAOImpl();

    public TransportRouteRelation get(Integer id) throws SQLException {

        return relationDAOImpl.getByID(id);
    }

    public Set<TransportRouteRelation> getAll() throws SQLException {

        return relationDAOImpl.getAll();
    }

    public boolean deleteByID(Integer id) throws SQLException {

        return relationDAOImpl.deleteByID(id);
    }

    public boolean updateByID(Integer idRel, String idTran, Integer idRoute) throws SQLException {

        //не забыть преобразовать параметра String idTran в Integer

        return relationDAOImpl.updateByID(idRel, idTran, idRoute);
    }

    public boolean create(TransportRouteRelation relation) throws SQLException {

        return relationDAOImpl.create(relation);
    }
}
