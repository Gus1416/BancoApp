/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadeintegracion.gui;

import logicadeaccesodedatos.ClienteCRUD;
import logicadenegocios.Cliente;

/**
 *
 * @author Alejandra Merino
 */
public class ControladorConsultarCliente  {
  
  public String controlarConsultaCliente (String pIdentificacion) {
  ClienteCRUD clienteCRUD = new ClienteCRUD ();
  Cliente cliente = clienteCRUD.consultarCliente(pIdentificacion);
  return cliente.toString();
  }
}
