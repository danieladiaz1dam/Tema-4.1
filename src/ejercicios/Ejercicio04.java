package ejercicios;

import java.util.Arrays;

/*
 * Crea un programa que cree un array de tamaño 30 y lo rellene con valores aleatorios entre 0 y 9
 * (utiliza Math.random()*10). Luego ordena los valores del array y los mostrará por pantalla.
 */

public class Ejercicio04 {
	public static void main(String[] args) {
		// Crear el array
		int arr[] = new int[30];

		// Rellenar array
		for (int i = 0; i < arr.length; i++)
			arr[i] = (int)(Math.random() * 10);
		
		// Ordenar el array
		Arrays.sort(arr);
		
		// impimir array
		System.out.println(Arrays.toString(arr));
	}
}
