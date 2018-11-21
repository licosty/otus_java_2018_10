package ru.otus.l021;

public class Main {
    public static void main(String... args) {

        System.out.println(String.format("byte size: %s bytes\n", Measurer.measureByte()));
        System.out.println(String.format("short size: %s bytes\n", Measurer.measureShort()));
        System.out.println(String.format("int size: %s bytes\n", Measurer.measureInt()));
        System.out.println(String.format("long size: %s bytes\n", Measurer.measureLong()));

        System.out.println(String.format("float size: %s bytes\n", Measurer.measureFloat()));
        System.out.println(String.format("double size: %s bytes\n", Measurer.measureDouble()));

        System.out.println(String.format("Element size: %s bytes\n", Measurer.measure(() -> new MyClass())));
        System.out.println(String.format("Empty string size: %s bytes", Measurer.measure(() -> new String(new char[0]))));

    }

    private static class MyClass {
        private byte b = 0;     // +1
        private int i = 0;      // +4
        private long l = 1;     // +8
    }
}
