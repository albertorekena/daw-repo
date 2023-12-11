package triangle;

public class TestTriangle {
	public static void main(String[] args) {
		Triangle t1 = Triangle.fabricarTriangle(5, 8, 3);

		if (t1 == null) {
			System.out.println("Triangle invàlid");
		} else {
			System.out.println(t1.getMajor());
			System.out.println(t1.getArea());
			t1.mostrarTipus();
		}
	}
}