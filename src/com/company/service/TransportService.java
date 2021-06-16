package com.company.service;

import com.company.dao.TransportDAOImpl;
import com.company.domain.Transport;

import java.sql.SQLException;
import java.util.Set;

public class TransportService {

    TransportDAOImpl transportDAOImpl = new TransportDAOImpl();

    public Transport get(Integer id) throws SQLException {

        return transportDAOImpl.getByID(id);
    }

    public Set<Transport> getAll() throws SQLException {

        return transportDAOImpl.getAll();
    }

    public boolean deleteByID(Integer id) throws SQLException {

        return transportDAOImpl.deleteByID(id);
    }

    public boolean updateByID(Integer id, String userInput, Integer rowNumber) throws SQLException {

        return transportDAOImpl.updateByID(id, userInput, rowNumber);
    }

    public boolean create(Transport transport) throws SQLException {

        return transportDAOImpl.create(transport);
    }
}
