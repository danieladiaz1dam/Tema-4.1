package ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Helper {
	/**
	 * Pide un numero entero al usuario
	 * @param sc Scanner
	 * @param msg Mensaje para imprimir al usuario
	 * @return numero introducido por el usuario
	 */
	static int pedirInt(Scanner sc, String msg) {
		int num = 0;
		boolean ok = false;

		do {
			try {
				System.out.printf("%s: ", msg);
				num = sc.nextInt();
				ok = true;
			} catch (InputMismatchException e) {
				System.out.printf("Dato inválido.\n");
				
			} finally {
				sc.nextLine();
			}

		} while (!ok);

		return num;
	}
	
	/**
	 * Pide un numero entero al usuario entre un rango
	 * @param sc Scanner
	 * @param msg Mensaje para imprimir al usuario
	 * @param min Minimo del rango
	 * @param max Maximo del rango
	 * @return numero introducido por el usuario
	 */
	static int pedirInt(Scanner sc, String msg, int min, int max) {
		int num = 0;
		boolean ok = false;

		do {
			try {
				System.out.printf("%s (rango: %d~%d): ", msg, min, max);
				num = sc.nextInt();
				ok = num > min && num < max;
			} catch (InputMismatchException e) {
				System.out.printf("Dato inválido.\n");
				
			} finally {
				sc.nextLine();
			}

		} while (!ok);
		
		return num;
	}
	
	/**
	 * Pide un numero entero al usuario a partir de un numero (no incluido)
	 * @param sc Scanner
	 * @param msg Mensaje para imprimir al usuario
	 * @param min Menor numero posible a introducir
	 * @return numero introducido por el usuario
	 */
	static int pedirInt(Scanner sc, String msg, int min) {
		int num = 0;
		boolean ok = false;

		do {
			try {
				System.out.printf("%s (min: %d): ", msg, min);
				num = sc.nextInt();
				ok = num > min;
			} catch (InputMismatchException e) {
				System.out.printf("Dato inválido.\n");
				
			} finally {
				sc.nextLine();
			}

		} while (!ok);
		
		return num;
	}
	
	/**
	 * Calcula la suma de todos los numeros desde 0 hasta un numero especificado
	 * 
	 * @param n Numero tope
	 * @return la suma de 0 hasta el topa
	 */
	static int sumaRecesiva(int n) {

		if (n != 0)
			return n + sumaRecesiva(n - 1);
		else
			return 0;
	}

}
