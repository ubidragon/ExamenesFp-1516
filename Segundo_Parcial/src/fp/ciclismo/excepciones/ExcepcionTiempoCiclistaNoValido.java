package src.fp.ciclismo.excepciones;

public class ExcepcionTiempoCiclistaNoValido extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionTiempoCiclistaNoValido() {

		super();

	}

	public ExcepcionTiempoCiclistaNoValido(String string) {

		super(string);

	}

}