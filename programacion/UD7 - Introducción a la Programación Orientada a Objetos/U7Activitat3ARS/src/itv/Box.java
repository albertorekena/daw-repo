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

	public void meterCoche(Vehiculo vehiculo) {
		this.fases[0].setFaseVehiculo(vehiculo);
	}

	public boolean boxVacio() {
		boolean boxVacio = true;

		for (int i = 0; i < this.fases.length && boxVacio; i++) {
			boxVacio = this.fases[i].vacio() ? true : false;
		}

		return boxVacio;
	}

	public Vehiculo vehiculoEnUltimaFase() {
		return this.fases[this.fases.length - 1].getVehiculo();
	}
	
	public void moverCochesBox() {
		for (int i = this.fases.length - 1; i > 0; i--) {
			if (this.fases[i - 1].getVehiculo() != null) {
				this.fases[i].setFaseVehiculo(this.fases[i - 1].getVehiculo());
			}

			this.fases[0].setFaseVehiculo(null);
		}
	}

	public void mostrarEstadoDentroDelBox() {
		for (int i = 0; i < this.fases.length; i++) {
			this.fases[i].mostrarFaseVehiculo();
		}
	}
}