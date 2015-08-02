package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки ввода-вывода.

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(new FileReader(reader.readLine()));
        DataOutputStream stream = new DataOutputStream(new FileOutputStream(reader.readLine()));
        while (scanner.hasNext()) {
            String line = scanner.next();
            String[] buffer = line.replaceAll("[\\p{Punct}]", " ").split(" ");
            for (String text : buffer) {
                if (isDigit(text)) {
                    String result = text + " ";
                    stream.write(result.getBytes());
                }
            }
        }
        scanner.close();
        stream.close();
    }

    public static boolean isDigit(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}


