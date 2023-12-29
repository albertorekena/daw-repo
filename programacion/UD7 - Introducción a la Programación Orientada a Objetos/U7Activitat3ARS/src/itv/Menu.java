package itv;

import itv.util.*;

public class Menu {
	private Interval interval = new Interval(1, OPCIONES.length);

	private static GestorIO gestorIO = new GestorIO();

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
		System.out.print("\n\n");
		for (int i = 0; i < OPCIONES.length; i++) {
			gestorIO.out(OPCIONES[i]);
			System.out.print("\n");
		}
		System.out.print("\n");
		gestorIO.out("Selecciona una opción: ");
	}
	
	public int opcionElegida() {
		this.mostrar();

		int opcionElegida = 0;
		boolean opcionValida = false;

		do {
			try {
				opcionElegida = Integer.parseInt(gestorIO.inString());
				opcionValida = interval.inclou((double) opcionElegida) ? true : false;
			} catch (Exception e) {}

			if (!opcionValida) {
				gestorIO.out("\nOpción seleccionada incorrecta. Por favor, vuelve a indicar una opción: ");
			}
		} while (!opcionValida);
		return opcionElegida;
	}
}