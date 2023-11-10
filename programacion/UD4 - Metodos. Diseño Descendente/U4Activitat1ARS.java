// Alberto Requena Sáez
// Descripció: Funciona correctamente. Compilar el archivo ".java" con el comando "javac U4Activitat1ARS.java -encoding UTF-8"

// El programa acaba cuando ya se acertó todo
// Métodos:
// generarPalabra: montarPalabra: generarLetra
// Dentro de trabajarRespuesta: leerRespuesta y comprobarRespuesta
// Dentro de pista: generarPista y darRespuesta

import java.util.Random;
import java.util.Scanner;

public class U4Activitat1ARS {
	public static void main(String[] args) {
		String palabraAdivinar;

		palabraAdivinar = montarPalabra();
		trabajarRespuesta();
	}

	private static String montarPalabra() {
		String palabra = "";
		for (int i = 0; i < 5; i++) {
			palabra += generarLetra();
		}
		return palabra;
	}

	private static char generarLetra() {
		char letra;
		Random numeroAleatorio = new Random();
		letra = (char) (numeroAleatorio.nextInt(26) + 'a');
		return letra;
	}
	
	private static void trabajarRespuesta() {
		System.out.println("Escriu 5 lletres minúscules: ");
		leerRespuesta();
	}

	private static void leerRespuesta() {
		String respuesta;
		Scanner sc = new Scanner(System.in);
		respuesta = sc.nextLine();

		// https://www.youtube.com/results?search_query=java+nextline+tutorial
	}

	// private void pista() {

	// }
}
