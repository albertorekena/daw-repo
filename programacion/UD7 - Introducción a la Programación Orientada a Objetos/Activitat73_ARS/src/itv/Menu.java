package itv;

import itv.util.*;

public class Menu {
	int opcionElegida;

	private static final String[] OPCIONES = {
		"1. Alta y recepción de vehículos",
		"2. Reclamar vehículo para entrar al box",
		"3. Mover todos los vehiculos de fase dentro de un box",
		"4. Información del estado de un box concreto",
		"5. Información general de todos los boxes",
		"6. Salir del programa"
	};

	private static final GestorIO gestorIO = new GestorIO();
	private static final Interval interval = new Interval(1, OPCIONES.length);

	public void mostrar() {
		for (int i = 0; i < OPCIONES.length; i++) {
			gestorIO.out(OPCIONES[i]);
		}
		gestorIO.out("Selecciona una opción: ");
	}
	
	public int leerOpcion() {
		boolean opcionValida = false;
		
		do {
			this.opcionElegida = gestorIO.inInt();
			opcionValida = interval.inclou((double) this.opcionElegida) ? true : false;
			
			if (!opcionValida) {
				gestorIO.out("Opción seleccionada incorrecta. Por favor, vuelve a introducir una opción: ");
			}
		} while (!opcionValida);

		return this.opcionElegida;
	}
}