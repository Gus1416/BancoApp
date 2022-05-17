/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadeintegracion.gui;

import java.util.ArrayList;
import logicadeaccesodedatos.ClienteCRUD;
import logicadeaccesodedatos.CuentaCRUD;
import logicadeaccesodedatos.OperacionCRUD;
import logicadenegocios.Cliente;
import logicadenegocios.Cuenta;
import logicadenegocios.Operacion;
import logicadenegocios.PalabraSecreta;
import logicadevalidacion.FondosInsuficientesExcepcion;
import serviciosexternos.Sms;
import serviciosexternos.TipoCambio;

/**
 *
 * @author Alejandra Merino
 */
public class ControladorRetirar extends Controlador {
  private ClienteCRUD clienteCRUD;
  
  private String palabraSecreta;
  private Cuenta cuenta;
  private CuentaCRUD cuentaCRUD;
  private OperacionCRUD operacionCRUD;
  

  public ControladorRetirar() {
    clienteCRUD = new ClienteCRUD ();
    cuentaCRUD = new CuentaCRUD ();
    operacionCRUD = new OperacionCRUD ();
  }
  
  public void controlarRetiro (String pNumCuenta, String pRetiro, String 
          pMoneda) throws FondosInsuficientesExcepcion {
    if(pMoneda.equals("Colones")) {
      controlarRetiroColones (pNumCuenta, pRetiro);
    } else {
      controlarRetiroDolares(pNumCuenta, pRetiro);
    }
  }
  
  public void controlarRetiroColones (String pNumCuenta, String pRetiro) throws FondosInsuficientesExcepcion {
    cuenta = devolverCuentaDeposito(pNumCuenta);
    double retiro = Double.parseDouble(pRetiro);
    int numOperaciones = cuentaCRUD.obtenerCantidadOperaciones();
    int numOperacionesCuenta = operacionCRUD.obtenerCantidadOpeCuenta(pNumCuenta);
    cuenta.setCantidadDepositosRetiros(numOperacionesCuenta);
    cuenta.retirarColones(retiro, numOperaciones);
    cuentaCRUD.actualizarSaldo(cuenta);
    ArrayList<Operacion> operaciones = cuenta.getOperaciones();
    Operacion operacion = operaciones.get(operaciones.size()-1);
    operacionCRUD.registrarOperacion(operacion, pNumCuenta);
    super.mensaje = "Estimado usuario, el monto de este retiro es "+retiro+" colones.\n" +
              "[El monto cobrado por concepto de comisión fue de :"+
            operacion.getMontoComision()+" colones, que \n" +
            "fueron rebajados automáticamente de su saldo actual]";
  }
  
  public void controlarRetiroDolares (String pNumCuenta, String pRetiro) throws FondosInsuficientesExcepcion {
    cuenta = devolverCuentaDeposito(pNumCuenta);
    double retiro = Double.parseDouble(pRetiro);
    int numOperaciones = cuentaCRUD.obtenerCantidadOperaciones();
    int numOperacionesCuenta = operacionCRUD.obtenerCantidadOpeCuenta(pNumCuenta);
    cuenta.setCantidadDepositosRetiros(numOperacionesCuenta);
    cuenta.retirarDolares(retiro, numOperaciones);
    cuentaCRUD.actualizarSaldo(cuenta);
    ArrayList<Operacion> operaciones = cuenta.getOperaciones();
    Operacion operacion = operaciones.get(operaciones.size()-1);
    operacionCRUD.registrarOperacion(operacion, pNumCuenta);
    TipoCambio tc = new  TipoCambio ();
    double saldoEqui = tc.convertirAColones(retiro);
    double redondeo = Math.round(saldoEqui*100.0)/100.0;
    super.mensaje = "Estimado usuario, el monto de este retiro es: "+pRetiro+" dólares.\n" +
              "[Según el BCCR, el tipo de cambio de venta del dólar de hoy es: "+tc.getVenta()+"]\n" +
              "[El monto equivalente de su retiro es "+redondeo+" colones]\n" +
              "[El monto cobrado por concepto de comisión fue de "+operacion.getMontoComision()+" colones, que\n" +
              "fueron rebajados automáticamente de su saldo actual]";
  }
  
  public void controlarEnvioSms (String pNumCuenta) {
  Cliente cliente = clienteCRUD.consultarPropietarioCuenta(pNumCuenta);
  PalabraSecreta secreta = new PalabraSecreta ();
  palabraSecreta = PalabraSecreta.generarPalabraSecreta();
  Sms mensajeTexto = new Sms();
  mensajeTexto.enviarSms(palabraSecreta,cliente.getNumeroTelefono());
  super.mensaje = "Estimado usuario se ha enviado una palabra por mensaje "
              + "de texto, por favor revise sus mensajes y proceda a digitar la"
              + " palabra enviada.";
  }
  
  public Cuenta devolverCuentaDeposito (String pNumCuenta) {
    Cuenta pCuenta = cuentaCRUD.consultarCuenta(pNumCuenta);
    return pCuenta;
  }

  public String getPalabraSecreta() {
    return palabraSecreta;
  }
  
}
