package ejercicios;

/*
 * Escribe la función: int buscar(int t[], int clave), que busca de forma secuencial en
 * la tabla t el valor clave. En caso de encontrarlo, devuelve en qué posición
 * lo encuentra; y en caso contrario, devolverá -1.
 */

public class Ejercicio04 {
	/**
	 * Busca un numero en una array
	 * 
	 * @param t     Array donde buscar
	 * @param clave Numero a encontrar
	 * @return Posicion delnumero si se encuentra, -1 si no se encuentra
	 */
	public static int buscar(int t[], int clave) {
		int pos = 0;

		// Añadir posiciones hasta que se encuentre o se llegue al final del array
		while (pos < t.length && clave != t[pos]) {
			pos++;
		}

		// Si hemos llegado al final del array, significa que no lo hemos encontrado
		if (pos == t.length)
			pos = -1;

		return pos;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(buscar(arr, 7));
		System.out.println(buscar(arr, 85));
	}
}
