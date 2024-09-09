import java.util.*;

public class Regole {

  private static List<Pair<Nave, Integer>> flottaStandard = new ArrayList<>();

  public static List<Pair<Nave, Integer>> getFlottaStandard() {
    if (flottaStandard.size() == 0) {
      flottaStandard.add(new Pair(new Sottomarino("C3", "C3"), 5));
      flottaStandard.add(new Pair(new Torpediniera("C3", "C3"), 4));
      flottaStandard.add(new Pair(new Cacciatorpediniere("C3", "C3"), 3));
      flottaStandard.add(new Pair(new Petroliera("C3", "C3"), 2));
      flottaStandard.add(new Pair(new Portaerei("C3", "C3"), 1));
    }
    return flottaStandard;
  }

  // 0 -> libero
  // 1 -> occupato (Sottomarino)
  // 2 -> occupato (Torpediniera)
  // 3 -> occupato (Cacciatorpediniere)
  // 4 -> occupato (Petroliera)
  // 5 -> occupato (Portaerei)

  // 5 Sottomarini (1 cella)
  // 4 Torpediniere (2 celle)
  // 3 Cacciatorpediniere (3 celle)
  // 2 Petroliere (4 celle)
  // 1 Portaerei (5 celle)

  /*
   * a[0]
   * a[1]
   * a[2]
   * 
   * 
   * a[Sottomarino] = 5
   * a[Torpediniera] = 4
   * a[Cacciatorpediniere] = 3
   */
}