// Alberto Requena Sáez
// Descripció: Funciona correctamente. Compilar el archivo ".java" con el comando "javac U4Activitat1ARS.java -encoding UTF-8"
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
		boolean juegoResuelto = true;

		palabraAAdivinar = generarPalabra();

		do {
			respuestaUsuario = conseguirRespuesta();
			pistaAMostrar = pista(respuestaUsuario, palabraAAdivinar);

			for (int i = 0; i < pistaAMostrar.length() && juegoResuelto; i++) {
				if (pistaAMostrar.charAt(i) != '0') {
					juegoResuelto = false;
				}
			}

			if (juegoResuelto) {
				System.out.printf("La resposta és [%s]. Has encertat!\n\n\n", pistaAMostrar);
			} else {
				System.out.printf("La resposta és [%s] Continua intentant-ho\n", pistaAMostrar);
			}
		} while (!juegoResuelto);
	}

	private static String generarPalabra() {
		String palabra = "";

		for (int i = 0; i < 5; i++) {
			palabra += generarLetra();
		}

		System.out.println("\n\n" + palabra + "\n");

		return palabra;
	}

	private static char generarLetra() {
		char letra;
		Random numeroAleatorio = new Random();
		letra = (char) (numeroAleatorio.nextInt(26) + 'a');
		return letra;
	}
	
	private static String conseguirRespuesta() {
		String respuesta = "";

		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("\nEscriu 5 lletres minúscules: ");
			while (sc.hasNextLine()) {
				sc.nextLine();
				respuesta = sc.nextLine();
				// https://www.baeldung.com/java-scanner-nosuchelementexception-reading-file
				// https://www.google.es/search?q=java+scanner+nextline+after+isn%27t+empty&sca_esv=581645294&source=hp&ei=JnFQZYHpOZP8kdUPptqO0AE&iflsig=AO6bgOgAAAAAZVB_Nm5X0L0rux2AhI8OQboPpG2zvW6G&ved=0ahUKEwiBlMKU672CAxUTfqQEHSatAxoQ4dUDCAs&uact=5&oq=java+scanner+nextline+after+isn%27t+empty&gs_lp=Egdnd3Mtd2l6IidqYXZhIHNjYW5uZXIgbmV4dGxpbmUgYWZ0ZXIgaXNuJ3QgZW1wdHkyBRAhGKABMgUQIRigATIIECEYFhgeGB1I15cBUABY3pUBcAF4AJABBJgBvgWgAZAwqgEOMjguNC4zLjIuMC4yLjG4AQPIAQD4AQHCAgcQABiKBRhDwgIEEAAYA8ICChAAGIoFGLEDGEPCAg4QLhiABBixAxiDARjUAsICCBAuGIAEGLEDwgIOEC4YgwEY1AIYsQMYgATCAggQABiABBixA8ICBxAAGIAEGArCAgUQABiABMICBhAAGBYYHsICBBAhGBXCAgoQIRgWGB4YDxgd&sclient=gws-wiz
			}
		} while (!comprobarRespuesta(respuesta));

		sc.close();

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

		for (int i = 0; i < palabraAAdivinar.length(); i++) {
			char letraCorrecta = palabraAAdivinar.charAt(i);

			if (letraCorrecta == respuestaUsuario.charAt(i)) {
				pistaAMostrar[i] = '0';
			} else {
				for (int j = 0; j < respuestaUsuario.length(); j++) {
					if (j != i) {
						pistaAMostrar[i] = respuestaUsuario.charAt(j) == letraCorrecta ? 'X' : '-';
					}
				}
			}
		}

		return new String(pistaAMostrar);
	}
}
