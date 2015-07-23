package com.javarush.test.level10.lesson11.home04;

/* Большая зарплата
Вывести на экран надпись «Я не хочу изучать Java, я хочу большую зарплату» 40 раз по образцу.
Образец:
Я не хочу изучать Java, я хочу большую зарплату
 не хочу изучать Java, я хочу большую зарплату
не хочу изучать Java, я хочу большую зарплату
е хочу изучать Java, я хочу большую зарплату
 хочу изучать Java, я хочу большую зарплату
хочу изучать Java, я хочу большую зарплату
…
*/

public class Solution {
    public static void main(String[] args) {
        //первый вариант - мой. Уродство, если честно.
        String s = "Я не хочу изучать Java, я хочу большую зарплату";
        char[] st = s.toCharArray();
        for (int i = 0; i < 40; i++) {
            //Конструктор String()  принимает параметры - массив символов, номер начального символа, номер конечного символа
            String str = new String(st, i, st.length - i);
            System.out.println(str);

        }

        //второй вариант Eldqs

/*       String s = "Я не хочу изучать Java, я хочу большую зарплату";

        //Напишите тут ваш код
        char[] c = new char[s.length()];
        for(int i = 0; i < s.length(); i++)
        {

            c[i] = s.charAt(i);

        }
        for(int i = 0; i < 40; i++)
        {
            System.out.print("\n");
            for(int j = i; j < c.length; j++)
            {
                System.out.print(c[j]);
            }
        }
*/
        //третий вариант - MSBlast


/*      int i=1;
        String s = "Я не хочу изучать Java, я хочу большую зарплату";
        for (int j = 0; j < 40; j++){
            if (s.substring(j).startsWith(" ")) j++;
            if (i%2==0) {
                System.out.println(s.substring(j));
                System.out.println(s.substring(j));
            }
            else
                System.out.println(s.substring(j));
            i++;
        }
*/

        //самый правильный способ - четвертый.

/*
        for(int i = 0; i < s.length(); i++) System.out.println(s.substring(i, s.length()));
*/
    }

}
