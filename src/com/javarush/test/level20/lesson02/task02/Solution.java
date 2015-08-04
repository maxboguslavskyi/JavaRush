package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {

        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);

            JavaRush javaRush = new JavaRush();
            User user = new User();
            user.setFirstName("John");
            user.setLastName("Smith");
            user.setBirthDate(format.parse("02.02.2002"));
            user.setMale(true);
            user.setCountry(User.Country.UKRAINE);
            javaRush.users.add(user);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
            PrintWriter writer = new PrintWriter(outputStream);

            if (this.users != null) {
                for (User user : users) {
                    writer.println(user.getFirstName());
                    writer.println((user.getLastName()));
                    writer.println(dateFormat.format(user.getBirthDate()));
                    writer.println(user.isMale());
                    writer.println(user.getCountry().getDisplayedName());
                }
            }
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;

            while ((line = reader.readLine()) != null) {
                User user = new User();
                user.setFirstName(line);
                user.setLastName(reader.readLine());
                Date format = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse(reader.readLine());
                user.setBirthDate(format);
                user.setMale(Boolean.parseBoolean(reader.readLine()));

                String countries = reader.readLine();
                switch (countries) {
                    case "Ukraine":
                        user.setCountry(User.Country.UKRAINE);
                        break;
                    case "Russia":
                        user.setCountry(User.Country.RUSSIA);
                        break;
                    default:
                        user.setCountry(User.Country.OTHER);
                        break;
                }
                this.users.add(user);
            }
            reader.close();
        }
    }
}