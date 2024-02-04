package ejercicios;

import java.util.Scanner;
import helper.Helper;

/**
 * Ejercicio02
 */
public class Ejercicio02 {

	/**
	 * Metodo main
	 * @param args
	 */
	public static void main(String[] args) {
		final int notasAlumnos[][] = new int[4][5];
		final Scanner sc = new Scanner(System.in);

		// Rellenar notas de los alumnos
		for (int iAlumno = 0; iAlumno < notasAlumnos.length; iAlumno++) {
			System.out.printf("Notas del alumno %d\n", iAlumno + 1);
			for (int iAsignatura = 0; iAsignatura < notasAlumnos[0].length; iAsignatura++) {
				notasAlumnos[iAlumno][iAsignatura] = Helper.pedirInt(sc,
						"Introduce la nota %d: ".formatted(iAsignatura + 1), 0, 10);
				// notasAlumnos[iAlumno][iAsignatura] = (int) (Math.random() * 11);
			}
			System.out.println();
		}

		System.out.println();

		// Imprimir cabecera asignatira X
		// "Alumno 1 " mide 9
		System.out.printf("%9s| ", "");
		for (int i = 0; i <= notasAlumnos.length; i++) {
			System.out.printf("Asignatura %d | ", i + 1);
		}
			
		System.out.println();

		// Imprimir las notas de los alumnos
		for (int i = 0; i < notasAlumnos.length; i++) {
			System.out.printf("Alumno %d |", i + 1);
			for (int j = 0; j < notasAlumnos[i].length; j++) {
				// "Asignatura 1 " mide 13
				System.out.printf(" %-13d|", notasAlumnos[i][j]);
			}
			System.out.println();
		}

		System.out.println("\n");

		// Imprimir media de los alumnos
		// Imprimir cabecera
		System.out.printf("%8s | %8s | %8s | %8s |\n", "", "Media", "Max", "Min");

		// Imprimir tabla
		for (int i = 0; i < notasAlumnos.length; i++) {
			System.out.printf("Alumno %d |", i + 1);
			System.out.printf("%9.0f |", Helper.media(notasAlumnos[i]));
			System.out.printf("%9d |", Helper.findMax(notasAlumnos[i]));
			System.out.printf("%9d |", Helper.findMin(notasAlumnos[i]));
			System.out.println();
		}
		
		// Cerrar scanner
		sc.close();

	}
}
