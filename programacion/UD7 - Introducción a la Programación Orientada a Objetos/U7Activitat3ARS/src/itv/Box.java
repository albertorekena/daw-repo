package itv;

public class Box {
	private Fase[] fases;

	public static final int NUMERO_BOXES = 6;

	public Box() {
		this.fases = new Fase[Fase.FASES.length];
	}

	public Fase[] getFases() {
		return this.fases;
	}
}