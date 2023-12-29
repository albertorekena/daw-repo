package itv;

public class Box {
	private Fase[] fases;

	public Box() {
		this.fases = new Fase[Fase.FASES.length];
		for (int i = 0; i < fases.length; i++) {
			this.fases[i] = new Fase();
		}
	}

	public Fase[] getFases() {
		return this.fases;
	}

	public boolean disponible() {
		return (this.fases[0].disponible()) ? true : false;
	}
}