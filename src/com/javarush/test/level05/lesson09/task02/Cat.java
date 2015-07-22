package com.javarush.test.level05.lesson09.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес не известен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    public Cat(String name) {
        name = "Tom";
    }
    public Cat(String name, int weight, int age) {
        weight = 3;
        age = 6;
    }
    public Cat(String name, int age) {

    }
    public Cat(int weight, String color) {
        color = "black";
    }
    public Cat(int weight, String color, String adress) {
        adress = null;
    }

}
