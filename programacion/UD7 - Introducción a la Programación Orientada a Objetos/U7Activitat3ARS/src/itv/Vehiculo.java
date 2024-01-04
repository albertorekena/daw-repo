package itv;

import itv.util.*;

public class Vehiculo {
	private String matricula;
	private String modelo;
	private TipoVehiculo tipoVehiculo;

	public static Vehiculo vehiculoValido(Vehiculo[] todosLosVehiculos) {
		GestorIO gestorIO = new GestorIO();
		Interval interval = new Interval(TipoVehiculo.values().length - 1);
		
		String matricula;
		boolean matriculaYaEnTaller = false;
		String modelo;
		int tipoVehiculoNumeroOpcion = 0;
		TipoVehiculo tipoVehiculo;

		gestorIO.out("Por favor, introduce los siguientes datos:\n\n\n");

		do {
			matriculaYaEnTaller = false;
			gestorIO.out("·Matrícula(4 cifras y 3 letras mayúsculas): ");
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

		gestorIO.out("\n·Modelo: ");
		modelo = gestorIO.inString();

		do {
			gestorIO.out("\n[0]Coche   [1]Furgoneta   [2]Microbús   [3]Camión   [4]Otro\n·Tipo de Vehiculo: ");
			try {
				tipoVehiculoNumeroOpcion = Integer.parseInt(gestorIO.inString());
			} catch (Exception e) {}
		} while (!interval.inclou(Double.valueOf(tipoVehiculoNumeroOpcion)));
		tipoVehiculo = TipoVehiculo.values()[tipoVehiculoNumeroOpcion];

		return new Vehiculo(matricula, modelo, tipoVehiculo);
	}

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

	public void mostrarVehiculo() {
		System.out.printf("matricula:%s - modelo:%s - tipoVehiculo:%s", this.matricula, this.modelo, this.tipoVehiculo);
	}
}