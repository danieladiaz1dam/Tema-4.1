package ejercicios;

import helper.Helper;

public class Ejercicio04 {
	public static int[][] tablasMultiplicar() {
		int[][] tablas = new int[10][10];

		for (int i = 0; i < tablas.length; i++) {
			for (int j = 0; j < tablas[i].length; j++) {
				tablas[i][j] = i * j;
			}
		}

		return tablas;
	}
	
	public static void main(String[] args) {
		Helper.printMtrx(tablasMultiplicar(), 2);
	}
}
