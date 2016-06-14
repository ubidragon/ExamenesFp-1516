package fp.ciclismo.tipos

public class CiclistaImpl implements Ciclista{

	private String nombre ;
	private LocalDate fechaNacimiento ;
	private String pais;

	/*********** CONSTRUCTOR ***********/
	public CiclistaImpl(String nombre, LocalDate fechaNacimiento, String pais) {

		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.pais = pais;

	}

	/*********** CONSTRUCTOR APARTIR DE STRING ***********/

	public CiclistaImpl(String s){
		// Ejemplo de formato de la cadena de entrada:
		// Alberto Contador # España # 06/12/1982

		String[] trozos = s.split("#");

		if (campos.length != 3) {
			throw new IllegalArgumentException("El formato de la cadena de entrada no es correcto.");
		}

		String nombre = trozos[0].trim();
		LocalDate fechaNacimiento = new LocalDate.parse(trozos[1].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String pais = trozos[2].trim();


		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.pais = pais;


	}


	/*********** EXCEPCIONES ***********/

	private void checkEdad(LocalDate fechaNacimiento){

		Integer edad = (int) getFechaNacimiento().until(LocalDate.now(), ChronoUnit.YEARS);

		if(edad < 18){
			throw new ExcepcionCiclistaNoValido("El ciclista tiene una edad inferior a 18");
		}

	}

	/*********** GETTERS & SETTERS ***********/	

	public String getNombre(){

		return nombre;

	}

	public LocalDate getFechaNacimiento(){

		return fechaNacimiento;
	}

	public String getPais(){

		return pais;

	}

	/*******EQUALS HASHCODE COMPARETO**********/

	public boolean equals(Object o) {

		boolean result = false;

		if (o instanceof Ciclista) {

		 Ciclista c =  (Ciclista) o;
			result = this.getNombre().equals(c.getNombre());

		}

		return result;

	}

	public int hashCode() {

		return this.getNombre().hashCode()*31;

	}

	public int compareTo (Ciclista c) {

		return this.getNombre().compareTo(c.getNombre());

	}




}
