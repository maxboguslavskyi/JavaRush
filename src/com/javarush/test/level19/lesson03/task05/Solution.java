package com.javarush.test.level19.lesson03.task05;

import java.util.HashMap;
import java.util.Map;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {
    private static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            String code = "";
            for (Map.Entry<String, String> pair : countries.entrySet())
                if (pair.getValue().equals(this.customer.getCountryName()))
                    code = pair.getKey();

            return code;
        }

        @Override
        public String getCompany() {
            return this.customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            return this.contact.getName().substring(this.contact.getName().indexOf(" ") + 1);
        }

        @Override
        public String getContactLastName() {
            return this.contact.getName().substring(0, this.contact.getName().indexOf(","));
        }

        @Override
        public String getDialString() {
            String phoneNumber;
            phoneNumber = this.contact.getPhoneNumber().replace("(", "");
            phoneNumber = phoneNumber.replace(")", "");
            phoneNumber = phoneNumber.replace("-", "");
            return phoneNumber;
        }
    }

    public interface RowItem {
        String getCountryCode();

        String getCompany();

        String getContactFirstName();

        String getContactLastName();

        String getDialString();
    }

    public interface Customer {
        String getCompanyName();

        String getCountryName();
    }

    public interface Contact {
        String getName();

        String getPhoneNumber();
    }
}