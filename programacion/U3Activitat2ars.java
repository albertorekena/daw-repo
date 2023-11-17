// Autor: Alberto Requena Sáez
// Descripció: Funciona correctamente. Compilar el archivo ".java" con el comando "javac U3Activitat2ars.java -encoding UTF-8".

import java.util.Scanner;

public class U3Activitat2ars {
	public static void main(String args[]) {
		int dimension = 0;
		int[][] matriz;
		boolean todoCeros = true;
		int fila = 0;
		int acumuladorUnosFilaMaxima = 0;
		int columna = 0;
		int acumuladorUnosColumnaMaxima = 0;
		int acumuladorUnosFila;
		int acumuladorUnosColumna;
		boolean filaCeros = true;
		int indiceFilaCeros = -1;
		boolean filaUnos = true;
		int indiceFilaUnos = -1;
		int registroContador = -1;
		boolean columnaCeros = true;
		int indiceColumnaCeros = -1;
		boolean columnaUnos = true;
		int indiceColumnaUnos = -1;
		boolean diagonalCeros = true;
		boolean diagonalUnos = true;
		boolean subdiagonalCeros = true;
		boolean subdiagonalUnos = true;

		Scanner sc = new Scanner(System.in);

		System.out.print("\n\nIntrodueix la mida de la matriu: ");
		if (sc.hasNextInt()) {
			dimension = sc.nextInt();
			sc.nextLine();
		} else {
			while (!sc.hasNextInt() || (dimension = sc.nextInt()) <= 0) {
				sc.nextLine();
				System.out.print("Introdueix la mida de la matriu: ");
			}
		}

		matriz = new int[dimension][dimension];
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				matriz[i][j] = Math.random() > 0.5f ? 1 : 0;
			}
		}

		System.out.println("");
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				System.out.print(matriz[i][j]);
			}
			System.out.println("");
		}
		System.out.println("");

		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				if (matriz[i][j] == 1) {
					todoCeros = false;
				}
			}
		}
		if (todoCeros) {
			System.out.println("1. La matriu només té zeros");
			System.out.println("2. La matriu només té zeros");
		} else {
			for (int i = 0; i < dimension; i++) {
				acumuladorUnosFila = 0;
				for (int j = 0; j < dimension; j++) {
					if (matriz[i][j] == 1) {
						acumuladorUnosFila++;
					}
					if (acumuladorUnosFila >= acumuladorUnosFilaMaxima) {
						acumuladorUnosFilaMaxima = acumuladorUnosFila;
						fila = i;
					}
				}
			}
			System.out.printf("1. Fila %d amb major nombre d'1s\n", fila);

			for (int i = 0; i < dimension; i++) {
				acumuladorUnosColumna = 0;
				for (int j = 0; j < dimension; j++) {
					if (matriz[j][i] == 1) {
						acumuladorUnosColumna++;
					}
					if (acumuladorUnosColumna >= acumuladorUnosColumnaMaxima) {
						acumuladorUnosColumnaMaxima = acumuladorUnosColumna;
						columna = i;
					}
				}
			}
			System.out.printf("2. Columna %d amb major nombre d'1s\n", columna);
		}

		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				if (matriz[i][j] == 1) {
					filaCeros = false;
				}
				if (matriz[i][j] == 0) {
					filaUnos = false;
				}
			}
			if (filaCeros == true) {
				indiceFilaCeros = i;
			}
			if (filaUnos == true) {
				indiceFilaUnos = i;
			}
			filaCeros = true;
			filaUnos = true;
		}
		if (indiceFilaCeros >= 0 || indiceFilaUnos >= 0) {
			if (indiceFilaCeros >= 0) {
				System.out.printf("3. Fila %d amb tot 0s\n", indiceFilaCeros);
			} else {
				System.out.println("3. No hi ha files amb tot 0s");
			}
			if (indiceFilaUnos >= 0) {
				System.out.printf("3. Fila %d amb tot 1s\n", indiceFilaUnos);
			} else {
				System.out.println("3. No hi ha files amb tot 1s");
			}
		} else {
			System.out.println("3. No hi ha files amb el mateix número");
		}

		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				if (matriz[j][i] == 1) {
					columnaCeros = false;
				}
				if (matriz[j][i] == 0) {
					columnaUnos = false;
				}
				registroContador = j;
			}
			if (columnaCeros == true) {
				indiceColumnaCeros = registroContador;
			}
			if (columnaUnos == true) {
				indiceColumnaUnos = registroContador;
			}
			columnaCeros = true;
			columnaUnos = true;
		}
		if (indiceColumnaCeros >= 0 || indiceColumnaUnos >= 0) {
			if (indiceColumnaCeros >= 0) {
				System.out.printf("4. Columna %d amb tot 0s\n", indiceColumnaCeros);
			} else {
				System.out.println("4. No hi ha columnes amb tot 0s");
			}
			if (indiceColumnaUnos >= 0) {
				System.out.printf("4. Columna %d amb tot 1s\n", indiceColumnaUnos);
			} else {
				System.out.println("4. No hi ha columnes amb tot 1s");
			}
		} else {
			System.out.println("4. No hi ha columnes amb el mateix número");
		}

		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				if (i == j) {
					if (matriz[i][j] == 1) {
						diagonalCeros = false;
					} else {
						diagonalUnos = false;
					}
				}
			}
		}
		if (diagonalCeros == true || diagonalUnos == true) {
			if (diagonalCeros == true) {
				System.out.println("5. Diagonal major amb tot 0s");
			}
			if (diagonalUnos == true) {
				System.out.println("5. Diagonal major amb tot 1s");
			}
		} else {
			System.out.println("5. Diagonal major sense números iguals");
		}

		for (int i = 0; i < dimension; i++) {
			for (int j = dimension - 1; j >= 0; j--) {
				if (i == (dimension - 1 - j)) {
					if (matriz[i][j] == 1) {
						subdiagonalCeros = false;
					} else {
						subdiagonalUnos = false;
					}
				}
			}
		}
		if (subdiagonalCeros == true || subdiagonalUnos == true) {
			if (subdiagonalCeros == true) {
				System.out.println("6. Subdiagonal amb tot 0s");
			}
			if (subdiagonalUnos == true) {
				System.out.println("6. Subdiagonal amb tot 1s");
			}
		} else {
			System.out.println("6. Subdiagonal sense números iguals");
		}
		
		System.out.println("\n");

		sc.close();
	}
}