package org.example;
public class Main {

    public static void main(String[] args) {
        Container.scan();
        new App().run();
        Container.close();
    }
}