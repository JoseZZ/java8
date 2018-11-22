package com.java.concepts;

import com.java.concepts.Functions.Predicates;
import com.java.concepts.Lambda.BasicLambda;
import com.java.concepts.Lambda.MethodReference;
import com.java.concepts.Stream.ChainConsumers;
import com.java.concepts.Stream.MapFilterReduce;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Java8Application {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(Java8Application.class, args);

		Scanner scanner = new Scanner(System.in);
		int opcion = 0;

		while(opcion < 20) {
			System.out.println("Opcion: " + opcion);
			System.out.println("Introduce el numero de prueba: ");
			opcion = scanner.nextInt();
			switch (opcion) {
				// 1. Clases anonimas vs expresiones lambda
				case 1:
					BasicLambda.Filtro();
					BasicLambda.Runable();
					BasicLambda.Comparador();
					break;
				// 2. Method reference
				case 2:
					MethodReference.Ejemplos();
					break;
				// 3. Functions
				case 3:
					Predicates.Ejemplos();
					break;
				// 4. Functions
				case 4:
					ChainConsumers.ForEach();
					break;
				// Streams
				case 5:
					MapFilterReduce.Operaciones();
					break;
				default:
					break;
			}
		}
		System.out.println("Adios");
	}
}
