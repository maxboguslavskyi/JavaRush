package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstName = reader.readLine();
        String secondName = reader.readLine();
        FileInputStream fisOne = null;
        FileInputStream fisTwo = null;

        try {
            fisOne = new FileInputStream(firstName);
            fisTwo = new FileInputStream(secondName);

            byte[] firstBuffer = new byte[fisOne.available()];
            byte[] secondBuffer = new byte[fisTwo.available()];

            while (fisOne.available() > 0) {
                fisOne.read(firstBuffer);
            }

            while (fisTwo.available() > 0) {
                fisTwo.read(secondBuffer);
            }

            RandomAccessFile raf = new RandomAccessFile(firstName, "rw");
            raf.seek(0);
            raf.write(secondBuffer);
            raf.write(firstBuffer);
            raf.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fisOne != null && fisTwo != null) {
                fisOne.close();
                fisTwo.close();
            }
        }
    }
}
