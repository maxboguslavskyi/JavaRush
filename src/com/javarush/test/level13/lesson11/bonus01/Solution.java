package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        //открываем поток для чтения имени файла
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close(); //закрываем поток

        //Создаем лист, в котором будем хранить данные
        ArrayList<Integer> list = new ArrayList<Integer>();

        //Открываем поток чтения из файла
        BufferedReader inputStream = new BufferedReader(new FileReader(fileName));

        while (inputStream.ready()) //пока данные читаются
        {
            int i = Integer.parseInt(inputStream.readLine());
            if (i % 2 == 0) list.add(i);
        }

        Collections.sort(list); //сортируем

        for (int i : list) System.out.println(i);

    }
}

