package ejercicios;

import java.util.Arrays;

import helper.Helper;

public class ejercicio5 {
	/**
	 * Suma todos los valores de un array
	 * 
	 * @param arr Array para sumar sus valores
	 * @return Suma de los valores
	 */
	public static int suma(int[] arr) {
		int suma = 0;

		for (int num : arr)
			suma += num;

		return suma;
	}

	/**
	 * "Rota" la matriz, cambia las rows por las columns
	 * 
	 * @see <a href="https://mathinsight.org/matrix_transpose">transpose of
	 *      matrix</a>
	 * @param mtrx Matriz para rotar
	 * @return Matrix rotada
	 */
	public static int[][] transpose(int mtrx[][]) {
		int newMtrx[][] = new int[mtrx[0].length][mtrx.length];

		for (int i = 0; i < newMtrx.length; i++) {
			for (int j = 0; j < newMtrx[i].length; j++) {
				newMtrx[i][j] = mtrx[j][i];
			}
		}

		return newMtrx;
	}

	public static void main(String[] args) {
		// Matriz que rellenar y calcular
		int mtrx[][] = new int[6][5]; // <-- esto esta al reves :)))

		// Rellenar el array
		for (int i = 0; i < mtrx.length - 1; i++) {
			for (int j = 0; j < mtrx[i].length - 1; j++) {
				mtrx[i][j] = (int) (100 + Math.random() * 900); // 100 ~ 999
			}
		}

		// Rellenar las sumas de las rows
		for (int i = 0; i < mtrx.length; i++) {
			mtrx[i][mtrx[0].length - 1] = suma(mtrx[i]);
		}

		// Rellenar las sumas de las columns
		// Transpose para que las colums pasen a ser rows y pueda usar la misma funcion
		mtrx = transpose(mtrx);
		for (int i = 0; i < mtrx.length; i++) {
			mtrx[i][mtrx[0].length - 1] = suma(mtrx[i]);
		}

		// Rellenar suma de todo
		System.out.println();
		// Sumar en el ultimo espacio la suma de las sumas de las columns menos la
		// ultima que ya esta
		mtrx[mtrx.length - 1][mtrx[0].length - 1] += suma(
				Arrays.copyOfRange(mtrx[mtrx.length - 1], 0, mtrx[0].length - 1));

		// Imprimir matriz
		Helper.printMtrx(mtrx, 5);
	}
}
