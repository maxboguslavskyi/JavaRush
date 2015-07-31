package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран частоту встречания пробела. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
Закрыть потоки
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = null;
        String name = args[0];
        double result;
        int count = 0;
        int spaceCount = 0;

        try {
            fis = new FileInputStream(name);

            while (fis.available() > 0) {
                int temp = fis.read();
                count++;

                if (temp == (int) ' ') {
                    spaceCount++;
                }
            }

            result = (double) spaceCount / count * 100;
            System.out.printf("%.2f", result);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
    }
}







