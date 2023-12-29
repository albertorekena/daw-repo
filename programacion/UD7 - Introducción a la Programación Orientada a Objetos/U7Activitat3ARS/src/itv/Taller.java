package itv;

import itv.util.*;

public class Taller {
	private Cola cola = null;
	private Box[] boxes;
	public final int NUMERO_BOXES = 6;
	private Vehiculo[] todosLosVehiculos = new Vehiculo[Cola.MAX_LONGITUD_COLA + (this.NUMERO_BOXES * Fase.FASES.length)];
	private GestorIO gestorIO = new GestorIO();

	public static void main(String[] args) {
		Taller taller = new Taller();
		taller.iniciar();
	}

	Taller() {
		this.cola = new Cola();
		this.boxes = new Box[this.NUMERO_BOXES];
		for (int i = 0; i < boxes.length; i++) {
			boxes[i] = new Box();
		}
	}

	public void iniciar() {
		Menu menu = new Menu();
		int opcionElegida;

		do {
			opcionElegida = menu.opcionElegida();

			switch (opcionElegida) {
				case 1:
					boolean vehiculoAdmitido = false;

					gestorIO.out("\n\n-------------------------------------\n");
					gestorIO.out("-------- OPCION 1 SELECCIONADA ------\n");
					gestorIO.out("-------------------------------------\n\n");

					Vehiculo vehiculo = Vehiculo.vehiculoValido(todosLosVehiculos);

					for (int i = 0; i < cola.getVehiculos().length && !vehiculoAdmitido; i++) {
						if (cola.getVehiculos()[i] == null) {
							cola.getVehiculos()[i] = vehiculo;

							for (int j = 0; j < todosLosVehiculos.length && !vehiculoAdmitido; j++) {
								if (todosLosVehiculos[j] == null) {
									todosLosVehiculos[j] = vehiculo;
									vehiculoAdmitido = true;
								}
							}

							gestorIO.out("\n\n-------------------------------------\n\n");
							this.cola.mostrarVehiculos();
							gestorIO.out("-------------------------------------\n");
						}
					}
					break;
					
				case 2:
					gestorIO.out("\n\n-------------------------------------\n");
					gestorIO.out("-------- OPCION 2 SELECCIONADA ------\n");
					gestorIO.out("-------------------------------------\n\n");

					int boxElegido;

					this.impresionNumerosBoxes();
					gestorIO.out("Indica el Box al cual se dirigirá el vehículo: ");
					boxElegido = this.numeroValidoBox();
					this.boxes[boxElegido].getFases()[0].setVehiculo(this.cola.getVehiculos()[0]);
					this.cola.vehiculoDejaColaYEntraBox();

					gestorIO.out("\nEl vehículo correspondiente de la cola ha pasado al box seleccionado.");
					
					gestorIO.out("\n\n-------------------------------------\n\n");
					this.cola.mostrarVehiculos();
					gestorIO.out("-------------------------------------\n");
					break;

				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				default:
					break;
			}
		} while (opcionElegida != 6);
	}

	private void impresionNumerosBoxes() {
		for (int i = 0; i < boxes.length; i++) {
			String impresionNumeroBoxSegunDisponibilidad = boxes[i].disponible() ? String.valueOf(i) : "";
			if (i < boxes.length - 1) {
				System.out.printf("[%s]  ", impresionNumeroBoxSegunDisponibilidad);
			} else {
				System.out.printf("[%s]\n", impresionNumeroBoxSegunDisponibilidad);
			}
		}
	}

	private int numeroValidoBox() {
		int boxElegido = -1;
		boolean numeroBoxElegidoCorrecto = false;
		Interval intervalBoxes = new Interval(this.NUMERO_BOXES - 1);
		boolean numeroBoxElegidoDisponible = false;

		do {
			try {
				boxElegido = Integer.parseInt(gestorIO.inString());
				numeroBoxElegidoCorrecto = intervalBoxes.inclou((double) boxElegido) ? true : false;
			} catch (Exception e) {}

			if (numeroBoxElegidoCorrecto) {
				numeroBoxElegidoDisponible = this.boxes[boxElegido].disponible();
				if (!numeroBoxElegidoDisponible) {
					gestorIO.out("\n");
					this.impresionNumerosBoxes();
					gestorIO.out("El box seleccionado se encuentra ocupado. Por favor, elige uno entre las opciones disponibles: ");
				}
			} else {
				gestorIO.out("\n");
				this.impresionNumerosBoxes();
				gestorIO.out("El número de box indicado es incorrecto. Por favor, vuelve a introducir el dato: ");
			}
		} while (!numeroBoxElegidoCorrecto || !numeroBoxElegidoDisponible);

		return boxElegido;
	}
}