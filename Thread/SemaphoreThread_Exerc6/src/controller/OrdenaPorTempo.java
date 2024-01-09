package controller;

import java.util.Comparator;

public class OrdenaPorTempo implements Comparator<DadosGrid>{

	@Override
	public int compare(DadosGrid o1, DadosGrid o2) {
		return o1.getTempoVolta() - o2.getTempoVolta();
	}
}
