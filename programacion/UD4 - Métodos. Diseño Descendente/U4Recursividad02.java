//A partir d'un enter retorna la suma dels seus dígits.

public class Recursividad02 {
	public static void main(String[] args) {
		System.out.println(sumaCifras(123));
	}

	public static int sumaCifras(int numero) {
		if (numero / 10 == 0) {
			return numero;
		}

		return (numero % 10) + sumaCifras(numero / 10);
	}
}