package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
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

        System.out.println();
        String s3 = br.readLine();
        int num3 = Integer.parseInt(s3);

        System.out.println();
        String s4 = br.readLine();
        int num4 = Integer.parseInt(s4);

        if (num1 >= num2 && num1 >= num3 && num1 >= num4) {
            System.out.println(num1);
        } else if (num2 >= num1 && num2 >= num3 && num2 >= num4) {
            System.out.println(num2);
        } else if (num3 >= num1 && num3 >= num2 && num3 >= num4) {
            System.out.println(num3);
        } else {
            System.out.println(num4);
        }

    }
}
