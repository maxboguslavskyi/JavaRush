package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес неизвестен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat {
    public void initialize(String name) {
        name = "Tom";
    }

    public void initialize(String name, int weight, int age) {
        weight = 3;
        age = 6;
    }

    public void initialize(String name, int age) {

    }

    public void initialize(int weight, String color) {
        color = "black";
    }

    public void initialize(int weight, String color, String adress) {
        adress = null;
    }

}
