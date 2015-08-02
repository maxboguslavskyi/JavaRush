package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки ввода-вывода.
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов.
*/

import java.io.*;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = bufferedReader.readLine();
        String secondFileName = bufferedReader.readLine();
        FileReader reader = null;
        FileWriter writer = null;

        try {
            reader = new FileReader(firstFileName);
            writer = new FileWriter(secondFileName);

            while (reader.ready()) {
                char chars = (char) reader.read();
                if (!Pattern.matches("\\p{P}", String.valueOf(chars))) {
                    writer.write(chars);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null && writer != null) {
                reader.close();
                writer.close();
            }
        }

    }
}
