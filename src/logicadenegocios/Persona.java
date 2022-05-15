package logicadenegocios;

import java.util.ArrayList;
import java.util.Date;
import logicadevalidacion.FondosInsuficientesExcepcion;

/**
 *
 * @author Gustavo
 */
public class Persona implements Comparable {

	private String primerApellido;
	private String segundoApellido;
	private String nombre;
	private String identificacion;
	private Date fechaNacimiento;
	private ArrayList<Cuenta> cuentas;
	
	public Persona(){}

	public Persona(String pIdentificacion, String pPrimerApellido, String pSegundoApellido, String pNombre,  Date pFechaNacimiento) {
		primerApellido = pPrimerApellido;
		segundoApellido = pSegundoApellido;
		nombre = pNombre;
		identificacion = pIdentificacion;
		fechaNacimiento = pFechaNacimiento;
		cuentas = new ArrayList<>();
	}

	public void crearCuenta(String pPin, double pMontoInicial) {
		Cuenta nuevaCuenta = new Cuenta(pPin, pMontoInicial);
		getCuentas().add(nuevaCuenta);
	}
	
//	public void transferirSaldoEntreCuentasPropias(String pNumeroCuentaOrigen, String pNumeroCuentaDestino, double pMontoTransferencia) throws FondosInsuficientesExcepcion {
//		Busqueda.buscarCuenta(pNumeroCuentaDestino, cuentas).retirarColones(pMontoTransferencia);
//		Busqueda.buscarCuenta(pNumeroCuentaOrigen, cuentas).recibirTransferencia(pMontoTransferencia);
//	}

	@Override
	public boolean comparar(Comparable b) {
		return getNombre().compareTo(((Persona) b).getNombre()) <= 0;
	}

	@Override
	public String toString() {
		String mensaje = "";
		
		mensaje += "Primer apellido: " + getPrimerApellido() + "\n";
		mensaje += "Segundo apellido: " + getSegundoApellido() + "\n";
		mensaje += "Nombre: " + getNombre() + "\n";
		mensaje += "Identificación: " + getIdentificacion() + "\n";
		mensaje += "Fecha de nacimiento: " + getFechaNacimiento() + "\n";
		return mensaje;
	}

	public String mostrarNumerosCuentaCliente() {
		String numerosCuenta = "";
		for (Cuenta cuenta : this.cuentas) {
			numerosCuenta += cuenta.getNumeroCuenta() + "\n";
		}
		return numerosCuenta;
	}

	/**
	 * @return the primerApellido
	 */
	public String getPrimerApellido() {
		return primerApellido;
	}

	/**
	 * @return the segundoApellido
	 */
	public String getSegundoApellido() {
		return segundoApellido;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the identificacion
	 */
	public String getIdentificacion() {
		return identificacion;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param cuentas the cuentas to set
	 */
	public void setCuentas(ArrayList<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	/**
	 * @return the cuentas
	 */
	public ArrayList<Cuenta> getCuentas() {
		return cuentas;
	}
}