package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        StringBuilder builder = new StringBuilder();

        while (fileReader.ready()) {
            builder.append(fileReader.readLine());
        }

        String lines = builder.toString().replaceAll("\r\n", "");
        if (!lines.contains("CDATA")) {
            findTags(args[0], lines, 0);
        }
    }

    public static void findTags(String tag, String input, int count) {
        int tagCount = 0, indexOfLastTags = 0;
        int i = count;
        while (i < (input.length() - tag.length() - 1)) {
            if (input.substring(i, i + tag.length() + 1).equals("<" + tag)) {
                if (tagCount == 0) {
                    indexOfLastTags = i;
                }
                tagCount++;
            } else if (input.substring(i, i + tag.length() + 2).equals("</" + tag)) {
                tagCount--;
                if (tagCount == 0) {
                    String result = input.substring(indexOfLastTags, i + tag.length() + 3);
                    System.out.println(result);
                    findTags(tag, result, 1);
                }
            }
            i++;
        }
    }
}

