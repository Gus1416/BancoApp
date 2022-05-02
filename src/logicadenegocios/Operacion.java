package logicadenegocios;

import java.util.Date;

/**
 *
 * @author SebCor
 */
public class Operacion {
	//a

	private Date fechaOperacion;
	private String tipoOperacion;
	private boolean seCobraComision;
	private double montoOperacion;
	private double montoComision;
	private String moneda;
	private double porcentajeComision = 0.2;

	public Operacion(Date pFechaOperacion, String pTipoOperacion, double pMontoOperacion, boolean pSeCobraComision, double pMontoComision, String pMoneda) {
		this.fechaOperacion = pFechaOperacion;
		this.tipoOperacion = pTipoOperacion;
		this.seCobraComision = pSeCobraComision;
		this.montoOperacion = pMontoOperacion;
		this.montoComision = pMontoComision;
		this.moneda = pMoneda;
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
		return "Operacion{" + "fechaOperacion=" + fechaOperacion + ", tipoOperacion=" + tipoOperacion + ", seCobraComision=" + seCobraComision + ", montoOperacion=" + montoOperacion + ", montoComision=" + montoComision + ", moneda=" + moneda + ", porcentajeComision=" + porcentajeComision + '}';
	}
}
