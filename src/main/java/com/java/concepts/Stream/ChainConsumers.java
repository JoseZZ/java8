package com.java.concepts.Stream;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ChainConsumers {

    public static void ForEach(){
        // Vamos a mostrar el contenido de una lista
        List<String> lista = Arrays.asList("uno", "dos", "tres", "cuatro", "cinco");
        // Vamos a usar un consumer para imprimir, ya que foreach tiene como entrada un consumer
        // que define la accion que se hara sobre cada elemento de la lista
        Consumer<String> c1 = System.out::println;
        lista.forEach(c1);
        // Se pueden encadenar los consumers con el metodo andThen
        List<String> results = new ArrayList<>();
        // Definimos un consumer para añadir elementos a una lista
        Consumer<String> c2 = results::add;
        // Si enlazamos los consumer, mostraremos por pantalla cada elemento y luego los añadiremos a la segunda lista
        lista.forEach(c1.andThen(c2));
        System.out.println("El tamaño de la segunda lista es: " + results.size());
    }
}
