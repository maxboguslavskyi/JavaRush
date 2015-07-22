package com.javarush.test.level14.lesson08.home05;

/**
 * Created by Макс on 02.05.2015.
 */
public class Monitor implements CompItem
{
    @Override
    public String getName()
    {
        return this.getClass().getSimpleName();
    }
}
