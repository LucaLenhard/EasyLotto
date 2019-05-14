package com.example.easylotto;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GameFunctions {

    public static boolean getValid(String temp) {
        //Subtstring Draw Date
        String substr = temp.substring(temp.indexOf(".") + 1);
        String year = substr.substring(substr.indexOf(".") + 1);
        String month = substr.substring(0, 2);
        String date = temp.substring(0, 2);

        // Sub String actual date
        String today = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        String temptemp = today.substring(today.indexOf("-") + 1);
        String dateToday = today.substring(0, 2);

        String temp3 = today.substring(today.indexOf("-") + 1);
        String monthToday = temp3.substring(0, 2);
        String yearToday = today.substring(today.length() - 4);

        Integer IntegerDate = Integer.parseInt(date);
        Integer IntegerMonth = Integer.parseInt(month);
        Integer IntegerYear = Integer.parseInt(year);
        Integer IntegerCurrentDate = Integer.parseInt(dateToday);
        Integer IntegerCurrentMonth = Integer.parseInt(monthToday);
        Integer IntegerCurrentYear = Integer.parseInt(yearToday);

        if (IntegerYear <= IntegerCurrentYear) {
            if (IntegerMonth == IntegerCurrentMonth && IntegerDate < IntegerCurrentDate) {
                return true;

            } else if (IntegerMonth < IntegerCurrentMonth) {
                return true;
            }else return false;
        }else return false;


   }
}
