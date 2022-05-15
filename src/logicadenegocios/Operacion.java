package logicadenegocios;

import java.util.Date;

/**
 *
 * @author SebCor
 */
public class Operacion {
	//a
	private int idOperacion;
	private Date fechaOperacion;
	private String tipoOperacion;
	private boolean seCobraComision;
	private double montoOperacion;
	private double montoComision;
	private String moneda;
	private double porcentajeComision = 0.2;
	private static int cantidadOperaciones = 0;

	public Operacion(Date pFechaOperacion, String pTipoOperacion, double pMontoOperacion, boolean pSeCobraComision, double pMontoComision, String pMoneda) {
		this.fechaOperacion = pFechaOperacion;
		this.tipoOperacion = pTipoOperacion;
		this.seCobraComision = pSeCobraComision;
		this.montoOperacion = pMontoOperacion;
		this.montoComision = pMontoComision;
		this.moneda = pMoneda;
		this.idOperacion = ++cantidadOperaciones;
	}
        
        public Operacion(Date pFechaOperacion, String pTipoOperacion, double 
                pMontoOperacion, boolean pSeCobraComision, double pMontoComision
                , String pMoneda, int pNum) {
                this.cantidadOperaciones = pNum;
		this.fechaOperacion = pFechaOperacion;
		this.tipoOperacion = pTipoOperacion;
		this.seCobraComision = pSeCobraComision;
		this.montoOperacion = pMontoOperacion;
		this.montoComision = pMontoComision;
		this.moneda = pMoneda;
		this.idOperacion = ++cantidadOperaciones;
	}

	public Operacion(Date fechaOperacion, String tipoOperacion, boolean seCobraComision) {
		this.fechaOperacion = fechaOperacion;
		this.tipoOperacion = tipoOperacion;
		this.seCobraComision = seCobraComision;
	}

	public double getMontoComision() {
		return this.montoComision;
	}

	public String getTipoOperacion() {
		return this.tipoOperacion;
	}

	@Override
	public String toString() {
		String mensaje = "Fecha de operacion: " + getFechaOperacion()
						+ "Tipo de operacion: " + tipoOperacion + "Cobro comision: "
						+ isSeCobraComision() + "Monto de operacion: " + getMontoOperacion()
						+ "Monto de comision" + montoComision + "Moneda: " + getMoneda()
						+ "Porcentaje de comision" + porcentajeComision;
		return mensaje;
	}

	/**
	 * @return the idOperacion
	 */
	public int getIdOperacion() {
		return idOperacion;
	}

	/**
	 * @param idOperacion the idOperacion to set
	 */
	public void setIdOperacion(int idOperacion) {
		this.idOperacion = idOperacion;
	}

	/**
	 * @return the fechaOperacion
	 */
	public Date getFechaOperacion() {
		return fechaOperacion;
	}

	/**
	 * @param fechaOperacion the fechaOperacion to set
	 */
	public void setFechaOperacion(Date fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}

	/**
	 * @param tipoOperacion the tipoOperacion to set
	 */
	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	/**
	 * @return the seCobraComision
	 */
	public boolean isSeCobraComision() {
		return seCobraComision;
	}

	/**
	 * @param seCobraComision the seCobraComision to set
	 */
	public void setSeCobraComision(boolean seCobraComision) {
		this.seCobraComision = seCobraComision;
	}

	/**
	 * @return the montoOperacion
	 */
	public double getMontoOperacion() {
		return montoOperacion;
	}

	/**
	 * @param montoOperacion the montoOperacion to set
	 */
	public void setMontoOperacion(double montoOperacion) {
		this.montoOperacion = montoOperacion;
	}

	/**
	 * @param montoComision the montoComision to set
	 */
	public void setMontoComision(double montoComision) {
		this.montoComision = montoComision;
	}

	/**
	 * @return the moneda
	 */
	public String getMoneda() {
		return moneda;
	}

	/**
	 * @param moneda the moneda to set
	 */
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
}