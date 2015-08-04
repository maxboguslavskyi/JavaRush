package com.javarush.test.level20.lesson02.task04;

import java.io.*;

/* Читаем и пишем в файл статики
Реализуйте логику записи в файл и чтения из файла для класса ClassWithStatic
Метод load должен инициализировать объект включая статические поля данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {

        try {

            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            ClassWithStatic classWithStatic = new ClassWithStatic();
            classWithStatic.i = 3;
            classWithStatic.j = 4;
            classWithStatic.save(outputStream);
            outputStream.flush();

            ClassWithStatic loadedObject = new ClassWithStatic();
            loadedObject.staticString = "something";
            loadedObject.i = 6;
            loadedObject.j = 7;

            loadedObject.load(inputStream);
            System.out.println(classWithStatic.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class ClassWithStatic {
        public static String staticString = "it's test static string";
        public int i;
        public int j;

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = null;
            String hasStaticString;

            try {
                printWriter = new PrintWriter(outputStream);

                if (staticString != null) {
                    hasStaticString = "yes";
                } else {
                    hasStaticString = "no";
                }
                printWriter.println(hasStaticString);

                if (hasStaticString.equals("yes")) {
                    printWriter.println(staticString);
                }
                printWriter.println(this.i);
                printWriter.println(this.j);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (printWriter != null) {
                    printWriter.close();
                }
            }
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader bufferedReader = null;
            String hasStaticString;

            try {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                hasStaticString = bufferedReader.readLine();

                if (hasStaticString.equals("yes")) {
                    staticString = bufferedReader.readLine();
                }
                this.i = Integer.parseInt(bufferedReader.readLine());
                this.j = Integer.parseInt(bufferedReader.readLine());

            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } finally {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
        }
    }
}
