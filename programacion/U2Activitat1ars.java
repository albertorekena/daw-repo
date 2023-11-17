// Autor: Alberto Requena Sáez
// Descripció: Funciona correctamente. Compilar el archivo ".java" con el comando "javac U2Activitat1ars.java -encoding UTF-8".
// El comando "javac U2Activitat1ars.java -encoding UTF-8" funciona bien, pero no imprime el símbolo de €. Pone una "?"
// en su lugar.

import java.util.Scanner;

public class U2Activitat1ars {
	public static void main(String[] args) {
		float sou;
		float souAnual;

		Scanner teclat = new Scanner(System.in);

		System.out.print("\n\nIntrodueix el sou brut mensual: ");
		sou = teclat.nextFloat();
		teclat.nextLine();

		while (sou > 0) {
			souAnual = sou * 12f;
			System.out.printf("El teu sou anual es %.1f€", souAnual);

			if (souAnual > 40000f) {
				System.out.printf("\nEt toca pagar %.1f€ y no reps cap ajuda", souAnual * 0.3f);
			} else if (souAnual >= 15000) {
				System.out.printf("\nEt toca pagar %.1f€ y no reps cap ajuda", souAnual * 0.2f);
			} else if (souAnual >= 10000) {
				System.out.printf("\nEt toca pagar %.1f€ y reps una ajuda de 1500€", souAnual * 0.2f);
			} else {
				System.out.print("\nEt toca pagar 0.0€ y reps una ajuda de 1500€");
			}

			System.out.print("\n\nIntrodueix el sou brut mensual: ");
			sou = teclat.nextFloat();
			teclat.nextLine();
		}

		System.out.println("ERROR\n\n");

		teclat.close();
	}
}