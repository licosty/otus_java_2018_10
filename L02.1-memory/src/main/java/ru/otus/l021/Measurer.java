package ru.otus.l021;

import java.util.function.Supplier;

class Measurer {

    private static final int ARRAY_SIZE = 20_000_000;

    static long measureByte() {
        long mem1 = getMem();
        byte [] array = new byte[ARRAY_SIZE];

        for (int i = 0; i < array.length; i++) {
            array[i] = (byte) (Math.random() * (Byte.MAX_VALUE + 1));
        }

        long size = (getMem() - mem1) / array.length;
        System.out.println("array length: " + array.length);
        return size;
    }

    static long measureShort() {
        long mem1 = getMem();
        short [] array = new short[ARRAY_SIZE];

        for (int i = 0; i < array.length; i++) {
            array[i] = (short)(Math.random() * (Short.MAX_VALUE + 1));
        }

        long size = (getMem() - mem1) / array.length;
        System.out.println("array length: " + array.length);
        return size;
    }

    static long measureInt() {
        long mem1 = getMem();
        int [] array = new int[ARRAY_SIZE];

        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        long size = (getMem() - mem1) / array.length;
        System.out.println("array length: " + array.length);
        return size;
    }

    static long measureLong() {
        long mem1 = getMem();
        long [] array = new long[ARRAY_SIZE];

        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        long size = (getMem() - mem1) / array.length;
        System.out.println("array length: " + array.length);
        return size;
    }

    static long measureFloat() {
        long mem1 = getMem();
        float [] array = new float[ARRAY_SIZE];

        for (int i = 0; i < array.length; i++) {
            array[i] = 0.5f + i;
        }

        long size = (getMem() - mem1) / array.length;
        System.out.println("array length: " + array.length);
        return size;
    }

    static long measureDouble() {
        long mem1 = getMem();
        double [] array = new double[ARRAY_SIZE];

        for (int i = 0; i < array.length; i++) {
            array[i] = 0.5 + i;
        }

        long size = (getMem() - mem1) / array.length;
        System.out.println("array length: " + array.length);
        return size;
    }

    static <T> long measure(Supplier<T> objectGetter) {
        Object [] array = new Object[ARRAY_SIZE];

        long mem1 = getMem();

        for (int i = 0; i < array.length; i++) {
            array[i] = objectGetter.get();
        }

        long size = (getMem() - mem1) / array.length;
        System.out.println("array length: " + array.length);
        return size;
    }

    private static long getMem() {
        System.gc();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }
}
