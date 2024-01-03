package itv;

import itv.util.GestorIO;

public class Fase {
	private int indice;
	private String nombre;
	private Vehiculo vehiculo;
	private GestorIO gestorIO = new GestorIO();

	public static final String[] FASES= {"SEGURIDAD", "SISTEMA ELÉCTRICO", "EMISIÓN HUMOS","FRENOS"};

	Fase(int indice, String nombre) {
		this.indice = indice;
		this.nombre = nombre;
	}

	public Vehiculo getFaseVehiculo() {
		return new Vehiculo(this.vehiculo);
	}
	
	public void setFaseVehiculo(Vehiculo vehiculo) {
		this.vehiculo = new Vehiculo(vehiculo);
	}

	public boolean vacio() {
		return this.vehiculo == null ? true : false;
	}

	public void mostrarFaseVehiculo() {
		gestorIO.out("\n[" + this.indice + "]" + "Fase:" + this.nombre + " --> ");
		if (this.vehiculo != null) {
			this.vehiculo.mostrarVehiculo();
		} else {
			gestorIO.out("VACIO");
		}
	}
}