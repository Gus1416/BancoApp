/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadeintegracion.gui;

import serviciosexternos.TipoCambio;

/**
 *
 * @author Alejandra Merino
 */
public class ControladorTipoCambio {
  private String mensaje;
  private TipoCambio tc;

  public ControladorTipoCambio() {
    tc = new TipoCambio ();
  }      
          
  public void controlarTipoCambio (String pTipo) {
    if (pTipo.equals("Compra")) {
      mensaje = "El tipo de cambio de compra del \nd�lar para d�a " 
              +tc.getFechaFinal()+" es de: "+tc.getCompra();
    } else {
      mensaje = "El tipo de cambio de venta del \nd�lar para d�a " 
              +tc.getFechaFinal()+" es de: "+tc.getVenta();
    }
  }

  public String getMensaje() {
    return mensaje;
  }
  
  
}
