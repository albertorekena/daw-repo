package pizza;

public class TestPizza {
	public static void main(String[] args) {
		Pizza p1 = new Pizza(Tipus.PROSCIUTTO, Tamany.MITJANA);
		Pizza p2 = new Pizza(Tipus.FUNGHI, Tamany.FAMILIAR);
		p2.servir();
		Pizza p3 = new Pizza(Tipus.QUATRE_FORMATGES, Tamany.MITJANA);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		p2.servir();
		System.out.println("demanades: " + Pizza.getTotalDemanades());
		System.out.println("servides: " + Pizza.getTotalServides());
	}
}
