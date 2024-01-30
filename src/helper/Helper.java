package helper;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Helper {
	// Colores básicos
	public static final String RESET = "\u001B[0m";
	public static final String BLACK = "\u001B[30m";
	public static final String RED = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String BLUE = "\u001B[34m";
	public static final String MAGENTA = "\u001B[35m";
	public static final String CYAN = "\u001B[36m";
	public static final String WHITE = "\u001B[37m";

	// Colores de fondo
	public static final String BLACK_BACKGROUND = "\u001B[40m";
	public static final String RED_BACKGROUND = "\u001B[41m";
	public static final String GREEN_BACKGROUND = "\u001B[42m";
	public static final String YELLOW_BACKGROUND = "\u001B[43m";
	public static final String BLUE_BACKGROUND = "\u001B[44m";
	public static final String MAGENTA_BACKGROUND = "\u001B[45m";
	public static final String CYAN_BACKGROUND = "\u001B[46m";
	public static final String WHITE_BACKGROUND = "\u001B[47m";

	/**
	 * Pide un numero entero al usuario
	 * 
	 * @param sc  Scanner
	 * @param msg Mensaje para imprimir al usuario
	 * @return numero introducido por el usuario
	 */
	public static int pedirInt(Scanner sc, String msg) {
		int num = 0;

		do {
			try {
				System.out.printf("%s", msg);
				num = sc.nextInt();
				return num;
			} catch (InputMismatchException e) {
				System.out.println("Dato inválido.");

			} finally {
				sc.nextLine();
			}

		} while (true);

	}

	/**
	 * Pide un número entero al usuario dentro de un rango.
	 *
	 * @param sc  Scanner
	 * @param msg Mensaje para imprimir al usuario
	 * @param min Mínimo del rango
	 * @param max Máximo del rango
	 * @return Número introducido por el usuario
	 */
	public static int pedirInt(Scanner sc, String msg, int min, int max) {
		int num;

		do {
			try {
				System.out.printf("%s", msg, min, max);
				num = sc.nextInt();

				if (num >= min && num <= max) {
					return num;
				} else {
					System.out.println("Número fuera del rango.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Dato inválido.");
			} finally {
				sc.nextLine(); // Limpiar el buffer del scanner
			}

		} while (true);
	}

	/**
	 * Pide un numero entero al usuario a partir de un numero (no incluido)
	 * 
	 * @param sc  Scanner
	 * @param msg Mensaje para imprimir al usuario
	 * @param min Menor numero posible a introducir
	 * @return numero introducido por el usuario
	 */
	public static int pedirInt(Scanner sc, String msg, int min) {
		int num;

		do {
			try {
				System.out.printf("%s", msg, min);
				num = sc.nextInt();

				if (num > min) {
					return num;
				} else {
					System.out.println("Número debe ser mayor que " + min);
				}
			} catch (InputMismatchException e) {
				System.out.println("Dato inválido.");
			} finally {
				sc.nextLine(); // Limpiar el buffer del scanner
			}

		} while (true);
	}

	/**
	 * Calcula la suma de todos los numeros desde 0 hasta un numero especificado
	 * 
	 * @param n Numero tope
	 * @return la suma de 0 hasta el topa
	 */
	public static int sumaRecursiva(int n) {

		if (n != 0)
			return n + sumaRecursiva(n - 1);
		else
			return 0;
	}

	/**
	 * Imprime una matriz
	 * 
	 * @param mtrx Matriz a imprimir
	 */
	public static void printMtrx(int[][] mtrx) {
		if (mtrx.length == 0 || mtrx[0].length == 0)
			return;

		for (int i = 0; i < mtrx.length; i++) {
			for (int j = 0; j < mtrx[0].length; j++) {
				System.out.printf("%d ", mtrx[i][j]);
			}
			System.out.printf("\n");
		}
	}

	/**
	 * Imprime una matriz con espacios
	 * 
	 * @param mtrx      Matriz a imprimir
	 * @param numLength Cuantos digitos tiene el numero mayor
	 */
	public static void printMtrx(int[][] mtrx, int numLenght) {
		if (mtrx.length == 0 || mtrx[0].length == 0)
			return;

		for (int i = 0; i < mtrx.length; i++) {
			for (int j = 0; j < mtrx[0].length; j++) {
				System.out.printf("%s%dd ".formatted("%", numLenght), mtrx[i][j]);
			}
			System.out.printf("\n");
		}
	}

}
