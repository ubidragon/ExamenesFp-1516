package src.fp.ciclismo.tipos.test;

import java.time.LocalDate;

import src.fp.ciclismo.excepciones.ExcepcionTiempoCiclistaNoValido;
import src.fp.ciclismo.tipos.Ciclista;
import src.fp.ciclismo.tipos.CiclistaImpl;
import src.fp.ciclismo.tipos.Etapa;
import src.fp.ciclismo.tipos.EtapaImpl;

public class TestEtapa  {

	public static void main(String[] args) {
		casoPrueba();
		
	}
	
	private static void casoPrueba() {
		// TODO Auto-generated method stub
		Ciclista cli = new CiclistaImpl("Alberto Hernandez", LocalDate.of(1994, 02, 25), "Colombia");
		Ciclista cli2 = new CiclistaImpl("Albert Hernandez", LocalDate.of(1994, 02, 25), "Spain");
		Ciclista cli3 = new CiclistaImpl("Manolo Hernandez", LocalDate.of(1994, 02, 25), "EEUU");
		
		añadirCiclista(cli, 4000);
		añadirCiclista(cli2, 6000);
		añadirCiclista(cli3, 8000);
	}

	private static void añadirCiclista(Ciclista c, Integer tiempo) {

		// Alumno alum = new AlumnoImpl(String dni, String nombre, String
		// apellidos, LocalDate fechaNacimiento,
		// String email);
		try {
			
			Etapa et = new EtapaImpl(LocalDate.of(2009, 02, 25), "Despeñaperros", "Puerto");
			System.out.println("Antes de la operacion: " + et.getCiclistas());
			System.out.println("Nuevo tiempo " + tiempo);
			et.añadirCiclista(c, tiempo);
			System.out.println("Listado de Ciclistas tras añadir" + et.getCiclistas());
			
			


		} catch (ExcepcionTiempoCiclistaNoValido e) {

			System.out.println("\n Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! ERROR!!! LA EXCEPCION LANZADA NO ES LA REGISTRADA \n GILIPOLLAS REVISA EL CODIGO");

		}
	}

}
