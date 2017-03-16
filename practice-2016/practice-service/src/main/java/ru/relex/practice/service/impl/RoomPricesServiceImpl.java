package ru.relex.practice.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.relex.practice.dao.RoomPriceDao;
import ru.relex.practice.dto.RoomPriceDTO;
import ru.relex.practice.mappings.RoomPricesMapper;
import ru.relex.practice.service.RoomPricesService;

import java.time.LocalDate;
import java.util.List;

@Service(value = "roomPricesService")
public class RoomPricesServiceImpl implements RoomPricesService {

    @Autowired
    RoomPricesMapper mapper;
    @Autowired
    RoomPriceDao priceDao;

    @Override
    public int getCoast(Integer id, LocalDate dateBegin, LocalDate dateEnd) {
        List<RoomPriceDTO> prices = mapper.roomsPricesToRoomPriceDtos(priceDao.getCoast(id));
        int coast = 0;
        for (RoomPriceDTO roomPriceDTO : prices) {
            if (roomPriceDTO.getDateBegin().toEpochDay() <= dateBegin.toEpochDay() &&
                    roomPriceDTO.getDateEnd().toEpochDay() <= dateEnd.toEpochDay() &&
                    roomPriceDTO.getDateEnd().toEpochDay() >= dateBegin.toEpochDay()) {  /*|..\...|.../.....*/
                System.out.println(dateBegin.toEpochDay() - roomPriceDTO.getDateEnd().toEpochDay());
                coast += (roomPriceDTO.getDateEnd().toEpochDay() - dateBegin.toEpochDay()+1) * roomPriceDTO.getPrice();
            }
            if (roomPriceDTO.getDateBegin().toEpochDay() >= dateBegin.toEpochDay() &&
                    roomPriceDTO.getDateEnd().toEpochDay() <= dateBegin.toEpochDay()) {
                    System.out.println(roomPriceDTO.getDateEnd().toEpochDay() - roomPriceDTO.getDateBegin().toEpochDay());
                    coast += (roomPriceDTO.getDateEnd().toEpochDay() - roomPriceDTO.getDateBegin().toEpochDay()+1)* roomPriceDTO.getPrice();
            }
            if (roomPriceDTO.getDateBegin().toEpochDay() > dateBegin.toEpochDay() &&
                        roomPriceDTO.getDateEnd().toEpochDay() >= dateEnd.toEpochDay() &&
                        roomPriceDTO.getDateBegin().toEpochDay()<= dateEnd.toEpochDay()) {
                        System.out.println(roomPriceDTO.getDateEnd().toEpochDay() - dateEnd.toEpochDay());
                        coast += (dateEnd.toEpochDay()-roomPriceDTO.getDateBegin().toEpochDay()+1)* roomPriceDTO.getPrice();
            }
            if (roomPriceDTO.getDateBegin().toEpochDay() < dateBegin.toEpochDay() &&
                            roomPriceDTO.getDateEnd().toEpochDay() > dateBegin.toEpochDay()) {
                            System.out.println(dateEnd.toEpochDay() - dateBegin.toEpochDay());
                            coast += (dateEnd.toEpochDay() - dateBegin.toEpochDay()+1)* roomPriceDTO.getPrice();
                        }
        }
        return coast;
    }
}