package com.javarush.test.level04.lesson06.task01;

/* Минимум двух чисел
Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        String s1 = br.readLine();
        int num1 = Integer.parseInt(s1);

        System.out.println();
        String s2 = br.readLine();
        int num2 = Integer.parseInt(s2);

        int min = 0;

        if (num1 < num2) {
            min = num1;
        } else {
            min = num2;
        }
        System.out.println(min);

        /* данные для тестирования:
        введите 1 и 2, минимум =  1
        введите 2 и 1, минимум =  1
        введите 1 и 1, минимум =  1
        введите -1 и -2, минимум =  -2
         */
    }
}