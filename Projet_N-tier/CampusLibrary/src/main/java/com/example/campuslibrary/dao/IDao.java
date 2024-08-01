package com.example.campuslibrary.dao;

import java.util.List;

public interface IDao<o> {
    boolean create(o elm1);

    boolean update(o elm1);

    boolean delete(o elm1);

    o getById(int id);

    List<o> findAll();
}
