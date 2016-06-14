package fp.formula1.tipos;

import java.util.List;

/*EJERCICIO 1

PilotoF1 describe al tipo piloto de Fórmula 1 a través de su nombre, la escudería en la que compite y su país
de origen. La clase que lo implementa cuenta con un único constructor al que se le pasan el nombre, la escudería
y el país, en este mismo orden.
PilotoF1Puntuado representa a un piloto de Fórmula 1 con las puntuaciones obtenidas en los distintos circuitos
a lo largo de un mundial. Tiene las siguientes propiedades:
 Circuitos: lista de circuitos en los que ha puntuado el piloto.
 Puntos: lista con las puntuaciones obtenidas por el piloto. La posición i-ésima de esta lista almacena la puntuación
obtenida por el piloto en el circuito i-ésimo.
 PuntuacionTotal: suma de todas las puntuaciones.
Se pide que escriba el siguiente código de la clase PilotoF1PuntuadoImpl:
a) (0.25 puntos) Cabecera y constructor de la clase, al que se le pasan el nombre, la escudería y el país como
parámetros. Inicialmente se considera que el piloto no ha puntuado en ningún circuito.
b) (0.25 puntos) Propiedad PuntuacionTotal, que se calcula como la suma de las puntuaciones obtenidas por
el piloto en todos los circuitos.
c) (0.5 puntos) Operación puntuar(circuito, puntos). Si el piloto ya tiene una puntuación para el circuito, esta
operación la sustituye por los nuevos puntos. En caso contrario, la añade como una puntuación nueva. Los
puntos que obtiene un piloto en un circuito es un entero entre 0 y 25, ambos valores incluidos. En caso de
intentar puntuar a un piloto con un valor no permitido se debe elevar la excepción ExcepcionPilotoF1PuntuadoOperacionNoPermitida.
No es necesario escribir el código de dicha excepción.
d) (0.5 puntos) Operación obtenerPuntuacion(circuito). Devuelve la puntuación obtenida por el piloto en el
circuito. En el caso de que el piloto no tenga ninguna puntuación para el circuito debe devolver cero.
e) (0.5 puntos) Método main que realice las siguientes acciones:
o Crear un piloto puntuado con los siguientes datos:
 Nombre: “Lewis Hamilton”
 Escudería: “Mercedes”
 País: “UK”
 Circuitos: [“Mónaco”,”Shanghai”]
 Puntos: [25, 18]
o Mostrar por pantalla la puntuación total.
o Mostrar por pantalla la puntuación obtenida en el circuito de “Mónaco”.

*/

public class PilotoF1PuntuadoImpl extends PilotoF1Impl implements PilotoF1Puntuado {

	private List<Integer> puntos;
	private List<String> circuitos;

	public PilotoF1PuntuadoImpl(String nombre, String escuderia, String pais) {

		super(nombre, escuderia, pais);

		this.puntos = new ArrayList<Integer>();
		this.circuitos = new ArrayList<String>();

	}

	/************** EXCEPCIONES **************/

	private void checkPuntuacion(Integer p) {

		if (p < 0 || p > 25) {

			throw new ExcepcionPilotoF1PuntuadoOperacionNoPermitida("La puntuación debe estar en [0,25]");

		}

	}

	/************** GETTERS & SETTERS **************/

	public Integer getPuntuacionTotal() {

		Integer result = 0;

		for (Integer p : this.puntos) {

			result += p;

		}

		return result;

	}

	public void puntuar(String c, Integer p) {
		checkPuntuacion(p);

		if (this.circuitos.contains(c)) {

			this.puntos.set(this.circuitos.indexOf(c), p);

		} else {

			this.circuitos.add(c);
			this.puntos.add(p);

		}

	}

	public Integer obtenerPuntuacion(String c) {

		Integer result = 0;
		Integer pos = this.circuitos.indexOf(c);

		if (pos != -1) {

			result = this.puntos.get(pos);

		}

		return result;

	}
	


}