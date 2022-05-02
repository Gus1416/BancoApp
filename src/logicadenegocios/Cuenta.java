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
        
        public void determinarCobroComisionRetiro (double pMontoRetiro) {
          if(contarDepositosRetiro()>3) {
            double comision = pMontoRetiro*0.2;
            try {
              retirar (pMontoRetiro, true, comision);
            } catch (FondosInsuficientesExcepcion ex) {
              Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
            }
          } else {
            try {
              retirar (pMontoRetiro, false, 0);
            } catch (FondosInsuficientesExcepcion ex) {
              Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        }
        
	//Dentro de deposito, retiro, transferencia se crea una nueva operacion?
	public void depositar(double pMontoDeposito) {
	}
        
        private void retirar (double pMontoRetiro, boolean seCobraComision, 
                double montoComision) 
                throws FondosInsuficientesExcepcion {
          double retiroTotal = pMontoRetiro+montoComision;
          if ( retiroTotal <= saldo) {
            saldo -=retiroTotal;
            Date fechaO = obtenerFechaSistema() ;
            agregarOperacion(fechaO,"Retiro", seCobraComision, pMontoRetiro, montoComision,"CRC");
          } else {
            double requiere = retiroTotal - saldo;
            throw new FondosInsuficientesExcepcion(requiere);
          }
        }
        
        public void determinarCobroComisionRetiroDolares (double pMontoRetiro) {
          double montoColones;
          TipoCambio tc = new TipoCambio();
          montoColones = tc.convertirAColones(pMontoRetiro);
          if(contarDepositosRetiro()>3) {
            double comision = montoColones*0.2;
            try {
              retirarDolares (montoColones, true, comision);
            } catch (FondosInsuficientesExcepcion ex) {
              Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
            }
          } else {
            try {
              retirarDolares (montoColones, false, 0);
            } catch (FondosInsuficientesExcepcion ex) {
              Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        }
        private void retirarDolares (double pMontoRetiro, boolean seCobraComision, 
                double montoComision) 
                throws FondosInsuficientesExcepcion {
          double retiroTotal = pMontoRetiro+montoComision;
          if ( retiroTotal <= saldo) {
            saldo-=retiroTotal;
            Date fechaO = obtenerFechaSistema() ;
            agregarOperacion(fechaO,"Retiro", seCobraComision, pMontoRetiro, montoComision,"USD");
          } else {
            double requiere = retiroTotal - saldo;
            throw new FondosInsuficientesExcepcion(requiere);
          }
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