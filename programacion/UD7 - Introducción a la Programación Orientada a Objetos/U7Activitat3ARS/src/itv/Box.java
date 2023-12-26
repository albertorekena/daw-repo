package itv;

public class Box {
	private int id;
	private Fase[] fases;

	public static final int NUMERO_BOXES = 6;

	public Box(int id) {
		this.id = id;
		this.fases = new Fase[Fase.NUMERO_FASES];
	}
}