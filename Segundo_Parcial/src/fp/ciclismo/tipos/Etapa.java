package src.fp.ciclismo.tipos;

import java.time.LocalDate;
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
	void a�adirCiclista(Ciclista c, Integer tiempo);
	void bonificarCiclista(Ciclista c, Integer tiempo);
	void eliminarCiclista(Ciclista c);


}