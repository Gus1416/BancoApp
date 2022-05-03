/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadevalidacion;

/**
 *
 * @author Alejandra Merino
 */
public class FondosInsuficientesExcepcion extends Exception {
  private double monto;

  public FondosInsuficientesExcepcion(double pMonto) {
    monto = pMonto;
  }

  @Override
  public String toString() {
    String mensaje;
    mensaje= "El monto de retiro excede el saldo de la cuenta actual por: " + monto;
    return mensaje;
  }
  
  
  
  
}
