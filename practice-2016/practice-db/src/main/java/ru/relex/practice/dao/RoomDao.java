package ru.relex.practice.dao;

import ru.relex.practice.model.Facility;
import ru.relex.practice.model.Room;

import java.util.List;
import java.util.Set;

public interface RoomDao {
    /**
     * Создает новую комнату
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
     * @param facilities - множество удобств
     * @return идентификатор созданной комнаты
     */
    Room createRoom(String shortDescription,
                    String fullDescription,
                    Integer persons,
                    Integer numberOfRooms,
                    Long price,
                    Boolean isBooked,
                    Boolean isShown,
                    Boolean hasBreakfast,
                    String urlPhoto1, String urlPhoto2, String urlPhoto3,
                    Double ratingPosition, Double ratingComfort, Double ratingPrice, Double ratingQuality,
                    Double ratingAvg, Set<Facility> facilities, String name);

    /**
     * Удаляет комнату по id
     * @param id - идентификатор комнаты
     */
    void deleteRoom(Integer id);
    
    /**
     * Обновляет список удобств комнаты по её id
     * @param id - идентификатор комнаты
     * @param facilities - новый полный список удобств
     */
    void updateFacilitiesForRoom(Integer id, Set<Facility> facilities);
    
    /**
     * Обновляет произвольный набор свойств комнаты по её id
     * @param id - идентификатор комнаты
     * @param facilities - новый полный список удобств
     */
    void updateRoom(Integer id, String shortDescription,
            String fullDescription,
            Integer persons,
            Integer numberOfRooms,
            Long price,
            Boolean isBooked,
            Boolean isShown,
            Boolean hasBreakfast,
            String urlPhoto1, String urlPhoto2, String urlPhoto3,
            Double ratingPosition, Double ratingComfort, Double ratingPrice, Double ratingQuality,
            Double ratingAvg, Set<Facility> facilities, String name);

    /**
     *
     * @param id идентификатор номера
     * @param persons максимальное количество человек в номере
     * @param amountOfRooms количество комнат в номере
     * @param prices средняя цена
     * @param hasBreakfast есть завтрак
     * @return список комнат по заданному параметру
     */

    List<Room> getRooms(Integer id,Integer persons, Integer amountOfRooms, Integer prices, Boolean hasBreakfast);

    /**
     * @return список всех комнат
     */
    List<Room> getRooms();
    
    /**
     * @return топ 5 лучших комнат
     */
    List<Room> getTopFive();
}
