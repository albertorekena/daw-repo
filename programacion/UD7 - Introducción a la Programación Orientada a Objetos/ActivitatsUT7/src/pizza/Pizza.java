// Crea la classe Pizza amb els atributs i mètodes que calguen.
// Sobre cada pizza volem saber el tamany (mitjana o familiar),
// el tipus (prosciutto, quatre formatges o funghi)
// i el seu estat (demanada o servida).
// La classe ha d'emmagatzemar informació sobre el nombre total de pizzes que s'han demanat i s'han servit.
// Sempre que es crea una nova pizza el seu estat serà "demanada".
// (Falta información. Mirar enunciado original)

package pizza;

public class Pizza {
	private Tipus tipus;
	private Tamany tamany;
	private Estat estat;

	private static int totalDemanades = 0;
	private static int totalServides = 0;

	public Pizza(Tipus tipus, Tamany tamany) {
		this.tamany = tamany;
		this.tipus = tipus;
		this.estat = Estat.DEMANADA;

		totalDemanades++;
	}

	public String toString() {
		return "pizza " + this.tipus + " tamany " + this.tamany + ", " + this.estat;
	}

	public void servir() {
		if (this.estat == Estat.DEMANADA) {
			this.estat = Estat.SERVIDA;
			totalServides++;
		} else {
			System.out.println("eixa pizza ja s'ha servit");
		}
	}

	public static int getTotalDemanades() {
		return totalDemanades;
	}

	public static int getTotalServides() {
		return totalServides;
	}
}
