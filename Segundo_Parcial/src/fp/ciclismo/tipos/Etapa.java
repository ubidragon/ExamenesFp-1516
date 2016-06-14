package src.fp.ciclismo.tipos;

import java.util.Set;

public interface Etapa extends Comparable<Etapa>{
	//Orden natural: por fecha
	//Propiedades
	LocalDate getFecha();
	String getSalida();
	String getLlegada();
	Set<Ciclista> getCiclistas();						//Derivada
	Ciclista getGanador();								//Derivada
	Integer getTiempoCiclista(Ciclista c);				//Derivada
	Set<Ciclista> getCiclistasTiempo(Integer tiempo);	//Derivada
	//Operaciones
	void añadirCiclista(Ciclista c, Integer tiempo);
	void bonificarCiclista(Ciclista c, Integer tiempo);
	void eliminarCiclista(Ciclista c);


}