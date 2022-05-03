package logicadenegocios;

import java.util.Date;

/**
 * Clase que representa al usuario.
 *
 * @author Gustavo
 */
public class Usuario extends Persona{

	public Usuario(String pPrimerApellido, String pSegundoApellido, String pNombre, String pIdentificacion, Date pFechaNacimiento) {
		super(pIdentificacion,pPrimerApellido, pSegundoApellido, pNombre, pFechaNacimiento);
	}
}
