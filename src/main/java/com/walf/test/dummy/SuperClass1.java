package com.walf.test.dummy;

public class SuperClass1 {

    public SuperClass1() {
        System.out.println("SuperClass1 construct!");
    }

    static {
        System.out.println("SuperClass init 1");
    }

    static {
        System.out.println("SuperClass init 2");
    }

    public static int value = 123;
}
