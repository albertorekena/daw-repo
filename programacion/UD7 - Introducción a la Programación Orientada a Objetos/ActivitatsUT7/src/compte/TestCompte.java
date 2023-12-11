package compte;

public class TestCompte {
	public static void main(String[] args) {
		Compte compte = new Compte("75874698X");
		compte.mostrar();
		compte.dipositar(200);
		compte.mostrar();
		compte.retirar(250);
		compte.mostrar();
		compte.retirar(100);
		compte.mostrar();
		compte.dipositar(30);
		compte.mostrar();
		compte.dipositar(100);
		compte.mostrar();
	}
}