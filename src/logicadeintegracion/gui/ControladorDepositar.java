/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadeintegracion.gui;

import java.util.ArrayList;
import logicadeaccesodedatos.CuentaCRUD;
import logicadeaccesodedatos.OperacionCRUD;
import logicadenegocios.Cuenta;
import logicadenegocios.Operacion;
import serviciosexternos.TipoCambio;

/**
 *
 * @author Alejandra Merino
 */
public class ControladorDepositar extends Controlador{
 
  public CuentaCRUD cuentaCRUD;
  public OperacionCRUD operacionCRUD;
  public Cuenta cuenta;

  public ControladorDepositar() {
    cuentaCRUD = new CuentaCRUD();
    operacionCRUD = new OperacionCRUD ();
  }
  
  
  
  public void controlarDeposito (String pNumCuenta, String pDeposito, String pMoneda) {
    if(pMoneda.equals("Colones")) {
      controlarDepositoColones (pNumCuenta, pDeposito);
    } else {
      controlarDepositoDolares(pNumCuenta, pDeposito);
    }
  }
  
  public void controlarDepositoDolares (String pNumCuenta, String pDeposito) {
    cuenta = devolverCuentaDeposito(pNumCuenta);
    double deposito = Double.parseDouble(pDeposito);
    int numOperaciones = cuentaCRUD.obtenerCantidadOperaciones();
    int numOperacionesCuenta = cuentaCRUD.obtenerCantidadOpeCuenta(pNumCuenta);
    cuenta.setCantidadDepositosOperaciones(numOperacionesCuenta);
    cuenta.depositarDolares(deposito,numOperaciones);
    cuentaCRUD.actualizarSaldo(cuenta);
    ArrayList<Operacion> operaciones = cuenta.getOperaciones();
    Operacion operacion = operaciones.get(operaciones.size()-1);
    operacionCRUD.registrarOperacion(operacion, pNumCuenta);
    double montoReal = operacion.getMontoOperacion() - operacion.getMontoComision();
    TipoCambio tc = new  TipoCambio ();
    double saldoEqui = tc.convertirAColones(deposito);
    double redondeo = Math.round(saldoEqui*100.0)/100.0;
    super.mensaje = "Estimado usuario, se han recibido correctamente: "+deposito
            +" dólares\n[Según el BCCR, el tipo de cambio de compra del dólar de:"+ 
            tc.getFechaFinal()+ " es: "+tc.getCompra()+ "]\n[El monto equivalente"
            + " en colones es: " + redondeo + "]\n[El "
            + "monto real depositado a su cuenta: " +cuenta.getNumeroCuenta() 
            +" es de: "+montoReal+ " colones]\n[El monto cobrado por concepto de comisión"
            + " fue de: "+operacion.getMontoComision() +" colones, que fueron "
            + "rebajados automáticamente de su saldo actual]";
  }
  
  public void controlarDepositoColones (String pNumCuenta, String pDeposito) {
    cuenta = devolverCuentaDeposito(pNumCuenta);
    double deposito = Double.parseDouble(pDeposito);
    int numOperaciones = cuentaCRUD.obtenerCantidadOperaciones();
    int numOperacionesCuenta = cuentaCRUD.obtenerCantidadOpeCuenta(pNumCuenta);
    cuenta.setCantidadDepositosOperaciones(numOperacionesCuenta);
    cuenta.depositarColones(deposito, numOperaciones);
    cuentaCRUD.actualizarSaldo(cuenta);
    ArrayList<Operacion> operaciones = cuenta.getOperaciones();
    Operacion operacion = operaciones.get(operaciones.size()-1);
    operacionCRUD.registrarOperacion(operacion, pNumCuenta);
    double montoReal = operacion.getMontoOperacion() - operacion.getMontoComision();
    super.mensaje = "Estimado usuario, se han depositado correctamente: "+deposito
            +" colones\n[El monto real depositado a su cuenta: " +cuenta.getNumeroCuenta() 
            +" es de: "+montoReal+ " colones]\n[El monto cobrado por concepto de comisión"
            + " fue de: "+operacion.getMontoComision() +" colones, que fueron "
            + "rebajados automáticamente de su saldo actual]";
  }
  
  public Cuenta devolverCuentaDeposito (String pNumCuenta) {
    Cuenta pCuenta = cuentaCRUD.consultarCuenta(pNumCuenta);
    return pCuenta;
  }

  
}
