package com.javarush.test.level04.lesson06.task06;

/* И 18-ти достаточно
Ввести с клавиатуры имя и возраст. Если возраст больше 20 вывести надпись «И 18-ти достаточно».
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
        int age = Integer.parseInt(s2);

        if (age > 20) {
            System.out.println("И 18-ти достаточно");
        } else {
            System.out.println();
        }

    }
}
