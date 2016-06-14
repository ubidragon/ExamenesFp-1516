package src.fp.ciclismo.excepciones;

public class ExcepcionBonificacionCiclistaNoValida extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionBonificacionCiclistaNoValida() {

		super();

	}

	public ExcepcionBonificacionCiclistaNoValida(String string) {

		super(string);

	}

}