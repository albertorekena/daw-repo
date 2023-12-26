package itv;

public enum TipusVehicle {
	COTXE, FURGONETA, MICROBUS, CAMIO, RES;

	@Override
	public String toString() {
		switch (this) {
			case COTXE:
				return "Cotxe";

			case FURGONETA:
				return "Furgoneta";

			case MICROBUS:
				return "Microbús";

			case CAMIO:
				return "Camió";

			case RES:
				return "res";
		}

		return null;
	}
}