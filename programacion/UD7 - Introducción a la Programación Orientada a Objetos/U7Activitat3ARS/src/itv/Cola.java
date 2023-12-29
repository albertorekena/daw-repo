package itv;

public class Cola {
	public static final int MAX_LONGITUD_COLA = 50;

	private Vehiculo[] vehiculos = new Vehiculo[MAX_LONGITUD_COLA];

	Cola() {}

	public Vehiculo[] getVehiculos() {
		return this.vehiculos;
	}

	public void mostrarVehiculos() {
		System.out.println("Cola de coches ACTUALIZADA:\n");
		for (int i = 0; i < this.vehiculos.length && this.vehiculos[i] != null; i++) {
			System.out.printf("Posición vehículo --> %d\n", i);
			this.vehiculos[i].mostrarVehiculo();
			System.out.print("\n");
		}
	}

	public void vehiculoDejaColaYEntraBox() {
		for (int i = 0; i < vehiculos.length && vehiculos[i] != null; i++) {
			if (vehiculos[i + 1] != null) {
				vehiculos[i] = new Vehiculo(vehiculos[i + 1]); 
			} else {
				vehiculos[i] = null;
			}
		}
	}
}