package itv;

import itv.util.GestorIO;

class Box {
	private int id;
	private FaseRevisio[] fasesRevisio;

	private static final String[] TITOLS_FASES = new String[] {"1(Seguretat)", "2(Sistema elèctric)", "3(Fums)", "4(Frens y direcció)"};
	private static final int NUM_FASES = 4;

	public Box(int id) {
		this.id = id;
		this.fasesRevisio = new FaseRevisio[NUM_FASES];
		for (int i = 0; i < this.fasesRevisio.length; i++) {
			this.fasesRevisio[i] = new FaseRevisio(TITOLS_FASES[i]);
		}
	}

	public boolean estaLliure() {
		return !this.fasesRevisio[0].teVehicle();
	}

	private boolean esPrimeraFase(int indexFase) {
		return indexFase == 0;
	}

	public void afegir(Vehicle vehicle) {
		fasesRevisio[0].assignar(vehicle);
	}

	public void passarVehiclesDeFase() {
		for (int i = fasesRevisio.length - 1; i > 0; i--) {
			if (!esPrimeraFase(i)) {
				this.fasesRevisio[i - 1].assignarVehicleA(this.fasesRevisio[i]);
			}
		}
		this.fasesRevisio[0].desassignarVehicle();
	}

	public void mostrar() {
		GestorIO gestorIO = new GestorIO();
		gestorIO.out("\nBox:" + id + "\n----");
		for (FaseRevisio faseRevisio : fasesRevisio) {
			faseRevisio.mostrar();
		}
	}
}