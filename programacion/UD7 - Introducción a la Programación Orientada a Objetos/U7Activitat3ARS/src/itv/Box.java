package itv;

public class Box {
	private Fase[] boxFases;

	public Box() {
		this.boxFases = new Fase[Fase.FASES.length];
		for (int i = 0; i < boxFases.length; i++) {
			this.boxFases[i] = new Fase();
		}
	}

	public Fase[] getBoxFases() {
		return this.boxFases.clone();
	}

	public boolean disponible() {
		return (this.boxFases[0].disponible()) ? true : false;
	}

	public void meterCoche(Vehiculo vehiculo) {
		this.boxFases[0].setFaseVehiculo(vehiculo);
	}

	public boolean boxVacio() {
		boolean boxVacio = true;

		for (int i = 0; i < this.boxFases.length && boxVacio; i++) {
			boxVacio = this.boxFases[i].disponible() ? false : true;
		}

		return boxVacio;
	}

	public Vehiculo moverCochesBox() {
		Vehiculo vehiculo = null;
		
		for (int i = this.boxFases.length - 1; i >= 0; i--) {
			if (this.boxFases[i].len)
		}

		return vehiculo;
	}
}