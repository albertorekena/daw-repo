// Alberto Requena Sáez
// Descripció: Funciona correctamente. Compilar el archivo ".java" con el comando "javac U1Activitat3.java -encoding UTF-8"

public class U1Activitat3 {
	public static void main(String[] args) {
		float milles = 14f / 1.6f;
		float hores = ((45f * 60f) + 30f) / 3600f;
		float millesHora = milles / hores;

		System.out.println("\n\nDISTÀNCIA I TEMPS (km\\h)");
		System.out.println("-----------------------------");
		System.out.println("14 quilòmetres (45' 30'')");
		System.out.println("\nVELOCITAT MITJANA (mph)");
		System.out.println("--------------------------");
		System.out.printf("%.2f\n\n\n", millesHora);
	}
}