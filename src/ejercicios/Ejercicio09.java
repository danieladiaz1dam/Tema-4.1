package ejercicios;

import java.util.Scanner;

/*
 * Realiza un programa que pida la temperatura media que ha hecho en cada mes de un
 * determinado año y que muestre a continuación un diagrama de barras horizontales
 * con esos datos. Las barras del diagrama se pueden dibujar a base de asteriscos
 * o cualquier otro carácter.
 */

public class Ejercicio09 {
	/**
	 * Encontrar el numero mas grande en un array
	 * 
	 * @param arr Array
	 * @return Numero mayor
	 */
	public static float max(float[] arr) {
		if (arr.length == 0) {
			// throw exception
			return 0;
		}

		float max = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i])
				max = arr[i];
		}

		return max;
	}

	/**
	 * Encontrar el numero mas pequeño en un array
	 * 
	 * @param arr Array
	 * @return Numero menor
	 */
	public static float min(float[] arr) {
		if (arr.length == 0) {
			// throw exception
			return 0;
		}

		float min = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (min > arr[i])
				min = arr[i];
		}

		return min;
	}

	/**
	 * Pinta una barra de n caracteres especificados
	 * 
	 * @param len Longitud
	 * @param c   Caracter a usar
	 */
	public static void Barra(int len, int value, char c) {
		if (value < 0)
			value *= -1;

		System.out.printf("%2d ºC | ", value);
		for (int i = 0; i < value; i++) {
			System.out.printf("%c", c);
		}
	}

	/**
	 * Pinta una barra de n #s
	 * 
	 * @param len Longitud
	 */
	public static void Barra(int len, float value) {
		if (value < 0)
			value *= -1;

		// 5 caracteres (4 numeros + ',')
		// de los cuales 2 son decimales
		System.out.printf("%5.2fºC |", value);
		for (int i = 0; i < value; i++) {
			System.out.printf("#");
		}
		for (int i = (int) value; i < len; i++) {
			System.out.printf(" ");
		}
		System.out.printf("|");
	}

	public static void main(String[] args) {
		// Crear tabla
		float[] temps = new float[12];
		float maxTemp = 0;
		Scanner sc = new Scanner(System.in);

		// Introducir temperaturas del usuario
		for (int i = 0; i < temps.length; i++) {
			System.out.printf("Introduce la temperatura del mes #%d: ", i + 1);
			temps[i] = sc.nextFloat();
			// temps[i] = (float) (Math.random() * 30 + 1);
		}

		maxTemp = max(temps);

		// Imprimirtemperaturas
		System.out.printf("\nTemperaturas:\n");
		for (float temp : temps) {
			Barra((int) maxTemp, temp);
			System.out.println();
		}

		// Imprimir maximas y minimas
		System.out.printf("\nMaximas y minimas:\n");
		System.out.printf("Max: %5.2fºC\n", maxTemp);
		System.out.printf("Min: %5.2fºC\n", min(temps));

		sc.close();
	}
}
