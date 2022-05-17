package logicadevalidacion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Alejandra Merino
 */
public class ValidacionCliente extends Validacion {

	public void validarDatosCliente(String pNum, String pCorreo) {
		validarTelefono(pNum);
		validarCorreo(pCorreo);
	}

	public void validarTelefono(String pNum) {
		if (!validarNumeroTelefonico(pNum)) {
			esValido = false;
			resultado += "Debe ingresar un número telefónico válido\n";
		}
	}

	public void validarCorreo(String pCorreo) {
		if (!validarCorreoElectronico(pCorreo)) {
			esValido = false;
			resultado += "Debe ingresar un correo electrónico válido";
		}
	}

	public static boolean validarNumeroTelefonico(String pNum) {
		Pattern patron = Pattern.compile("^\\d{8}$");
		Matcher compara = patron.matcher(pNum);
		return compara.matches();
	}

	public static boolean validarCorreoElectronico(String pCorreo) {
		Pattern patron = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher compara = patron.matcher(pCorreo);
		return compara.matches();
	}

}
