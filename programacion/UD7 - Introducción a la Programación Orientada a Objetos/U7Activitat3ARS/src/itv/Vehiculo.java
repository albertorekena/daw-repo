package itv;

public class Vehiculo {
	String matricula;
	String modelo;
	TipoVehiculo tipoVehiculo;

	public Vehiculo(String matricula, String modelo, TipoVehiculo tipoVehiculo) {
		this.matricula = matricula;
		this.modelo = modelo;
		this.tipoVehiculo = tipoVehiculo;
	}

	public static boolean vehiculoValido() {
		boolean vehiculoValido = false;
		return vehiculoValido;
	}
}