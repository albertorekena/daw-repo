package itv.util;

public class Interval {

    private double inferior;
    private double superior;

    /**
     * Proporciona un interval amb els límits inferior i superior que li donem
     * @param inferior
     * @param superior 
     */
    public Interval(double inferior, double superior) {
        assert superior >= inferior;
        
        this.inferior = inferior;
        this.superior = superior;
    }

    /**
     * Proporciona un interval amb límit superior que li donem
     * @param superior 
     */
    public Interval(double superior) {
        this(0, superior);
       
    }

    /**
     * Proporciona un interval a partir d'un altre (copia)
     * @param interval 
     */
    public Interval(Interval interval) {
        this(interval.inferior, interval.superior);
    }

    /**
     * Proporciona un interval amb límits per defecte.
     */
    public Interval() {
        this(0, 0);
    }

    /**
     * Clona l'interval
     * @return 
     */
    public Interval clone() {
        return new Interval(this);
    }

    /**
     * Longitud de l'interval
     * @return 
     */
    public double longitud() {
        return superior - inferior;
    }

    /**
     * Mou els límits de l'interval segons el que indiquem
     * @param moviment 
     */
    public void moure(double moviment) {
        inferior += moviment;
        superior += moviment;
    }

    /**
     * Obtiene l'interval mogut segons el moviment proporcionat
     * @param moviment
     * @return 
     */
    public Interval mogut(double moviment) {
        Interval Intervalo = this.clone();
        Intervalo.moure(moviment);
        return Intervalo;
    }

    /**
     * Determina si el valor está dintre de l'interval
     * @param valor
     * @return 
     */
    public boolean inclou(double valor) {
        return inferior <= valor && valor <= superior;
    }

    /**
     * Determina si l'interval proporcionat está inclòs en l'interval
     * @param interval
     * @return 
     */
    public boolean inclou(Interval interval) {
        assert interval != null;
        return this.inclou(interval.inferior)
                && this.inclou(interval.superior);
    }

    /**
     * Determina si dos intervals són iguals
     * @param interval
     * @return 
     */
    public boolean equals(Interval interval) {
        assert interval != null;
        return inferior == interval.inferior
                && superior == interval.superior;
    }

    /**
     * Obté l'interval que intersecta
     * @param interval
     * @return 
     */
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

    /**
     * Determina si un interval intersecta amb el nostre
     * @param interval
     * @return 
     */
    public boolean intersecta(Interval interval) {
        assert interval != null;
        return this.inclou(interval.inferior)
                || this.inclou(interval.superior)
                || interval.inclou(inferior)
                || interval.inclou(superior);
    }

    /**
     * Transforma l'interval en el seu oposat.
     */
    public void oposar() {
        double inferiorInicial = inferior;
        double superiorInicial = superior;
        inferior = -superiorInicial;
        superior = -inferiorInicial;
    }

    /**
     * Augmenta la grandària de l'interval al doble de la seua longitud (ha de creixer igual pels dos extrems).
     */
    public void doblar() {
        double longitudInicial = this.longitud();
        inferior -= longitudInicial / 2;
        superior += longitudInicial / 2;
    }

    /**
     * Demana a l'usuari que introduïsca els límits de l'interval
     */
    public void recollir() {
        GestorIO gestorIO = new GestorIO();
        gestorIO.out("Inferior?");
        inferior = gestorIO.inDouble();
        gestorIO.out("Superior?");
        superior = gestorIO.inDouble();
    }

    /**
     *  Mostra l'interval amb el format [limitInferior, limitSuperior].
     */
    public void mostrar() {
        GestorIO gestorIO = new GestorIO();
        gestorIO.out("[" + inferior + "," + superior + "]");
    }

    /**
     * Obté els subintervals en grandàries iguals segons els trossos proporcionats
     * @param trossos
     * @return 
     */
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