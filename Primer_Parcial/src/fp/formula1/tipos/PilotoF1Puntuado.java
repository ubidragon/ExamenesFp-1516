package src.fp.formula1.tipos;

import java.util.List;

public interface PilotoF1Puntuado extends PilotoF1 {
	// Propiedades
	List<String> getCircuitos();

	List<Integer> getPuntos();

	Integer getPuntuacionTotal();

	// Operaciones
	void puntuar(String circuito, Integer puntos);

	Integer obtenerPuntuacion(String circuito);
}