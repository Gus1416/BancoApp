package logicadevalidacion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Alejandra Merino
 */
public class ValidacionPersona {

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
