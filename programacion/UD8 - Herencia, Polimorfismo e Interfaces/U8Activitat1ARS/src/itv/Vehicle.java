package itv;

import static itv.TipusVehicle.*;

class Vehicle {
	private String matricula;
	private String model;
	private TipusVehicle tipusVehicle;

	public static final String PATRO_MATRICULA = "\\d{4}[A-Z]{3}";

	public Vehicle(String matricula, String model, TipusVehicle tipusVehicle) {
		this.matricula = matricula;
		this.model = model;
		this.tipusVehicle = tipusVehicle;
	}

	public boolean teEsta(String matricula) {
		if (matricula != null)
			return this.matricula.equals(matricula);
		else
			throw new RuntimeException("ERROR. Matricula és null");
	}

	String getMatricula() {
		return this.matricula;
	}

	@Override
	public String toString() {
		return "Matricula:" + matricula + " Model:" + model + " Tipus:" + tipusVehicle.toString();
	}

	public static TipusVehicle tipusSegonsIndex(int index) {
		switch (index) {
			case 1:
				return COTXE;
			case 2:
				return FURGONETA;
			case 3:
				return MICROBUS;
			case 4:
				return CAMIO;
		}

		return RES;
	}
}