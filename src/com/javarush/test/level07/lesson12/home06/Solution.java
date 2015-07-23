package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution {
    public static void main(String[] args) {
        Human grandfather1 = new Human();
        grandfather1.name = "Tom";
        grandfather1.sex = true;
        grandfather1.age = 70;
        grandfather1.father = null;
        grandfather1.mother = null;
        Human grandfather2 = new Human();
        grandfather2.name = "Ben";
        grandfather2.sex = true;
        grandfather2.age = 80;
        grandfather2.father = null;
        grandfather2.mother = null;
        Human grandmother1 = new Human();
        grandmother1.name = "Ann";
        grandmother1.sex = false;
        grandmother1.age = 65;
        grandmother1.father = null;
        grandmother1.mother = null;
        Human grandmother2 = new Human();
        grandmother2.name = "Lora";
        grandmother2.sex = false;
        grandmother2.age = 75;
        grandmother2.father = null;
        grandmother2.mother = null;
        Human father = new Human();
        father.name = "Alex";
        father.sex = true;
        father.age = 35;
        father.father = grandfather1;
        father.mother = grandmother1;
        Human mother = new Human();
        mother.name = "Karen";
        mother.sex = false;
        mother.age = 37;
        mother.father = grandfather2;
        mother.mother = grandmother2;
        Human child1 = new Human();
        child1.name = "Greg";
        child1.sex = true;
        child1.age = 17;
        child1.father = father;
        child1.mother = mother;
        Human child2 = new Human();
        child2.name = "John";
        child2.sex = true;
        child2.age = 19;
        child2.father = father;
        child2.mother = mother;
        Human child3 = new Human();
        child3.name = "Fiona";
        child3.sex = false;
        child3.age = 15;
        child3.father = father;
        child3.mother = mother;

        System.out.println(grandfather1);
        System.out.println(grandfather2);
        System.out.println(grandmother1);
        System.out.println(grandmother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
