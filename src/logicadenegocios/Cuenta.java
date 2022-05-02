package logicadenegocios;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Alejandra Merino
 */
public class Cuenta implements IComisiones, Comparable {
	private String numeroCuenta;
	private Date fechaCreacion;
	private double saldo;
	private String estatus = "activa";
	private String pin;
	private ArrayList<Operacion> operaciones;

	public Cuenta(String pPin, double pMontoInicial) {
		pin = pPin;
		saldo = pMontoInicial;
		fechaCreacion = obtenerFechaSistema();
		operaciones = new ArrayList<>();
	}

	private Date obtenerFechaSistema() {
		Date fecha = new Date();
		return fecha;
	}

	private int contarDepositosRetiro() {
		return 1;
	}

	//Dentro de deposito, retiro, transferencia se crea una nueva operacion?
	public void depositar(double pMontoDeposito) {
	}

	@Override
	public double calcularTotalComisionesDepositos() {
		return 0;
	}

	@Override
	public double calcularTotalComisionesRetiros() {
		return 0;
	}

	@Override
	public double calcularTotalComisiones() {
		return 0;
	}

	@Override
	public boolean comparar(Comparable b) {
		return false;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void agregarOperacion(Date fechaOperacion, String tipoOperacion, boolean seCobraComision, double montoOperacion, double montoComision, String moneda) {
		Operacion ope = new Operacion(fechaOperacion, tipoOperacion, seCobraComision, montoOperacion, montoComision, moneda);
		operaciones.add(ope);
	}
}