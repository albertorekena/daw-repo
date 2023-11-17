// Alberto Requena Sáez
// Descripció: Funciona correctamente. Compilar el archivo ".java" con el comando "javac U1Activitat6.java -encoding UTF-8"

import java.util.Scanner;

public class U1Activitat6 {
	public static void main(String[] args) {
		int preuProducte;
		int dinersInserit;
		int canvi;
		int cinquanta;
		int vint;
		int deu;
		int cinc;
		int dos;
		int resta;

		Scanner lector = new Scanner(System.in);

		System.out.println("\n\n- MÀQUINA DE BEGUDES -");
		System.out.println("----------------------");

		System.out.print("Introdueix el preu de la beguda que vols: ");
		preuProducte = lector.nextInt();
		System.out.print("Diners que introdueixes a la màquina en cèntims (màxim 100): ");
		dinersInserit = lector.nextInt();

		canvi = dinersInserit - preuProducte;
		System.out.printf("El seu canvi és: %d", canvi);

		cinquanta = canvi / 50;
		resta = canvi % 50;
		System.out.printf("\nLa quantitat de monedes de 50 cèntims es %d", cinquanta);

		vint = resta / 20;
		resta = resta % 20;
		System.out.printf("\nLa quantitat de monedes de 20 cèntims es %d", vint);

		deu = resta / 10;
		resta = resta % 10;
		System.out.printf("\nLa quantitat de monedes de 10 cèntims es %d", deu);

		cinc = resta / 5;
		resta = resta % 5;
		System.out.printf("\nLa quantitat de monedes de 5 cèntims es %d", cinc);

		dos = resta / 2;
		resta = resta % 2;
		System.out.printf("\nLa quantitat de monedes de 2 cèntims es %d", dos);

		System.out.printf("\nLa quantitat de monedes de 1 cèntims es %d\n\n\n", resta);

		lector.close();
	}
}