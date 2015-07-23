package com.javarush.test.level05.lesson05.task02;

/* Реализовать метод fight
Реализовать метод boolean fight(Cat anotherCat):
реализовать механизм драки котов в зависимости от их веса, возраста и силы.
Зависимость придумать самому. Метод должен определять, выиграли ли мы (this) бой или нет,
т.е. возвращать true, если выиграли и false - если нет.
Должно выполняться условие:
если cat1.fight(cat2) = true , то cat2.fight(cat1) = false
*/

public class Cat {
    public String name;
    public int age;
    public int weight;
    public int strength;

    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.age = 10;
        cat1.strength = 20;
        cat1.weight = 20;

        Cat cat2 = new Cat();
        cat2.name = "Tom";
        cat2.weight = 25;
        cat2.strength = 15;

        cat1.fight(cat2);
    }

    public Cat() {
        this.age = age;
        this.weight = weight;
        this.strength = strength;
    }

    public boolean fight(Cat anotherCat) {

        if (this.strength > anotherCat.strength) {
            return true;
        } else return false;
    }
}
