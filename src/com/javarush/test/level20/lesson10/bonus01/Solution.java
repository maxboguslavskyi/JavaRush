package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;
import java.util.List;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {

    public static void main(String[] args) {
        Long value0 = System.currentTimeMillis();
        int number = 100000000;
        int[] numbers = getNumbers(number);
        Long value1 = System.currentTimeMillis();
        System.out.println("time: " + (value1 - value0) / 1000d + " sec");
        System.out.println("memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " mb");
        for (int i : numbers) {
            System.out.print(i + ", ");
        }
        System.out.println();

    }

    public static int[] getNumbers(int number) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < number; i++) {
            if (isArmStrong(i)) list.add(i);
        }
        int[] result;
        result = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            result[i] = list.get(i);
        return result;
    }

    private static boolean isArmStrong(int number) {
        int result = 0;
        int original = number;
        int expected = Integer.toString(original).length();
        while (number != 0) {
            int remainder = number % 10;
            result += power(remainder, expected);
            number = number / 10;
        }
        return original == result;
    }

    static int power(double d, long l) {
        int result = 1;
        while (l != 0) {
            if (l % 2 != 0) {
                result *= d;
                l -= 1;
            }
            d *= d;
            l /= 2;
        }
        return result;
    }
}

