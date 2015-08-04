package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();


    public void fillInPropertiesMap() {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            load(new FileInputStream(reader.readLine()));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties properties = new Properties();

        try {
            for (Map.Entry<String, String> pair : Solution.properties.entrySet()) {
                properties.put(pair.getKey(), pair.getValue());
            }
            properties.store(outputStream, null);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            outputStream.close();
        }
    }

    public void load(InputStream inputStream) throws Exception {
        Properties properties = new Properties();

        try {
            properties.load(inputStream);

            for (String text : properties.stringPropertyNames()) {
                Solution.properties.put(text, properties.getProperty(text));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}