package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

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

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        String productName = "";

        ArrayList<String> strList = getStringList(fileName);
        ArrayList<Long> idList = getIdList(fileName);
        PrintWriter printWriter;
        int index = idList.indexOf(Long.parseLong(args[1]));

        if (args[0].equals("-u")) {
            for (int i = 2; i < args.length - 2; i++) {
                productName = productName + args[i] + " ";
            }

            String trueProductName = setSpaces(productName, 30);
            String truePrice = setSpaces(args[args.length - 2], 8);
            String trueQuantity = setSpaces(args[args.length - 1], 4);
            String id = setSpaces(args[1], 8);
            String resultString = id + trueProductName + truePrice + trueQuantity;

            if (!idList.contains(Long.parseLong(args[1]))) {
                printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));
                printWriter.println(resultString);
            } else {
                strList.set(index, resultString);
                printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
                for (String s : strList)
                    printWriter.println(s);
            }
            printWriter.close();
        } else if (args[0].equals("-d")) {
            strList.remove(index);
            printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
            for (String s : strList)
                printWriter.println(s);
            printWriter.close();
        }
    }

    public static ArrayList<String> getStringList(String fileName) throws IOException {
        ArrayList<String> allStr = new ArrayList<String>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            allStr.add(line);
        }
        bufferedReader.close();
        return allStr;
    }

    public static ArrayList<Long> getIdList(String fileName) throws IOException {
        ArrayList<Long> allIds = new ArrayList<Long>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        Long currentId;
        while ((line = reader.readLine()) != null) {
            line = line.substring(0, 8).replaceAll("\\s", "");
            currentId = Long.parseLong(line);
            allIds.add(currentId);
        }
        reader.close();
        return allIds;
    }


    public static String setSpaces(String previousName, int count) {
        String trueName;
        if (previousName.length() > count)
            trueName = previousName.substring(0, count);
        else {
            String text = "";
            for (int i = 0; i < (count - previousName.length()); i++) {
                text = text + " ";
            }
            trueName = previousName + text;
        }
        return trueName;
    }
}
