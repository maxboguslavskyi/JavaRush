package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать во второй файл
Закрыть потоки
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        List<Double> list = new ArrayList<Double>();

        doScan(list);

        String secondFile = reader.readLine();
        FileWriter fw = new FileWriter(secondFile);
        for (Double d : list) {
            int result = (int) Math.round(d);
            fw.write(result + " ");
        }
        fw.close();
    }


    public static List<Double> doScan(List<Double> list) throws IOException {
        String firstFile = reader.readLine();
        Scanner scanner = new Scanner(new FileReader(firstFile));
        while (scanner.hasNext()) {
            String[] text = scanner.nextLine().split(" ");
            for (int i = 0; i < text.length; i++) {
                list.add(Double.parseDouble(text[i]));
            }
        }
        scanner.close();
        return list;
    }
}



