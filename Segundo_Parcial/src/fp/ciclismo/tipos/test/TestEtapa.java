package src.fp.ciclismo.tipos.test;

import java.time.LocalDate;

import src.fp.ciclismo.excepciones.ExcepcionBonificacionCiclistaNoValida;
import src.fp.ciclismo.excepciones.ExcepcionTiempoCiclistaNoValido;
import src.fp.ciclismo.tipos.Ciclista;
import src.fp.ciclismo.tipos.CiclistaImpl;
import src.fp.ciclismo.tipos.Etapa;
import src.fp.ciclismo.tipos.EtapaImpl;

public class TestEtapa  {

	public static void main(String[] args) {
		casoPrueba();
		casoPrueba1();
		casoPrueba2();
		
	}
	
	/************CASOS DE PRUEBA **************/
	
	private static void casoPrueba() {
		// TODO Auto-generated method stub
		Ciclista cli = new CiclistaImpl("Alberto Hernandez", LocalDate.of(1994, 02, 25), "Colombia");
		Ciclista cli2 = new CiclistaImpl("Albert Hernandez", LocalDate.of(1994, 02, 25), "Spain");
		Ciclista cli3 = new CiclistaImpl("Manolo Hernandez", LocalDate.of(1994, 02, 25), "EEUU");
		Ciclista cli4 = new CiclistaImpl("Lolo Hernandez", LocalDate.of(1994, 02, 25), "EEUU");
		
		añadirCiclista(cli, 4000);
		añadirCiclista(cli2, 6000);
		añadirCiclista(cli3, 8000);
		añadirCiclista(cli2, 1000);
		añadirCiclista(cli2, -6000);
		
		
		eliminarCiclista(cli2);
		eliminarCiclista(cli4);
		
	}
	
	private static void casoPrueba1(){
		Ciclista cli = new CiclistaImpl("Alberto Hernandez", LocalDate.of(1994, 02, 25), "Colombia");
		Ciclista cli2 = new CiclistaImpl("Albert Hernandez", LocalDate.of(1994, 02, 25), "Spain");
		Etapa et = new EtapaImpl(LocalDate.of(2009, 02, 25), "Despeñaperros", "Puerto");
		et.añadirCiclista(cli, 4000);
		tiempoCiclista(cli);
		tiempoCiclista(cli2);
	}
	
	private static void casoPrueba2() {
		Ciclista cli = new CiclistaImpl("Alberto Hernandez", LocalDate.of(1994, 02, 25), "Colombia");
		Ciclista cli2 = new CiclistaImpl("Albert Hernandez", LocalDate.of(1994, 02, 25), "Spain");
		Ciclista cli3 = new CiclistaImpl("Manolo Hernandez", LocalDate.of(1994, 02, 25), "EEUU");
		Etapa et = new EtapaImpl(LocalDate.of(2009, 02, 25), "Despeñaperros", "Puerto");
		et.añadirCiclista(cli, 4000);
		et.añadirCiclista(cli3, 4000);
		bonificacionTiempo(cli, 50);
		bonificacionTiempo(cli2, 50);
		bonificacionTiempo(cli3, 5000);
		
	}
	

	/************METODOS AUXILIARES **************/
	
	private static void añadirCiclista(Ciclista c, Integer tiempo) {

		// Alumno alum = new AlumnoImpl(String dni, String nombre, String
		// apellidos, LocalDate fechaNacimiento,
		// String email);
		try {
			
			Etapa et = new EtapaImpl(LocalDate.of(2009, 02, 25), "Despeñaperros", "Puerto");
			System.out.println("Antes de la operacion: " + et.getCiclistas());
			System.out.println("Nuevo tiempo " + tiempo);
			et.añadirCiclista(c, tiempo);
			System.out.println("Listado de Ciclistas tras añadir" + et.getCiclistas() +("\n"));
			
			


		} catch (ExcepcionTiempoCiclistaNoValido e) {

			System.out.println("\n Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! ERROR!!! LA EXCEPCION LANZADA NO ES LA REGISTRADA \n GILIPOLLAS REVISA EL CODIGO");

		}
	}
	
	private static void eliminarCiclista(Ciclista c) {

		// Alumno alum = new AlumnoImpl(String dni, String nombre, String
		// apellidos, LocalDate fechaNacimiento,
		// String email);
		try {
			
			Etapa et = new EtapaImpl(LocalDate.of(2009, 02, 25), "Despeñaperros", "Puerto");
			System.out.println("Antes de la operacion: " + et.getCiclistas());
			System.out.println("Ciclista a eliminar " + c);
			et.eliminarCiclista(c);
			System.out.println("Listado de Ciclistas tras eliminar" + et.getCiclistas()+("\n"));
			
			


		} catch (ExcepcionTiempoCiclistaNoValido e) {

			System.out.println("\n Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! ERROR!!! LA EXCEPCION LANZADA NO ES LA REGISTRADA \n GILIPOLLAS REVISA EL CODIGO");

		}
	}
	
	private static void tiempoCiclista(Ciclista c) {

		// Alumno alum = new AlumnoImpl(String dni, String nombre, String
		// apellidos, LocalDate fechaNacimiento,
		// String email);
		try {
			
			Etapa et = new EtapaImpl(LocalDate.of(2009, 02, 25), "Despeñaperros", "Puerto");
			System.out.println("Ciclista: " + c);
			System.out.println("Tiempo ciclista: " + et.getTiempoCiclista(c) + "\n");
			
		} catch (ExcepcionTiempoCiclistaNoValido e) {

			System.out.println("\n Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! ERROR!!! LA EXCEPCION LANZADA NO ES LA REGISTRADA \n GILIPOLLAS REVISA EL CODIGO");

		}
	}
	
	private static void bonificacionTiempo(Ciclista c, Integer tiempo) {

		// Alumno alum = new AlumnoImpl(String dni, String nombre, String
		// apellidos, LocalDate fechaNacimiento,
		// String email);
		try {
			
			Etapa et = new EtapaImpl(LocalDate.of(2009, 02, 25), "Despeñaperros", "Puerto");
			System.out.println("Ciclista: " + c);
			System.out.println("Tiempo ciclista: " + et.getTiempoCiclista(c));
			System.out.println("bonificacion: "+ tiempo);
			et.bonificarCiclista(c, tiempo);
			System.out.println("Tiempo final del ciclista: " + et.getTiempoCiclista(c)+"\n");
			
		} catch (ExcepcionBonificacionCiclistaNoValida e) {

			System.out.println("\n Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! ERROR!!! LA EXCEPCION LANZADA NO ES LA REGISTRADA \n GILIPOLLAS REVISA EL CODIGO");

		}
	}

}
