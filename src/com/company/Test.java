package com.company;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Test {

    public static void main(String args[]) {

        GregorianCalendar gCalendar1 = new GregorianCalendar();

        Date newDate1 = gCalendar1.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date temp = null;
        try {
            temp = sdf.parse("1970-01-01");

            if (newDate1.compareTo(temp) > 0) {
                System.out.println("newDate1 is greater than 1970. Valid date");
            } else {
                System.out.println("Not Valid date. Defaulting.");
                newDate1 = sdf.parse("2000-01-01");
            }
        } catch (ParseException e) {
            //Something
        }

        java.sql.Date d = new java.sql.Date(newDate1.getTime());
        System.out.println("DELAYED BILLING DATE AFTER CONVERTING TO SQLDATE= ®" + d);

        DateFormat dateFormatForDate = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat timeFormatForDate = new SimpleDateFormat("HH:mm:ss");
        java.util.Date date = new java.util.Date();
        String currentDate = dateFormatForDate.format(date);
        System.out.println(currentDate);
        String currentTime = timeFormatForDate.format(date);
        System.out.println(currentTime);


        System.out.println(newDate1);

    }
}
