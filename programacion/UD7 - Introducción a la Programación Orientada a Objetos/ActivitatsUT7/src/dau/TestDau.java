package dau;

public class TestDau {
	public static void main(String[] args) {
		Dau1 dau1 = new Dau1();
		System.out.println("Dau1");
		dau1.llansar();
		dau1.llansar();
		dau1.llansar();
		
		System.out.println("--------------------------------------");
		
		Dau2 dau2 = new Dau2();
		System.out.println("Dau2");
		dau2.llansar();
		dau2.llansar();
		dau2.llansar();
		
		System.out.println("--------------------------------------");
		
		Dau3 dau3 = new Dau3();
		System.out.println("Dau3");
		dau3.llansar();
		dau3.llansar();
		dau3.llansar();

		System.out.println("--------------------------------------");

		System.out.println("2 Daus");
		dau1.llansar();
		dau2.llansar();
	}
}