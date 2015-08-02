package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть поток ввода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader bufferedReader = null;
        int wordCount = 0;

        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));

            while (bufferedReader.ready()) {
                String[] text = bufferedReader.readLine().replaceAll("\\p{Punct}", " ").split(" ");
                for (String s : text) {
                    if (s.equals("world")) {
                        wordCount++;
                    }
                }
            }
            System.out.println(wordCount);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
    }
}