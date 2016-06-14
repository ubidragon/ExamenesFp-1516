package src.fp.ciclismo.tipos;

import java.util.List;
import java.util.Map;

public class FactoriaCiclista {


	public static <T> List<T> leeFichero(String nombreFichero, Function<String, T> funcion_deString_aT) {
		List<T> res = null;
		try {
			res = Files.lines(Paths.get(nombreFichero)).map(funcion_deString_aT).collect(Collectors.toList());
		} catch (IOException e) {
			System.out.println("Error en lectura del fichero: " + nombreFichero);
		}
		return res;
	}

	private static Map<String, List<Ciclista>> creaCiclista = new HashMap<String, List<Ciclista>>();

	public static void actualizaPobsCiclista(List<Ciclista> c) {
		creaCiclista.put(c.getPais(), c);
	}

	/*********** CONSTRUCTOR APARTIR DE STRING ***********/
	public static Ciclista createCiclista(String s) {

		// Genera un nuevo ciclista en base al String
		Ciclista res = new CiclistaImpl(s);

		// Añade el ciclista al Set por eso se actualiza
		actualizaPobsCiclista(res);

		return res;

	}

	/*********** CONSTRUCTOR APARTIR DE FICHERO ***********/

	public static List<Ciclista> createCiclistas(String nombreFichero) {

		List<Ciclistas> res = leeFichero(nombreFichero, s ->createCiclista(s));

		return res;

	}

	public static List<Ciclista> getCiclistasPorPais(String pais){
      return creaCiclista.get(pais);
    }

}
