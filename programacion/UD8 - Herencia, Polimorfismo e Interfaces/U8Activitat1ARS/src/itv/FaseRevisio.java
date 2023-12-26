package itv;

import itv.util.GestorIO;

class FaseRevisio {
	private String nom;
	private Vehicle vehicle;

	public FaseRevisio(String nom) {
		this.nom = nom;
		this.vehicle = null;
	}

	public boolean teVehicle() {
		return vehicle != null;
	}

	public void assignar(Vehicle vehicle) {
		if (vehicle != null)
			this.vehicle = vehicle;
		else
			throw new RuntimeException("ERROR. Vehicle es null");
	}

	public void desassignarVehicle() {
		this.vehicle = null;
	}

	public void mostrar() {
		GestorIO gestorIO = new GestorIO();
		gestorIO.out("\nFase " + nom + ": ");

		if (vehicle != null)
			gestorIO.out(vehicle);
		else
			gestorIO.out("Buit");
	}

	public void assignarVehicleA(FaseRevisio faseRevisio) {
		faseRevisio.vehicle = this.vehicle;
		this.desassignarVehicle();
	}
}