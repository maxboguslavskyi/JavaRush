package com.javarush.test.level18.lesson05.task01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* Исправить ошибки
Исправить функциональность в соответствии с требованиями
Программа должна:
1. переписать все байты одного файла в другой одним куском.
2. закрывать потоки ввода-вывода
Подсказка: 4 ошибки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            inputStream = new FileInputStream("c:/data.txt");
            outputStream = new FileOutputStream("c:/result.txt");

            while (inputStream.available() > 0) {
                byte[] buffer = new byte[inputStream.available()];
                int count = inputStream.read(buffer);
                outputStream.write(buffer, 0, count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null && outputStream != null) {
                inputStream.close();
                outputStream.close();
            }
        }
    }
}
