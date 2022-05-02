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

	//Dentro de deposito, retiro, transferencia se crea una nueva operacion?
        // la lista de cuentas debe ser un atributo estatico 
        
	//public void depositar(String pNumCuenta,double pMontoDeposito) {
     //   Busqueda search = new Busqueda();
      //  search.buscarCuenta(pNumCuenta, operaciones);
            
            
      //  registrarOperacion("Deposito Colones",pMontoDeposito,"CRC");
        
            
            
	//}
        
        

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
	
	private ArrayList obtenerListaDepositos(){
		ArrayList depositos = new ArrayList<Operacion>();
		for (Operacion operacion : this.operaciones){
			if (operacion.getTipoOperacion().equals("Depósito")){
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

	public void registrarOperacion(String tipoOperacion, double montoOperacion, String moneda) {
		Operacion ope = new Operacion(tipoOperacion, montoOperacion,moneda);
		operaciones.add(ope);
	}

    @Override
    public String toString() {
        return "Cuenta{" + "numeroCuenta=" + numeroCuenta + ", fechaCreacion=" + fechaCreacion + ", saldo=" + saldo + ", estatus=" + estatus + ", pin=" + pin + ", operaciones=" + operaciones + '}';
    }
        
  
        
        
        
}