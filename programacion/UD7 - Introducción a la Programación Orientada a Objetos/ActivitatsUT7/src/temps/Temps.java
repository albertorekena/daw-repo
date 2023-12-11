// Crea la classe Temps amb els mètodes suma i resta.
// Els objectes de la classe Temps són intervals de temps i es creen de la forma Temps t = new Temps(1, 20, 30) on els paràmetres que es passen al constructor són les hores, els minuts i els segons respectivament.
// Crea el mètode toString per vore els intervals de temps de la forma 10h 35m 5s.
// Si se sumen per exemple 30m 40s i 35m 20s el resultat hauria de ser 1h 6m 0s.
// Realitza un programa de prova per comprovar que la classe funciona bé.

package temps;

public class Temps {
	private int hores;
	private int minuts;
	private int segons;

	public Temps(int h, int m, int s) {
		this.hores = h;
		this.minuts = m;
		this.segons = s;
	}

	public int getHores() {
		return hores;
	}

	public int getMinuts() {
		return minuts;
	}

	public int getSegons() {
		return segons;
	}

	public Temps suma(Temps altreTemps) {
		int h;
		int m;
		int s;

		h = this.hores + altreTemps.hores;

		m = this.minuts + altreTemps.getMinuts();
		if (m > 59) {
			h++;
			m = m % 60;
		}

		s = this.segons + altreTemps.getSegons();
		if (s > 59) {
			m++;
			s = s % 60;
		}
		
		return new Temps(h, m, s);
	}

	public Temps resta(Temps altreTemps) {
		int h;
		int m;
		int s;

		h = this.hores - altreTemps.hores;

		m = this.minuts - altreTemps.getMinuts();
		if (m < 0) {
			h--;
			m += 60;
		}

		s = this.segons - altreTemps.getSegons();
		if (s < 0) {
			m--;
			s += 60;
		}
		
		return new Temps(h, m, s);
	}

	public String toString() {
		return this.hores + "h" + this.minuts + "m" + this.segons + "s";
	}
}