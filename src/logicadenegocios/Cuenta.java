/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Alejandra Merino
 */
public class Cuenta implements IComisiones, Comparable{
  private String numeroCuenta;
  private Date fechaCreacion;
  private double saldo;
  private String estatus = "activa";
  private String pin;
  private ArrayList<Operacion> operaciones;

  public Cuenta(String pPin, double pMontoInicial) {
    pin = pPin;
    saldo = pMontoInicial;
    fechaCreacion = obtenerFechaSistema ();
    operaciones = new ArrayList<> ();
  }
  
  private Date obtenerFechaSistema () {
  Date fecha = new Date ();
  return fecha;
  }
  
  private int contarDepositosRetiro () {
   return 1; 
  }
  
  //Dentro de deposito, retiro, transferencia se crea una nueva operacion?
  public void depositar (double pMontoDeposito) {
  }
  
  
}
