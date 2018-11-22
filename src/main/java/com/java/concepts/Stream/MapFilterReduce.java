package com.java.concepts.Stream;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MapFilterReduce {

    public static void Operaciones(){
        List<Person> personas = Arrays.asList(new Person("Juan", "Perez Ruiz", 23),
                new Person("Laura", "Garcia Torres", 46),
                new Person("Tomas", "Sanchez Antunez", 32));

        // Foreach. Tiene como parametro un Consumer
        // Podemos obtener un stream a partir de una coleccion
        System.out.println("-- Foreach todas las personas --");
        Stream<Person> stream = personas.stream();
        stream.forEach(System.out::println);

        // Filtro. Tiene un Predicate como parametro
        // Devuelve un stream que es un objeto distinto del inicial
        Stream<Person> filtro = personas.stream();
        // Predicate para filtrar por mayor de 30
        Stream<Person> filtrado = filtro.filter(person -> person.getEdad() > 30);
        System.out.println("\n-- Filtro personas con mas de 30 años --");
        filtrado.forEach(System.out::println);

        // Otra forma de crear un stream es con Stream.of
        Stream<String> igual = Stream.of("azul", "blanco", "verde", "negro");
        // Predicate para filtrar por igual a
        Predicate<String> p1 = Predicate.isEqual("blanco");
        Predicate<String> p2 = Predicate.isEqual("azul");
        Stream<String> igualado = igual.filter(p1.or(p2));
        System.out.println("\n-- Filtro igual a blanco o azul --");
        igualado.forEach(System.out::println);

        // Peek
        // El metodo peek es como el foreach, pero el metodo foreach no devuelve nada y el metodo peek
        // devuelve un stream. El siguiente codigo no imprime nada porque no hay una operacion final
        Stream<String> stream1 = Stream.of("uno", "dos", "tres", "cuatro", "cinco");

        Predicate<String> p3 = Predicate.isEqual("dos");
        Predicate<String> p4 = Predicate.isEqual("tres");

        List<String> list = new ArrayList<>();

        stream1.peek(System.out::println)
                .filter(p3.or(p4))
                .peek(list::add);
        // La lista sigue vacia porque peek es una operacion intermedia y la lista no se ha llenado
        // Si lo hacemos con foreach si se llenara porque es una operación final
        System.out.println("Tamaño de la lista con peek: " + list.size());
        // Si lo hacemos con foreach si se llenara porque es una operación final

        System.out.println("-- FlatMap --");
        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7);
        List<Integer> list2 = Arrays.asList(2,4,6);
        List<Integer> list3 = Arrays.asList(3,5,7);

        // Hacemos una lista de listras
        List<List<Integer>> lista4 = Arrays.asList(list1, list2, list3);
        System.out.println(lista4);

        // Definimos una funcion que devuelve un stream de la entrada, que sera una lista
        Function<List<Integer>, Stream<Integer>> flatmapper = l -> l.stream();
        System.out.println("Lista 1: " + list1.toString());
        System.out.println("Lista 2: " + list2.toString());
        System.out.println("Lista 3: " + list3.toString());
        System.out.println("Flatmap de las tres listas es: ");
        lista4.stream().flatMap(flatmapper)
                .forEach(System.out::println);

        System.out.println("-- Reduce --");
        Stream<Integer> numeros = list1.stream();
        System.out.println("Los numeros son: " + list1.toString());
        BinaryOperator<Integer> sum = (i1, i2) -> i1 + i2;
        Integer id = 0; // identidad del elemento suma
        int red = numeros.reduce(id, sum);
        System.out.println("La suma con reduce es: " + red + "\n");

        System.out.println("Reduce con stream vacio");
        Stream<Integer> vacio = Stream.empty();
        int n = vacio.reduce(id, sum);
        System.out.println("La reduccion de un stream vacio es: " + n);

        System.out.println("Reduce con stream de un elemento (1)");
        Stream<Integer> uno = Stream.of(1);
        int solo = uno.reduce(id, sum);
        System.out.println("La reduccion de un stream con un 1 es: " + solo);
    }


}
