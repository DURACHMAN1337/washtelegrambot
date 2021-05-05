package ru.itwizard.washtelegrambot.Entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TimeTable {

    public static List<Date> timeTableTotal = new ArrayList<>();

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM");
        Date start = new Date();
        start.setHours(8);
        start.setMinutes(0);
        for (int i = 0; i < 10 ; i++){
            Date date = new Date();
            date.setDate(start.getDay() + i);
            date.setHours(8);
            date.setMinutes(0);
            date.setMinutes(start.getMinutes() + (30 * i));
            timeTableTotal.add(date);
        }
        for (Date date : timeTableTotal){
            System.out.println(sdf.format(date));
        }

    }
}
