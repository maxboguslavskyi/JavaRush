package com.javarush.test.level14.lesson08.home05;

/**
 * Created by Макс on 02.05.2015.
 */
public class Computer
{
    private Mouse mouse;
    private Monitor monitor;
    private Keyboard keyboard;

    public Computer()
    {
        this.mouse = new Mouse();
        this.monitor = new Monitor();
        this.keyboard = new Keyboard();
    }

    public Keyboard getKeyboard()
    {
        return keyboard;
    }

    public Monitor getMonitor()
    {

        return monitor;
    }

    public Mouse getMouse()
    {

        return mouse;
    }
}
