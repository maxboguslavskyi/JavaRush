package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Макс on 02.05.2015.
 */
class UkrainianHen extends Hen
{
    @Override
    int getCountOfEggsPerMonth()
    {
        return 100;
    }

    @Override
    String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
