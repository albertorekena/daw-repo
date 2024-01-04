package itv;

public class Box {
	private Fase[] fases;

	public Box() {
		this.fases = new Fase[Fase.FASES.length];
		for (int i = 0; i < fases.length; i++) {
			this.fases[i] = new Fase(i, Fase.FASES[i]);
		}
	}

	public boolean disponible() {
		return this.fases[0].vacio() ? true : false;
	}

	public void meterVehiculo(Vehiculo vehiculo) {
		this.fases[0].setVehiculo(vehiculo);
	}

	public boolean completamenteVacio() {
		boolean boxCompletamenteVacio = true;

		for (int i = 0; i < this.fases.length && boxCompletamenteVacio; i++) {
			boxCompletamenteVacio = this.fases[i].vacio() ? true : false;
		}

		return boxCompletamenteVacio;
	}

	public Vehiculo vehiculoEnUltimaFase() {
		return this.fases[this.fases.length - 1].getVehiculo();
	}
	
	public void moverVehiculosBox() {
		for (int i = this.fases.length - 1; i > 0; i--) {
			if (this.fases[i - 1].getVehiculo() != null) {
				this.fases[i].setVehiculo(this.fases[i - 1].getVehiculo());
			}
		}

		this.fases[0].setVehiculo(null);
	}

	public void mostrarEstadoDentroDelBox() {
		for (int i = 0; i < this.fases.length; i++) {
			this.fases[i].mostrarVehiculo();
		}
	}
}