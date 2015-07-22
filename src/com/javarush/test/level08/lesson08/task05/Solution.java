package com.javarush.test.level08.lesson08.task05;

import java.util.*;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{

    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Андреев", "Сергей");
        map.put("Алексеев", "Юрий");
        map.put("Абрамян", "Юрий");
        map.put("Осипов", "Иван");
        map.put("Захаров", "Сергей");
        map.put("Минин", "Кирилл");
        map.put("Панин", "Юрий");
        map.put("Захаров1", "Юрий");
        map.put("Осипов1", "Иван");
        map.put("Захаров2", "Юрий");
        return map;
        //Напишите тут ваш код

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        String a = ""; int i = 0;
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
           a = pair.getValue();
           for (Map.Entry<String, String> pair2: copy.entrySet())
           {
               if (pair2.getValue().equals(a))
                   i++;
           }
           if (i > 1)
           removeItemFromMapByValue(map, a);
           i = 0;
        }
        //Напишите тут ваш код

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
