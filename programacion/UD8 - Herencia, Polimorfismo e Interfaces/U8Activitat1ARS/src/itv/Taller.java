package itv;

import itv.util.GestorIO;
import itv.util.Interval;
import java.util.regex.Pattern;

public class Taller {
	private Box[] boxs;
	private CuaInicial cuaInicial;

	private static final int NUM_BOXS = 6;

	public Taller() {
		this.boxs = new Box[Taller.NUM_BOXS];
		for (int i = 0; i < boxs.length; i++) {
			this.boxs[i] = new Box(i + 1);
		}
		this.cuaInicial = new CuaInicial();
	}

	private void iniciar() {
		Menu menu = new Menu();
		GestorIO gestorIO = new GestorIO();
		int opcio;

		do {
			menu.mostrar();
			opcio = menu.getOpcio();
			switch (opcio) {
				case 1:
					Vehicle vehiclePendent = this.recollirNouVehicle();
					if (this.cuaInicial.conteMatricula(vehiclePendent.getMatricula())) {
						gestorIO.out("No es pot afegir el vehicle a la cua. Matrícula ja existent.");
					} else {
						cuaInicial.afegir(vehiclePendent);
						gestorIO.out("Vehicle afegit a la cua");
					}
					break;

				case 2:
					if (!cuaInicial.estaBuida()) {
						Box box = this.getBox();
						if (box.estaLliure()) {
							box.afegir(cuaInicial.traure());
							gestorIO.out("Vehicle afegit al box correctament");
						} else {
							gestorIO.out("Error!! No es pot afegir el vehicle, n'hi ha un en la primera fase del box");
						}
					} else {
						gestorIO.out("Error!!! En la cua no hi ha vehicles");
					}
					break;

				case 3:
					this.getBox().passarVehiclesDeFase();
					gestorIO.out("Vehicles desplaçats correctament");
					break;

				case 4:
					this.getBox().mostrar();
					break;

				case 5:
					this.mostrar();
					break;

				default:
					break;
			}
		} while (opcio != 6);
	}

	private Vehicle recollirNouVehicle() {
		return new Vehicle(getMatricula(), getModel(), getTipusVehicle());
	}

	private String getMatricula() {
		GestorIO gestorIO = new GestorIO();
		String matricula;
		boolean error;
		do {
			gestorIO.out("¿Matrícula? [DDDDLLL]:");
			matricula = gestorIO.inString();
			error = !Pattern.matches(Vehicle.PATRO_MATRICULA, matricula);
			if (error) {
				gestorIO.out("Error!!! Ha de ser una matrícula vàlida");
			}
		} while (error);
		return matricula;
	}

	private String getModel() {
		GestorIO gestorIO = new GestorIO();
		gestorIO.out("¿Model?:");
		return gestorIO.inString();
	}

	private TipusVehicle getTipusVehicle() {
		GestorIO gestorIO = new GestorIO();
		boolean error;
		int opcio;

		do {
			gestorIO.out("¿Tipus de vehícle? [1:Cotxe, 2:Furgoneta, 3: Microbús, 4:Camió]:");
			opcio = gestorIO.inInt();
			error = !new Interval(1, 4).inclou(opcio);
			if (error) {
				gestorIO.out("Error!!! Ha de ser un tipus vàlid");
			}
		} while (error);

		return Vehicle.tipusSegonsIndex(opcio);
	}

	private Box getBox() {
		GestorIO gestorIO = new GestorIO();
		int numBox;
		boolean error;
		do {
			gestorIO.out("¿Número box? [1-" + NUM_BOXS + "]:");
			numBox = gestorIO.inInt();
			error = !new Interval(1, NUM_BOXS).inclou(numBox);
			if (error) {
				gestorIO.out("Error!!! Ha de ser un número de box vàlid");
			}
		} while (error);
		return boxs[numBox - 1];
	}

	private void mostrar() {
		cuaInicial.mostrar();
		mostrarBoxs();
	}

	public void mostrarBoxs() {
		for (Box box : boxs) {
			box.mostrar();
		}
	}

	public static void main(String[] args) {
		new Taller().iniciar();
	}
}