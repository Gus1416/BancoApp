package logicadenegocios;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

/**
 * Clase utilitaria que provee métodos para la encriptación y desencriptación de textos.
 *
 * @author Gustavo
 */
public class Encriptacion {

	public static String encriptar(String pTexto) {	
		Encoder encoder = Base64.getEncoder();
		return encoder.encodeToString(pTexto.getBytes());
	}

	public static String desencriptar(String pTextoEncriptado) {
		Decoder decoder = Base64.getDecoder();
		byte[] bytes = decoder.decode(pTextoEncriptado);
		return new String(bytes);
	}
}