package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        Set<Integer> set = new TreeSet<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fis = null;

        try {
            fis = new FileInputStream(reader.readLine());

            while (fis.available() > 0) {
                int temp = fis.read();
                set.add(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
        }

        for (Integer bytes : set) {
            System.out.print(bytes + " ");
        }
    }
}
