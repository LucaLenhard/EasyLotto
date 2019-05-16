package com.example.easylotto;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.provider.ContactsContract;
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
            } else return false;
        } else return false;


    }


    public static void getWinner(Cursor data, Context context) {
        DatabaseHelper mDatabaseHelper;

            String temp = data.getString(2);
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


            if (IntegerYear.intValue() == IntegerCurrentYear.intValue() && IntegerMonth.intValue() == IntegerCurrentMonth.intValue() && IntegerDate.intValue() == IntegerCurrentDate.intValue()) {
                Integer buyin = data.getInt(1);
                Integer volumen = data.getInt(3);
                Log.d("fin. game vol:", String.valueOf(volumen));
                Log.d("fin. game buyin:", String.valueOf(buyin));

                double volumen_double = (double) volumen;
                double buyin_double    = (double) buyin;
                int chance = (int) (volumen_double / buyin_double) * 100;
                Integer WinningNumber = (int) (Math.random() * 100);


                if (chance >= WinningNumber && data.getInt(5)==0) {
                    mDatabaseHelper = new DatabaseHelper(context);
                    mDatabaseHelper.updateUserWonGame(data.getInt(0));

                    SharedPreferences sp = context.getSharedPreferences("TaskerPrefs", context.MODE_PRIVATE);
                    int guthaben = sp.getInt("guthaben", 0);
                    Log.d("GUTHABEN", String.valueOf(guthaben));
                    Log.d("VOLUMEN ", String.valueOf(volumen));
                    int neuesGuthaben = guthaben + volumen;

                    sp.edit().putInt("guthaben", neuesGuthaben).commit();

                }



        }

        }
}