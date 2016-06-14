package fp.formula1.tipos.test;

import java.util.List;


public class testPilotoF1Puntuado{

public static void main(String[] args){

	PilotoF1Puntuado p = new PilotoF1PuntuadoImpl("Lewis Hamilton", "Mercedes", "UK");
	p.puntuar("Mónaco", 25);
	p.puntuar("Shanghai", 18);
	System.out.println("Puntuación total: " + p.getPuntuacionTotal());
	System.out.println("Puntuación Mónaco: " + p.obtenerPuntuacion("Mónaco"));
}


}