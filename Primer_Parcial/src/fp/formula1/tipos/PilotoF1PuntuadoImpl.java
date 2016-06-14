package src.fp.formula1.tipos;

import java.util.ArrayList;
import java.util.List;

import src.fp.formula1.excepciones.ExcepcionPilotoF1PuntuadoOperacionNoPermitida;

/*EJERCICIO 1

PilotoF1 describe al tipo piloto de FÃ³rmula 1 a travÃ©s de su nombre, la escuderÃ­a en la que compite y su paÃ­s
de origen. La clase que lo implementa cuenta con un Ãºnico constructor al que se le pasan el nombre, la escuderÃ­a
y el paÃ­s, en este mismo orden.
PilotoF1Puntuado representa a un piloto de FÃ³rmula 1 con las puntuaciones obtenidas en los distintos circuitos
a lo largo de un mundial. Tiene las siguientes propiedades:
ï‚· Circuitos: lista de circuitos en los que ha puntuado el piloto.
ï‚· Puntos: lista con las puntuaciones obtenidas por el piloto. La posiciÃ³n i-Ã©sima de esta lista almacena la puntuaciÃ³n
obtenida por el piloto en el circuito i-Ã©simo.
ï‚· PuntuacionTotal: suma de todas las puntuaciones.
Se pide que escriba el siguiente cÃ³digo de la clase PilotoF1PuntuadoImpl:
a) (0.25 puntos) Cabecera y constructor de la clase, al que se le pasan el nombre, la escuderÃ­a y el paÃ­s como
parÃ¡metros. Inicialmente se considera que el piloto no ha puntuado en ningÃºn circuito.
b) (0.25 puntos) Propiedad PuntuacionTotal, que se calcula como la suma de las puntuaciones obtenidas por
el piloto en todos los circuitos.
c) (0.5 puntos) OperaciÃ³n puntuar(circuito, puntos). Si el piloto ya tiene una puntuaciÃ³n para el circuito, esta
operaciÃ³n la sustituye por los nuevos puntos. En caso contrario, la aÃ±ade como una puntuaciÃ³n nueva. Los
puntos que obtiene un piloto en un circuito es un entero entre 0 y 25, ambos valores incluidos. En caso de
intentar puntuar a un piloto con un valor no permitido se debe elevar la excepciÃ³n ExcepcionPilotoF1PuntuadoOperacionNoPermitida.
No es necesario escribir el cÃ³digo de dicha excepciÃ³n.
d) (0.5 puntos) OperaciÃ³n obtenerPuntuacion(circuito). Devuelve la puntuaciÃ³n obtenida por el piloto en el
circuito. En el caso de que el piloto no tenga ninguna puntuaciÃ³n para el circuito debe devolver cero.
e) (0.5 puntos) MÃ©todo main que realice las siguientes acciones:
o Crear un piloto puntuado con los siguientes datos:
ï‚§ Nombre: â€œLewis Hamiltonâ€�
ï‚§ EscuderÃ­a: â€œMercedesâ€�
ï‚§ PaÃ­s: â€œUKâ€�
ï‚§ Circuitos: [â€œMÃ³nacoâ€�,â€�Shanghaiâ€�]
ï‚§ Puntos: [25, 18]
o Mostrar por pantalla la puntuaciÃ³n total.
o Mostrar por pantalla la puntuaciÃ³n obtenida en el circuito de â€œMÃ³nacoâ€�.

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

			throw new ExcepcionPilotoF1PuntuadoOperacionNoPermitida("La puntuaciÃ³n debe estar en [0,25]");

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

	public List<String> getCircuitos() {
		
		return  new ArrayList<String>(circuitos);
		
	}

	public List<Integer> getPuntos() {
	
		return  new ArrayList<Integer>(puntos);
		
	}

	


}