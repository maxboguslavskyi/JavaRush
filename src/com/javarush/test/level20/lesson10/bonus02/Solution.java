package com.javarush.test.level20.lesson10.bonus02;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        int horizontal = a[0].length;
        int vertical = a.length;
        int count;
        int verticalEnd;
        int horizontalEnd;
        int result = 0;
        for (int i = 0; i < vertical; i++) {
            for (int j = 0; j < horizontal; j++) {
                if (a[i][j] == 1) {
                    verticalEnd = i;
                    horizontalEnd = j;

                    //vertical
                    count = i + 1;
                    System.out.println("a[" + count + "][" + j + "]");
                    while (true) {
                        if (count >= vertical || (a[count][j] == 0 && count < vertical)) {
                            verticalEnd = count - 1;
                            System.out.println("verticalEnd = " + verticalEnd);
                            break;
                        }
                        count++;
                        System.out.println("a[" + count + "][" + j + "]");
                    }

                    //horizontal
                    count = j + 1;
                    while (true) {
                        if (count >= horizontal || (a[i][count] == 0 && count < horizontal)) {
                            horizontalEnd = count - 1;
                            System.out.println("horizontalEnd = " + horizontalEnd);
                            break;
                        }
                        count++;
                    }

                    boolean flag = true;
                    for (int p = i; p <= verticalEnd; p++)
                        for (int q = j; q <= horizontalEnd; q++)
                            if (a[p][q] != 1) {
                                flag = false;
                                break;
                            }

                    if (flag) {
                        System.out.println("startI = " + i);
                        System.out.println("startJ = " + j);
                        System.out.println("endI = " + verticalEnd);
                        System.out.println("endJ = " + horizontalEnd);
                        for (int p = i; p <= verticalEnd; p++)
                            for (int q = j; q <= horizontalEnd; q++)
                                a[p][q] = 0;
                        result++;
                    }
                    System.out.println();
                }
            }
        }
        return result;
    }
}

