package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {

        Map<Character, Integer> map = new TreeMap<Character, Integer>();
        String fileName = args[0];
        FileInputStream fis = null;


        try {
            fis = new FileInputStream(fileName);

            while (fis.available() > 0) {
                char chars = (char) fis.read();
                if (map.containsKey(chars)) {
                    map.put(chars, map.get(chars) + 1);
                } else {
                    map.put(chars, 1);
                }
            }

            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
    }
}

