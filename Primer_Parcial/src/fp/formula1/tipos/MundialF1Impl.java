package src.fp.formula1.tipos;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;

/*EJERCICIO 3

MundialF1 describe al tipo Mundial de Fórmula 1 a través de las propiedades calendario (conjunto ordenado de
carreras), el año en el que se celebra y las puntuaciones obtenidas por los pilotos que participan en el mundial.
Se pide que escriba el siguiente código de la clase MundialF1Impl:
a) (0.5 puntos) Operación posterioresA(carrera), que devuelve una lista con las carreras que se celebran
en una fecha posterior a la carrera.
b) (0.75 puntos) Operación puntuarCarrera(carrera), que puntúe a todos los pilotos de la carrera en función
del puesto en el que terminaron.
c) (0.75 puntos) Operación carrerasGanadas (piloto), que devuelve el número de carreras que ha ganado
el piloto. En el caso de que el piloto no se haya clasificado en ninguna carrera del calendario esta operación
devuelve cero.
d) (1 punto) Operación masCarrerasGanadas(), que devuelve el nombre del piloto que mayor número de
carreras ha ganado en el mundial.
e) (1 punto) Operación ganaEnCasa(), que devuelve el primer piloto del calendario que gana en casa, es
decir, que el país del circuito es el mismo que el país de origen del piloto. En caso de no existir ningún
piloto que haya ganado en casa la operación debe elevar la excepción NoSuchElementException.
f) (1 punto) Operación existeGanador(String pais, Integer n), que devuelve true si existe al menos un
piloto del país dado que ha ganado n o más carreras, y false en caso contrario.

*/

public class MundialF1Impl implements MundialF1{

	private Integer anyo;
	private SortedSet<CarreraF1> calendario;
	private Set<PilotoF1Puntuado> pilotos;

	public MundialF1Impl(Integer anyo, SortedSet<CarreraF1> calendario, Set<PilotoF1Puntuado> pilotos) {
		this.anyo = anyo;
		this.calendario = new TreeSet<CarreraF1>();
		this.pilotos = new HashSet<PilotoF1Puntuado>();

	}	

	public List<CarreraF1> posterioresA(CarreraF1 c) {
		List<CarreraF1> result = new ArrayList<CarreraF1>(this.calendario.tailSet(c));
		result.remove(c);
		return result;
	}

	public void puntuarCarrera(CarreraF1 c) {
		for (PilotoF1Puntuado p : this.pilotos) {
			Integer puntuacion = c.obtenerPuntuacionPiloto(p);
			p.puntuar(c.getCircuito(), puntuacion);
		}
	}

	public Integer carrerasGanadas(PilotoF1 p) {
		Integer result = 0;
		for (CarreraF1 c : this.calendario) {
			if (carreraGanada(c, p)) {
				result++;
			}
		}
		return result;
	}
	private Boolean carreraGanada(CarreraF1 c, PilotoF1 p) {
		return c.getClasificacion().indexOf(p) == 0;
	}

	public String masCarrerasGanadas() {
		PilotoF1Puntuado result = null;
		Integer max = 0;
		for (PilotoF1Puntuado p : pilotos) {
			if (result == null || carrerasGanadas(p) > max) {
				result = p;
				max = carrerasGanadas(p);
			}
		}
		if (result == null){
			throw new NoSuchElementException();
		}
		return result.getNombre();
	}

	public PilotoF1 ganaEnCasa(){
		PilotoF1 result = null;
		for(CarreraF1 c: calendario){
			if (c.getPais().equals(pilotoGanador(c).getPais())){
				result=pilotoGanador(c);
				break;
			}
		}
		if (result == null)
			throw new NoSuchElementException();
		return result;
	}
	private PilotoF1 pilotoGanador(CarreraF1 c){
		return c.getClasificacion().get(0);
	} 

	public Boolean existeGanador(String pais, Integer nCarreras) {
		Boolean result = false;
		for (PilotoF1 p : this.pilotos) {
			if (p.getPais().equals(pais) && carrerasGanadas(p) > nCarreras) {
				result = true;
				break;
			}
		}
		return result;
	}

	public Integer getA�o() {

		return anyo;
		
	}

	public SortedSet<CarreraF1> getCalendario() {

		return new TreeSet<CarreraF1>();
		
	}

	public Set<PilotoF1Puntuado> getPilotos() {
		
		return new HashSet<PilotoF1Puntuado>();
		
	}

}