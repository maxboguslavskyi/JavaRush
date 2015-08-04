package com.javarush.test.level20.lesson02.task05;

import java.io.*;

/* И еще раз о синхронизации
Реализуйте логику записи в файл и чтения из файла для класса Object
Метод load должен инициализировать объект данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {

        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Object object = new Object();
            object.string1 = new String();
            object.string2 = new String();
            object.save(outputStream);
            outputStream.flush();

            Object loadedObject = new Object();
            loadedObject.string1 = new String();
            loadedObject.string2 = new String();


            loadedObject.load(inputStream);
            System.out.println(object.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Object {
        public String string1;
        public String string2;

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = null;

            try {
                writer = new PrintWriter(outputStream);

                java.lang.String hasFirstString;
                if (string1 != null) {
                    hasFirstString = "yes";
                } else {
                    hasFirstString = "no";
                }
                writer.println(hasFirstString);
                currentValue = countStrings - 1;

                java.lang.String hasSecondString;
                if (string2 != null) {
                    hasSecondString = "yes";
                } else {
                    hasSecondString = "no";
                }
                writer.println(hasSecondString);
                currentValue = currentValue - 1;

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (writer != null) {
                    writer.close();
                }
            }
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = null;

            try {
                reader = new BufferedReader(new InputStreamReader(inputStream));

                int temp = countStrings;
                countStrings = currentValue;

                java.lang.String hasFirstString = reader.readLine();
                if (hasFirstString.equals("yes")) {
                    this.string1 = new String();
                }

                java.lang.String hasSecondString = reader.readLine();
                if (hasSecondString.equals("yes")) {
                    this.string2 = new String();
                }

                countStrings = temp;
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }
        }
    }

    public static int currentValue;
    public static int countStrings;

    public static class String {
        private final int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }
}
