import java.util.*;
// import package.src.*;

public class Main {
  public static void main(String[] args) {

    // Giocatore g1 = new Giocatore("Tommy");
    Torpediniera t1 = new Torpediniera("A1", "Z2");
    // accettabile(t1);
    Campo c = new Campo();
    Portaerei p = new Portaerei("A1", "A5");
    c.inserisciNave(p);
    c.inserisciNave(t1);

    Cacciatorpediniere c1 = new Cacciatorpediniere("A1", "A3");
    c.inserisciNave(c1);

    Interfaccia.stampaCampo(c);
  }

  public void play() {
    boolean gioco = true;
    System.out.println("Benvenut* a Battaglia Navale!");
  }

  public static void accettabile(Nave n) {
    Scanner s = new Scanner(System.in);
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