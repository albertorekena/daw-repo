package itv;

public class Fase {
	private Vehiculo vehiculo;

	public static final String[] FASES= {"Seguridad", "Sistema Eléctrico", "Emisión Humos","Frenos"};

	Fase() {}

	public Vehiculo getFaseVehiculo() {
		return this.vehiculo;
	}
	
	public void setFaseVehiculo(Vehiculo vehiculo) {
		this.vehiculo = new Vehiculo(vehiculo);
	}

	public boolean disponible() {
		return this.vehiculo == null ? true : false;
	}
}