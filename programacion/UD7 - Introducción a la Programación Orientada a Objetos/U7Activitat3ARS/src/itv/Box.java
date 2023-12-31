package itv;

public class Box {
	private Fase[] fases;

	public Box() {
		this.fases = new Fase[Fase.FASES.length];
		for (int i = 0; i < fases.length; i++) {
			this.fases[i] = new Fase();
		}
	}

	public Fase[] getFases() {
		return this.fases.clone();
	}

	public boolean disponible() {
		return (this.fases[0].disponible()) ? true : false;
	}

	public void meterCoche(Vehiculo vehiculo) {
		this.fases[0].setVehiculo(vehiculo);
	}

	public boolean boxVacio() {
		boolean boxVacio = true;

		for (int i = 0; i < this.fases.length && boxVacio; i++) {
			boxVacio = this.fases[i].disponible() ? false : true;
		}

		return boxVacio;
	}
}