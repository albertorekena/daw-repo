// Autor: Alberto Requena Sáez
// Descripció: Funciona correctamente. Compilar el archivo ".java" con el comando "javac U2Activitat3ars.java -encoding UTF-8".

import java.util.Scanner;

public class U2Activitat3ars {
	public static void main(String[] args) {
		float nota = 0f;
		float sumaNotas = 0f;
		int alumnos = 0;
		int alumnosAprobados = 0;
		float porcentajeAlumnosAprobados = 0f;
		float sumaNotasAprobados = 0f;
		int alumnosSuspendidos = 0;
		float porcentajeAlumnosSuspendidos = 0f;
		float sumaNotasSuspendidos = 0f;
		float notaMasAlta = 0.f;
		float notaMasBaja = 10.f;
		float notaMedia = 0.f;
		float notaMediaAprobados = 0.f;
		float notaMediaSuspendidos = 0.f;
		
		Scanner sc = new Scanner(System.in);

		System.out.println("\n\n--------------------------");
		System.out.println("-- ESTADÍSTICA DE NOTES --");
		System.out.println("--------------------------");
		System.out.print("\n\nIntrodueix una nota (valor negatiu per a finalitzar): ");
		
		while (!sc.hasNextFloat() || (nota = sc.nextFloat()) < 0f || nota > 10f) {
			if (nota < 0f) break;
			System.out.println("ERROR: Nota invàlida");
			sc.nextLine();
			System.out.print("Introdueix una nota (valor negatiu per a finalitzar): ");

			while (sc.hasNextFloat() && (nota = sc.nextFloat()) >= 0f && nota <= 10f) {
				alumnos++;
				if (nota >= 5f) {
					alumnosAprobados++;
					porcentajeAlumnosAprobados = (alumnosAprobados / alumnos) * 100f;
					sumaNotasAprobados += nota;
					notaMediaAprobados = sumaNotasAprobados / alumnosAprobados;
				} else {
					alumnosSuspendidos++;
					porcentajeAlumnosSuspendidos = (alumnosSuspendidos / alumnos) * 100f;
					sumaNotasSuspendidos += nota;
					notaMediaSuspendidos = sumaNotasSuspendidos / alumnosSuspendidos;
				}
				notaMasAlta = notaMasAlta > nota ? notaMasAlta : nota;
				notaMasBaja = notaMasBaja < nota ? notaMasBaja : nota;
				sumaNotas += nota;
				notaMedia = sumaNotas / alumnos;
			}

			if (nota < 0f) break;
			System.out.println("ERROR: Nota invàlida");
			sc.nextLine();
			System.out.print("Introdueix una nota (valor negatiu per a finalitzar): ");
		}

		while (nota >= 0f && nota <= 10f) {
			alumnos++;
			if (nota >= 5f) {
				alumnosAprobados++;
				sumaNotasAprobados += nota;
				notaMediaAprobados = sumaNotasAprobados / alumnosAprobados;
			} else {
				alumnosSuspendidos++;
				sumaNotasSuspendidos += nota;
				notaMediaSuspendidos = sumaNotasSuspendidos / alumnosSuspendidos;
			}
			porcentajeAlumnosAprobados = (alumnosAprobados / (float) alumnos) * 100f;
			porcentajeAlumnosSuspendidos = (alumnosSuspendidos / (float) alumnos) * 100f;
			notaMasAlta = notaMasAlta > nota ? notaMasAlta : nota;
			notaMasBaja = notaMasBaja < nota ? notaMasBaja : nota;
			sumaNotas += nota;
			notaMedia = sumaNotas / (float) alumnos;
			
			System.out.print("Introdueix una nota (valor negatiu per a finalitzar): ");

			sc.nextLine();
			while (!sc.hasNextFloat() || (nota = sc.nextFloat()) < 0f || nota > 10f) {
				if (nota < 0f) break;
				System.out.println("ERROR: Nota invàlida");
				sc.nextLine();
				System.out.print("Introdueix una nota (valor negatiu per a finalitzar): ");
			}
		}

		sc.close();

		if (alumnos > 0) {
			System.out.printf("\n\n- S'han avaluat un total de %d alumnes", alumnos);
			System.out.printf("\n- La nota mitjana del curs ha sigut un %.2f", notaMedia);
			System.out.printf("\n- Han aprovat %d alumnes, el que suposa un %.2f%% del total", alumnosAprobados, porcentajeAlumnosAprobados);
			if (alumnosAprobados > 0) {
				System.out.printf("\n- La nota mitjana dels alumnes aprovats ha sigut un %.2f", notaMediaAprobados);
			} else {
				System.out.printf("\n- La nota mitjana del alumnes aprovats és inexistent, perquè no hi ha cap aprovat");
			}
			if (alumnosSuspendidos > 0) {
				System.out.printf("\n- Han suspés %d alumnes, el que suposa un %.2f%% del total", alumnosSuspendidos, porcentajeAlumnosSuspendidos);
			} else {
				System.out.printf("\n- La nota mitjana del alumnes suspesos és inexistent, perquè no hi ha cap suspès");
			}
			
			System.out.printf("\n- La nota mitjana dels alumnes suspesos ha sigut un %.2f", notaMediaSuspendidos);
			
			System.out.printf("\n- La nota més alta ha sigut un %.2f", notaMasAlta);
			System.out.printf("\n- La nota més baixa ha sigut un %.2f\n\n\n", notaMasBaja);
		} else {
			System.out.println("\nNo s'han introduït notes.\n\n");
		}
	}
}