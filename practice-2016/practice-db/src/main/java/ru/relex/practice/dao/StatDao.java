package ru.relex.practice.dao;

import ru.relex.practice.model.Stat;

import java.util.Date;
import java.util.List;

/**
 * 24.11.2016.
 * interface DAO
 */
public interface StatDao {

    Stat addStat(Date workDay, int adultsNumber, int childrenNumber, int occupiedRoomsOne, int occupiedRoomsTwo, int occupiedRoomsThree, int occupiedRoomsFour, int occupiedRoomsFive);
    Stat getNumberOccupiedRoomsByDate(Date wDay);
    int getNumberOccupiedRoomsById(long id);
    List <Stat> getStats();
    List <Stat> updateStats();
    List <Stat> getStatByDate(Date workDay);
    List<Stat> getStatsByDate(Date workDay, int numberdays);


}
