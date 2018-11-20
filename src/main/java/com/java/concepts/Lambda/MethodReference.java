package com.java.concepts.Lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Jose Gonzalez on 20/11/2018.
 */
public class MethodReference {

    public static void Ejemplos(){
        // Un method reference es una forma de acortar una expresion lambda
        // Se omite el parametro y se indica el metodo precedido de ::
        Consumer<String> a = s -> System.out.println(s);
        Consumer<String> b = System.out::println;
        a.accept("Imprimimos con lambda clasico");
        b.accept("Imprimimos con method reference\n");

        // Aunque vengan 2 parametros, el compilador los deduce, no hay que ponerlos
        Comparator<Integer> c = (i1, i2) -> Integer.compare(i1, i2);
        List<Integer> oldList = Arrays.asList(2,4,3,1);
        System.out.println("-- Comparador lambda clasico (" + oldList.toString() + ") --");
        Collections.sort(oldList, c);
        for(Integer s: oldList){
            System.out.println(s);
        }

        Comparator<Integer> d = Integer::compare;
        List<Integer> newList = Arrays.asList(3,5,1,8);
        System.out.println("-- Comparador method reference (" + newList.toString() + ") --");
        Collections.sort(newList, d);
        for(Integer s: newList){
            System.out.println(s);
        }
    }
}

