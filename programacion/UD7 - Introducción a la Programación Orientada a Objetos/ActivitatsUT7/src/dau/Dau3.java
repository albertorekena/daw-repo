package dau;

import java.util.Random;

public class Dau3 {
	private int valor;

	public int getValor() {
		return valor;
	}
	
	public void llansar() {
		this.valor = new Random().nextInt(6) + 1;
		System.out.println("S'ha llançat el dau. El seu valor és: " + this.valor);
	}
}