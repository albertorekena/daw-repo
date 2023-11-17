// Autor: Alberto Requena Sáez
// Descripció: Funciona correctamente. Compilar el archivo ".java" con el comando "javac U3Activitat1ars.java -encoding UTF-8".

import java.util.Scanner;

public class U3Activitat1ars {
	public static void main(String args[]) {
		float[][] medidas = new float[2][10];
		int j = 0;
		int i = 0;
		float dato;
		boolean sistolicaCandidataValidada = false;
		float sistolicaCandidata = 0f;
		String siONo;
		boolean salirMedidas = false;
		boolean salirPrograma = false;
		int opcion = 0;
		float sistolicaMaxima;
		float diastolicaMinima;
		float acumuladorSistolica = 0f;
		float sistolicaMedia;
		float acumuladorDiastolica = 0f;
		float diastolicaMedia;
		int m = 0;
		float tensionMasCompensada = 0f;
		float auxTensionMasCompensada = 0f;
		int indiceTensionMasCompensada = 0;

		Scanner sc = new Scanner(System.in);

		System.out.println("\n\nTENSIÓ ARTERIAL");
		System.out.println("-------------------");
		System.out.print("Introdueix les mesures (1 per línia):\n");

		while (j <= 10 && !salirMedidas && !salirPrograma) {
			while (i <= 1 && !salirMedidas && !salirPrograma) {
				if (sc.hasNextFloat()) {
					dato = sc.nextFloat();

					if (dato != 0) {
						if (i == 0) {
							if (dato >= 3 && dato <= 22) {
								sistolicaCandidataValidada = true;
								sistolicaCandidata = dato;
							}
						}

						if (i == 1) {
							if (dato >= 3 && dato <= 22 && sistolicaCandidata >= dato && sistolicaCandidataValidada == true) {
								medidas[0][j] = sistolicaCandidata;
								medidas[1][j] = dato;
								j++;
							}
						}

						i++;

						if (i > 1) {
							i = 0;
							if (j > 9) {
								salirMedidas = true;
							}
						}
					}

					if (dato == 0 && j <= 1) {
						System.out.println("Si no introdueixes, almenys, 2 mesures vàlids, no se't podran mostrar els resultats i sortiràs del programa.");
						System.out.println("Estàs segur que vols sortir?");
						System.out.println("Introdueix \"n\" si NO vols sortir. Introdueix \"s\" si SÌ que vols sortir: ");
						siONo = sc.next();
						if (siONo.equals("n")) {
							System.out.print("Continua introduint les mesures (1 per línia):\n");
						} else if (siONo.equals("s")) {
							salirPrograma = true;
						} else {
							while (!siONo.equals("n") && !siONo.equals("s")) {
								System.out.println("Introdueix \"n\" si NO vols sortir. Introdueix \"s\" si SÌ que vols sortir: ");
								siONo = sc.next();
								if (siONo.equals("n")) {
									System.out.print("Continua introduint les mesures (1 per línia):\n");
								} else if (siONo.equals("s")) {
									salirPrograma = true;
								}
							}
						}
					}

					if (dato == 0 && j > 1) {
						salirMedidas = true;
					}
				} else {
					i++;
				}

				sc.nextLine();
			}
		}

		System.out.println("\n1- Sistòlica màxima");
		System.out.println("2- Diastòlica mínima");
		System.out.println("3- Més compensada");
		System.out.println("4- Tensió mitjana");
		System.out.println("5- Eixir");
		System.out.printf("Selecciona l'opció desitjada: ");

		while ((!sc.hasNextInt() || (opcion = sc.nextInt()) != 5) && !salirPrograma) {
			sc.nextLine();

			if (opcion >= 1 && opcion <= 4) {
				switch (opcion) {
					case 1:
						sistolicaMaxima = medidas[0][0];
						for (int k = 0; k < 10; k++) {
							if (medidas[0][k] >= sistolicaMaxima) {
								sistolicaMaxima = medidas[0][k];
							}
						}
						System.out.printf("%.1f es la sistólica máxima\n", sistolicaMaxima);
						System.out.printf("Selecciona l'opció desitjada: ");
						break;

					case 2:
						diastolicaMinima = medidas[1][0];
						for (int k = 0; k < 10; k++) {
							if (medidas[1][k] <= diastolicaMinima && medidas[1][k] >= 3) {
								diastolicaMinima = medidas[1][k];
							}
						}
						System.out.printf("%.1f es la diastólica mínima\n", diastolicaMinima);
						System.out.printf("Selecciona l'opció desitjada: ");
						break;

					case 3:
						tensionMasCompensada = Math.abs(medidas[0][0] - (2 * medidas[1][0]));
						for (m = 0; m < j; m++) {
							for (int l = 0; l < 2; l++) {
								auxTensionMasCompensada = Math.abs(medidas[0][l] - (2 * medidas[1][l]));
								if (tensionMasCompensada > auxTensionMasCompensada) {
									tensionMasCompensada = auxTensionMasCompensada;
									indiceTensionMasCompensada = m;
								}
							}
						}
						System.out.printf("%.1f ", medidas[0][indiceTensionMasCompensada]);
						System.out.printf("%.1f ", medidas[1][indiceTensionMasCompensada]);
						if (medidas[0][indiceTensionMasCompensada] < 12f && medidas[1][indiceTensionMasCompensada] < 8f) {
							System.out.println("Òptima");
							System.out.printf("Selecciona l'opció desitjada: ");
						}
						if (medidas[0][indiceTensionMasCompensada] >= 12f && medidas[0][indiceTensionMasCompensada] < 13f && medidas[1][indiceTensionMasCompensada] >= 8f && medidas[1][indiceTensionMasCompensada] < 8.5f) {
							System.out.println("Normal");
							System.out.printf("Selecciona l'opció desitjada: ");
						}
						if (medidas[0][indiceTensionMasCompensada] >= 13f && medidas[0][indiceTensionMasCompensada] < 14f && medidas[1][indiceTensionMasCompensada] >= 8.5f && medidas[1][indiceTensionMasCompensada] < 9f) {
							System.out.println("Normal-Alta");
							System.out.printf("Selecciona l'opció desitjada: ");
						}
						if (medidas[0][indiceTensionMasCompensada] >= 14f && medidas[0][indiceTensionMasCompensada] < 16f && medidas[1][indiceTensionMasCompensada] >= 9f && medidas[1][indiceTensionMasCompensada] < 10f) {
							System.out.println("Gran 1");
							System.out.printf("Selecciona l'opció desitjada: ");
						}
						if (medidas[0][indiceTensionMasCompensada] >= 16f && medidas[0][indiceTensionMasCompensada] < 18f && medidas[1][indiceTensionMasCompensada] >= 10f && medidas[1][indiceTensionMasCompensada] < 11f) {
							System.out.println("Gran 2");
							System.out.printf("Selecciona l'opció desitjada: ");
						}
						if (medidas[0][indiceTensionMasCompensada] >= 18f && medidas[1][indiceTensionMasCompensada] >= 11f) {
							System.out.println("Gran 3");
							System.out.printf("Selecciona l'opció desitjada: ");
						}
						if (medidas[0][indiceTensionMasCompensada] >= 14f && medidas[1][indiceTensionMasCompensada] < 9f) {
							System.out.println("Sistòlica aïllada");
							System.out.printf("Selecciona l'opció desitjada: ");
						}
						break;

					case 4:
						for (int k = 0; k < j; k++) {
							acumuladorSistolica += medidas[0][k];
						}
						sistolicaMedia = acumuladorSistolica / j;
						System.out.printf("%.1f ", sistolicaMedia);

						for (int k = 0; k < j; k++) {
							acumuladorDiastolica += medidas[1][k];
						}
						diastolicaMedia = acumuladorDiastolica / j;
						System.out.printf("%.1f ", diastolicaMedia);

						if (sistolicaMedia < 12f && diastolicaMedia < 8f) {
							System.out.println("Òptima");
							System.out.printf("Selecciona l'opció desitjada: ");
						}
						if (sistolicaMedia >= 12f && sistolicaMedia < 13f && diastolicaMedia >= 8f && diastolicaMedia < 8.5f) {
							System.out.println("Normal");
							System.out.printf("Selecciona l'opció desitjada: ");
						}
						if (sistolicaMedia >= 13f && sistolicaMedia < 14f && diastolicaMedia >= 8.5f && diastolicaMedia < 9f) {
							System.out.println("Normal-Alta");
							System.out.printf("Selecciona l'opció desitjada: ");
						}
						if (sistolicaMedia >= 14f && sistolicaMedia < 16f && diastolicaMedia >= 9f && diastolicaMedia < 10f) {
							System.out.println("Gran 1");
							System.out.printf("Selecciona l'opció desitjada: ");
						}
						if (sistolicaMedia >= 16f && sistolicaMedia < 18f && diastolicaMedia >= 10f && diastolicaMedia < 11f) {
							System.out.println("Gran 2");
							System.out.printf("Selecciona l'opció desitjada: ");
						}
						if (sistolicaMedia >= 18f && diastolicaMedia >= 11f) {
							System.out.println("Gran 3");
							System.out.printf("Selecciona l'opció desitjada: ");
						}
						if (sistolicaMedia >= 14f && diastolicaMedia < 9f) {
							System.out.println("Sistòlica aïllada");
							System.out.printf("Selecciona l'opció desitjada: ");
						}
						break;

					default:
						break;
				}
			} else {
				System.out.println("Error");
				System.out.printf("Selecciona l'opció desitjada: ");
			}

			opcion = 0;
		}

		System.out.println("\n");

		sc.close();
	}
}