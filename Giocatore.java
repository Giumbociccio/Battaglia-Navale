public class Giocatore {
  private String nome;
  private Campo campo;

  public Giocatore(String nome) {
    super();
    this.nome = nome;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String n) {
    this.nome = n;
  }

  public Campo getCampo() {
    return this.campo;
  }

  public void setCampo(Campo newTab) {
    this.campo = newTab;
  }

}