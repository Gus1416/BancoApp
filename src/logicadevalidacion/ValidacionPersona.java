package logicadevalidacion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Alejandra Merino
 */
public class ValidacionPersona extends Validacion {

	public void validarDatosPersona(String apellido1, String apellido2,
					String pNombre, String pID) {
		validarApellido12(apellido1);
		validarApellido12(apellido2);
		validarNombres(pNombre);
		validarID(pID);
		System.out.println();
	}

	public void validarApellido12(String pCadena) {
		if (!validarApellido(pCadena)) {
			esValido = false;
			resultado += "Debe utilizar el alfabeto en inglés\n";
		}
	}

	public void validarNombres(String pCadena) {
		if (!validarNombre(pCadena)) {
			esValido = false;
			resultado += "Debe utilizar el alfabeto en inglés\n";
		}
	}

	public void validarID(String pNum) {
		if (!validarIdentificacion(pNum)) {
			esValido = false;
			resultado += "Debe ingresar un número de identificación válido\n";
		}
	}
	
	//Valida los caracteres de un apellido. No recibe la letra ñ.
	public static boolean validarApellido(String pCadena) {
		Pattern patron = Pattern.compile("^([a-zA-Z][a-zA-Z\\ $]*)$");
		Matcher compara = patron.matcher(pCadena);
		return compara.matches();
	}

	//Valida los caracteres de un nombre. No recibe la letra ñ.
	public static boolean validarNombre(String pCadena) {
		Pattern patron = Pattern.compile("^([a-zA-Z][a-zA-Z\\ $]*)$");
		Matcher compara = patron.matcher(pCadena);
		return compara.matches();
	}

	public static boolean validarIdentificacion(String pNum) {
		Pattern patron = Pattern.compile("^\\d{9}$");
		Matcher compara = patron.matcher(pNum);
		return compara.matches();
	}

}
