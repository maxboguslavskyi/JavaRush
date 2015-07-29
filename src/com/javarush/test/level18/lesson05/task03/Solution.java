package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки ввода-вывода
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = null;
        FileOutputStream fosOne = null;
        FileOutputStream fosTwo = null;

        try {
            fis = new FileInputStream(reader.readLine());
            fosOne = new FileOutputStream(reader.readLine());
            fosTwo = new FileOutputStream(reader.readLine());

            while (fis.available() > 0) {
                if (fis.available() % 2 == 0) {
                    byte[] firstHalf = new byte[fis.available() / 2];
                    byte[] secondHalf = new byte[fis.available() / 2];
                    int countOne = fis.read(firstHalf);
                    int countTwo = fis.read(secondHalf);
                    fosOne.write(firstHalf, 0, countOne);
                    fosTwo.write(secondHalf, 0, countTwo);
                } else {
                    byte[] firstHalf = new byte[fis.available() / 2 + 1];
                    byte[] secondHalf = new byte[fis.available() / 2];
                    int countOne = fis.read(firstHalf);
                    int countTwo = fis.read(secondHalf);
                    fosOne.write(firstHalf, 0, countOne);
                    fosTwo.write(secondHalf, 0, countTwo);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
            if (fis != null && fosOne != null && fosTwo != null) {
                fis.close();
                fosOne.close();
                fosTwo.close();
            }
        }
    }
}
