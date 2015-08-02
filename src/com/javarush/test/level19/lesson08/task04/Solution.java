package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream wrapper = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(byteArrayOutputStream);

        System.setOut(stream);
        testString.printSomething();
        System.setOut(wrapper);

        String result = byteArrayOutputStream.toString();
        result = doCalculation(result);
        System.out.println(result);
    }

    public static String doCalculation(String res) {
        String[] text = res.split(" ");
        int a = Integer.parseInt(text[0]);
        int b = Integer.parseInt(text[2]);
        int c = 0;
        if (text[1].equals("+")) {
            c = a + b;
        } else if (text[1].equals("*")) {
            c = a * b;
        } else if (text[1].equals("-")) {
            c = a - b;
        }

        return a + " " + text[1] + " " + b + " " + text[3] + " " + c;
    }


    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

