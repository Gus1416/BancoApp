package logicadenegocios;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Gustavo
 */
public class Persona implements Comparable {

	protected String primerApellido;
	protected String segundoApellido;
	protected String nombre;
	protected String identificacion;
	protected Date fechaNacimiento;
	private ArrayList<Cuenta> cuentas;

	public Persona(String pPrimerApellido, String pSegundoApellido, String pNombre, String pIdentificacion, Date pFechaNacimiento) {
		primerApellido = pPrimerApellido;
		segundoApellido = pSegundoApellido;
		nombre = pNombre;
		identificacion = pIdentificacion;
		fechaNacimiento = pFechaNacimiento;
		cuentas = new ArrayList<>();
	}

	public void crearCuenta(String pPin, double pMontoInicial) {
		Cuenta nuevaCuenta = new Cuenta(pPin, pMontoInicial);
		cuentas.add(nuevaCuenta);
	}

	@Override
	public boolean comparar(Comparable b) {
		return nombre.compareTo(((Persona) b).getNombre()) <= 0;
	}

	private String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		String mensaje;
		mensaje = "Primer apellido: " + primerApellido + "\nSegundo apellido: "
						+ segundoApellido + "Nombre: " + nombre + "Identificacion: "
						+ identificacion + "Fecha de nacimiento: " + fechaNacimiento;
		return mensaje;
	}
}