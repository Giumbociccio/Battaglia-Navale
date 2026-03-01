package it.giumbociccio;

import java.util.*;

public abstract class Interfaccia {
	private static String startRow = "     A   B   C   D   E   F   G   H   I   J   K   L   M   N   O   P   Q   R   S   T   U   V   W   X   Y   Z\n"
			+ "   ┌───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┐";
	private static String middleRow = "\n   ├───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤";
	private static String endRow = "\n   └───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┘";

	public static void stampaElenco(List<String> opzioni) {
		for (int i = 0; i < opzioni.size(); i++) {
			System.out.println(i + ") " + opzioni.get(i));
		}
	}

	public static void stampaSceltaMultipla(String domanda, List<String> opzioni) {
		System.out.println(domanda);
		stampaElenco(opzioni);
	}

	public static String richiediValore(String messaggio) {
		Scanner s = new Scanner(System.in);
		System.out.println(messaggio);
		String valore = s.nextLine();
		return valore;
	}

	public static void stampaCampo(Campo campo) {
		int[][] toPrint = campo.getMatrice();
		System.out.println(startRow);

		for (int i = 0; i < toPrint.length; i++) {
			// cambiare (i) in (i+1) per il campo A-Z, 1-26
			System.out.print((i) + ((i) < 10 ? "  │" : " │"));

			for (int j = 0; j < toPrint[i].length; j++) {
				System.out.print(" " + (toPrint[i][j] == 0 ? " " : toPrint[i][j]) + " │");
			}
			System.out.println((i < 25) ? middleRow : endRow);
		}
	}

	public static void stampaMatrice(int[][] campo) {
		for (int i = 0; i < campo.length; i++) {
			for (int j = 0; j < campo[i].length; j++) {
				System.out.print(campo[i][j] + " ");
			}
			System.out.println();
		}
	}
}