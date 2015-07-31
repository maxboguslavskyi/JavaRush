package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static List<String> list = new ArrayList<String>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        int maxValue = 0;

        if (args[0].equals("-c")) {
            while (bufferedReader.ready()) {
                String text = bufferedReader.readLine();
                list.add(text);
                int temp = Integer.parseInt(text.substring(0, 8).replaceAll(" ", ""));
                if (temp > maxValue) {
                    maxValue = temp;
                }
            }
            maxValue++;
            bufferedReader.close();

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));

            for (String s : list) {
                if (s.equals("")) {
                    continue;
                }
                bufferedWriter.write(String.format("%s%n", s));
            }

            String productName = args[1];

            for (int i = 2; i < args.length - 2; i++) {
                productName += " " + args[i];
            }
            bufferedWriter.write(String.format("%-8.8s%-30.30s%-8.8s%-4.4s%n", String.valueOf(maxValue), productName, args[args.length - 2], args[args.length - 1]));
            bufferedWriter.close();
        }
    }
}
