package dau;

public class Dau2 {
	private int valor;

	public Dau2() {
		this.valor = 6;
	}

	public int getValor() {
		return valor;
	}

	public void llansar() {
		this.valor = this.valor < 6 ? ++this.valor : 1;
		System.out.println("S'ha llançat el dau. El seu valor és: " + this.valor);
	}
}