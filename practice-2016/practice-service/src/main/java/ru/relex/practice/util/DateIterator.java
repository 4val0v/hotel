package ru.relex.practice.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *  11/28/2016.
 */
public class DateIterator {
    Date firstDate = new Date();
    Date lastDate = new Date();

    public List<Date> iterateDate(Date firstDate, Date lastDate){
        List<Date> listDays = new ArrayList<Date>();
        long start = firstDate.getTime();
        long end = lastDate.getTime();

        for (long i = start; i<=end; i+=86400000){
            Date date = new Date();
            date.setTime(i);
            listDays.add(date);
        }
        return listDays;
    }

    public List<Date> reversiveIterateDate(Date lastDate, int numberDay){

        List<Date> listDays = new ArrayList<Date>();
        long start = lastDate.getTime()-numberDay*86400000;
        long end = lastDate.getTime();

        for (long i = start; i<=end; i+=86400000){
            Date date = new Date();
            date.setTime(i);
            listDays.add(date);
        }
        return listDays;
    }



}
