package com.walf.test.annotation;

@HelloAnnotation(say = "Do it!")
public class TestMain {
    public static void main(String[] args) {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        HelloAnnotation annotation = TestMain.class.getAnnotation(HelloAnnotation.class);
        System.out.println(annotation.say());
    }
}
