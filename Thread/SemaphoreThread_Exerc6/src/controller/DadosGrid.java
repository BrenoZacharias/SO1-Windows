package controller;

public class DadosGrid {

	private int escuderia;
	private int piloto;
	private int tempoVolta;
	
	public DadosGrid(int escuderia, int piloto, int tempoVolta) {
		this.escuderia = escuderia;
		this.piloto = piloto;
		this.tempoVolta = tempoVolta;
	}

	public int getEscuderia() {
		return escuderia;
	}

	public int getPiloto() {
		return piloto;
	}

	public int getTempoVolta() {
		return tempoVolta;
	}
	
	@Override
	public String toString() {
		return ("\nMelhor tempo: " + tempoVolta + "  Escuderia:" + escuderia + "  Piloto:" + piloto);
	}
}

