package src.fp.formula1.tipos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import src.fp.formula1.excepciones.ExcepcionCarreraF1OperacionNoPermitida;

/*EJERCICIO 2

CarreraF1 describe al tipo carrera de Fórmula 1 a través de las propiedades circuito en el que se celebra la
carrera, país en el que se celebra y fecha en la que se celebra. Además, cuenta con otras dos propiedades que
representan a la parrilla de salida (lista de pilotos ordenada por la posición en la que salen los pilotos) y la
clasificación (lista de pilotos ordenada por la posición en la que finalizan los pilotos la carrera).
Se pide que escriba el siguiente código de la clase CarreraF1Impl:
a) (0.5 puntos) Los métodos equals, hashCode y compareTo teniendo en cuenta que dos carreras son iguales
si lo son las fechas en las que se celebran, y que el orden natural es también por la fecha en la que se
celebran las carreras.
b) (0.5 puntos) Operación obtenerPuntuacionPiloto(piloto) que devuelve la puntuación que ha obtenido el
piloto en función de la posición que ocupa en la clasificación de la siguiente forma:
Puesto Puntos Puesto Puntos
1º 25 puntos 6º 8 puntos
2º 18 puntos 7º 6 puntos
3º 15 puntos 8º 4 puntos
4º 12 puntos 9º 2 puntos
5º 10 puntos 10º 1 punto
Si el piloto se clasifica a partir de la posición undécima obtiene cero puntos. Si el piloto no está en la lista de
clasificados se elevará la excepción ExcepcionCarreraF1OperaciónNoPermitida. No tiene que escribir el
código de la excepción.
c) (0.5 puntos) Operación lineaDeSalida(piloto), que devuelve la línea que ocupa el piloto en la parrilla de
salida, teniendo que cuenta que cada línea tiene dos pilotos. Por ejemplo, un piloto que ocupa la posición 11º
en la parrilla, saldrá en la 6ª línea de salida. Si el piloto no está en la parrilla de salida se elevará la excepción
ExcepcionCarreraF1OperaciónNoPermitida. No tiene que escribir el código de la excepción.
d) (0.5 puntos) Operaciones primerosParrillaSalida(n) y primerosClasificacion(n), que devuelven la lista de
pilotos que ocupan las primeras n posiciones de la parrilla de salida y de la clasificación, respectivamente. Si
n tiene un valor mayor que el número de pilotos que hay en la parrilla de salida o en la clasificación, devolverán
todos los pilotos de la parrilla de salida o de la clasificación, respectivamente.
e) (1 punto) Operación parrillaYClasificacion(n), que devuelve el conjunto de pilotos que salieron entre las n
primeras posiciones de la parrilla de salida y han quedado entre los n primeros puestos de la clasificación, es
decir, que están entre los n primeros de la parrilla y de la clasificación.

*/

public class CarreraF1Impl implements CarreraF1 {

	private String circuito;
	private String pais;
	private LocalDate fecha;
	private List<PilotoF1> parrillaSalida;
	private List<PilotoF1> clasificacion;

	/************* CONSTRUCTOR *************/

	public CarreraF1Impl(String circuito, String pais, LocalDate fecha, List<PilotoF1> parrillaSalida,
			List<PilotoF1> clasificacion) {

		this.circuito = circuito;
		this.pais = pais;
		this.fecha = fecha;
		parrillaSalida = new ArrayList<PilotoF1>();
		clasificacion = new ArrayList<PilotoF1>();

	}

	/************* GETTERS & SETTERS *************/

	public String getCircuito() {

		return circuito;

	}

	public String getPais() {

		return pais;

	}

	public LocalDate getFecha() {

		return fecha;

	}

	public List<PilotoF1> getParrillaSalida() {

		return new ArrayList<PilotoF1>(parrillaSalida);

	}

	public List<PilotoF1> getClasificacion() {

		return new ArrayList<PilotoF1>(clasificacion);

	}

	private static final Integer[] PUNTUACIONES = { 25, 18, 15, 12, 10, 8, 6, 4, 2, 1 };

	public Integer obtenerPuntuacionPiloto(PilotoF1 p) {

		Integer result = 0;
		Integer pos = this.clasificacion.indexOf(p);

		if (pos == -1) {

			throw new ExcepcionCarreraF1OperacionNoPermitida();

		}

		if (pos < PUNTUACIONES.length) {

			result = PUNTUACIONES[pos];

		}

		return result;

	}

	public Integer lineaDeSalida(PilotoF1 p) {

		Integer result = 0;
		Integer pos = this.parrillaSalida.indexOf(p);

		if (pos != -1) {

			result = (pos / 2) + 1;

		} else {

			throw new ExcepcionCarreraF1OperacionNoPermitida();

		}

		return result;

	}

	public List<PilotoF1> primerosParrillaSalida(Integer n) {

		return primeros(n, parrillaSalida);

	}

	public List<PilotoF1> primerosClasificacion(Integer n) {

		return primeros(n, clasificacion);

	}

	private List<PilotoF1> primeros(Integer n, List<PilotoF1> lp) {

		List<PilotoF1> result = new ArrayList<PilotoF1>();

		if (n > lp.size()) {

			n = lp.size();

		}

		if (n > 0) {

			result = new ArrayList<PilotoF1>(lp.subList(0, n));

		}

		return result;

	}

	public Set<PilotoF1> parrillaYClasificacion(Integer n) {

		Set<PilotoF1> result = new HashSet<PilotoF1>(primerosParrillaSalida(n));
		result.retainAll(primerosClasificacion(n));
		return result;

	}

	/************* EQUALS HASHCODE COMPARETO *************/

	public boolean equals(Object o) {

		boolean result = false;

		if (o instanceof CarreraF1) {

			CarreraF1 c = (CarreraF1) o;
			result = this.getFecha().equals(c.getFecha());

		}

		return result;

	}

	public int hashCode() {

		return this.getFecha().hashCode() * 31;

	}

	public int compareTo(CarreraF1 c) {

		return this.getFecha().compareTo(c.getFecha());

	}

}