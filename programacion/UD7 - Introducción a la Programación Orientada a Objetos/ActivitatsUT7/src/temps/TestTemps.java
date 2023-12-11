package temps;

public class TestTemps {
	public static void main(String[] args) {
		Temps t1 = new Temps(0, 30, 40);
		Temps t2 = new Temps(0, 35, 20);
		System.out.println(t1.suma(t2));
		System.out.println(t2.resta(t1));

		System.out.println("---------------------------------------");

		Temps t3 = new Temps(1, 30, 40);
		Temps t4 = new Temps(0, 35, 25);
		System.out.println(t3.suma(t4));
		System.out.println(t4.resta(t3));
	}
}