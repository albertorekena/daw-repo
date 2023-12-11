package complex;

public class TestComplex {
	public static void main(String[] args) {
		Complex a = new Complex(3, -4);
		Complex b = new Complex(2, 7);

		System.out.println(a);
		System.out.println(b);
		System.out.println(a.sumar(b));
		System.out.println(a.producte(b));
	}
}
