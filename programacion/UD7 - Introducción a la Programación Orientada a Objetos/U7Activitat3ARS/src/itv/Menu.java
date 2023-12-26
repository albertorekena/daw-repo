package itv;

import itv.util.*;

public class Menu {
	private GestorIO gestorIO = new GestorIO();
	private Interval interval = new Interval(1, OPCIONES.length);

	private static final String[] OPCIONES = {
		"1. Alta y recepción de vehículos",
		"2. Reclamar vehículo para entrar al box",
		"3. Mover todos los vehiculos de fase dentro de un box",
		"4. Información del estado de un box concreto",
		"5. Información general de todos los boxes",
		"6. Salir del programa"
	};

	Menu() {}

	private void mostrar() {
		System.out.println();
		System.out.println();
		for (int i = 0; i < OPCIONES.length; i++) {
			gestorIO.out(OPCIONES[i]);
			System.out.println();
		}
		gestorIO.out("Selecciona una opción: ");
	}
	
	public int opcionElegida() {
		this.mostrar();
		int opcionElegida;
		boolean opcionValida = false;
		boolean primerIntento = true;

		do {
			opcionElegida = gestorIO.inInt();
			opcionValida = interval.inclou((double) opcionElegida) ? true : false;

			if (!primerIntento) {
				System.out.println();
			}

			if (!opcionValida) {
				gestorIO.out("Opción seleccionada incorrecta. Por favor, vuelve a introducir una opción: ");
				primerIntento = false;
			}
		} while (!opcionValida);

		return opcionElegida;
	}
}