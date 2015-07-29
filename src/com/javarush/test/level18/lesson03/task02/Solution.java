package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();
        FileInputStream in = null;
        int min = 0;
        try {
            in = new FileInputStream(name);
            in.read();

            while (in.available() > 0) {
                int temp = in.read();
                if (temp < min) {
                    min = temp;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            in.close();
            System.out.println(min);
        }
    }
}
