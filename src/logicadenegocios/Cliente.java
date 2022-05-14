package logicadenegocios;

import java.util.ArrayList;
import java.util.Date;

/**
 * Clase que representa al cliente
 * 
 * @author Gustavo
 */
public class Cliente extends Persona {
	private String numeroTelefono;
	private String correoElectronico;
	private String codigoCliente;
	private static int cantidadClientes = 0;
	private ArrayList<Cuenta> cuentas;
	
	public Cliente (String pIdentificacion, String pPrimerApellido, String pSegundoApellido, String pNombre, Date pFechaNacimiento, String pNumeroTelefono, String pCorreoElectronico){
		super(pIdentificacion, pPrimerApellido, pSegundoApellido, pNombre, pFechaNacimiento);
		numeroTelefono = pNumeroTelefono;
		correoElectronico = pCorreoElectronico;
		codigoCliente = "CIF_" + ++cantidadClientes;
		cuentas = new ArrayList<>();
	}
        
        public Cliente (String pIdentificacion, String pPrimerApellido, String pSegundoApellido, String pNombre, Date pFechaNacimiento, String pNumeroTelefono, String pCorreoElectronico, int pNum){
		super(pIdentificacion, pPrimerApellido, pSegundoApellido, pNombre, pFechaNacimiento);
		cantidadClientes = pNum;
                numeroTelefono = pNumeroTelefono;
		correoElectronico = pCorreoElectronico;
		codigoCliente = "CIF_" + ++cantidadClientes;
		cuentas = new ArrayList<>();
	}

        public Cliente() {
          throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
        
	
	@Override
	public String toString(){
		String mensaje = super.toString();
		mensaje += "Número de teléfono: " + getNumeroTelefono() + "\n";
		mensaje += "Correo electrónico: " + getCorreoElectronico() + "\n";
		mensaje += "Código de cliente: " + getCodigoCliente() + "\n";
		return mensaje;
	}

	
	
	/**
	 * @return the numeroTelefono
	 */
	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	/**
	 * @return the correoElectronico
	 */
	public String getCorreoElectronico() {
		return correoElectronico;
	}

	/**
	 * @return the codigoCliente
	 */
	public String getCodigoCliente() {
		return codigoCliente;
	}

	/**
	 * @return the cantidadClientes
	 */
	public static int getCantidadClientes() {
		return cantidadClientes;
	}

	/**
	 * @param codigoCliente the codigoCliente to set
	 */
	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
}

