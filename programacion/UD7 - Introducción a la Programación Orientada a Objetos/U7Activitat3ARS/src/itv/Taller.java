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

	private void iniciar() {
		Menu menu = new Menu();
		int opcionElegida;

		do {
			opcionElegida = menu.opcionElegida();

			switch (opcionElegida) {
				case 1:
					gestorIO.out("\n\n-------------------------------------\n");
					gestorIO.out("-------- OPCION 1 SELECCIONADA ------\n");
					gestorIO.out("-------------------------------------\n\n");
				
					Vehiculo vehiculo = Vehiculo.vehiculoValido(todosLosVehiculos);
					boolean vehiculoAdmitido = this.cola.vehiculoLlegaACola(vehiculo);

					if (vehiculoAdmitido) {
						boolean vehiculoAnyadido = false;
						for (int j = 0; j < todosLosVehiculos.length && !vehiculoAnyadido; j++) {
							if (todosLosVehiculos[j] == null) {
								todosLosVehiculos[j] = vehiculo;
								vehiculoAnyadido = true;
								gestorIO.out("\n El vehículo ha sido introducido correctamente en el sistema.");
							}
						}
					} else {
						gestorIO.out("\n El vehículo No ha sido introducido en el sistema. NO caben más vehículos en la cola.");
					}

					gestorIO.out("\n\n-------------------------------------\n\n");
					this.cola.mostrarVehiculos();
					gestorIO.out("-------------------------------------\n");
					break;

				case 2:
					gestorIO.out("\n\n-------------------------------------\n");
					gestorIO.out("-------- OPCION 2 SELECCIONADA ------\n");
					gestorIO.out("-------------------------------------\n\n");

					int boxElegido;

					this.impresionNumerosBoxesSegunOcupadoParaEntrar();
					gestorIO.out("Indica el Box al cual se dirigirá el vehículo: ");
					boxElegido = this.numeroValidoMeterCocheBox();
					this.boxes[boxElegido].meterCoche(this.cola.vehiculoEntraABox());

					gestorIO.out("\nEl vehículo correspondiente de la cola ha pasado al box seleccionado.");
					
					gestorIO.out("\n\n-------------------------------------\n\n");
					this.cola.mostrarVehiculos();
					gestorIO.out("-------------------------------------\n");
					break;

				case 3:
					gestorIO.out("\n\n-------------------------------------\n");
					gestorIO.out("-------- OPCION 3 SELECCIONADA ------\n");
					gestorIO.out("-------------------------------------\n\n");

					this.impresionNumerosBoxesSegunVacio();
					gestorIO.out("Indica el número de Box en el que quieres que avancen los vehículos: ");
					
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

	private void impresionNumerosBoxesSegunOcupadoParaEntrar() {
		for (int i = 0; i < boxes.length; i++) {
			String impresionNumeroBoxSegunDisponibilidad = boxes[i].disponible() ? String.valueOf(i) : "OCUPADO";
			if (i < boxes.length - 1) {
				System.out.printf("[%s]  ", impresionNumeroBoxSegunDisponibilidad);
			} else {
				System.out.printf("[%s]\n", impresionNumeroBoxSegunDisponibilidad);
			}
		}
	}

	private int numeroValidoMeterCocheBox() {
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
					this.impresionNumerosBoxesSegunOcupadoParaEntrar();
					gestorIO.out("El box seleccionado se encuentra ocupado. Por favor, elige uno entre las opciones disponibles: ");
				}
			} else {
				gestorIO.out("\n");
				this.impresionNumerosBoxesSegunOcupadoParaEntrar();
				gestorIO.out("El número de box indicado es incorrecto. Por favor, vuelve a introducir el dato: ");
			}
		} while (!numeroBoxElegidoCorrecto || !numeroBoxElegidoDisponible);

		return boxElegido;
	}

	private void impresionNumerosBoxesSegunVacio() {
		for (int i = 0; i < this.boxes.length; i++) {
			boolean boxVacio = false;
			boxVacio = this.boxes[i].boxVacio();

			if (!boxVacio) {
				System.out.printf("[%s] ", i);
			} else {
				gestorIO.out("[VACIO] ");
			}

			if (i == this.boxes.length - 1) {
				gestorIO.out("\n");
			}
		}
	}

	
}