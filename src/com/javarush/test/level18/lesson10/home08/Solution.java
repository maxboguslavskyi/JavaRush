package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Не забудьте закрыть все потоки
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<String>();
        try {
            String fileName;

            while (!(fileName = reader.readLine()).equals("exit")) {
                list.add(fileName);
            }
            for (String text : list) {
                ReadThread readThread = new ReadThread(text);
                readThread.start();
                readThread.join();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }

        System.out.println(resultMap);
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        public void run() {
            List<Integer> list = new ArrayList<Integer>();
            FileInputStream fis = null;

            try {
                fis = new FileInputStream(fileName);

                while (fis.available() > 0) {
                    int temp = fis.read();
                    list.add(temp);
                }

                int max = 0;
                int id = 0;

                for (int i = 0; i < list.size(); i++) {
                    int count = Collections.frequency(list, list.get(i));
                    if (count > max) {
                        max = count;
                        id = list.get(i);
                    }
                }

                resultMap.put(fileName, id);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
