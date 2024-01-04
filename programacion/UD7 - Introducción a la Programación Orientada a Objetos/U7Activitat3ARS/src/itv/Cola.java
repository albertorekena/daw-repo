package itv;

import itv.util.GestorIO;

public class Cola {
	public static final int MAX_LONGITUD_COLA = 50;

	private Vehiculo[] colaVehiculos = new Vehiculo[MAX_LONGITUD_COLA];

	private GestorIO gestorIO = new GestorIO();

	Cola() {}

	public Vehiculo[] getColaVehiculos() {
		return this.colaVehiculos.clone();
	}

	public int vehiculoLlegaACola(Vehiculo vehiculo) {
		boolean vehiculoAdmitido = false;
		int posicionVehiculoEnCola = -1;

		for (int i = 0; i < this.colaVehiculos.length && !vehiculoAdmitido; i++) {
			if (this.colaVehiculos[i] == null) {
				this.colaVehiculos[i] = vehiculo;
				vehiculoAdmitido = true;
				posicionVehiculoEnCola = i;
			}
		}

		return posicionVehiculoEnCola;
	}

	public void mostrarVehiculos() {
		gestorIO.out("\n\nCola de coches ACTUALIZADA:\n");

		for (int i = 0; i < this.colaVehiculos.length && this.colaVehiculos[i] != null; i++) {
			System.out.printf("·Posición vehículo --> %d\n", i);
			this.colaVehiculos[i].mostrarVehiculo();
			System.out.print("\n");
		}
		
		if (this.colaVehiculos[0] == null) {
			gestorIO.out("COLA VACIA\n");
		}
	}

	private void vehiculoDejaCola() {
		for (int i = 0; i < colaVehiculos.length && colaVehiculos[i] != null; i++) {
			if (colaVehiculos[i + 1] != null) {
				colaVehiculos[i] = new Vehiculo(colaVehiculos[i + 1]); 
			} else {
				colaVehiculos[i] = null;
			}
		}
	}

	public Vehiculo vehiculoEntraABox() {
		Vehiculo vehiculo = new Vehiculo(colaVehiculos[0]);
		this.vehiculoDejaCola();
		return vehiculo;
	}
}