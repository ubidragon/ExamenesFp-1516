package src.fp.formula1.tipos;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface CarreraF1 extends Comparable<CarreraF1> {
// Propiedades
	String getCircuito();
	String getPais();
	LocalDate getFecha();
	List<PilotoF1> getParrillaSalida();
	List<PilotoF1> getClasificacion();
// Operaciones
	Integer obtenerPuntuacionPiloto(PilotoF1 piloto);
	Integer lineaDeSalida(PilotoF1 piloto);
	List<PilotoF1> primerosParrillaSalida(Integer n);
	List<PilotoF1> primerosClasificacion(Integer n);
	Set<PilotoF1> parrillaYClasificacion(Integer n);
}