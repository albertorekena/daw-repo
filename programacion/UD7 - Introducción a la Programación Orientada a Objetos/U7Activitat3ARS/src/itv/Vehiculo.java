package itv;

import itv.util.*;

public class Vehiculo {
	private String matricula;
	private String modelo;
	private TipoVehiculo tipoVehiculo;

	Vehiculo(String matricula, String modelo, TipoVehiculo tipoVehiculo) {
		this.matricula = matricula;
		this.modelo = modelo;
		this.tipoVehiculo = tipoVehiculo;
	}

	Vehiculo(Vehiculo vehiculo) {
		this(vehiculo.matricula, vehiculo.modelo, vehiculo.tipoVehiculo);
	}

	public String getMatricula() {
		return this.matricula;
	}

	public static Vehiculo vehiculoValido(Vehiculo[] todosLosVehiculos) {
		GestorIO gestorIO = new GestorIO();
		
		String matricula;
		boolean matriculaYaEnTaller = false;
		String modelo;
		int tipoVehiculoNumeroOpcion = 0;
		TipoVehiculo tipoVehiculo;

		gestorIO.out("Por favor, introduce los siguientes datos.\n\n");

		do {
			matriculaYaEnTaller = false;
			gestorIO.out("Matrícula(4 cifras y 3 letras mayúsculas): ");
			matricula = gestorIO.inString();
			if (matricula.matches("^[0-9]{4}[A-Z]{3}$")) {
				for (int i = 0; i < todosLosVehiculos.length && todosLosVehiculos[i] != null; i++) {
					if (matricula.equals(todosLosVehiculos[i].matricula)) {
						gestorIO.out("YA HAY UN VEHÍCULO CON ESA MATRÍCULA EN EL TALLER. Por favor, vuelve a introducir el dato.\n");
						matriculaYaEnTaller = true;
					}
				}
			}
		} while (!matricula.matches("^[0-9]{4}[A-Z]{3}$") || matriculaYaEnTaller);

		gestorIO.out("\nModelo: ");
		modelo = gestorIO.inString();

		do {
			gestorIO.out("\n[1] Coche   [2] Furgoneta   [3] Microbús   [4] Camión   [5] Otro\nTipo de Vehiculo: ");
			try {
				tipoVehiculoNumeroOpcion = Integer.parseInt(gestorIO.inString());
			} catch (Exception e) {}
		} while (tipoVehiculoNumeroOpcion < 1 && 5 < tipoVehiculoNumeroOpcion);
		tipoVehiculo = TipoVehiculo.values()[tipoVehiculoNumeroOpcion - 1];

		return new Vehiculo(matricula, modelo, tipoVehiculo);
	}

	public void mostrarVehiculo() {
		System.out.printf("matricula:%s - modelo:%s - tipoVehiculo:%s\n", this.matricula, this.modelo, this.tipoVehiculo);
	}
}