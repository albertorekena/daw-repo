// Autor: Alberto Requena Sáez
// Descripció: Funciona correctamente. Compilar el archivo ".java" con el comando "javac U2Activitat2ars.java -encoding UTF-8".

import java.util.Scanner;

public class U2Activitat2ars {
	public static void main(String[] args) {
		int intents;
		int numeroIntroduit;
		int numeroSecret = (int) (Math.random() * 100);
		int diferencia;
		String mayorOMenor;
		Boolean acertado = false;

		System.out.println("\n\nBENVINGUT AL JOC: ENDEVINA EL NÚMERO SECRET");
		System.out.println("------------------------------------------------\n");
		System.out.print("De quants intents vols disposar?: ");

		Scanner teclat = new Scanner(System.in);

		while (!teclat.hasNextInt() || ((intents = teclat.nextInt()) < 1) || (intents > 10)) {
			System.out.print("Error");
			teclat.nextLine();
			System.out.print("\nDe quants intents vols disposar?: ");
		}

		for (int i = 0; i < intents && acertado == false; i++) {
			System.out.printf("Intent %d: ", i + 1);

			while (!teclat.hasNextInt()) {
				System.out.print("\nError");
				System.out.printf("\nIntent %d: ", i + 1);
				teclat.nextLine();
			}

			numeroIntroduit = teclat.nextInt();

			diferencia = numeroIntroduit - numeroSecret;
			mayorOMenor = diferencia > 0 ? "mayor" : "menor";
			diferencia = Math.abs(diferencia);

			if (diferencia >= 30) {
				System.out.printf("El número introduït és %s (Fred)\n", mayorOMenor);
			} else if (diferencia > 10) {
				System.out.printf("El número introduït és %s (Temperat)\n", mayorOMenor);
			} else if (diferencia > 0){
				System.out.printf("El número introduït és %s (Calent)\n", mayorOMenor);
			} else {
				System.out.println("Enhorabona, has encertat el número\n\n\n");
				acertado = true;
			}
		}

		teclat.close();
	}
}