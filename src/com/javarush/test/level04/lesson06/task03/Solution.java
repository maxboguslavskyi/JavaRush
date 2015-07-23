package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println();
        String s1 = br.readLine();
        int n1 = Integer.parseInt(s1);

        System.out.println();
        String s2 = br.readLine();
        int n2 = Integer.parseInt(s2);

        System.out.println();
        String s3 = br.readLine();
        int n3 = Integer.parseInt(s3);

        if (n1 < n2 && n2 < n3)
            System.out.println(n3 + " " + n2 + " " + n1);
        else if (n2 < n1 && n1 < n3)
            System.out.println(n3 + " " + n1 + " " + n2);
        else if (n3 < n1 && n1 < n2)
            System.out.println(n2 + " " + n1 + " " + n3);
        else if (n3 < n2 && n2 < n1)
            System.out.println(n1 + " " + n2 + " " + n3);
        else if (n1 < n3 && n3 < n2)
            System.out.println(n2 + " " + n3 + " " + n1);
        else System.out.println(n1 + " " + n3 + " " + n2);


    }
}
