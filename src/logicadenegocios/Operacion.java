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

    public Operacion(Date fechaOperacion, String tipoOperacion, double montoOperacion, boolean seCobraComision, double montoComision, String moneda) {
        this.fechaOperacion = fechaOperacion;
        this.tipoOperacion = tipoOperacion;
        this.seCobraComision = seCobraComision;
        this.montoOperacion = montoOperacion;
        this.montoComision = montoComision;
        this.moneda = moneda;
    }

    public Operacion(Date fechaOperacion, String tipoOperacion, boolean seCobraComision) {
        this.fechaOperacion = fechaOperacion;
        this.tipoOperacion = tipoOperacion;
        this.seCobraComision = seCobraComision;
    }
		
		public double getMontoComision(){
			return this.montoComision;
		}
		
		public String getTipoOperacion(){
			return this.tipoOperacion;
		}

    public Operacion(String tipoOperacion, double montoOperacion, String moneda) {
        this.tipoOperacion = tipoOperacion;
        this.montoOperacion = montoOperacion;
        this.moneda = moneda;
    }
    
    

    @Override
    public String toString() {
        return "Operacion{" + "fechaOperacion=" + fechaOperacion + ", tipoOperacion=" + tipoOperacion + ", seCobraComision=" + seCobraComision + ", montoOperacion=" + montoOperacion + ", montoComision=" + montoComision + ", moneda=" + moneda + ", porcentajeComision=" + porcentajeComision + '}';
    }
}