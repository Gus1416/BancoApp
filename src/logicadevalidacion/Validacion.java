package logicadevalidacion;

/**
 *
 * @author Alejandra Merino
 */
public class Validacion {

	public static boolean esValido = true;
	public String resultado = "";

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String getResultado() {
		return resultado;
	}

	public boolean esValido() {
		return esValido;
	}

	public void setValido() {
		this.esValido = true;
	}
}
