package itv;

import itv.util.GestorIO;
import itv.util.Interval;

class Menu {
	private static final String[] TITOLS = new String[] {
		"\n1. Donar d'alta cotxe i passar a la cua",
		"\n2. Afegir nou vehicle al box",
		"\n3. Passar de fase vehicles en box",
		"\n4. Mostrar box",
		"\n5. Mostrar taller complet",
		"\n6. Eixir"
	};

	private static final Interval OPCIONS = new Interval(1, 6);

	public void mostrar() {
		GestorIO gestorIO = new GestorIO();
		for (String titol : TITOLS) {
			gestorIO.out(titol);
		}
	}

	public int getOpcio() {
		GestorIO gestorIO = new GestorIO();
		int opcio;
		boolean error;
		do {
			gestorIO.out("\nOpció? [1-6]: ");
			opcio = gestorIO.inInt();
			error = !OPCIONS.inclou(opcio);
			if (error) {
				gestorIO.out("Error!!! L'opció ha de ser entre 1 i 6");
			}
		} while (error);
		return opcio;
	}
}