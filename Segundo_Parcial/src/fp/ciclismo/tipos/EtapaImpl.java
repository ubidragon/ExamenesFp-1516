package src.fp.ciclismo.tipos;

import java.time.LocalDate;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import src.fp.ciclismo.excepciones.ExcepcionBonificacionCiclistaNoValida;
import src.fp.ciclismo.excepciones.ExcepcionTiempoCiclistaNoValido;

public class EtapaImpl implements Etapa {
	
	private LocalDate fecha;
	private String salida;
	private String llegada;
	private static SortedMap<Ciclista, Integer> ciclistaTiempo = new TreeMap<Ciclista, Integer>();

	public EtapaImpl(LocalDate fecha, String salida, String llegada) {

		this.fecha = fecha;
		this.salida = salida;
		this.llegada = llegada;

	}

	/*********** GETTERS & SETTERS ***********/
	public LocalDate getFecha() {

		return fecha;

	}

	public String getSalida() {

		return salida;

	}

	public String getLlegada() {

		return llegada;

	}

	public Set<Ciclista> getCiclistas() {
		 //se usa el keySet, si no la lista es vacia, tu aññades los 
		//ciclistas al map, y con esto los sacas todos, por eso te salia vacio
	    return ciclistaTiempo.keySet();

	}

	public Ciclista getGanador() {
		return null;

	}

	public Integer getTiempoCiclista(Ciclista c) {
		
		Integer tiempo = null;
		
		if(ciclistaTiempo.containsKey(c)){
			tiempo = ciclistaTiempo.get(c).intValue();
		}
		
		return tiempo;

	}

	public Set<Ciclista> getCiclistasTiempo(Integer tiempo) {
		return null;

	}

//	public void añadirCiclista(Ciclista c, Integer tiempo) {
//		
//		
//		if(tiempo < 0){
//			throw new ExcepcionTiempoCiclistaNoValido("El tiempo es inferior a 0");
//		}
//		
//		for (Ciclista cli : getCiclistas()) {
//			
//			if (getCiclistas().contains(cli)) {
//				ciclistaTiempo.replace(c, tiempo);
//			}else{
//				ciclistaTiempo.put(cli, tiempo);
//			}
//
//		}
//		
//				
//	}
	
	public void añadirCiclista(Ciclista c, Integer tiempo) {
	    
	    
	    if(tiempo < 0){
	      throw new ExcepcionTiempoCiclistaNoValido("El tiempo es inferior a 0");
	    }

	      if (!ciclistaTiempo.keySet().contains(c)) {
	        
	        ciclistaTiempo.put(c, tiempo);
	      }else{
	        ciclistaTiempo.replace(c, tiempo);
	      }
	    
	        
	  }

	public void bonificarCiclista(Ciclista c, Integer tiempo) {
		
		if(ciclistaTiempo.containsKey(c)){
		Integer t =ciclistaTiempo.get(c).intValue();
		Integer op= t-tiempo;
		if(op < 0){
			throw new ExcepcionBonificacionCiclistaNoValida("Ciclista inexistente");
			
		}
		
		ciclistaTiempo.replace(c, op);
		}
				
	}

	public void eliminarCiclista(Ciclista c) {

		ciclistaTiempo.remove(c);
		
		
	}

	 
	

	/******* EQUALS HASHCODE COMPARETO **********/

	public boolean equals(Object o) {

		boolean result = false;

		if (o instanceof Etapa) {

			Etapa et = (Etapa) o;
			result = this.getFecha().equals(et.getFecha());

		}

		return result;

	}

	public int hashCode() {

		return this.getFecha().hashCode() * 31;

	}

	public int compareTo(Etapa et) {

		return this.getFecha().compareTo(et.getFecha());

	}

	public String toString() {

		return "Fecha de la Etapa: " + getFecha();

	}

}
