package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length < 3) {
            System.out.println("Try again...");
            return;
        }

        FileInputStream fis = new FileInputStream(args[1]);
        FileOutputStream fos = new FileOutputStream(args[2]);


        if (args[0].equals("-e")) {

            try {

                while (fis.available() > 0) {
                    int temp = encrypt(fis.read());
                    fos.write(temp);
                }

            } catch (IOException e) {
                System.out.println("Done");
            } finally {
                fis.close();
                fos.close();
            }
        }
        if (args[0].equals("-d")) {


            try {

                while (fis.available() > 0) {
                    int temp = decrypt(fis.read());
                    fos.write(temp);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                fis.close();
                fos.close();
            }
        }

    }

    public static int encrypt(int content) {
        return content * 2;
    }

    public static int decrypt(int content) {
        return content / 2;
    }

}
