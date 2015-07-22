package com.javarush.test.level04.lesson06.task05;

/* 18+
Ввести с клавиатуры имя и возраст. Если возраст меньше 18 вывести надпись «Подрасти еще».
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println();
        String s1 = br.readLine();

        System.out.println();
        String s2 = br.readLine();
        int age = Integer.parseInt(s2);

        if(age < 18) {
            System.out.println("Подрасти еще");
        }
        else
        {
            System.out.println();
        }

    }
}
