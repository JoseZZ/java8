package com.java.concepts.Functions;

import java.util.function.Predicate;

public class Predicates {

    public static void Ejemplos(){
        Predicate<String> p1 = s -> s.length() < 20;
        Predicate<String> p2 = s -> s.length() > 10;

        // Se pueden enlazar (and, or, etc) con métodos del mismo interfaz
        Predicate<String> p3 = p1.and(p2);
        System.out.println("La palabra desconsiderado tiene entre 10 y 20 letras: " + p3.test("desconsiderado"));
        System.out.println("La palabra libro tiene entre 10 y 20 letras: " + p3.test("libro"));


    }
}
