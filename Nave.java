public abstract class Nave {
  private int lunghezza;
  private int[] coord1 = new int[2];
  private int[] coord2 = new int[2];

  public Nave(String coordinate1, String coordinate2, int n) {
    super();
    this.lunghezza = n;

    this.coord1 = strCoord(coordinate1);
    this.coord2 = strCoord(coordinate2);
  }

  public static int[] strCoord(String c) {
    int[] coord = new int[2];
    String[] cSplit = new String[2];
    cSplit[0] = c.substring(0, 1);
    cSplit[1] = c.substring(1);
    String str_alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String[] alfabeto = str_alfabeto.split("");

    for (int i = 0; i < alfabeto.length; i++) {
      if (cSplit[0].equalsIgnoreCase(alfabeto[i])) {
        coord[0] = i;
      }
    }
    coord[1] = Integer.parseInt(cSplit[1]);
    return coord;
  }

  public static String coordStr(int[] c) {
    String str_alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String[] alfabeto = str_alfabeto.split("");
    String coord = alfabeto[c[0]] + "" + c[1];
    return coord;
  }

  public int getLunghezza() {
    return this.lunghezza;
  }

  public void setLunghezza(int n) {
    this.lunghezza = n;
  }

  public int[] getCoord1() {
    return this.coord1;
  }

  public void setCoord1(String coordinate1) {
    this.coord1 = strCoord(coordinate1);
  }

  public int[] getCoord2() {
    return this.coord2;
  }

  public void setCoord2(String coordinate2) {
    this.coord2 = strCoord(coordinate2);
  }

}