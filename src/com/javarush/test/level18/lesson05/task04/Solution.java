package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки ввода-вывода
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(reader.readLine());
            fos = new FileOutputStream(reader.readLine());

            while (fis.available() > 0) {
                byte[] buffer = new byte[fis.available()];
                for (int i = fis.read(buffer); i > 0; i--) {
                    fos.write(buffer[i - 1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null && fos != null) {
                fis.close();
                fos.close();
            }
        }


    }
}
