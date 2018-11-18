package ru.otus.l021;

import java.lang.management.ManagementFactory;

public class Main {
    public static void main(String... args) throws InterruptedException {
        System.out.println("pid: " + ManagementFactory.getRuntimeMXBean().getName());

        long startMem = getMem();
        System.out.println("Start memory: " + startMem);

        String emptyString = new String(new char[0]);
        long afterStringMem = getMem();
        System.out.println("Empty String size: " + (afterStringMem - startMem));
        System.out.println("----------");

        int size = 20_000_000;

        // Create an array of objects
        Object[] array = new Object[size];

        long arrayMem1 = getMem();
        System.out.println("Ref size: " + (arrayMem1 - startMem) / array.length);

        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        long arrayMem2 = getMem();
        System.out.println("Object size: " + (arrayMem2 - arrayMem1) / array.length);
        System.out.println("----------");

        // Create an array of integers
        Integer[] arrayInt = new Integer[size];

        long arrayIntMem1 = getMem();
        System.out.println("Ref size: " + (arrayIntMem1 - arrayMem2) / arrayInt.length);

        for (int i = 0; i < arrayInt.length; i++) {
            arrayInt[i] = i;
        }

        long arrayIntMem2 = getMem();
        System.out.println("Integer size: " + (arrayIntMem2 - arrayIntMem1) / arrayInt.length);
        System.out.println("----------");

        // Create an array of objects of MyClass
        MyClass[] arrayMyClass = new MyClass[size];

        long arrayMyClassMem1 = getMem();
        System.out.println("Ref size: " + (arrayMyClassMem1 - arrayIntMem2) / arrayMyClass.length);

        for (int i = 0; i < arrayMyClass.length; i++) {
            arrayMyClass[i] = new MyClass();
        }

        long arrayMyClassMem2 = getMem();
        System.out.println("MyClass size: " + (arrayMyClassMem2 - arrayMyClassMem1) / arrayMyClass.length);
        System.out.println("----------");

        array = null;
        arrayInt = null;
        arrayMyClass = null;
        System.out.println("Array is ready for GC");

        Thread.sleep(1000); //wait for 1 sec
    }

    private static long getMem() throws InterruptedException {
        System.gc();
        Thread.sleep(10);
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }

    private static class MyClass {
        private byte b = 0;     // +1
        private int i = 0;      // +4
        private long l = 1;     // +8
    }
}
