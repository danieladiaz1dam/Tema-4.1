package ejercicios;

import java.util.Arrays;

/*
 * Implementa la función: int[] suma(int t[], int numElementos), que crea y devuelve una tabla con las sumas de los
 * numElementos elementos consecutivos de t. 
 * Veamos un ejemplo, sea t=[10, 1, 5, 8, 9, 2]. Si los elementos de t se agrupan de 3 en 3, se harán las sumas:
 * 
 * 10+1+5=16
 * 1+5+8=14
 * 5+8+9=22
 * 8+9+2=19
 * Por lo tanto, la función devolverá una tabla con los resultados: [16, 14, 22, 19].
 */

public class Ejercicio06 {
	/**
	 * Devuelve un array con las sumas de los numElementos consecutivos de t
	 * 
	 * @param t            Array de la que coger los elementos
	 * @param numElementos Numero de elementos consecutivos para sumar
	 * @return Array con sumas
	 */
	public static int[] suma(int t[], int numElementos) {
		// Nuevo array para guardar los numero necesarios
		// con (int) + .99f, redondeamos hacia arriba si es necesario un hueco mas
		int sumas[] = new int[(int) (t.length / (float) numElementos + .99f)];
		// Posicion para guadar la siguiente suma
		int pos = 0;
		// Ultima posicion de la que hemos leido numeros
		int lastPos = 0;
		// Variables temporales del bucle
		int suma, j;

		// Recorremos el array
		for (int i = 0; i < sumas.length; i++) {
			suma = 0;
			j = 0;

			// Recorremos una porcion del array, si llegamos al final y no se pueden agrupar
			// mas numeros, salir del bucle
			while (lastPos + j < t.length && j < numElementos) {
				suma += t[lastPos + j];
				j++;
			}

			// Guardar la suma y actualizar variables
			sumas[pos] = suma;
			pos++;
			lastPos += numElementos;
		}

		return sumas;
	}

	public static void main(String[] args) {
		int t[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };

		for (int i = 1; i <= t.length; i++)
			System.out.println(Arrays.toString(suma(t, i)));
	}
}
