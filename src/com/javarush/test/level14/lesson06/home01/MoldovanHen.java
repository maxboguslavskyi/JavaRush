package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Макс on 02.05.2015.
 */
class MoldovanHen extends Hen
{
    @Override
    int getCountOfEggsPerMonth()
    {
        return 1000;
    }

    @Override
    String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}