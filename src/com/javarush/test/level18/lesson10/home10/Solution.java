package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть все потоки ввода-вывода
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = null;
        FileOutputStream fos = null;
        Set<String> fileSet = new TreeSet<String>();
        String names;

        while (!(names = reader.readLine()).equals("end")) {
            fileSet.add(names);
        }

        String text = fileSet.iterator().next();
        text = text.substring(0, text.lastIndexOf('.'));

        try {
            fos = new FileOutputStream(text);
            for (String p : fileSet) {
                fis = new FileInputStream(p);
                byte[] buffer = new byte[fis.available()];
                if (fis.available() > 0) {
                    fis.read(buffer);
                }
                fos.write(buffer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
                fos.close();

            }
        }
    }
}
