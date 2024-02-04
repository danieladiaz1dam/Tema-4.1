package ejercicios;

import java.util.Arrays;

/**
 * Ejercicio06
 */
public class Ejercicio06 {
	/**
	 * Devuelve los numeros mayor y menor de un array
	 * 
	 * @param arr Array donde buscar los numeros
	 * @return Array de dos posiciones, la 0 con el numero menor y la con el numero
	 *         mayor
	 */
	public static int[] minMax(int arr[][]) {
		int min = arr[0][0];
		int max = arr[0][0];

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (min > arr[i][j])
					min = arr[i][j];
				if (max < arr[i][j])
					max = arr[i][j];
			}
		}

		return new int[] { min, max };
	}

	/**
	 * Rellena un array
	 * 
	 * @return Array rellena
	 */
	public static int[][] rellenarArray() {
		final int arr[][] = new int[6][10];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = (int) (Math.random() * 1001);
			}
		}

		return arr;
	}

	/**
	 * Metodo main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(Arrays.toString(minMax(rellenarArray())));
	}
}
