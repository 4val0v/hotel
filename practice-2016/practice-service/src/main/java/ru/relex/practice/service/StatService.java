package ru.relex.practice.service;

import ru.relex.practice.dto.StatDTO;

import java.util.Date;
import java.util.List;

/**
 * Stat servie
 */
public interface StatService {
    /**
     * добавляет новую запись
     * @param adultsNumber количество взрослых
     * @param childrenNumber количество детей
     * @param occupiedRoomsOne занято однокомнатных номеров
     * @param occupiedRoomsTwo занято двухкомнатных номеров
     * @param occupiedRoomsThree занято трехкомнатных номеров
     * @param occupiedRoomsFour занято четырехкомнатных номеров
     * @param occupiedRoomsFive занято пятикомнатных номеров
     * @return
     * id идентификатор записи;
     */
    StatDTO saveStat(Date workDay,
            int adultsNumber,
            int childrenNumber,
            int occupiedRoomsOne,
            int occupiedRoomsTwo,
            int occupiedRoomsThree,
            int occupiedRoomsFour,
            int occupiedRoomsFive);

    /**
     * Получает список записей из статистики
     * @return
     */
    List<StatDTO> getStats();

    /**
     * Выполняет поиск статистики по дню
     * @param workday дата записи
     * @return запись с заданной датой или {@code null}
     */
    StatDTO findByDate(Date workday);


    List<StatDTO>updateStats();

    List<StatDTO> getLastStat(Date date);







}
