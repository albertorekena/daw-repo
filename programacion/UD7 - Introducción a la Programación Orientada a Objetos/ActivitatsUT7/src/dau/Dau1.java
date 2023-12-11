// Dissenya i escriu una classe que actue com un dau, el qual es pot llançar per obtenir un valor de l'1 al 6.
// Escriu la classe de manera que al principi s'obtinga el valor 6.
// Escriu un programa per a crear un objecte i utilitzar-lo.
// La pantalla ha de mostrar una opció que faça que es llance el dau i se'n mostre el valor.
// Després modifiqueu la classe "Dau" de manera que retorne un valor que siga un punt més gran al que tenia l'última vegada que es va llançar; per exemple, 4 quan era un 3. Quan l'últim valor siga 6, el nou valor serà 1.
// Després modifiqueu la classe perquè utilitze el generador de números aleatoris de la biblioteca.
// Alguns jocs com el backgammon necessiten dos daus. Escriu les instruccions de Java per a crear dos instàncies de l'objecte "Dau", llançar els daus i mostrar els resultats.

package dau;

public class Dau1 {
	private int valor;

	public Dau1() {
		this.valor = 6;
	}

	public int getValor() {
		return valor;
	}

	public void llansar() {
		System.out.println("S'ha llançat el dau. El seu valor és: " + this.valor);
	}
}