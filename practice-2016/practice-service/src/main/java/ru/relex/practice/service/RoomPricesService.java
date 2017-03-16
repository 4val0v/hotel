package ru.relex.practice.service;

import java.time.LocalDate;

public interface RoomPricesService {
    int getCoast(Integer id, LocalDate dateBegin, LocalDate dateEnd);
}
