package ejercicios;

import helper.Helper;

/**
 * Ejercicio09
 */
public class Ejercicio09 {
	/**
	 * Calcula si una tabla es magica
	 * 
	 * @param tabla Tabla para comprobar
	 * @return true si es magica, false en caso contrario
	 */
	public static boolean esMagica(int tabla[][]) {
		int sumaF1 = 0;
		int suma;
		int y = 1, k;
		boolean magica = true;

		// Calcular la suma de la primera fila
		for (int j = 0; j < tabla[0].length; j++)
			sumaF1 += tabla[0][j];

		// Comprobar que la suma del resto de filas es igual a la suma de la primera
		while (y < tabla.length && magica) {
			k = 0;
			suma = 0;

			while (k < tabla[0].length && magica) {
				suma += tabla[y][k];
				k++;
			}

			if (suma != sumaF1)
				magica = false;

			y++;
		}

		y = 0;
		while (y < tabla[0].length && magica) {
			suma = 0;
			k = 0;
			while (k < tabla.length && magica) {
				suma += tabla[k][y];
				k++;
			}

			if (suma != sumaF1)
				magica = false;

			y++;
		}

		return magica;
	}

	/**
	 * Metodo main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		final int tabla[][] = new int[3][3];

		// Rellenar tabla
		for (int i = 0; i < tabla.length; i++)
			for (int j = 0; j < tabla[i].length; j++)
				tabla[i][j] = (int) (Math.random() * 6);

		// tabla = new int[][] { { 2, 7, 9 }, { 9, 5, 1 }, { 4, 3, 8 } };

		Helper.printMtrx(tabla);

		System.out.println(esMagica(tabla) ? "La matriz es magica" : "La matriz no es magica");
	}
}
