package com.walf.test.dummy;

public class StaticClassTest1 {

     class SubClass1 {

        public  void fun1() {
            System.out.println("SubClass1");
        }

        public  void fun2() {
            System.out.println("SubClass1.2");
        }

    }

     class Subclass2 extends SubClass1 {

        public  void fun1() {
            System.out.println("SubClass2");
        }

    }

    public void mainfun1() {
        SubClass1 class1 = new Subclass2();
        class1.fun1();
    }

    public static void main(String[] argv) {
        new StaticClassTest1().mainfun1();
        System.gc();
    }


}
