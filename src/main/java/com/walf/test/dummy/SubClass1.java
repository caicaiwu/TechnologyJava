package com.walf.test.dummy;

public class SubClass1 extends SuperClass1 {

    int subA;
    static int subB = 456;

    public SubClass1() {
        System.out.println("SubClass construct!");
    }

    static {
        System.out.println("SubClass init 1!");
    }

    static {
        System.out.println("SubClass init 2!");
    }

    static class InStatiiClass {
        int sI;
        void inFun1() {
        }
    }

    public static void main(String[] args) {

        //new SubClass1();
        //System.out.println(SuperClass1.value);
        System.out.println(SubClass1.subB);
       // SuperClass1[] sca = new SuperClass1[10];

        /*InStatiiClass  inC = new InStatiiClass();
        inC.sI = 3;

        System.out.println(inC.sI);*/

    }
}
