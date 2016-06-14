package src.fp.formula1.tipos;

import java.util.SortedSet;
import java.util.List;
import java.util.Set;

public interface MundialF1 {
	// Propiedades
	Integer getAño();

	SortedSet<CarreraF1> getCalendario();

	Set<PilotoF1Puntuado> getPilotos();

	// Operaciones
	List<CarreraF1> posterioresA(CarreraF1 c);

	void puntuarCarrera(CarreraF1 c);

	Integer carrerasGanadas(PilotoF1 p);

	String masCarrerasGanadas();

	PilotoF1 ganaEnCasa();

	Boolean existeGanador(String pais, Integer n);
}