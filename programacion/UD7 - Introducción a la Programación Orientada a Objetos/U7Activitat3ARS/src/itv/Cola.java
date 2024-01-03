package itv;

public class Cola {
	public static final int MAX_LONGITUD_COLA = 50;

	private Vehiculo[] colaVehiculos = new Vehiculo[MAX_LONGITUD_COLA];

	Cola() {}

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
		System.out.println("Cola de coches ACTUALIZADA:\n");
		for (int i = 0; i < this.colaVehiculos.length && this.colaVehiculos[i] != null; i++) {
			System.out.printf("Posición vehículo --> %d\n", i);
			this.colaVehiculos[i].mostrarVehiculo();
			System.out.print("\n");
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