package src.fp.ciclismo.excepciones;

public class ExcepcionCiclistaNoValido extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionCiclistaNoValido() {

		super();

	}

	public ExcepcionCiclistaNoValido(String string) {

		super(string);

	}

}