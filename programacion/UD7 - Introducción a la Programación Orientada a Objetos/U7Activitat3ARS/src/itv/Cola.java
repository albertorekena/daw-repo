package itv;

public class Cola {
	public static final int MAX_LONGITUD_COLA = 50;

	private Vehiculo[] vehiculos = new Vehiculo[MAX_LONGITUD_COLA];

	Cola() {}

	public Vehiculo[] getVehiculos() {
		return this.vehiculos.clone();
	}

	public boolean vehiculoLlegaACola(Vehiculo vehiculo) {
		boolean vehiculoAdmitido = false;

		for (int i = 0; i < this.vehiculos.length && !vehiculoAdmitido; i++) {
			if (this.vehiculos[i] == null) {
				this.vehiculos[i] = vehiculo;
				vehiculoAdmitido = true;
			}
		}

		return vehiculoAdmitido;
	}

	public void mostrarVehiculos() {
		System.out.println("Cola de coches ACTUALIZADA:\n");
		for (int i = 0; i < this.vehiculos.length && this.vehiculos[i] != null; i++) {
			System.out.printf("Posición vehículo --> %d\n", i);
			this.vehiculos[i].mostrarVehiculo();
			System.out.print("\n");
		}
	}

	private void vehiculoDejaColaYEntraBox() {
		for (int i = 0; i < vehiculos.length && vehiculos[i] != null; i++) {
			if (vehiculos[i + 1] != null) {
				vehiculos[i] = new Vehiculo(vehiculos[i + 1]); 
			} else {
				vehiculos[i] = null;
			}
		}
	}

	public Vehiculo vehiculoEntraABox() {
		Vehiculo vehiculo = new Vehiculo(vehiculos[0]);
		this.vehiculoDejaColaYEntraBox();
		return vehiculo;
	}
}