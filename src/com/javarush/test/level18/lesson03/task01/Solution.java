package com.javarush.test.level18.lesson03.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();
        FileInputStream in = null;
        int max = 0;
        try {
            in = new FileInputStream(name);
            max = in.read();

            while (in.available() > 0) {
                int temp = in.read();
                if (temp > max) {
                    max = temp;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            in.close();
            System.out.println(max);
        }

    }
}
