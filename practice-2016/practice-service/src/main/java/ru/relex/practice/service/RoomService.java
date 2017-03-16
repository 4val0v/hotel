package ru.relex.practice.service;

import ru.relex.practice.dto.FacilityDTO;
import ru.relex.practice.dto.RoomDTO;
import ru.relex.practice.model.Room;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Интерфейс получения данных по номерам
 */
public interface RoomService {
    /**
     * Сохраняет новую комнату
     * @param shortDescription - краткое описание
     * @param fullDescription - подробное описание
     * @param persons - количество человек
     * @param numberOfRooms - колчичество комнат
     * @param price - стоимость
     * @param isBooked - является ли номер забронированным
     * @param isShown - показывается ли номер на сайте
     * @param hasBreakfast - включен ли в стоимость завтрак
     * @param urlPhoto1 - ссылка на фоото
     * @param urlPhoto2 - ссылка на фоото
     * @param urlPhoto3 - ссылка на фоото
     * @param ratingPosition - оценка расположения
     * @param ratingComfort - оценка условий
     * @param ratingPrice - оценка стоимости
     * @param ratingQuality - оценка качества обслуживания
     * @param ratingAvg - средний рейтинг
     * @return DTO созданной комнаты
     */
    RoomDTO saveRoom(String shortDescription,
                     String fullDescription,
                     Integer persons,
                     Integer numberOfRooms,
                     Long price,
                     Boolean isBooked,
                     Boolean isShown,
                     Boolean hasBreakfast,
                     String urlPhoto1, String urlPhoto2, String urlPhoto3,
                     Double ratingPosition, Double ratingComfort, Double ratingPrice, Double ratingQuality,
                     Double ratingAvg, Set<FacilityDTO> facilityDTOs, String name);
    
    /**
     * Сохраняет новую комнату сериализуя объект Room из json
     * @param room - сериализованный из json объект RoomDTO
     * @return DTO созданной комнаты
     */
    RoomDTO saveRoomFromJson(RoomDTO room);
    
    /**
     * Удаляет комнату по id
     * @param id - идентификатор комнаты
     */
    void removeRoom(Integer id);
    
    /**
     * Обновляет набор удобств в комнате по id
     * @param room - содержит заполненные поля id и facilities
     */
    void updateFacilitiesForRoom(RoomDTO room);
    
    /**
     * Обновляет свойства комнаты по id
     * @param room - содержит заполненное поле id и
     * произвольный набор остальных свойств
     */
    void updateRoom(RoomDTO room);

    /**
     * @return  список комнат
     */
    List<RoomDTO> getRooms();

    /**
     *
     * @param id идентификатор номера
     * @param persons максимальное количество человек в номере
     * @param amountOfRooms количество комнат в номере
     * @param prices средняя цена
     * @param hasBreakfast есть завтрак
     * @return список комнат по заданному параметру
     */
    List<RoomDTO> getRooms(Integer id, Integer persons, Integer amountOfRooms, Integer prices, Boolean hasBreakfast);

    /**
     * @return top 5 rooms
     */
    List<RoomDTO> getTopFive();
}
