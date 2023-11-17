// Autor: Alberto Requena Sáez
// Descripció: Funciona correctamente. Compilar el archivo ".java" con el comando "javac U1Activitat1.java -encoding UTF-8".
// Esta solución redondean los valores del perímetro y el área, a diferencia de como ocurre en el enunciado.

import java.util.Scanner;

public class U1Activitat1 {
	public static void main(String[] args) {
		float radi;
		final float NUMERO_PI = 3.1416f;
		float baseRectangle;
		float alturaRectangle;
		float catetPrimer;
		float catetSegon;
		float hipotenusaAlQuadrat;

		Scanner lector = new Scanner(System.in);

		System.out.print("\n\nDis-me el valor del radi d'un cercle: ");
		radi = lector.nextFloat();

		System.out.print("\nAra dis-me el valor de la base d'un rectangle: ");
		baseRectangle = lector.nextFloat();
		System.out.print("\nNo oblides dir-me també el valor de l'altura del rectangle: ");
		alturaRectangle = lector.nextFloat();

		System.out.printf("\nDe moment tenim un cercle de perímetre %.2f i àrea %.2f, i un rectangle d'àrea %.2f",
			2 * NUMERO_PI * radi, NUMERO_PI * radi * radi, baseRectangle * alturaRectangle);

		System.out.print("\n\nM'agrada el teorema de Pitàgores, dis-me el valor del catet 1: ");
		catetPrimer = lector.nextFloat();
		System.out.print("\nI també del catet 2: ");
		catetSegon = lector.nextFloat();

		hipotenusaAlQuadrat = catetPrimer * catetPrimer + catetSegon * catetSegon;
		System.out.printf("\nD'acord, el valor de la hipotenusa al quadrat és %.2f, per tant, el valor de la hipotenusa és %.2f\n\n\n",
			hipotenusaAlQuadrat, Math.sqrt(hipotenusaAlQuadrat));

		lector.close();
	}
}