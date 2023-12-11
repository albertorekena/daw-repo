package puntpla;

public class TestPuntPla {
	public static void main(String[] args) {
		PuntPla p1 = new PuntPla();
		PuntPla p2 = new PuntPla(0, -40);

		p1.mostrarQuadrant();
		p2.mostrarQuadrant();
	}
}