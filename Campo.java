import java.util.*;

public class Campo {
  private int[][] matrice = new int[26][26];
  private Nave[] flotta = new Nave[15];

  public Campo() {
    /*
     * int j = 0;
     * List<Pair<Nave, Integer>> list = Regole.getFlottaStandard();
     * for (Pair<Nave, Integer> n : list) {
     * for (int i = 0; i < n.getValue(); i++) {
     * String currentNave = n.getKey().getClass().getSimpleName();
     * System.out.println();
     * String messaggio = "Inserisci coordinate " + currentNave + " " + (i + 1);
     * flotta[j] = new Nave(richiediCoordinate(messaggio),
     * richiediCoordinate(messaggio), n.getKey().getLunghezza());
     * j++;
     * }
     * }
     * 
     * for (int i = 0; i < flotta.length; i++) {
     * 
     * }
     */
  }

  public static String richiediCoordinate(String messaggio) {
    int[] coordinate = Nave.strCoord(Interfaccia.richiediValore(messaggio));
    // parte da aggiungere per il campo A-Z, 1-26
    // coordinate[1] = coordinate[1] - 1;
    String toReturn = Nave.coordStr(coordinate);
    return toReturn;
  }

  public static List<String> richiediLineaDiCoordinate(String messaggio) {

    String coordinateIniziali = richiediCoordinate("\nInserisci coordinate iniziali: ");
    String coordinateFinali = richiediCoordinate("Inserisci coordinate finali: ");

    return calcolaLineaDiCoordinate(coordinateIniziali, coordinateFinali);
  }

  public static List<String> calcolaLineaDiCoordinate(String coordinateIniziali, String coordinateFinali) {
    int[] cIniziali = Nave.strCoord(coordinateIniziali);
    int[] cFinali = Nave.strCoord(coordinateFinali);
    boolean horizontal = false, vertical = false;
    List<String> toReturn = new ArrayList<>();
    int startIndex = 0, endIndex = 0;

    if (cIniziali[0] == cFinali[0]) {
      vertical = true;
      startIndex = Math.min(cIniziali[1], cFinali[1]);
      endIndex = Math.max(cIniziali[1], cFinali[1]);
    } else if (cIniziali[1] == cFinali[1]) {
      horizontal = true;
      startIndex = Math.min(cIniziali[0], cFinali[0]);
      endIndex = Math.max(cIniziali[0], cFinali[0]);
    }

    for (int i = startIndex; i <= endIndex; i++) {
      String toAdd = "";
      if (vertical)
        toAdd = coordinateIniziali.charAt(0) + String.valueOf(i);
      else if (horizontal)
        toAdd = Nave.coordStr(new int[] { i, cIniziali[1] });
      toReturn.add(toAdd);
    }
    return toReturn;
  }
  
  static int clamp(int value, int min, int max) {
      return Math.max(min, Math.min(max, value));
  }   
  
  public static List<String> calcolaLineaDiCoordinate(String coordinateIniziali, Direzione dir, int lunghezza) {
    String cF;
    int[] cI = Nave.strCoord(coordinateIniziali);

    switch (dir) {
      case DX:
        cF = Nave.coordStr(new int[] { clamp(cI[0] + (lunghezza - 1), 0, 25), cI[1] });
        break;
      case UP:
        cF = Nave.coordStr(new int[] { cI[0], clamp(cI[1] - (lunghezza - 1),0 , 25) });
        break;
      case SX:
        cF = Nave.coordStr(new int[] { clamp(cI[0] - (lunghezza - 1),0,25), cI[1] });
        break;
      case DW:
        cF = Nave.coordStr(new int[] { cI[0], clamp(cI[1] + (lunghezza - 1),0,25) });
        break;
      default:
        cF = Nave.coordStr(new int[] { clamp(cI[0] + (lunghezza - 1),0, 25), cI[1] });
        break;
    }

    return calcolaLineaDiCoordinate(coordinateIniziali, cF);
  }

  public static List<List<String>> calcolaLineeDiCoordinate(String coordinateIniziali, int lunghezza) {

    List<String> up = calcolaLineaDiCoordinate(coordinateIniziali, Direzione.UP, lunghezza);
    List<String> right = calcolaLineaDiCoordinate(coordinateIniziali, Direzione.DX, lunghezza);
    List<String> down = calcolaLineaDiCoordinate(coordinateIniziali, Direzione.DW, lunghezza);
    List<String> left = calcolaLineaDiCoordinate(coordinateIniziali, Direzione.SX, lunghezza);
    List<List<String>> toReturn = Arrays.asList(up, down, left, right);
    return toReturn;
  }

  public int[][] getMatrice() {
    return this.matrice;
  }

  public void setMatrice(int[][] matrice) {
    this.matrice = matrice;
  }

  public Nave[] getFlotta() {
    return this.flotta;
  }

  public void setFlotta(Nave[] flotta) {
    this.flotta = flotta;
  }

  public boolean cellaLibera(int[] coordinate) {
    boolean toReturn = false;
    if (this.matrice[coordinate[1]][coordinate[0]] == 0) {
      toReturn = true;
    }
    return toReturn;
  }

  public boolean celleIdonee(int[] cella) {
    boolean idonea = true;

    for (int i = Math.max(0, cella[0] - 1); i < Math.min(25, cella[0] + 2); i++) {
      for (int j = Math.max(0, cella[1] - 1); j < Math.min(25, cella[1] + 2); j++) {
        if (!idonea){
          break;
        }
        idonea = cellaLibera(new int[] { i, j });
      }
    }
    return idonea;
  }

  public boolean naveInseribile(Nave nave, String coordIniziali, Direzione dir) {
    boolean idonea = true;
    List<String> coordinate = calcolaLineaDiCoordinate(coordIniziali, dir, nave.getLunghezza());

    for (int i = 0; i < coordinate.size(); i++) {
      idonea = celleIdonee(Nave.strCoord(coordinate.get(i)));
      if (!idonea)
        break;
    }
    System.out.println(idonea);
    return idonea;
  }

  public boolean piazzaNave(Nave nave, String coordIniziali, Direzione dir) {
    if (!naveInseribile(nave, coordIniziali, dir)) {
      return false;
    }

    List<String> coordinate = calcolaLineaDiCoordinate(coordIniziali, dir, nave.getLunghezza());

    for (int i = 0; i < coordinate.size(); i++) {
      int[] coord = Nave.strCoord(coordinate.get(i));
      this.matrice[coord[1]][coord[0]] = nave.getLunghezza();
    }

    return true;
  }

  public void inserisciNave(Nave nave) {
    String coordIniziali = richiediCoordinate("Inserisci coordinate iniziali: ");

    List<List<String>> linee = calcolaLineeDiCoordinate(coordIniziali, nave.getLunghezza());
    List<String> opzioni = new ArrayList<>();
    for (int i = 0; i < linee.size(); i++) {
      if (!naveInseribile(nave, coordIniziali, Direzione.values()[i]) || nave.getLunghezza() > linee.get(i).size())
        opzioni.add("Direzione non disponbile: cella/e occupata/e");
      else
        opzioni.add(linee.get(i).toString());
    }

    Interfaccia.stampaSceltaMultipla("Scegli set di coordinate: ", opzioni);

    int input = Integer.parseInt(Interfaccia.richiediValore(""));
    Direzione dir = Direzione.values()[input];
    piazzaNave(nave, coordIniziali, dir);
  }
}