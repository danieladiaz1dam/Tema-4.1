package ejercicios;

import helper.Helper;

/**
 * Ejercicio10
 */
public class Ejercicio10 {
	/**
	 * Gira una tabla 90 grados
	 * 
	 * @param tablaInicio Tabla que girar
	 * @return Tabla girada si la tabla es cuadrada, tabla vacia si no es cuadrada
	 */
	public static int[][] gira90(int tablaInicio[][]) {
		final int newTabla[][];

		if (tablaInicio.length != tablaInicio[0].length)
			newTabla = new int[0][0];
		else
			newTabla = new int[tablaInicio.length][tablaInicio.length];

		for (int i = 0; i < newTabla.length; i++) {
			for (int j = 0; j < newTabla[0].length; j++) {
				newTabla[i][newTabla[0].length - j - 1] = tablaInicio[j][i];
			}
		}

		return newTabla;
	}

	/**
	 * Metodo Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		final int mtrx[][] = new int[4][4];

		for (int i = 0; i < mtrx.length; i++) {
			for (int j = 0; j < mtrx[i].length; j++) {
				mtrx[i][j] = i * mtrx.length + j + 1;
			}
		}

		Helper.printMtrx(mtrx, 2);
		System.out.println();
		Helper.printMtrx(gira90(mtrx), 2);
	}
}
