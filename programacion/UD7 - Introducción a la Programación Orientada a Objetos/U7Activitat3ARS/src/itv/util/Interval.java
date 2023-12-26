package itv.util;

public class Interval {
  private double inferior;
  private double superior;

  public Interval(double inferior, double superior) {
    assert inferior <= superior;
    this.inferior = inferior;
    this.superior = superior;
  }

  public Interval(double superior) {
    this(0, superior);
  }

  public Interval(Interval interval) {
    this(interval.inferior, interval.superior);
  }

  public Interval() {
    this(0, 0);
  }

  public Interval clone() {
    return new Interval(this);
  }

  public double longitud() {
    return this.superior - this.inferior;
  }

  public void moure(double moviment) {
    this.inferior += moviment;
    this.superior += moviment;
  }

  public Interval mogut(double moviment) {
    Interval Intervalo = this.clone();
    Intervalo.moure(moviment);
    return Intervalo;
  }

  public boolean inclou(double valor) {
    return this.inferior <= valor && valor <= this.superior;
  }

  public boolean inclou(Interval interval) {
    assert interval != null;
    return this.inclou(interval.inferior) && this.inclou(interval.superior);
  }

  public boolean equals(Interval interval) {
    assert interval != null;
    return this.inferior == interval.inferior && this.superior == interval.superior;
  }

  public boolean intersecta(Interval interval) {
    assert interval != null;
    return this.inclou(interval.inferior) || this.inclou(interval.superior) || interval.inclou(inferior) || interval.inclou(superior);
  }

  public Interval interseccio(Interval interval) {
    assert this.intersecta(interval);
    
    if (this.inclou(interval)) {
      return interval.clone();
    } else if (interval.inclou(this)) {
      return this.clone();
    } else if (this.inclou(interval.inferior)) {
      return new Interval(interval.inferior, superior);
    } else {
      return new Interval(inferior, interval.superior);
    }
  }

  public void oposar() {
    double inferiorInicial = this.inferior;
    double superiorInicial = this.superior;
    this.inferior = -superiorInicial;
    this.superior = -inferiorInicial;
  }

  public void doblar() {
    double longitudInicial = this.longitud();
    this.inferior -= longitudInicial / 2;
    this.superior += longitudInicial / 2;
  }

  public void recollir() {
    GestorIO gestorIO = new GestorIO();
    gestorIO.out("Inferior?");
    this.inferior = gestorIO.inDouble();
    gestorIO.out("Superior?");
    this.superior = gestorIO.inDouble();
  }

  public void mostrar() {
    GestorIO gestorIO = new GestorIO();
    gestorIO.out("[" + this.inferior + "," + this.superior + "]");
  }

  public Interval[] trossejar(int trossos) {
    assert trossos > 0;
    
    double longitudTros = longitud() / trossos;
    Interval[] subIntervals = new Interval[trossos];
    
    double inferiorTros = this.inferior;
    
    for (int i = 0; i < trossos; i++) {
      double superiorTros = inferiorTros + longitudTros;
      subIntervals[i] = new Interval(inferiorTros, superiorTros);
      inferiorTros += longitudTros;
    }
    
    return subIntervals;
  }
}