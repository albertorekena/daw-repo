// Alberto Requena Sáez
// Descripció: Funciona correctamente. Compilar el archivo ".java" con el comando "javac U1Activitat4.java -encoding UTF-8"

public class U1Activitat4 {
	public static void main(String[] args) {
		float a = 3.4f;
		float b = 50.2f;
		float e = 44.5f;
		float c = 2.1f;
		float d = 0.55f;
		float f = 5.9f;
		float ed = e * d;
		float bf = b * f;
		float divisor = (a * d) - (b * c);
		float x = (ed - bf) / divisor;
		float af = a * f;
		float ec = e * c;
		float y = (af - ec) / divisor;

		System.out.println("\n\nSISTEMA D'EQUACIONS LINEALS");
		System.out.println("-------------------------------------");
		System.out.println("3.4x + 50.2y = 44.5");
		System.out.println("2.1x + 0.55y = 5.9");

		System.out.println("\n\nSOLUCIÓ PER CRAMER");
		System.out.println("-------------------------------------");
		System.out.printf("x = %.2f", x);
		System.out.printf("\ny = %.2f", y);

		System.out.println("\n\nCOMPROVACIÓ DONADA LA 'x'");
		System.out.println("-------------------------------------");
		System.out.printf("y = %.2f", (e - (a * x)) / b);
		System.out.printf("\ny = %.2f\n\n\n", (f - (c * x)) / d);
	}
}