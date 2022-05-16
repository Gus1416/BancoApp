package logicadenegocios;

import java.util.ArrayList;
import java.util.Date;
import logicadevalidacion.FondosInsuficientesExcepcion;

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
	protected ArrayList<Cuenta> cuentas;
   
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
        
        public void crearCuenta(String pPin, double pMontoInicial, int pNum) {
		Cuenta nuevaCuenta = new Cuenta(pPin, pMontoInicial, pNum);
		getCuentas().add(nuevaCuenta);
	}

	@Override
	public boolean comparar(Comparable b) {
		return getNombre().compareTo(((Persona) b).getNombre()) <= 0;
	}
        
        public String toStringCuentas () {
          String mensaje = "Los numeros de cuenta son: \n";
            for (Cuenta cuenta: cuentas){
              mensaje+=cuenta.getNumeroCuenta() +"\n";
            }
          return mensaje;
        }

	@Override
	public String toString() {
		String mensaje;
		mensaje = "Primer apellido: " + getPrimerApellido() + "\nSegundo apellido: "
						+ getSegundoApellido() + "\nNombre: " + getNombre() + "\nIdentificacion: "
						+ getIdentificacion() + "\nFecha de nacimiento: " + getFechaNacimiento();
		return mensaje;
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