package itv;

import java.util.Arrays;
import itv.util.GestorIO;

class CuaInicial {
	private Vehicle[] vehicles;

	public CuaInicial() {
		vehicles = new Vehicle[0];
	}

	public void afegir(Vehicle vehicle) {
		vehicles = Arrays.copyOf(vehicles, vehicles.length + 1);
		vehicles[vehicles.length - 1] = vehicle;
	}

	public Vehicle traure() {
		if (!estaBuida()) {
			Vehicle vehicle = vehicles[0];

			for (int i = 1; i < vehicles.length; i++) {
				this.vehicles[i - 1] = this.vehicles[i];
			}

			vehicles = Arrays.copyOf(vehicles, vehicles.length - 1);
			return vehicle;
		} else
			throw new RuntimeException("ERROR. Cua buida");
	}

	public boolean estaBuida() {
		return this.vehicles.length == 0;
	}

	public void mostrar() {
		GestorIO gestorIO = new GestorIO();
		if (!this.estaBuida()) {
			gestorIO.out("\nCua Inicial:");
			for (Vehicle vehicle : vehicles) {
				gestorIO.out("\n" + vehicle);
			}
		}
	}

	public boolean conteMatricula(String matricula) {
		for (Vehicle v : vehicles) {
			if (v.teEsta(matricula)) {
				return true;
			}
		}
		return false;
	}
}