package itv;

import itv.util.GestorIO;

public class Fase {
	public static final String[] FASES= {"SEGURIDAD", "SISTEMA ELÉCTRICO", "EMISIÓN HUMOS","FRENOS"};

	private int indice;
	private String nombre;
	private Vehiculo vehiculo;
	private GestorIO gestorIO = new GestorIO();

	Fase(int indice, String nombre) {
		this.indice = indice;
		this.nombre = nombre;
	}

	public Vehiculo getVehiculo() {
		Vehiculo vehiculo;

		if (this.vehiculo != null) {
			vehiculo = new Vehiculo(this.vehiculo);
		} else {
			vehiculo = null;
		}

		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = new Vehiculo(vehiculo);
	}

	public boolean vacio() {
		return this.vehiculo == null ? true : false;
	}

	public void mostrarVehiculo() {
		gestorIO.out("\n[" + this.indice + "]" + "Fase:" + this.nombre + " --> ");
		if (this.vehiculo != null) {
			this.vehiculo.mostrarVehiculo();
		} else {
			gestorIO.out("VACIO");
		}
	}
}