package ru.relex.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.relex.practice.dto.OrderDTO;
import ru.relex.practice.dto.RoomDTO;
import ru.relex.practice.dto.StatDTO;
import ru.relex.practice.service.FeedbackService;
import ru.relex.practice.service.OrderService;
import ru.relex.practice.service.RoomService;
import ru.relex.practice.service.StatService;
import ru.relex.practice.util.DateIterator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 11/24/2016.
 */
@Controller
@RequestMapping("/")
public class StatController {

    @Autowired
    StatService statService;
    @Autowired
    RoomService roomService;
    @Autowired
    OrderService orderService;
    @Autowired
    FeedbackService feedbackService;

    @RequestMapping(value = "getstats", method = RequestMethod.GET)
    public @ResponseBody List<ListData> statPage() {

        List<RoomDTO> rooms = roomService.getRooms();

        ListData data = new ListData();
        List<ListData> listData = new ArrayList<>();

        Date date = new Date();

        int number = 0;
        float rating=0;
        for (RoomDTO room : rooms){
            number+=room.getPersons();
            rating+=room.getRatingAvg();
        }

        data.roomsNumber = roomService.getRooms().size(); //всего комнат
        data.ordersNumber = orderService.findOrderByDay(date).size(); //занято комнат
        data.placesNumber = number; //всего мест
        data.guestsNumber = orderService.getGuestsNumberByDate(date);
        data.avgRating = rating/data.roomsNumber;
        data.feedbackNumber = feedbackService.getFeedback().size();
        listData.add(data);

        return listData;
    }

    @RequestMapping(value = "chartdata", method = RequestMethod.GET)
    public @ResponseBody List<StatDTO> getChartInfo() {

        return statService.getLastStat(new Date());
    }



    @RequestMapping(value = "update", method = RequestMethod.GET)
    public @ResponseBody List<StatDTO> updateStat() {
        statService.updateStats();
        //statService.saveStat(new Date(),1,0,0,0,0,0,0);
        return statService.getLastStat(new Date());
    }

    private class ListData {
        public Integer roomsNumber;
        public Integer ordersNumber;
        public Integer placesNumber;
        public Integer guestsNumber;
        public Float avgRating;
        public Integer feedbackNumber;

    }
}
