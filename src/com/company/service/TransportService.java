package com.company.service;

import com.company.dao.TransportDAO;
import com.company.domain.Transport;

import java.sql.SQLException;
import java.util.Set;

public class TransportService {

    TransportDAO transportDAO = new TransportDAO();

    public Transport get(Integer id) throws SQLException {

        return transportDAO.getTransportById(id);
    }

    public Set<Transport> getAll() throws SQLException {

        return transportDAO.getAll();
    }
}
