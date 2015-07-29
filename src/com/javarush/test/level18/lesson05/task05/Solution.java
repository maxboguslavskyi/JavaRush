package com.javarush.test.level18.lesson05.task05;

/* DownloadException
1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть все потоки ввода-вывода
2.2 выбросить исключение DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException, DownloadException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = null;

        try {
            while (true) {
                fis = new FileInputStream(reader.readLine());
                if (fis.available() < 1000) {
                    fis.close();
                    reader.close();
                    throw new DownloadException();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
    }


    public static class DownloadException extends Exception {

    }
}
