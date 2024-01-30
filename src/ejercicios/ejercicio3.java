package ejercicios;

import helper.Helper;

/*
 * Define una función que reciba una tabla bidimensional y la rellene de la siguiente forma:
 * el elemento de la posición [n][m] debe contener el valor 10 * n + m.
 * La función no devuelve nada, sino que se modifica la tabla introducido por parámetro dentro de la función.
 * Realiza un main que llame a la función y muestre la tabla por consola.
 */

public class ejercicio3 {
	public static void fillMtrx(int mtrx[][]) {
		for (int i = 0; i < mtrx.length; i++)
			for (int j = 0; j < mtrx[0].length; j++)
				mtrx[i][j] = 10 * i+j;
	}

	public static void main(String[] args) {
		int mtrx[][] = new int[5][5];

		fillMtrx(mtrx);

		Helper.printMtrx(mtrx, 3);
	}
}
