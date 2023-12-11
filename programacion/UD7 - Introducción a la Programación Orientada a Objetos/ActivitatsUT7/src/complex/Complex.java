// Construeix una classe Complex amb dos atributs. Real: part real del nombre complex. Imaginària: part imaginària del nombre complex
// A continuació crea els mètodes següents dins de la classe:
// public Complex(): Constructor que inicialitza els atributs a zero.
// public Complex(double real, double imag): Constructor que inicialitza els atributs als valors indicats pels paràmetres.
// public double getReal(): Retorna la part real de l'objecte.
// public double getImaginaria(): Retorna la part imaginària de l'objecte.
// public void setReal(double real): Assigna a la part real de l'objecte el valor indicat al paràmetre real.
// public void setImaginaria(double imaginària): Assigna a la part imaginària de l'objecte el valor indicat en el paràmetre imaginària.
// public String toString(): Converteix a String el nombre complex, mitjançant la concatenació dels seus atributs i torna com a resultat la cadena de text 3 + 4i, si 3 és la part real i 4 la part imaginària.
// public Complex sumar(Complex b): Suma la part real amb la part real del nombre complex b, i la part imaginària amb la part imaginària del nombre complex b.
// public Complex producte(Complex b): Calcula el producte del nombre complex multiplicat per b. Si un nombre té els components x1 i y1, i el segon nombre té els components x2 i y2: La part real del producte = x1 * x2 - y1 * y2 La part imaginària del producte = x1 * y2 + x2 * y1

package complex;

public class Complex {
	private double real;
	private double imaginaria;

	public Complex(double real, double imaginaria) {
		this.real = real;
		this.imaginaria = imaginaria;
	}

	public Complex() {
		this(0, 0);
	}

	public double getReal() {
		return this.real;
	}

	public double getImaginaria() {
		return this.imaginaria;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public void setImaginaria(double imaginaria) {
		this.imaginaria = imaginaria;
	}

	public Complex sumar(Complex sum) {
		return new Complex(this.getReal() + sum.getReal(), this.getImaginaria() + sum.getImaginaria());
	}

	public Complex producte(Complex prod) {
		return new Complex(
			(this.getReal() * prod.getReal()) - (this.getImaginaria() * prod.getImaginaria()),
			(this.getReal() * prod.getImaginaria()) + (this.getImaginaria() * prod.getReal())
		);
	}

	public String toString() {
		return this.real + " " + this.imaginaria + "i";
	}
}