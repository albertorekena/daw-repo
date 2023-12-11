// Escriu un programa que simule un compte bancari.
// Un mètode permet fer un dipòsit al compte. La quantitat s'introdueix com a paràmetre.
// Un segon mètode permet fer una retirada (si l'estat és "DESCOBERT" no es permetrà fer més retirades).
// El DNI del titular, el saldo i l'estat del compte s'han de mostrar per pantalla en invocar al mètode "mostrar": l'estat pot ser OK o DESCOBERT.
// Crea una classe anomenada Compte per a representar comptes bancaris.
// Has de tenir els mètodes dipositar i retirar, getSaldoActual i mostrar.

package compte;

public class Compte {
	private String dni;
	private double saldo;
	private Estat estat;

	public Compte(String dni) {
		this.dni = dni;
		this.saldo = 0.0;
		this.estat = Estat.OK;
	}

	public void dipositar(double quantitat) {
		if (quantitat > 0) {
			this.saldo += quantitat;

			if (this.saldo >= 0 && this.estat == Estat.DESCOBERT) {
				this.estat = Estat.OK;
			}
		}
	}

	public void retirar(double quantitat) {
		if (quantitat > 0 && this.estat == Estat.OK) {
			this.saldo -= quantitat;

			if (this.saldo < 0) {
				this.estat = Estat.DESCOBERT;
			}
		}
	}

	public void mostrar() {
		System.out.println("dni del titular: " + this.dni);
		System.out.println("saldo del compte: " + this.saldo + "€");
		System.out.println("estat del compte: " + this.estat);
		System.out.println("-----------------------------------------\n");
	}

	public double getSaldoActual() {
		return this.saldo;
	}
}