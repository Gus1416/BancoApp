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
public class ControladorTipoCambio extends Controlador {
  
  private TipoCambio tc;

  public ControladorTipoCambio() {
    tc = new TipoCambio ();
  }      
          
  public void controlarTipoCambio (String pTipo) {
    if (pTipo.equals("Compra")) {
      super.mensaje = "El tipo de cambio de compra del \ndólar para día " 
              +tc.getFechaFinal()+" es de: "+tc.getCompra();
    } else {
      super.mensaje = "El tipo de cambio de venta del \ndólar para día " 
              +tc.getFechaFinal()+" es de: "+tc.getVenta();
    }
  }
  
  
}
