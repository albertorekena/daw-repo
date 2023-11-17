// Alberto Requena Sáez
// Descripció: Funciona correctamente. Compilar el archivo ".java" con el comando "javac U1Activitat2.java -encoding UTF-8".
// El comando "javac U1Activitat2.java -encoding UTF-8" funciona bien, pero no imprime las letras en mayúscula con tilde. Pone una "?"
// en su lugar.

public class U1Activitat2 {
	public static void main(String[] args) {
		final int POBLACIO_ACTUAL = 312032486;
		final int DIES_ANY = 365;
		final int SEGONS_ANY = DIES_ANY * 24 * 60 * 60;
		final float NAIXEMENTS_ANY = SEGONS_ANY / 7f;
		final float MORTS_ANY = SEGONS_ANY / 13f;
		final float INMIGRANTS_ANY = SEGONS_ANY / 45f;
		final float INCREMENT_POBLACIO_PER_ANY = NAIXEMENTS_ANY - MORTS_ANY + INMIGRANTS_ANY;

		System.out.println("\n\nPROJECCIÓ DE LA POBLACIÓ ALS EUA");
		System.out.println("\n-------------------------------------");
		System.out.printf("\nAny actual: %d persones", POBLACIO_ACTUAL);
		System.out.printf("\nAny 2024: %.0f persones", (float) POBLACIO_ACTUAL + INCREMENT_POBLACIO_PER_ANY);
		System.out.printf("\nAny 2025: %.0f persones", (float) POBLACIO_ACTUAL + INCREMENT_POBLACIO_PER_ANY * 2);
		System.out.printf("\nAny 2026: %.0f persones", (float) POBLACIO_ACTUAL + INCREMENT_POBLACIO_PER_ANY * 3);
		System.out.printf("\nAny 2027: %.0f persones", (float) POBLACIO_ACTUAL + INCREMENT_POBLACIO_PER_ANY * 4);
		System.out.printf("\nAny 2028: %.0f persones\n\n\n", (float) POBLACIO_ACTUAL + INCREMENT_POBLACIO_PER_ANY * 5);
	}
}