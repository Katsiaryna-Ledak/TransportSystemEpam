package com.company.dao;

import java.sql.SQLException;
import java.util.Set;

public interface CrudDAO<T> {

    T getByID(Integer id) throws SQLException;

    Set<T> getAll() throws SQLException;

    boolean updateByID(Integer id, String userInput, Integer rowNumber) throws SQLException;

    boolean create(T item) throws SQLException;

    boolean deleteByID(Integer id) throws SQLException;

}
