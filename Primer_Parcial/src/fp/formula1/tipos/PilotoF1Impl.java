package src.fp.formula1.tipos;

public class PilotoF1Impl implements PilotoF1 {

	private String nombre;
	private String escuderia;
	private String pais;

	public PilotoF1Impl(String nombre, String escuderia, String pais) {

		this.nombre = nombre;
		this.escuderia = escuderia;
		this.pais = pais;

	}

	public String getNombre() {

		return nombre;

	}

	public String getEscuderia() {

		return escuderia;

	}

	public String getPais() {

		return pais;

	}

}