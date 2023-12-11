// Desenvolupar un programa que carregue els costats d'un triangle i implemente els mètodes següents:
// Constructor que inicialitze tots els atributs.
// mètode que torna el valor del costat major
// mètode que torna l'àrea del triangle
// mètode que mostre quin tipus de triangle és (equilàter, isòsceles, escalè).

package triangle;

public class Triangle {
	private double a;
	private double b;
	private double c;

	public static Triangle fabricarTriangle(double a, double b, double c) {
		if ((a + b > c) && (a + c > b) && (b + c > a)) {
			return new Triangle(a, b, c);
		} else {
			return null;
		}
	}

	private Triangle(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double getMajor() {
		return Math.max(this.a, Math.max(this.b, this.c));
	}

	public double getArea() {
		double semiperimetre = (a + b + c) / 2;
		return Math.sqrt(a * (semiperimetre - a) * (semiperimetre - b) * (semiperimetre - c));
	}

	public void mostrarTipus() {
		String resposta = "Tipus: ";

		if (a == b && b == c) {
			resposta += "equilàter";
		} else if (a == b || a == c || b == c) {
			resposta += "isòsceles";
		} else {
			resposta += "escalé";
		}

		System.out.println(resposta);
	}
}