package logicadenegocios;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	private String estatus;
	private String pin;
	private ArrayList<Operacion> operaciones;
	private int cantidadDepositosOperaciones = 0;
	private static int identificadorCuenta = 0;  

	public Cuenta() {
	}

	public Cuenta(String pPin, double pMontoInicial) {
		pin = pPin;
		saldo = pMontoInicial;
		estatus = "activa";   
		numeroCuenta = "CTA_" + ++identificadorCuenta;  
		fechaCreacion = obtenerFechaSistema();
		operaciones = new ArrayList<>();
	}

	private Date obtenerFechaSistema() {
		Date fecha = new Date();
		return fecha;
	}

//	public void depositarColones(double pMontoDeposito){
//		boolean seCobraComision = determinarCobroComision();
//		double comision = 0.00;
//		
//		if (seCobraComision){
//			comision = pMontoDeposito * 0.02;
//		}	
//			
//		this.saldo += (pMontoDeposito + comision);	
//		registrarOperacion("Dep�sito", pMontoDeposito, seCobraComision, comision, "Colones");
//	}
	
	public void depositarColones(double pMontoDeposito, int cantidad) {
		this.cantidadDepositosOperaciones = cantidad;

		boolean seCobraComision = determinarCobroComision();
		double comision = 0.00;

		double montoRealDeposito;

		if (seCobraComision) {
			comision = pMontoDeposito * 0.02;
		}

		this.saldo += (pMontoDeposito - comision);
		montoRealDeposito = pMontoDeposito - comision;

		registrarOperacion("Dep�sito", pMontoDeposito, seCobraComision, comision, "Colones");

		System.out.println("Estimado usuario, se han depositado correctamente: " + String.format("%.2f", pMontoDeposito) + " colones");
		System.out.println("[El monto real depositado a su cuenta " + this.getNumeroCuenta() + " es de: " + String.format("%.2f", montoRealDeposito) + " colones");
		System.out.println("[El monto cobrado por concepto de comisi�n fue de: " + String.format("%.2f", comision) + " colones, que \n"
						+ "fueron rebajados autom�ticamente de su saldo actual]");
	}
	
//	public void depositarDolares(double pMontoDepositoDolares) {
//		TipoCambio tc = new TipoCambio();
//		double depositoEnColones = tc.convertirAColones(pMontoDepositoDolares);
//		boolean seCobraComision = determinarCobroComision();
//		double comision = 0.00;
//		
//		if (seCobraComision){
//			comision = depositoEnColones * 0.02;
//		} 
//		
//		this.saldo += (depositoEnColones + comision);
//		registrarOperacion("Dep�sito", pMontoDepositoDolares, seCobraComision, comision, "D�lares");
//	}
	
	public void depositarDolares(double pMontoDepositoDolares, int cantidad) {
		this.cantidadDepositosOperaciones = cantidad;
		TipoCambio tc = new TipoCambio();
		double depositoEnColones = tc.convertirAColones(pMontoDepositoDolares);
		boolean seCobraComision = determinarCobroComision();
		double comision = 0.00;
		double montoRealDeposito;

		if (seCobraComision) {
			comision = depositoEnColones * 0.02;
		}

		this.saldo += (depositoEnColones - comision);
		montoRealDeposito = depositoEnColones - comision;

		registrarOperacion("Dep�sito", pMontoDepositoDolares, seCobraComision, comision, "D�lares");

		System.out.println("Estimado usuario, se han recibido correctamente " + String.format("%.2f", pMontoDepositoDolares) + " d�lares");

		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

		System.out.println("Seg�n el BCCR, el tipo de cambio de compra del d�lar de hoy: ");
		System.out.println(formatter.format(date));

		System.out.println("El monto equivalente en colones es: " + String.format("%.2f", depositoEnColones));
		System.out.println("El monto real depositado a su cuenta " + this.getNumeroCuenta() + " es de: " + String.format("%.2f", montoRealDeposito) + " colones");
		System.out.println("El monto cobrado por concepto de comisi�n fue de: " + String.format("%.2f", comision) + " colones, que \n"
						+ "fueron rebajados autom�ticamente de su saldo actual");
	}

//	public void retirarColones(double pMontoRetiro) throws FondosInsuficientesExcepcion {
//		boolean seCobraComision = determinarCobroComision();
//		double comision = 0.00;
//		double montoTotalRetiro = pMontoRetiro;
//		
//		if (seCobraComision){
//			comision = pMontoRetiro * 0.02;
//			montoTotalRetiro += comision;
//		}
//		
//		if (validarRetiro(montoTotalRetiro)){
//			this.saldo -= (montoTotalRetiro);
//			registrarOperacion("Retiro", pMontoRetiro, seCobraComision, comision, "Colones");
//		} else {
//			double saldoFaltante = montoTotalRetiro - this.getSaldo();
//			throw new FondosInsuficientesExcepcion(saldoFaltante);
//		}
//	}
	
	public void retirarColones(double pMontoRetiro, int cantidad) throws FondosInsuficientesExcepcion {

		this.cantidadDepositosOperaciones = cantidad;
		boolean seCobraComision = determinarCobroComision();
		double comision = 0.00;
		double montoTotalRetiro = pMontoRetiro;

		if (seCobraComision) {
			comision = pMontoRetiro * 0.02;
			montoTotalRetiro += comision;
		}

		if (validarRetiro(montoTotalRetiro)) {
			this.saldo -= (montoTotalRetiro);
			registrarOperacion("Retiro", pMontoRetiro, seCobraComision, comision, "Colones");
			System.out.println("Estimado usuario, el monto de este retiro es: " + String.format("%.2f", pMontoRetiro) + " colones");
			System.out.println("El monto cobrado por concepto de comisi�n fue de: " + String.format("%.2f", comision) + " colones");
			System.out.println("que fueron rebajados autom�ticamente de su saldo actual");

		} else {
			double saldoFaltante = montoTotalRetiro - this.saldo;
			throw new FondosInsuficientesExcepcion(saldoFaltante);
		}
	}

//	public void retirarDolares(double pMontoRetiro) throws FondosInsuficientesExcepcion {
//		boolean seCobraComision = determinarCobroComision();
//		double comision = 0.00;
//		
//		TipoCambio tc = new TipoCambio();
//		double montoTotalRetiro = tc.convertirAColones(pMontoRetiro);
//		
//		if (seCobraComision){
//			comision = pMontoRetiro * 0.02;
//			montoTotalRetiro += comision;
//		}
//		
//		if (validarRetiro(montoTotalRetiro)){
//			this.saldo -= montoTotalRetiro;
//			registrarOperacion("Retiro", pMontoRetiro, seCobraComision, comision, "D�lares");
//			
//		} else {
//			double saldoFaltante = montoTotalRetiro - this.getSaldo();
//			throw new FondosInsuficientesExcepcion(saldoFaltante);
//		}
//	}
	
	public void retirarDolares(double pMontoRetiro, int cantidad) throws FondosInsuficientesExcepcion {
		this.cantidadDepositosOperaciones = cantidad;
		boolean seCobraComision = determinarCobroComision();
		double comision = 0.00;

		TipoCambio tc = new TipoCambio();
		double montoTotalRetiro = tc.convertirAColones(pMontoRetiro);

		if (seCobraComision) {
			comision = pMontoRetiro * 0.02;
			montoTotalRetiro += comision;
		}

		if (validarRetiro(montoTotalRetiro)) {
			this.saldo -= montoTotalRetiro;
			registrarOperacion("Retiro", pMontoRetiro, seCobraComision, comision, "D�lares");
			System.out.println("Estimado usuario el monto de este retiro es: " + pMontoRetiro);
			System.out.println("Seg�n el BCCR, el tipo de cambio de venta del d�lar de hoy es: " + tc.getCompra());
			System.out.println("El monto equivalente de este retiro es: " + String.format("%.2f", montoTotalRetiro) + " colones");
			System.out.println("El monto cobrado por concepto de comisi�n fue de: " + String.format("%.2f", tc.convertirAColones(comision)) + " colones");
			System.out.println("que fueron rebajados autom�ticamente de su saldo actual");

		} else {
			double saldoFaltante = montoTotalRetiro - this.saldo;
			throw new FondosInsuficientesExcepcion(saldoFaltante);
		}
	}
	
	public void recibirTransferencia(double pMontoRecibido){
		this.saldo += pMontoRecibido;
		registrarOperacion("Transferencia", pMontoRecibido, false, 0.00, "Colones");
	}
	
	public double consultarSaldoActual(){
		double saldoActual = getSaldo();
		registrarOperacion();
		return saldoActual;
	}
	
	private boolean validarRetiro(double pMontoTotalRetiro) {
		return pMontoTotalRetiro + (pMontoTotalRetiro * 0.02) <= this.getSaldo();
	}
	
	private boolean determinarCobroComision(){
		return this.cantidadDepositosOperaciones > 3;
	}
	
	private void registrarOperacion(String pTipoOperacion, double pMontoOperacion, boolean pSeCobraComision, double pMontoComision, String pMoneda) {
		Operacion operacion = new Operacion(obtenerFechaSistema(), pTipoOperacion, pMontoOperacion, pSeCobraComision, pMontoComision, pMoneda);
		getOperaciones().add(operacion);
		this.cantidadDepositosOperaciones++;
	}
	
	private void registrarOperacion(){
		Operacion operacion = new Operacion(obtenerFechaSistema(), "Consulta", false);
		getOperaciones().add(operacion);
	}

	@Override
	public double calcularTotalComisionesDepositos() {
		ArrayList<Operacion> depositos = obtenerListaDepositos();
		double totalComisionesDepositos = 0.0;
		for (Operacion deposito : depositos) {
			totalComisionesDepositos += deposito.getMontoComision();
		}
		return totalComisionesDepositos;
	}

	@Override
	public double calcularTotalComisionesRetiros() {
		ArrayList<Operacion> retiros = obtenerListaRetiros();
		double totalComisionesRetiros = 0.0;
		for (Operacion retiro : retiros) {
			totalComisionesRetiros += retiro.getMontoComision();
		}
		
		return totalComisionesRetiros;
	}

	@Override
	public double calcularTotalComisiones() {
		double totalComisiones = 0.0;

		for (Operacion operacion : this.getOperaciones()) {
			totalComisiones += operacion.getMontoComision();
		}
		return totalComisiones;
	}

	private ArrayList obtenerListaDepositos() {
		ArrayList depositos = new ArrayList<Operacion>();
		for (Operacion operacion : this.getOperaciones()) {
			if (operacion.getTipoOperacion().equals("Dep�sito")) {
				depositos.add(operacion);
			}
		}
		return depositos;
	}

	private ArrayList obtenerListaRetiros() {
		ArrayList retiros = new ArrayList<Operacion>();
		for (Operacion operacion : this.getOperaciones()) {
			if (operacion.getTipoOperacion().equals("Retiro")) {
				retiros.add(operacion);
			}
		}
		return retiros;
	}
	
	public String consultarDetallesOperaciones() {
		String mensaje = "Operaciones: \n";
		for (Operacion elemento : getOperaciones()) {
			mensaje += elemento.toString() + "\n";
		}
		return mensaje;
	}

	public String consultarEstatus() {
		String mensaje = "La cuenta n�mero XXXXXX tiene estatus de: " + getEstatus();
		return mensaje;
	}
	
	public String consultarEstadoCuenta(){
		String estadoCuenta = "";
		estadoCuenta += this.toString() + "\n";
		estadoCuenta += this.consultarDetallesOperaciones() + "\n";
		return estadoCuenta;
	}
	
	public void inactivarCuenta() {
		this.setEstatus("inactiva");
	}

	public void cambiarPin(String pNuevoPin) {
		this.pin = pNuevoPin;
		registrarOperacion();
	}

	public boolean verificarPin(String pPinAntiguo) {
		return this.getPin().equals(pPinAntiguo) == true;
	}

	@Override
	public boolean comparar(Comparable b) {
		return false;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	
	public double getSaldo(){
		return this.saldo;
	}
	
	public double getSaldoDolares(){
		TipoCambio tc = new TipoCambio();
		return tc.convertirADolares(this.getSaldo());
	}

	@Override
	public String toString() {
		return "Cuenta{" + "numeroCuenta=" + getNumeroCuenta() + ", fechaCreacion=" + getFechaCreacion() + ", saldo=" + getSaldo() + ", estatus=" + getEstatus() + ", pin=" + getPin() + '}';
	}

	/**
	 * @return the pin
	 */
	public String getPin() {
		return pin;
	}

	/**
	 * @return the fechaCreacion
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @return the estatus
	 */
	public String getEstatus() {
		return estatus;
	}

	/**
	 * @param numeroCuenta the numeroCuenta to set
	 */
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	/**
	 * @param operaciones the operaciones to set
	 */
	public void setOperaciones(ArrayList<Operacion> operaciones) {
		this.operaciones = operaciones;
	}

	/**
	 * @return the operaciones
	 */
	public ArrayList<Operacion> getOperaciones() {
		return operaciones;
	}
	
	public int getCantidadDepositosOperaciones() {
		return cantidadDepositosOperaciones;
	}
}
