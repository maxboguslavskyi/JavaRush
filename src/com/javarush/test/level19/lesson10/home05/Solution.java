package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<String>();

        BufferedReader reader = null;
        FileOutputStream fos = null;

        try {
            reader = new BufferedReader(new FileReader(args[0]));
            fos = new FileOutputStream(args[1]);

            while (reader.ready()) {
                String[] temp = reader.readLine().split(" ");
                for (String line : temp) {
                    char[] chars = line.toCharArray();
                    for (char c : chars) {
                        if (Character.isDigit(c)) {
                            list.add(line + " ");
                            break;
                        }
                    }
                }
            }
            for (String text : list) {
                fos.write(text.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null && fos != null) {
                reader.close();
                fos.close();
            }
        }
    }
}
