// Alberto Requena Sáez
// Descripció: Funciona correctamente. Compilar el archivo ".java" con el comando "javac U1Activitat5.java -encoding UTF-8"

import java.util.Scanner;

public class U1Activitat5 {
	public static void main(String[] args) {
		float temperaturaCentigrads;
		float temperaturaFahrenheit;
		float velocitatVentKilometresHora;
		float velocitatVentMillesHora;
		float temperaturaFahrenheitReal;
		float temperaturaCentrigradsReal;

		Scanner teclat = new Scanner(System.in);

		System.out.println("\n\nCÀLCUL DE LA TEMPERATURA REAL");
		System.out.println("------------------------------");
		
		System.out.print("\nIntrodueix la temperatura (ºC): ");
		temperaturaCentigrads = teclat.nextFloat();
		temperaturaFahrenheit = (temperaturaCentigrads * 1.8f) + 32f;
		System.out.print("Introdueix la velocitat del vent (km/h): ");
		velocitatVentKilometresHora = teclat.nextFloat();
		velocitatVentMillesHora = velocitatVentKilometresHora / 1.608f;

		temperaturaFahrenheitReal = 35.74f
			+ (0.6215f * temperaturaFahrenheit)
			- (35.75f * (float)Math.pow(velocitatVentMillesHora, 0.16f))
			+ (0.4275f * temperaturaFahrenheit * (float)Math.pow(velocitatVentMillesHora, 0.16f));
		temperaturaCentrigradsReal = (temperaturaFahrenheitReal - 32f) * (5f / 9f);
		System.out.printf("\n\nLa temperatura real és %.1f (ºC)\n\n\n", temperaturaCentrigradsReal);

		teclat.close();
	}
}