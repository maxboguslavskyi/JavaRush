package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
[Файл 1]
строка1
строка2
строка3

[Файл 2]
строка1
строка3
строка4

[Результат - список lines]
SAME строка1
REMOVED строка2
SAME строка3
ADDED строка4
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<>();
    public static List<String> firstFileLines = new ArrayList<>();
    public static List<String> secondFileLines = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = reader.readLine();
        String secondFileName = reader.readLine();
        BufferedReader firstFileReader = new BufferedReader(new FileReader(firstFileName));
        BufferedReader secondFileReader = new BufferedReader(new FileReader(secondFileName));
        reader.close();

        while (firstFileReader.ready()) {
            firstFileLines.add(firstFileReader.readLine());
        }
        firstFileReader.close();

        while (secondFileReader.ready()) {
            secondFileLines.add(secondFileReader.readLine());
        }
        secondFileReader.close();

        int a = 0, b = 0;
        boolean firstListIsEmpty = false;
        boolean secondListIsEmpty = false;

        while (true) {
            if (a >= firstFileLines.size()) {
                firstListIsEmpty = true;
            } else if (b >= secondFileLines.size()) {
                secondListIsEmpty = true;
            }

            //Only 1st list is empty.
            if (firstListIsEmpty && !secondListIsEmpty) {
                if (lines.get(lines.size() - 1).type.equals(Type.SAME)) {
                    lines.add(new LineItem(Type.ADDED, secondFileLines.get(b)));
                    break;
                } else {
                    return;
                }
            }

            //Only 2nd list is empty.
            if (secondListIsEmpty && !firstListIsEmpty) {
                if (lines.get(lines.size() - 1).type.equals(Type.SAME)) {
                    lines.add(new LineItem(Type.REMOVED, firstFileLines.get(a)));
                    break;
                } else {
                    return;
                }
            }

            //Both lists are empty.
            if (firstListIsEmpty && secondListIsEmpty) {
                break;
            }

            //if SAME
            if (firstFileLines.get(a).equals(secondFileLines.get(b))) {
                lines.add(new LineItem(Type.SAME, firstFileLines.get(a)));

                if (a < firstFileLines.size()) {
                    a++;
                } else {
                    firstListIsEmpty = true;
                }

                if (b < secondFileLines.size()) {
                    b++;
                } else {
                    secondListIsEmpty = true;
                }
            }

            //if not SAME
            else if (!firstListIsEmpty && !secondListIsEmpty) {

                //if ADD
                if ((b + 1 < secondFileLines.size()) && firstFileLines.get(a).equals(secondFileLines.get(b + 1))) {
                    lines.add(new LineItem(Type.ADDED, secondFileLines.get(b)));
                    lines.add(new LineItem(Type.SAME, firstFileLines.get(a)));

                    if (a < firstFileLines.size()) {
                        a++;
                    } else {
                        firstListIsEmpty = true;
                    }

                    if (b < secondFileLines.size()) {
                        b++;
                    } else {
                        secondListIsEmpty = true;
                    }

                    if (b < secondFileLines.size()) {
                        b++;
                    } else {
                        secondListIsEmpty = true;
                    }
                }

                //if REMOVE
                else if ((a + 1 < firstFileLines.size()) && secondFileLines.get(b).equals(firstFileLines.get(a + 1))) {
                    lines.add(new LineItem(Type.REMOVED, firstFileLines.get(a)));
                    lines.add(new LineItem(Type.SAME, secondFileLines.get(b)));

                    if (a < firstFileLines.size()) {
                        a++;
                    } else {
                        firstListIsEmpty = true;
                    }

                    if (a < firstFileLines.size()) {
                        a++;
                    } else {
                        firstListIsEmpty = true;
                    }

                    if (b < secondFileLines.size()) {
                        b++;
                    } else {
                        secondListIsEmpty = true;
                    }
                }
            }
        }

        for (LineItem result : lines)
            System.out.printf("%s %s%n", result.type, result.line);
    }


    public enum Type {
        ADDED,        //added new line
        REMOVED,      //removed line
        SAME          //no changes
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
