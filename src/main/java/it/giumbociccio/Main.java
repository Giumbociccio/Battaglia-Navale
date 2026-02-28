package it.giumbociccio;

import java.util.*;
// import package.src.*;

public class Main {
	public static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Benvenut* a Battaglia Navale!");
		boolean gioco = true;
		while (gioco) {
			gioco = play(gioco);
		}
	}

	public static boolean play(boolean gioco) {
		System.out.println("\nCosa vuoi fare?\n" + "1) Armare la flotta\n" + "2) Giocare\n"
				+ "3) Uscire");
		int risposta = s.nextInt();
		switch (risposta) {
		case 1:
			// Giocatore g1 = new Giocatore("Tommy");
			Torpediniera t1 = new Torpediniera("Z1", "Z4");
			// accettabile(t1);
			Campo c = new Campo();
			Portaerei p = new Portaerei("A1", "A5");
			c.inserisciNave(p);
			c.inserisciNave(t1);

			Cacciatorpediniere c1 = new Cacciatorpediniere("B7", "B9");
			c.inserisciNave(c1);

			Interfaccia.stampaCampo(c);
			break;
		case 2:
			break;
		case 3:
			System.out.println("\nE' stato un piacere giocare con te, alla prossima!!");
			gioco = false;
			break;
		default:
			break;
		}
		return gioco;
	}

	public static void accettabile(Nave n) {
		boolean giusto = false;
		while (!giusto) {
			if (n.getLunghezza() == lunghezzaNave(n)) {
				giusto = true;
			}
			if (!giusto) {
				System.out.print("Coordinate non accettabili\nInserire coordinate per la nave\nCoordinate iniziali: ");
				n.setCoord1(s.nextLine());
				System.out.print("Coordinate finali: ");
				n.setCoord2(s.nextLine());
			}
		}
	}

	public static int lunghezzaNave(Nave n) {
		int lunghezza = 0;
		int[] c1 = n.getCoord1();
		int[] c2 = n.getCoord2();
		if (c1[0] == c2[0]) {
			lunghezza = Math.abs(c1[1] - c2[1]) + 1;
		} else if (c1[1] == c2[1]) {
			lunghezza = Math.abs(c1[0] - c2[0]) + 1;
		}
		return lunghezza;
	}
}