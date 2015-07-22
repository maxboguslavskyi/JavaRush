package com.javarush.test.level09.lesson11.home04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* Конвертер дат
Ввести с клавиатуры дату в формате «08/18/2013»
Вывести на экран эту дату в виде «AUG 18, 2013».
Воспользоваться объектом Date и SimpleDateFormat.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String tempDate = reader.readLine();

        //в объект simpleFormat записываем тот формат, который нужен
        SimpleDateFormat simpleFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        //в объект simpleFormat2 записываем текущий по заданию формат
        SimpleDateFormat simpleFormat2 = new SimpleDateFormat("MM/dd/yyyy");
        //В объект data записываем запарсенную строку
        Date date = simpleFormat2.parse(tempDate);
        //Форматируем строку так, как нужно по заданию
        System.out.println(simpleFormat.format(date).toUpperCase());

        //Напишите тут ваш код
    }
}
