// Alberto Requena Sáez
// Descripció: Me falta pulir el método conseguirRespuesta para dar una respuesta en texto diferente cuando se introducen mal los datos.
// El resto del programa funciona correctamente.
// Compilar el archivo ".java" con el comando "javac U4Activitat1ARS.java -encoding UTF-8".
// Métodos:
// generarPalabra: generarLetra
// conseguirRespuesta: comprobarRespuesta
// pista: generarPista y darRespuesta

import java.util.Random;
import java.util.Scanner;

public class U4Activitat1ARS {
	public static void main(String[] args) {
		String palabraAAdivinar;
		String respuestaUsuario;
		String pistaAMostrar;
		boolean juegoResuelto = false;
		boolean sigueConElBucle = true;

		Scanner sc = new Scanner(System.in);

		palabraAAdivinar = generarPalabra();
		// palabraAAdivinar = "mtpzx";

		do {
			respuestaUsuario = conseguirRespuesta(sc);
			pistaAMostrar = pista(respuestaUsuario, palabraAAdivinar);

			for (int i = 0; i < pistaAMostrar.length() && sigueConElBucle; i++) {
				if (pistaAMostrar.charAt(i) != '0') {
					sigueConElBucle = false;
				}

				if (sigueConElBucle && (i == (pistaAMostrar.length() - 1))) {
					juegoResuelto = true;
				}
			}

			if (juegoResuelto) {
				System.out.printf("La resposta és [%s]. Has encertat!\n\n\n", pistaAMostrar);
			} else {
				System.out.printf("La resposta és [%s] Continua intentant-ho\n", pistaAMostrar);
				sigueConElBucle = true;
			}
		} while (!juegoResuelto);

		sc.close();
	}

	private static String generarPalabra() {
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
	
	private static String conseguirRespuesta(Scanner sc) {
		String respuesta = "";

		do {
			System.out.println("\nEscriu 5 lletres minúscules: ");
			respuesta = sc.nextLine();
		} while (!comprobarRespuesta(respuesta));

		return respuesta;
	}

	private static boolean comprobarRespuesta(String respuesta) {
		boolean formatoRespuestaCorrecto = false;

		if (respuesta.length() > 5) {
			formatoRespuestaCorrecto = false;
		} else {
			for (int i = 0; i < respuesta.length(); i++) {
				int asciiCaracter = (int) respuesta.charAt(i);
				int asciiA = (int) 'a';
				formatoRespuestaCorrecto = (asciiCaracter >= asciiA && asciiCaracter < (asciiA + 26)) ? true : false;
			}
		}

		return formatoRespuestaCorrecto;
	}

	private static String pista(String respuestaUsuario, String palabraAAdivinar) {
		char[] pistaAMostrar = {'-', '-', '-', '-', '-'};
		char letraRespuestaUsuario;

		for (int i = 0; i < respuestaUsuario.length(); i++) {
			letraRespuestaUsuario = respuestaUsuario.charAt(i);

			for (int j = 0; j < palabraAAdivinar.length(); j++) {
				if (letraRespuestaUsuario == palabraAAdivinar.charAt(j)) {
					pistaAMostrar[i] = 'X';
				}
				if (letraRespuestaUsuario == palabraAAdivinar.charAt(j) && j == i) {
					pistaAMostrar[i] = '0';
				}
			}
		}

		return new String(pistaAMostrar);
	}
}