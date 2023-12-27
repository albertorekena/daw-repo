package itv;

// import itv.util.GestorIO;

public class Taller {
	private Cola cola = null;
	private Box[] boxes;
	private Vehiculo[] todosLosVehiculos = new Vehiculo[Cola.MAX_LONGITUD_COLA + (Box.NUMERO_BOXES * Fase.FASES.length)];
	// private GestorIO gestorIO = new GestorIO();

	Taller() {
		this.cola = new Cola();
		this.boxes = new Box[Box.NUMERO_BOXES];
		for (int i = 0; i < boxes.length; i++) {
			boxes[i] = new Box();
		}
	}

	public static void main(String[] args) {
		Taller taller = new Taller();
		taller.iniciar();
	}

	public void iniciar() {
		Menu menu = new Menu();
		int opcionElegida;

		do {
			opcionElegida = menu.opcionElegida();

			switch (opcionElegida) {
				case 1:
					boolean vehiculoAdmitido = false;

					System.out.println("\n\n---- OPCION 1 SELECCIONADA ----");

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

							System.out.println("\n\n-------------------------------------\n");
							this.cola.mostrarVehiculos();
							System.out.println("-------------------------------------");
						}
					}
					break;

				case 2:
					System.out.println("\n\n---- OPCION 2 SELECCIONADA ----");

					int boxElegido;

					System.out.println("\n[1]  [2]  [3]  [4]  [5]  [6]");
					System.out.println("Indica el Box al cual se dirigirá el vehículo: ");

					do {
						
					} while ();
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
}