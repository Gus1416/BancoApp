package logicadenegocios;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import logicadevalidacion.FondosInsuficientesExcepcion;
import serviciosexternos.TipoCambio;

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

	public Cuenta(String pPin, double pMontoInicial, Date fechaCreacion) {
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

	public void determinarCobroComisionRetiro(double pMontoRetiro) {
		if (contarDepositosRetiro() > 3) {
			double comision = pMontoRetiro * 0.2;
			try {
				retirar(pMontoRetiro, true, comision);
			} catch (FondosInsuficientesExcepcion ex) {
				Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
			}
		} else {
			try {
				retirar(pMontoRetiro, false, 0);
			} catch (FondosInsuficientesExcepcion ex) {
				Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	public void depositar(double pMontoDeposito) {
	}

	private void retirar(double pMontoRetiro, boolean pSeCobraComision, double pMontoComision) throws FondosInsuficientesExcepcion {
		double retiroTotal = pMontoRetiro + pMontoComision;
		if (retiroTotal <= saldo) {
			saldo -= retiroTotal;
			registrarOperacion("Retiro", pMontoRetiro, pSeCobraComision, pMontoComision, "Colones");
		} else {
			double requiere = retiroTotal - saldo;
			throw new FondosInsuficientesExcepcion(requiere);
		}
	}

	private void retirarDolares(double pMontoRetiro, boolean pSeCobraComision, double pMontoComision) throws FondosInsuficientesExcepcion {
		double retiroTotal = pMontoRetiro + pMontoComision;
		if (retiroTotal <= saldo) {
			saldo -= retiroTotal;
			registrarOperacion("Retiro", pMontoRetiro, pSeCobraComision, pMontoComision, "Dólares");
		} else {
			double requiere = retiroTotal - saldo;
			throw new FondosInsuficientesExcepcion(requiere);
		}
	}
	
	public void determinarCobroComisionRetiroDolares(double pMontoRetiro) {
		double montoColones;
		TipoCambio tc = new TipoCambio();
		montoColones = tc.convertirAColones(pMontoRetiro);
		if (contarDepositosRetiro() > 3) {
			double comision = montoColones * 0.2;
			try {
				retirarDolares(montoColones, true, comision);
			} catch (FondosInsuficientesExcepcion ex) {
				Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
			}
		} else {
			try {
				retirarDolares(montoColones, false, 0);
			} catch (FondosInsuficientesExcepcion ex) {
				Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
	
	private void registrarOperacion(String pTipoOperacion, double pMontoOperacion, boolean pSeCobraComision, double pMontoComision, String pMoneda) {
		Operacion operacion = new Operacion(obtenerFechaSistema(), pTipoOperacion, pMontoOperacion, pSeCobraComision, pMontoComision, pMoneda);
		operaciones.add(operacion);
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

	private ArrayList obtenerListaDepositos() {
		ArrayList depositos = new ArrayList<Operacion>();
		for (Operacion operacion : this.operaciones) {
			if (operacion.getTipoOperacion().equals("Depósito")) {
				depositos.add(operacion);
			}
		}
		return depositos;
	}

	private ArrayList obtenerListaRetiros() {
		ArrayList retiros = new ArrayList<Operacion>();
		for (Operacion operacion : this.operaciones) {
			if (operacion.getTipoOperacion().equals("Retiros")) {
				retiros.add(operacion);
			}
		}
		return retiros;
	}

	@Override
	public boolean comparar(Comparable b) {
		return false;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	@Override
	public String toString() {
		return "Cuenta{" + "numeroCuenta=" + numeroCuenta + ", fechaCreacion=" + fechaCreacion + ", saldo=" + saldo + ", estatus=" + estatus + ", pin=" + pin + ", operaciones=" + operaciones + '}';
	}
}
