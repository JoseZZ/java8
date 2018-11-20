package com.java.concepts;

import com.java.concepts.Lambda.BasicLambda;
import com.java.concepts.Lambda.MethodReference;
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
				default:
					break;
			}
		}
		System.out.println("Adios");
	}
}
