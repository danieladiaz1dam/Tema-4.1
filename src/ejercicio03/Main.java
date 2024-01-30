package ejercicio03;

import java.util.Scanner;
import helper.Helper;

/*
 * Simularemos el lanzamiento de una piedra a un río. Se pedirá al usuario dónde quiere lanzar la piedra (posición del vector)
 * y la intensidadde la piedra (un número entero menor o igual que la dimensión máxima del vector).
 * Cuando se lance, se almacena en esa casilla la pedrá y en las adyacentes se irán simulando las ondas con números que se van decrementando.
 * Ejemplo, si damos una pedrá del 4 en la posición 6: {0,0,1,2,3,4,3,2,1,0,0,0}
 * Después, cada segundo, se irá calmando el río restándole uno a las posiciones con número.
 * La simulación se parará cuando el río vuelva a estar en calma; todo a cero.
 */

public class Main {
	public static void updateArr(int arr[]) {
		// Si el numero es mayor que 0, restarle 1
		for (int i = 0; i < arr.length; i++)
			if (arr[i] > 0)
				--arr[i];
	}

	public static String colorizeArray(int arr[]) {
		// Array para retornar
		String str = "";

		// Añadirle cada numero coloreado
		for (int num : arr) {
			switch (num) {
			case 0: {
				// Si el numero es 0, pintar azul oscuro
				str += "%s%d ".formatted(Helper.BLUE, num);
				break;
			}

			case 1:
				// Si el numero es 1, pintar blanco, para simular espuma
				str += "%s%d ".formatted(Helper.WHITE, num);
				break;

			default:
				// Cualquier otro numero, pintarlo de azul claro, simulando la superficio turbia
				// del rio
				str += "%s%d ".formatted(Helper.CYAN, num);
			}
		}

		// Resetear el final del string para que la terminal no se quede azul.
		str += Helper.RESET;

		// Devolver el array
		return str;
	}

	public static void main(String[] args) {
		// Array a rellenar
		int arr[];
		// Tamaño del array
		int size = 0;
		// Variables para realizar cálculos y rellenar el array
		int fuerza = 0, index = 0, calc;
		// Scanner
		Scanner sc = new Scanner(System.in);

		// Pedir tamaño al usuario
		size = Helper.pedirInt(sc, "¿Cómo de grande quieres que sea el array?: ");
		arr = new int[size];

		// Pedir dónde quiere dar y con qué fuerza
		index = Helper.pedirInt(sc, "¿Dónde quieres dar?: ", 0, size - 1);
		fuerza = Helper.pedirInt(sc, "¿Con qué fuerza?: ", 0, size - 1);

		// Rellenar el array
		for (int i = 0; i < arr.length; i++) {
			calc = fuerza - Math.abs(i - index);
			arr[i] = calc < 0 ? 0 : calc;
		}

		// Imprimir array inicial con color
		System.out.println("\n" + colorizeArray(arr));

		while (arr[index] > 0) {
			// Actualizar los valores del array
			updateArr(arr);

			// Imprimir array actualizado con color
			System.out.println(colorizeArray(arr));

			// Esperar un poco
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
