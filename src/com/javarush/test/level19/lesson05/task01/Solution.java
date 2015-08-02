package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
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
                fis.read(buffer);
                for (int i = 1; i < buffer.length; i++) {
                    if (i % 2 != 0) {
                        fos.write(buffer[i]);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
            if (fis != null && fos != null) {
                fis.close();
                fos.close();
            }
        }
    }
}
