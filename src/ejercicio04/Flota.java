package ejercicio04;

import helper.DColor;

public class Flota {
	// Plaeta de colores
	final DColor WATER = new DColor(42, 145, 223);
	final DColor SUBMARINE = new DColor(11, 45, 71);
	final DColor HIT = new DColor(255, 26, 32);

	// Panel donde jugar
	// 0 = agua, 1 = submarino, 2 = submarino hundido
	int[] panel;

	// Panel que conoce el jugador
	// 0 = desconocido 1 = agua, 2 = submarino hundido
	int[] knownPanel;

	// submarinos undidos
	int lostSubmarines;

	/**
	 * Constructor
	 */
	public Flota() {
		// Posicion donde escribir
		int pos;
		// Posiciones usadas
		int usedPos;

		// Generar panel
		do {
			// Inicializar panel
			panel = new int[20];
			usedPos = 0;

			// Rellenar panel
			while (usedPos < 4) {
				// Si no hay un submarino en esa posicion, guardar uno nuevo
				pos = (int) (Math.random() * panel.length);
				if (panel[pos] == 0) {
					panel[pos] = 1;
					usedPos++;
				}
			}
		} while (!checkPanel(panel));

		// Inicializar knownPanel
		this.knownPanel = new int[panel.length];
	}

	/**
	 * Cosntructor con panel ya generado ( para el jugador )
	 * 
	 * @param panel Panel ya generado y checkeado
	 */
	public Flota(int panel[]) {
		this.panel = panel;
		// Inicializar knownPanel
		this.knownPanel = new int[panel.length];
	}

	public void printWholePanel() {
		String str = "|";
		for (int place : panel) {
			switch (place) {
			case 0:
				str += "%s|".formatted(WATER.block());
				break;
			case 1:
				str += "%s|".formatted(SUBMARINE.block());
				break;
			case 2:
				str += "%s|".formatted(HIT.block());
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + place);
			}
		}

		System.out.println(str);
	}

	public void printKnownPanel() {
		String str = "|";
		for (int place : knownPanel) {
			switch (place) {
			// Si la casilla se desconoce
			case 0:
				str += "  |";
				break;
			// Si en la casilla hay agua
			case 1:
				str += "%s|".formatted(WATER.block());
				break;
			// Si en la casilla hay un submarino hundido
			case 2:
				str += "%s|".formatted(HIT.block());
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + place);
			}
		}

		System.out.println(str);
	}

	/**
	 * Validar panel
	 * 
	 * @return true si el panel no tiene submarinos adyacentes
	 */
	public static boolean checkPanel(int panel[]) {
		int lastPlace = 0;
		int i = 0;
		boolean check = false;

		while (i < panel.length && !(lastPlace == 1 && panel[i] == 1)) {
			lastPlace = panel[i];
			i++;
		}

		if (i == panel.length)
			check = true;

		return check;
	}

	/**
	 * Mira que hay en una posicion
	 * 
	 * @param pos Posicion donde mirar
	 * @return false si hay agua, true si hay un submarino
	 */
	public boolean checkPos(int pos) {
		// Si hay agua, devolver false
		if (panel[pos] == 0)
			return false;

		// Si ya estaba hundido no hacer nada
		if (panel[pos] == 2)
			return true;

		// Si hay un submarino, hundirlo y devolver true
		panel[pos] = 2;
		lostSubmarines++;

		return true;
	}

	public void addToKnown(int pos, boolean submarine) {
		if (knownPanel[pos] == 0) {
			// Si es un submarino guardar 2 (hundido) si no 1 (agua)
			knownPanel[pos] = submarine ? 2 : 1;
		}
	}

	public int generatePos() {
		// Calcular posicion donde atacar
		int pos;
		do {
			pos = (int) (Math.random() * panel.length);
		} while (knownPanel[pos] != 0);
		
		// Devolver posicion
		return pos;
	}

	/**
	 * Mira si se han hundido los 4 submarinos
	 * 
	 * @return true si se han hundido los 4, false en caso contrario
	 */
	public boolean loose() {
		return lostSubmarines >= 4;
	}
}
