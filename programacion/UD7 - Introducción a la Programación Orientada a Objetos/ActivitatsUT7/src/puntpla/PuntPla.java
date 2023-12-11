// Constructor que inicialitze els valors de x i y (en eixe ordre)
// Constructor buit que inicialitzarà x=0 i y=0.
// Mètode que imprimeix per pantalla en quin quadrant es troba el punt (concepte matemàtic, primer quadrant si x i y són positives, si x<0 i y>0 segon quadrant, etc.)

package puntpla;

public class PuntPla {
	private double x;
	private double y;

	public PuntPla(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public PuntPla() {
		this(0, 0);
	}

	public void mostrarQuadrant() {
		String resposta = "El punt es trova en el ";

		if (x == 0 && y == 0) {
			resposta += "orige de coordenades";
		} else if (x == 0) {
			resposta += "eix y";
		} else if (y == 0) {
			resposta += "eix x";
		} else if (x > 0 && y > 0) {
			resposta += "primer quadrant";
		} else if (x < 0 && y > 0) {
			resposta += "segon quadrant";
		} else if (x < 0 && y < 0) {
			resposta += "tercer quadrant";
		} else if (x > 0 && y < 0) {
			resposta += "quart quadrant";
		}

		System.out.println(resposta);
	}
}