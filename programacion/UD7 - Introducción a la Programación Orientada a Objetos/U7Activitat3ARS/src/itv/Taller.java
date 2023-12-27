package itv;

import itv.util.GestorIO;

public class Taller {
	private Cola cola = null;
	private Box[] boxes;
	private GestorIO gestorIO = new GestorIO();

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
					boolean matriculaYaEnTaller = false;
					boolean vehiculoAdmitido = false;

					System.out.println("\n\n---- OPCION 1 SELECCIONADA ----");
					Vehiculo vehiculo = Vehiculo.vehiculoValido();
					String matriculaVehiculo = vehiculo.getMatricula();

					for (int i = 0; i < this.cola.getVehiculos().length && this.cola.getVehiculos()[i] != null; i++) {
						if (matriculaVehiculo.equals(this.cola.getVehiculos()[i].getMatricula())) {
							matriculaYaEnTaller = true;
						}
					}

					if (!matriculaYaEnTaller) {
						for (int i = 0; i < this.boxes.length && this.boxes[i] != null; i++) {
							for (int j = 0; j < this.boxes[i].getFases().length && this.boxes[i].getFases()[j] != null; j++) {
								if (matriculaVehiculo.equals(this.boxes[i].getFases()[j].getVehiculo().getMatricula())) {
									matriculaYaEnTaller = true;
								}
							}
						}
					}

					if (!matriculaYaEnTaller) {
						for (int i = 0; i < cola.getVehiculos().length && !vehiculoAdmitido; i++) {
							if (cola.getVehiculos()[i] == null) {
								cola.getVehiculos()[i] = vehiculo;
								vehiculoAdmitido = true;

								System.out.println("\n\n-------------------------------------\n");
								this.cola.mostrarVehiculos();
								System.out.println("-------------------------------------");
							}
						}
					}

					if (matriculaYaEnTaller) {
						System.out.println("\nESTA OPERACIÓN NO PUEDE SER PROCESADA. Ya hay un vehículo en el taller con la misma matrícula.");
						System.out.println("Pulsa la tecla enter para continuar");
						gestorIO.inString();
						System.out.println("\n-------------------------------------");
					}
					break;

				case 2:
					System.out.println("\n\n---- OPCION 2 SELECCIONADA ----");

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