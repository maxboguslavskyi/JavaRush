package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Макс on 03.05.2015.
 */
public class Singleton {
    private static Singleton instance;

    private Singleton (){
    }

    public static Singleton getInstance(){
        if (null == instance){
            instance = new Singleton();
        }
        return instance;
    }
}