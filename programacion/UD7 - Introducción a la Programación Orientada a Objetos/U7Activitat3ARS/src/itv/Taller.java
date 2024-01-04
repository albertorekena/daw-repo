package itv;

import itv.util.*;

public class Taller {
	private Cola cola = null;
	private Box[] boxes;
	
	public final int NUMERO_BOXES = 6;
	private Vehiculo[] todosLosVehiculosEnGestion = new Vehiculo[Cola.MAX_LONGITUD_COLA + (this.NUMERO_BOXES * Fase.FASES.length)];
	private Vehiculo[] todosLosVehiculosGestionados = new Vehiculo[1000];
	private GestorIO gestorIO = new GestorIO();

	Taller() {
		this.cola = new Cola();
		this.boxes = new Box[this.NUMERO_BOXES];
		for (int i = 0; i < boxes.length; i++) {
			boxes[i] = new Box();
		}
	}

	public static void main(String[] args) {
		Taller taller = new Taller();
		taller.iniciar();
	}

	private void iniciar() {
		Menu menu = new Menu();
		int opcionElegida;

		do {
			opcionElegida = menu.opcionElegida();
			int boxElegido;
			boolean todosLosBoxesVacios;

			switch (opcionElegida) {
				case 1:
					gestorIO.out("\n\n-------------------------------------\n");
					gestorIO.out("-------- OPCION 1 SELECCIONADA ------\n");
					gestorIO.out("-------------------------------------\n\n");

					Vehiculo vehiculo = Vehiculo.vehiculoValido(todosLosVehiculosEnGestion.clone());
					int posicionVehiculoEnCola = this.cola.vehiculoLlegaACola(vehiculo);

					if (posicionVehiculoEnCola != -1) {
						boolean vehiculoAnyadido = false;
						for (int j = 0; j < todosLosVehiculosEnGestion.length && !vehiculoAnyadido; j++) {
							if (todosLosVehiculosEnGestion[j] == null) {
								todosLosVehiculosEnGestion[j] = vehiculo;
								vehiculoAnyadido = true;
								gestorIO.out("\n\n-------------------------------------");
								gestorIO.out("\n\nEL VEHICULO HA SIDO INTRODUCIDO CORRECTAMENTE EN EL SISTEMA.");
								gestorIO.out("\nPosición del vehículo en la cola --> " + posicionVehiculoEnCola + "\n");
							}
						}
					} else {
						gestorIO.out("\n\n-------------------------------------");
						gestorIO.out("\n\n El vehículo No ha sido introducido en el sistema. NO caben más vehículos en la cola.\n");
					}

					this.cola.mostrarVehiculos();
					break;

				case 2:
					gestorIO.out("\n\n-------------------------------------\n");
					gestorIO.out("-------- OPCION 2 SELECCIONADA ------\n");
					gestorIO.out("-------------------------------------\n\n");

					this.impresionNumerosBoxesSegunOcupadoParaEntrar();
					gestorIO.out("Indica el Box al cual se dirigirá el vehículo: ");
					boxElegido = this.numeroValidoMeterCocheBox();
					this.boxes[boxElegido].meterCoche(this.cola.vehiculoEntraABox());

					gestorIO.out("\n\n-------------------------------------");
					gestorIO.out("\n\nEL VEHICULO CORRESPONDIENTE DE LA COLA HA PASADO AL BOX SELECCIONADO.");
					
					this.cola.mostrarVehiculos();
					break;

				case 3:
					gestorIO.out("\n\n-------------------------------------\n");
					gestorIO.out("-------- OPCION 3 SELECCIONADA ------\n");
					gestorIO.out("-------------------------------------\n\n");

					gestorIO.out("\n");
					todosLosBoxesVacios = this.impresionNumerosBoxesSegunVacio();
					if (!todosLosBoxesVacios) {
						gestorIO.out("Indica el número de Box en el que quieres que avancen los vehículos: ");
						this.moverCochesDentroBox();
					} else {
						gestorIO.out("-------------------------------------\n");
						gestorIO.out("TODOS LOS BOXES ESTAN VACIOS. NO PUEDES MOVER VEHICULOS");
						gestorIO.out("\n-------------------------------------\n");
					}
					break;

				case 4:
					gestorIO.out("\n\n-------------------------------------\n");
					gestorIO.out("-------- OPCION 4 SELECCIONADA ------\n");
					gestorIO.out("-------------------------------------\n\n");

					gestorIO.out("Indica el número de Box del que quieres mostrar la informacion: ");
					boxElegido = this.elegirNumeroBox();
					this.boxes[boxElegido].mostrarEstadoDentroDelBox();
					break;

				case 5:
					gestorIO.out("\n\n-------------------------------------\n");
					gestorIO.out("-------- OPCION 5 SELECCIONADA ------\n");
					gestorIO.out("-------------------------------------\n\n");

					for (int i = 0; i < this.boxes.length; i++) {
						gestorIO.out("---- BOX " + i + " ----");
						this.boxes[i].mostrarEstadoDentroDelBox();
						gestorIO.out("\n\n");
					}
					break;

				default:
					gestorIO.out("\n\n---- PROGRAMA TERMINADO ----\n\n");
					break;
			}
		} while (opcionElegida != 6);
	}

	private void impresionNumerosBoxesSegunOcupadoParaEntrar() {
		for (int i = 0; i < boxes.length; i++) {
			String impresionNumerosBoxesSegunOcupadoParaEntrar = boxes[i].disponible() ? String.valueOf(i) : "OCUPADO";
			if (i < boxes.length - 1) {
				System.out.printf("[%s]   ", impresionNumerosBoxesSegunOcupadoParaEntrar);
			} else {
				System.out.printf("[%s]\n", impresionNumerosBoxesSegunOcupadoParaEntrar);
			}
		}
	}

	private int elegirNumeroBox() {
		int numeroBoxElegido = -1;
		boolean numeroBoxElegidoCorrecto = false;
		Interval intervalBoxes = new Interval(this.NUMERO_BOXES - 1);

		do {
			try {
				numeroBoxElegido = Integer.parseInt(gestorIO.inString());
				numeroBoxElegidoCorrecto = intervalBoxes.inclou((double) numeroBoxElegido) ? true : false;
			} catch (Exception e) {}

			if (!numeroBoxElegidoCorrecto) {
				gestorIO.out("\n");
				this.impresionNumerosBoxesSegunOcupadoParaEntrar();
				gestorIO.out("El número de box indicado es incorrecto. Por favor, vuelve a introducir el dato: ");
			}
		} while (!numeroBoxElegidoCorrecto);

		return numeroBoxElegido;
	}
	
	private int numeroValidoMeterCocheBox() {
		int boxElegido = -1;
		boolean boxElegidoDisponible = false;

		do {
			boxElegido = this.elegirNumeroBox();
			boxElegidoDisponible = this.boxes[boxElegido].disponible();
			if (!boxElegidoDisponible) {
				gestorIO.out("\n");
				this.impresionNumerosBoxesSegunOcupadoParaEntrar();
				gestorIO.out("El box seleccionado se encuentra ocupado. Por favor, elige uno entre las opciones disponibles: ");
			}
		} while (!boxElegidoDisponible);

		return boxElegido;
	}

	private boolean impresionNumerosBoxesSegunVacio() {
		boolean todosLosBoxesVacios = true;
		
		for (int i = 0; i < this.boxes.length; i++) {
			boolean boxVacio = false;
			boxVacio = this.boxes[i].boxVacio();

			if (!boxVacio) {
				System.out.printf("[%s]", i);
				todosLosBoxesVacios = false;
			} else {
				gestorIO.out("[VACIO]");
			}

			if (i < this.boxes.length - 1) {
				gestorIO.out("   ");
			} else {
				gestorIO.out("\n");
			}
		}

		return todosLosBoxesVacios;
	}

	private void moverCochesDentroBox() {
		int boxElegido = this.elegirNumeroBox();

		if (!this.boxes[boxElegido].boxVacio()) {
			if (this.boxes[boxElegido].vehiculoEnUltimaFase() != null) {
				for (int i = todosLosVehiculosGestionados.length - 1; i > 0; i--) {
					if (todosLosVehiculosGestionados[i] != null) {
						todosLosVehiculosGestionados[i + 1] = todosLosVehiculosGestionados[i]; 
					}
				}

				todosLosVehiculosGestionados[0] = new Vehiculo(this.boxes[boxElegido].vehiculoEnUltimaFase());
			}

			this.boxes[boxElegido].moverCochesBox();
			gestorIO.out("Los vehículos han cambiado de fase correctamente dentro del box.");
		} else {
			gestorIO.out("\nEl box que has seleccionado se encuentra VACIO. NO hay coches que mover.");
		}
	}
}