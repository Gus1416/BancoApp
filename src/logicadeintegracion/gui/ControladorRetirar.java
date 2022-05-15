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
public class ControladorRetirar {
  private ClienteCRUD clienteCRUD;
  private String mensaje;
  private String palabraSecreta;
  private Cuenta cuenta;
  private CuentaCRUD cuentaCRUD;
  private OperacionCRUD operacionCRUD;
  

  public ControladorRetirar() {
    clienteCRUD = new ClienteCRUD ();
    cuentaCRUD = new CuentaCRUD ();
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
    int numOperaciones = cuentaCRUD.obtenerCantidadOpeCuenta(pNumCuenta);
    cuenta.retirarColones(retiro, numOperaciones);
    //cuentaCRUD.actualizarSaldo(cuenta);
    ArrayList<Operacion> operaciones = cuenta.getOperaciones();
    Operacion operacion = operaciones.get(operaciones.size()-1);
    //operacionCRUD.registrarOperacion(operacion, pNumCuenta);
    mensaje = "Estimado usuario, el monto de este retiro es "+retiro+" colones.\n" +
              "[El monto cobrado por concepto de comisi�n fue de :"+
            operacion.getMontoComision()+" colones, que \n" +
            "fueron rebajados autom�ticamente de su saldo actual]";
  }
  
  public void controlarRetiroDolares (String pNumCuenta, String pRetiro) throws FondosInsuficientesExcepcion {
    cuenta = devolverCuentaDeposito(pNumCuenta);
    double retiro = Double.parseDouble(pRetiro);
    int numOperaciones = cuentaCRUD.obtenerCantidadOpeCuenta(pNumCuenta);
    cuenta.retirarDolares(retiro, numOperaciones);
    //cuentaCRUD.actualizarSaldo(cuenta);
    ArrayList<Operacion> operaciones = cuenta.getOperaciones();
    Operacion operacion = operaciones.get(operaciones.size()-1);
    //operacionCRUD.registrarOperacion(operacion, pNumCuenta);
    TipoCambio tc = new  TipoCambio ();
    mensaje = "Estimado usuario, el monto de este retiro es: "+pRetiro+" d�lares.\n" +
              "[Seg�n el BCCR, el tipo de cambio de venta del d�lar de hoy es: "+tc.getVenta()+"]\n" +
              "[El monto equivalente de su retiro es "+operacion.getMontoOperacion()+" colones]\n" +
              "[El monto cobrado por concepto de comisi�n fue de "+operacion.getMontoComision()+" colones, que\n" +
              "fueron rebajados autom�ticamente de su saldo actual]";
  }
  
  public void controlarEnvioSms (String pNumCuenta) {
  Cliente cliente = clienteCRUD.consultarPropietarioCuenta(pNumCuenta);
  PalabraSecreta secreta = new PalabraSecreta ();
  palabraSecreta = PalabraSecreta.generarPalabraSecreta();
  Sms mensajeTexto = new Sms();
  mensajeTexto.sms(palabraSecreta,cliente.getNumeroTelefono());
  mensaje = "Estimado usuario se ha enviado una palabra por mensaje "
              + "de texto, por favor revise sus mensajes y proceda a digitar la"
              + " palabra enviada.";
  }
  
  public Cuenta devolverCuentaDeposito (String pNumCuenta) {
    Cuenta pCuenta = cuentaCRUD.consultarCuenta(pNumCuenta);
    return pCuenta;
  }

  public String getMensaje() {
    return mensaje;
  }

  public String getPalabraSecreta() {
    return palabraSecreta;
  }
  
}