package ru.relex.practice.dao;


import ru.relex.practice.model.RoomPrice;

import java.util.List;

public interface RoomPriceDao {

    List<RoomPrice> getCoast(Integer id);

}
