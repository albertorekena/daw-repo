package itv;

public class Taller {
	private Cola cola;
	private Box[] boxes;

	Taller() {
		this.cola = new Cola();
		this.boxes = new Box[Box.NUMERO_BOXES];
		for (int i = 0; i < boxes.length; i++) {
			boxes[i] = new Box(i);
		}
	}

	public static void main(String[] args) {
		Taller taller = new Taller();
		taller.iniciar();
	}

	public int iniciar() {
		Menu menu = new Menu();
		int opcionElegida;
		boolean salirMenu = false;

		do {
			opcionElegida = menu.opcionElegida();

			switch (opcionElegida) {
				case 1:
					boolean vehiculoValido;
					String matricula = ;
					String modelo;
					TipoVehiculo tipoVehiculo;
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				default:
					break;
			}
		} while (!salirMenu);

		return opcionElegida;
	}
}