package com.javarush.test.level04.lesson06.task04;

/* Сравнить имена
Ввести с клавиатуры два имени, и если имена одинаковые вывести сообщение «Имена идентичны».
 Если имена разные, но их длины равны – вывести сообщение – «Длины имен равны».
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println();
        String s1 = br.readLine();

        System.out.println();
        String s2 = br.readLine();

        if (s1.equals(s2)) {
            System.out.print("Имена идентичны");
        } else if (s1.length() == s2.length()) {
            System.out.print("Длины имен равны");
        } else {
            System.out.println();
        }


    }
}
