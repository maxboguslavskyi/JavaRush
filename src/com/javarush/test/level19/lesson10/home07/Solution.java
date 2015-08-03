package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<String>();
        String firstFileName = args[0];
        String input;
        BufferedReader reader = new BufferedReader(new FileReader(firstFileName));
        while ((input = reader.readLine()) != null) {
            list.add(input);
        }
        reader.close();

        List<String> finalList = new ArrayList<String>();
        for (String s : list) {
            String[] lines = s.split(" ");
            for (String text : lines) {
                if (text.length() > 6)
                    finalList.add(text);
            }
        }

        String result = "";
        for (int i = 0; i < finalList.size(); i++) {
            if (i == finalList.size() - 1) {
                result = result + finalList.get(i);
            } else {
                result = result + finalList.get(i) + ",";
            }
        }

        String secondFileName = args[1];
        PrintWriter writer = new PrintWriter(new FileWriter(secondFileName));
        writer.println(result);
        writer.close();
    }
}