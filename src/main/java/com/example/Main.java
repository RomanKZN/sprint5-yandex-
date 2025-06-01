package com.example;

public class Main {
    public static void main(String[] args) {
       // Animal animal = new Animal();
        //int count = getKittens(3); // вызов метода
        Feline feline = new Feline();
        System.out.println(feline.getFamily());
        System.out.println(feline.getKittens());
        System.out.println(feline.getKittens(5));// вывод результата

        //Cat cat = new Cat();

    }

}
