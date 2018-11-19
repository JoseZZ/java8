package com.java.concepts.Lambda.Ejemplos;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Jose Gonzalez on 19/11/2018.
 */
public class PrimerEjemplo {

    public static void Filtro(){
        // Esta clase genera un filtro para archivos java
        FileFilter javaFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                // Condicion para aceptar el archivo
                return pathname.getAbsolutePath().endsWith(".java");
            }
        };

        // Probamos el filtro con una lista de archivos. Hay 3 archivos txt y 2 java
        System.out.println("-- Filtro archivos .java con clase anonima --");
        File dir = new File("src/main/resources/archivos");
        File javaFiles[] = dir.listFiles(javaFilter);
        if(javaFiles != null){
            for(File f : javaFiles){
                System.out.println(f);
            }
        }

        System.out.println("-- Filtro archivos .txt con expresion lambda --");
        // Para la expresion lambda, a la izquierda de la flecha los parametros del que sería el metodo
        // que implementariamos en la clase anonima, y a la derecha la implementación del metodo
        FileFilter txtFilter = (File pathname) -> pathname.getAbsolutePath().endsWith(".txt");
        File txtFiles[] = dir.listFiles(txtFilter);
        if(txtFiles != null){
            for(File f : txtFiles){
                System.out.println(f);
            }
        }

    }

    public static void Runable() throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 3; i++){
                    System.out.println("Hola desde el hilo clasico [" +
                    Thread.currentThread().getName() + "]");
                }
            }
        };

        Thread t = new Thread(runnable);
        t.start();
        t.join();

        Runnable lambdable = () -> {
            for(int i = 0; i < 3; i++){
                System.out.println("Hola desde el hilo lambda [" +
                        Thread.currentThread().getName() + "]");
            }
        };

        Thread tl = new Thread(lambdable);
        tl.start();
        tl.join();
    }

    public static void Comparador(){
        Comparator<String> oldComp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        };
        List<String> oldList = Arrays.asList("**", "***", "****", "*");
        System.out.println("-- Comparador clasico (" + oldList.toString() + ") --");
        Collections.sort(oldList, oldComp);
        for(String s: oldList){
            System.out.println(s);
        }

        Comparator<String> lambdaComp = (String s1, String s2) -> Integer.compare(s1.length(), s2.length());
        List<String> newList = Arrays.asList("***", "*", "**", "****");
        System.out.println("-- Comparador lambda (" + newList.toString() + ") --");
        Collections.sort(newList, lambdaComp);
        for(String s: newList){
            System.out.println(s);
        }

    }
}
