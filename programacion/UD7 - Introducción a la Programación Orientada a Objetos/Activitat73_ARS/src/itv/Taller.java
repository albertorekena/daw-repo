package itv;

import itv.util.GestorIO;

public class Taller {
	private ColaInicial colaInicial;
	private Box[] boxes;

	private static final int NUM_BOXES = 6;
	private static final GestorIO gestorIO = new GestorIO();

	public static void main(String[] args) {
		Taller taller = new Taller();
		taller.iniciar();
	}

	Taller() {
		boxes = new Box[NUM_BOXES];
		for (int i = 0; i < NUM_BOXES; i++) {
			boxes[i] = new Box(i);
		}
	}

	public void iniciar() {
		Menu menu = new Menu();
		int opcionElegida;
		String matricula;
		String modelo;
		boolean salirMenu = false;

		do {
			menu.mostrar();
			opcionElegida = menu.leerOpcion();

			switch (opcionElegida) {
				case 1:
					matricula = gestorIO.inString();
					modelo = gestorIO.inString();
					break;
				default:
					break;
			}
		} while (!salirMenu);
	}

	public String leerMatricula() {
		String matricula;
		matricula = gestorIO.inString();
		return matricula;
	}

	public String modelo() {
		String modelo;
		modelo = gestorIO.inString();
		return modelo;
	}
}