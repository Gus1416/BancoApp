package logicadenegocios;

import java.util.Date;

/**
 * Clase que representa al cliente
 * 
 * @author Gustavo
 */
public class Cliente extends Persona{
	private String numeroTelefono;
	private String correoElectronico;
	private String codigoCliente;
	private static int cantidadClientes = 0;
	
	Cliente (String pPrimerApellido, String pSegundoApellido, String pNombre, String pIdentificacion, Date pFechaNacimiento, String pNumeroTelefono, String pCorreoElectronico){
		super(pPrimerApellido, pSegundoApellido, pNombre, pIdentificacion, pFechaNacimiento);
		numeroTelefono = pNumeroTelefono;
		correoElectronico = pCorreoElectronico;
		codigoCliente = "CIF_" + ++cantidadClientes;
	}
	
	@Override
	public String toString(){
		String mensaje = super.toString();
		mensaje += "Número de teléfono: " + numeroTelefono + "\n";
		mensaje += "Correo electrónico: " + correoElectronico + "\n";
		mensaje += "Código de cliente: " + codigoCliente + "\n";
		return mensaje;
	}
}
