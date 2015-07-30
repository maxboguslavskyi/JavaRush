package com.javarush.test.level18.lesson08.task03;

import java.io.FileOutputStream;
import java.io.IOException;

/* AmigoOutputStream
1 Измените класс AmigoOutputStream так, чтобы он стал Wrapper-ом для класса FileOutputStream
2 При вызове метода close() должны выполняться следующая последовательность действий:
2.1 вызвать метод flush()
2.2 дописать следующий текст [JavaRush © 2012-2013 All rights reserved.], используйте метод getBytes()
2.3 закрыть поток методом close()
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";
    private FileOutputStream fos;


    public AmigoOutputStream(FileOutputStream fos) throws IOException {
        super(fileName);
        this.fos = fos;
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        fos.write(b, off, len);
    }

    @Override
    public void write(byte[] b) throws IOException {
        fos.write(b);
    }

    @Override
    protected void finalize() throws IOException {
        super.finalize();
    }


    @Override
    public void write(int b) throws IOException {
        fos.write(b);
    }

    public void close() throws IOException {
        fos.flush();
        fos.write("JavaRush © 2012-2013 All rights reserved.".getBytes());
        fos.close();
    }

    public static void main(String[] args) throws IOException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}