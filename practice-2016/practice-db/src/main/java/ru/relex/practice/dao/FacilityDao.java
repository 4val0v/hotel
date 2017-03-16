package ru.relex.practice.dao;


import ru.relex.practice.model.Facility;

import java.util.List;

public interface FacilityDao {

    Facility getByID(Integer id);

    Facility getByName(String name);

    List<Facility> getFacilities();

}
