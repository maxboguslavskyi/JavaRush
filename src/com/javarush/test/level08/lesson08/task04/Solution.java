package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Сталлоне", new Date("JUNE 1 1980"));
        map.put("Баллок", new Date("JULY 5 1970"));
        map.put("Камерон", new Date("May 14 1956"));
        map.put("Диаз", new Date("DECEMBER 7 1998"));
        map.put("Кэрол", new Date("JUNE 7 1979"));
        map.put("Ривз", new Date("OCTOBER 3 1958"));
        map.put("Дауни", new Date("MARCH 28 1987"));
        map.put("Стрип", new Date("FEBRUARY 17 1971"));
        map.put("Махони", new Date("NOVEMBER 9 1943"));
        map.put("Бэй", new Date("JUNE 21 1993"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Date> pair = iterator.next();
            Date value = pair.getValue();
            int rad = value.getMonth();
            if (rad == 5 || rad == 6 || rad == 7)
                iterator.remove();
        }
    }
}
