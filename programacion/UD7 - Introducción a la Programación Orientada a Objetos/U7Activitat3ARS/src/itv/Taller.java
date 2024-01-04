package itv;

import itv.util.*;

public class Taller {
	private Cola cola = null;
	private Box[] boxes;
	public final int NUMERO_BOXES = 6;
	private Vehiculo[] todosLosVehiculosEnGestion = new Vehiculo[Cola.MAX_LONGITUD_COLA + (this.NUMERO_BOXES * Fase.FASES.length)];
	private Vehiculo[] todosLosVehiculosGestionados = new Vehiculo[4];
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
			boolean todosLosBoxesOcupadosParaEntrar;
			int boxElegido;
			Vehiculo vehiculo;
			boolean todosLosBoxesCompletamenteVacios;

			switch (opcionElegida) {
				case 1:
					gestorIO.out("\n\n-------------------------------------\n");
					gestorIO.out("-------- OPCION 1 SELECCIONADA ------\n");
					gestorIO.out("-------------------------------------\n\n");

					vehiculo = Vehiculo.vehiculoValido(todosLosVehiculosEnGestion.clone());
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
						gestorIO.out("\n\n El VEHICULO NO HA SIDO INTRODUCIDO EN EL SISTEMA. NO caben más vehículos en la cola.\n");
					}
					
					this.cola.mostrarVehiculos();
					gestorIO.out("\n-------------------------------------\n\n");
					break;

				case 2:
					gestorIO.out("\n\n-------------------------------------\n");
					gestorIO.out("-------- OPCION 2 SELECCIONADA ------\n");
					gestorIO.out("-------------------------------------\n\n");

					if (this.cola.getColaVehiculos()[0] != null) {
						todosLosBoxesOcupadosParaEntrar = this.impresionNumerosBoxesSegunOcupadoParaEntrar();

						if (!todosLosBoxesOcupadosParaEntrar) {
							gestorIO.out("Indica el Box al cual se dirigira el vehículo: ");
							boxElegido = this.numeroValidoMeterCocheBox();
							vehiculo = this.cola.vehiculoEntraABox();
							this.boxes[boxElegido].meterVehiculo(vehiculo);

							gestorIO.out("\n\n-------------------------------------");
							gestorIO.out("\n\nEL VEHICULO CORRESPONDIENTE DE LA COLA HA PASADO AL BOX SELECCIONADO.");

							this.cola.mostrarVehiculos();
							gestorIO.out("\nEstado del Box " + boxElegido + " ACTUALIZADO:");
							this.boxes[boxElegido].mostrarEstadoDentroDelBox();
							gestorIO.out("\n\n-------------------------------------\n\n");
						} else {
							gestorIO.out("TODOS LOS BOXES TIENEN SU 1era FASE OCUPADA. AHORA NO PUEDE ACCEDER NINGUN VEHICULO A NINGUNO DE ELLOS.");
						}
					} else {
						gestorIO.out("\n-------------------------------------\n");
						gestorIO.out("NO HAY VEHICULOS EN LA COLA. NO SE PUEDE METER NINGUN VEHICULO EN NINGUN BOX.");
						gestorIO.out("\n-------------------------------------\n");
					}

					break;

				case 3:
					gestorIO.out("\n\n-------------------------------------\n");
					gestorIO.out("-------- OPCION 3 SELECCIONADA ------\n");
					gestorIO.out("-------------------------------------\n\n");

					gestorIO.out("\n");
					todosLosBoxesCompletamenteVacios = this.impresionNumerosBoxesSegunVacio();
					if (!todosLosBoxesCompletamenteVacios) {
						gestorIO.out("Indica el número de Box en el que quieres que avancen los vehículos: ");
						boxElegido = this.elegirNumeroBox();
						this.moverCochesDentroBox(boxElegido);

						gestorIO.out("\n\nEstado del Box " + boxElegido + " ACTUALIZADO:");
						this.boxes[boxElegido].mostrarEstadoDentroDelBox();
						gestorIO.out("\n\n-------------------------------------\n\n");
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
					
					gestorIO.out("\n[0]   [1]   [3]   [4]   [5]   [6]\n");
					gestorIO.out("Indica el número de Box del que quieres mostrar la informacion: ");
					boxElegido = this.elegirNumeroBox();

					gestorIO.out("\n-------------------------------------\n");
					gestorIO.out("\nESTADO DEL BOX " + boxElegido + "\n");
					this.boxes[boxElegido].mostrarEstadoDentroDelBox();
					gestorIO.out("\n\n-------------------------------------\n\n");
					break;

				case 5:
					gestorIO.out("\n\n-------------------------------------\n");
					gestorIO.out("-------- OPCION 5 SELECCIONADA ------\n");
					gestorIO.out("-------------------------------------\n\n");

					for (int i = 0; i < this.boxes.length; i++) {
						gestorIO.out("---- BOX " + i + " ----");
						this.boxes[i].mostrarEstadoDentroDelBox();
						gestorIO.out("\n\n-------------------------------------\n\n");
					}
					break;

				default:
					break;
			}
		} while (opcionElegida != 6);

		gestorIO.out("\n\n-------------------------------------\n");
		gestorIO.out("-------- OPCION 6 SELECCIONADA ------\n");
		gestorIO.out("-------------------------------------\n\n");
		gestorIO.out("\n---- PROGRAMA TERMINADO ----\n\n\n");
	}

	private boolean impresionNumerosBoxesSegunOcupadoParaEntrar() {
		boolean boxDisponible;
		boolean todosLosBoxesOcupados = true;

		for (int i = 0; i < boxes.length; i++) {
			boxDisponible = boxes[i].disponible();

			if (todosLosBoxesOcupados) {
				todosLosBoxesOcupados = !boxDisponible;
			}

			String impresionNumerosBoxesSegunOcupadoParaEntrar = boxDisponible ? String.valueOf(i) : "OCUPADO";
			if (i < boxes.length - 1) {
				System.out.printf("[%s]   ", impresionNumerosBoxesSegunOcupadoParaEntrar);
			} else {
				System.out.printf("[%s]\n", impresionNumerosBoxesSegunOcupadoParaEntrar);
			}
		}

		return todosLosBoxesOcupados;
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
				gestorIO.out("El box seleccionado se encuentra OCUPADO. Por favor, elige uno entre las opciones disponibles: ");
			}
		} while (!boxElegidoDisponible);

		return boxElegido;
	}

	private boolean impresionNumerosBoxesSegunVacio() {
		boolean todosLosBoxesVacios = true;
		
		for (int i = 0; i < this.boxes.length; i++) {
			boolean boxCompletamenteVacio = false;
			boxCompletamenteVacio = this.boxes[i].completamenteVacio();

			if (!boxCompletamenteVacio) {
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

	private void moverCochesDentroBox(int boxElegido) {
		if (!this.boxes[boxElegido].completamenteVacio()) {
			if (this.boxes[boxElegido].vehiculoEnUltimaFase() != null) {
				for (int i = 0; i < this.todosLosVehiculosGestionados.length; i++) {
					if (this.todosLosVehiculosGestionados == null) {
						this.todosLosVehiculosGestionados[i] = new Vehiculo(this.boxes[boxElegido].vehiculoEnUltimaFase()); 
					}
				}
			}

			this.boxes[boxElegido].moverVehiculosBox();
			gestorIO.out("\n\n-------------------------------------\n");
			gestorIO.out("\nLos vehículos han cambiado de fase correctamente dentro del box.");
		} else {
			gestorIO.out("\nEl box que has seleccionado se encuentra VACIO. NO hay coches que mover.");
		}
	}
}