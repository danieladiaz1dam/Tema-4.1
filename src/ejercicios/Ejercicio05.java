package ejercicios;

import java.util.Arrays;

/*
 * Realiza la función: int[] buscarTodos(int t[], int valor), que crea y devuelve una tabla con
 * todos los índices de los elementos donde se encuentra el valor de búsqueda.
 * En el caso de que el valor no se encuentre en la tabla t, la función devolverá una tabla vacía.
 */

public class Ejercicio05 {
	/**
	 * Cambia el tamaño de un array para añadir un numero al final
	 * 
	 * @param arr Array Inicial
	 * @param n   Numero para añadir
	 * @return nueva array
	 */
	public static int[] addToArray(int arr[], int n) {
		int tmp[];

		// Copiar tabla original
		tmp = Arrays.copyOf(arr, arr.length);
		// Cambiar tamaño
		arr = new int[tmp.length + 1];
		// Copiar arr original a la nueva
		System.arraycopy(tmp, 0, arr, 0, tmp.length);
		// Añadir nuevo numero al final
		arr[arr.length - 1] = n;

		return arr;
	}

	/**
	 * Devuelve una array de las posiciones donde se encuentra el valor
	 * 
	 * @param t     Array donde buscar
	 * @param valor Valor que buscar
	 */
	public static int[] buscarTodos(int t[], int valor) {
		int arr[] = {};

		for (int i = 0; i < t.length; i++) {
			if (t[i] == valor) {
				arr = addToArray(arr, i);
			}
		}

		return arr;
	}

	public static void main(String[] args) {
		int arr[] = {};
		arr = addToArray(arr, 1);
		arr = addToArray(arr, 2);
		arr = addToArray(arr, 3);
		arr = addToArray(arr, 1);
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(buscarTodos(arr, 1)));
	}
}
