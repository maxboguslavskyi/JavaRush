package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        String name = args[0];
        int charCount = 0;

        FileInputStream fis = null;

        try {
            fis = new FileInputStream(name);
            while (fis.available() > 0) {
                int temp = fis.read();
                byte chars = (byte) temp;
                if (chars >= 'a' && chars <= 'z' || chars >= 'A' && chars <= 'Z') {
                    charCount++;
                }
            }
            System.out.print(charCount + " ");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
    }
}

