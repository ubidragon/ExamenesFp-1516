package src.fp.ciclismo.tipos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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
		creaCiclista.put(((Ciclista)c).getPais(), c);
	}

	/*********** CONSTRUCTOR APARTIR DE STRING ***********/
	public static Ciclista createCiclista(String s) {

		// Genera un nuevo ciclista en base al String
		Ciclista res = new CiclistaImpl(s);

		// Añade el ciclista al Set por eso se actualiza
		actualizaPobsCiclista((List<Ciclista>) res);

		return res;

	}

	/*********** CONSTRUCTOR APARTIR DE FICHERO ***********/

	public static List<Ciclista> createCiclistas(String nombreFichero) {

		List<Ciclista> res = leeFichero(nombreFichero, s ->createCiclista(s));

		return res;

	}

	public static List<Ciclista> getCiclistasPorPais(String pais){
      return creaCiclista.get(pais);
    }

}
