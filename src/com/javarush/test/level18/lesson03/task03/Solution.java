package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байты, которые чаше всех встречаются в файле
Вывести их на экран через пробел.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fis = null;

        try {
            fis = new FileInputStream(reader.readLine());

            while (fis.available() > 0) {
                int temp = fis.read();
                if (map.containsKey(temp)) {
                    map.put(temp, (map.get(temp)) + 1);
                } else {
                    map.put(temp, 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
        }

        int frequent = 0;
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            Integer value = pair.getValue();
            if (value > frequent) {
                frequent = value;
            }
        }

        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            if (pair.getValue() == frequent) {
                System.out.print(pair.getKey() + " ");
            }
        }
    }
}