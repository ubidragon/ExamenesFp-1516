package src.fp.ciclismo.tipos

import java.util.Set;

public class EtapaImpl implements Etapa{

	private LocalDate fecha ;
	private String salida;
	private String llegada;

	public EtapaImpl(LocalDate fecha, String salida, String llegada){

		this.fecha = fecha;
		this.salida = salida;
		this.llegada = llegada;

	}

	/*********** GETTERS & SETTERS ***********/	
	public LocalDate getFecha(){

		return fecha;

	}

	public String getSalida(){

		return salida;

	}

	public String getLlegada(){

		return llegada;

	}

	public Set<Ciclista> getCiclistas(){


	}						
	public Ciclista getGanador(){


	}								
	public Integer getTiempoCiclista(Ciclista c){


	}				
	public Set<Ciclista> getCiclistasTiempo(Integer tiempo){


	}	
	
	public void añadirCiclista(Ciclista c, Integer tiempo){


	}
	public void bonificarCiclista(Ciclista c, Integer tiempo){


	}
	public void eliminarCiclista(Ciclista c){


	}


	/*******EQUALS HASHCODE COMPARETO**********/

	public boolean equals(Object o) {

		boolean result = false;

		if (o instanceof Etapa) {

			Etapa et =  (Etapa) o;
			result = this.getFecha().equals(et.getFecha());

		}

		return result;

	}

	public int hashCode() {

		return this.getFecha().hashCode()*31;

	}

	public int compareTo (Etapa et) {

		return this.getFecha().compareTo(et.getFecha());

	}

	public String toString(){

		return "Fecha de la Etapa: "+ getFecha();

	}


}
