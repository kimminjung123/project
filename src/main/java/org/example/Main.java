package org.example;
public class Main {

    public static void main(String[] args) {
        Container.init();
        new App().run();
        Container.close();
    }
}