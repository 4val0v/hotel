package ru.relex.practice.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.relex.practice.dao.StatDao;
import ru.relex.practice.model.Order;
import ru.relex.practice.model.Stat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

/**
 * Data Access Object для статистики
 */
@Repository
public class StatDaoImpl implements StatDao {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Stat addStat(Date workDay, int adultsNumber, int childrenNumber, int occupiedRoomsOne, int occupiedRoomsTwo, int occupiedRoomsThree, int occupiedRoomsFour, int occupiedRoomsFive) {
        Stat stat = new Stat();
        stat.setWorkDay(workDay);
        stat.setAdultsNumber(adultsNumber);
        stat.setChildrenNumber(childrenNumber);
        stat.setOccupiedRoomsOne(occupiedRoomsOne);
        stat.setOccupiedRoomsTwo(occupiedRoomsTwo);
        stat.setOccupiedRoomsThree(occupiedRoomsThree);
        stat.setOccupiedRoomsFour(occupiedRoomsFour);
        stat.setOccupiedRoomsFive(occupiedRoomsFive);
        manager.persist(stat);
        return stat;

    }

    @Override
    public Stat getNumberOccupiedRoomsByDate(Date workDay) {
        List<Stat> numberRooms = manager.createQuery("FROM Stat WHERE workDay = :workDay", Stat.class).
                setParameter("workDay", workDay).getResultList();
        return numberRooms.isEmpty() ? null : numberRooms.get(0);
    }

    @Override
    public int getNumberOccupiedRoomsById(long id) {
        List<Stat> numberRooms = manager.createQuery("FROM Stat WHERE id = :id", Stat.class).
                setParameter("id", id).getResultList();

        int number = 0;

        for (Stat stat : numberRooms){
            number+=stat.getOccupiedRoomsOne()+stat.getOccupiedRoomsTwo()+stat.getOccupiedRoomsThree()+
                    stat.getOccupiedRoomsFour()+stat.getOccupiedRoomsFive();
        }

        return number;
    }

    @Override
    public List <Stat> getStats() {
        return manager.createQuery("FROM Stat", Stat.class).getResultList();
    }


    @Override
    public List<Stat> updateStats() {

        //TODO

        return null;

    }

    @Override
    public List<Stat> getStatByDate(Date workDay) {

        Date dayBefore = new Date();
        dayBefore.setTime(workDay.getTime()-86400000);
        Date dayAfter = new Date();
        dayAfter.setTime(workDay.getTime()+86400000);


        List<Stat> stats = manager.createQuery("FROM Stat WHERE ( workDay>=:dBefore) AND (workDay<= :dAfter)", Stat.class)
                .setParameter("dBefore", dayBefore).setParameter("dAfter",dayAfter).getResultList();

        return stats;
    }


    @Override
    public List<Stat> getStatsByDate(Date workDay, int numberdays) {

        Date dayBefore = new Date();
        dayBefore.setTime(workDay.getTime()-86400000*numberdays);

        List<Stat> stats = manager.createQuery("FROM Stat WHERE workDay>:dBefore ORDER BY workDay", Stat.class)
                .setParameter("dBefore", dayBefore).getResultList();

        return stats;
    }

}
