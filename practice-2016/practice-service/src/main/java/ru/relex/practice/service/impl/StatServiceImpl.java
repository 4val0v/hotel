package ru.relex.practice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.relex.practice.dao.OrderDAO;
import ru.relex.practice.dao.StatDao;
import ru.relex.practice.dto.OrderDTO;
import ru.relex.practice.dto.StatDTO;
import ru.relex.practice.mappings.OrderMapper;
import ru.relex.practice.mappings.StatMapper;
import ru.relex.practice.model.Order;
import ru.relex.practice.model.Stat;
import ru.relex.practice.service.StatService;
import ru.relex.practice.util.DateIterator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * реализация интерфейса StatService
 */
@Service("statService")
public class StatServiceImpl implements StatService {

    @Autowired
    StatDao statDao;

    @Autowired
    OrderDAO orderDAO;

    @Autowired
    StatMapper statMapper;

    @Autowired
    OrderMapper orderMapper;

    @Transactional
    @Override
    public StatDTO saveStat(Date workDay, int adultsNumber, int childrenNumber, int occupiedRoomsOne, int occupiedRoomsTwo, int occupiedRoomsThree, int occupiedRoomsFour, int occupiedRoomsFive) {
        Stat stat = statDao.addStat(workDay, adultsNumber,childrenNumber, occupiedRoomsOne, occupiedRoomsTwo,occupiedRoomsThree, occupiedRoomsFour,occupiedRoomsFive);
        return statMapper.statToDto(stat);
    }

    @Override
    public List<StatDTO> getStats() {
        return statMapper.statsToDtos(statDao.getStats());
    }

    @Override
    public StatDTO findByDate(Date workday) {
        return null;
    }


    @Transactional
    @Override
    public List<StatDTO> updateStats() {

        List<OrderDTO> orders = orderMapper.ordersToDtos(orderDAO.getAllOrders());

        List<StatDTO> stats = statMapper.statsToDtos(statDao.getStats());

        List<Stat> newStats = new ArrayList<>();

        DateIterator dateIterator = new DateIterator();

        //TODO
        /**
         Добавляет список всех дат с количеством человек в таблицу статистики, идентичные даты не добавляются, но
         даты с разницей во врмени будут добавляться, в дальнейшем можно убрать дублирвоание по дням,
         если не потребуется кастомизация вывода информации.
         */

        for (OrderDTO order : orders) {
            List<Date> listdates = dateIterator.iterateDate(order.getDateCheckIn(), order.getDateCheckOut());
            for (Date date : listdates) {
                if(statDao.getStatByDate(date).size()==0){
                    statDao.addStat(date,order.getCountAdults(),order.getCountChildren(),0,0,0,0,0);
                }

            }
        }

        return stats;
    }

    public List<StatDTO> getLastStat(Date date){

        return statMapper.statsToDtos(statDao.getStatsByDate(date,8));
    }


}
