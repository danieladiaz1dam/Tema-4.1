package ejercicios;

import java.util.Arrays;

/*
 * Crea un programa que cree un array de enteros e introduzca la
 * siguiente secuencia de valores: 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, etc.
 * hasta introducir 10 diez veces el 10, y luego la muestre por pantalla.
 * En esta ocasión has de utilizar Arrays.fill().
 */

public class Ejercicio02 {

	public static void main(String[] args) {
		// Crear la tabla con suficientes espacios
		int arr[] = new int[Helper.sumaRecesiva(10)];

		// Guardar la ultia posicion en la que hemos escrito
		int lastPos = 0;

		// Rellenar la tabla
		for (int i = 1; i <= 10; i++) {
			// Rellenar arr desde la ultima posicion hasta la posicion+numero con ese numero
			Arrays.fill(arr, lastPos, lastPos + i, i);
			lastPos += i;
		}

		// Imprimir la tabla
		System.out.printf("%s\n", Arrays.toString(arr));
	}
}
