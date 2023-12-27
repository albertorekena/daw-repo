package itv;

public class Cola {
	public static final int MAX_LONGITUD_COLA = 50;

	private Vehiculo[] cola = new Vehiculo[MAX_LONGITUD_COLA];

	Cola() {}

	public Vehiculo[] getVehiculos() {
		return this.cola;
	}

	public void mostrarVehiculos() {
		System.out.println("Cola de coches para ser atendidos en los diferentes boxes:\n");
		for (int i = 0; i < this.cola.length && this.cola[i] != null; i++) {
			System.out.printf("Posición vehículo --> %d\n", i);
			this.cola[i].mostrarVehiculo();
			System.out.print("\n");
		}
	}
}