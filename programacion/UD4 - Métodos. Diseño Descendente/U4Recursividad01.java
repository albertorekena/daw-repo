//A partir d'un enter retorna quants dígits té.

public class Recursividad01 {
	public static void main(String[] args) {
		System.out.println(numeroCifras(123));
	}

	public static int numeroCifras(int numero) {
		if (numero / 10 < 1) {
			return 1;
		}

		return 1 + numeroCifras(numero / 10);
	}
}