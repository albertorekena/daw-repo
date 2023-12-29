package itv;

public class Fase {
	private Vehiculo vehiculo;

	public static final String[] FASES= {"Seguridad", "Sistema Eléctrico", "Emisión Humos","Frenos"};

	Fase() {}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}
	
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = new Vehiculo(vehiculo);
	}

	public boolean disponible() {
		return this.vehiculo == null ? true : false;
	}
}