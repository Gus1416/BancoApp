/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadeintegracion.gui;

import logicadeaccesodedatos.ClienteCRUD;
import logicadenegocios.Cliente;
import logicadenegocios.PalabraSecreta;
import serviciosexternos.Sms;

/**
 *
 * @author Alejandra Merino
 */
public class ControladorRetirar {
  public ClienteCRUD clienteCRUD;
  public String mensaje;
  public String palabraSecreta;
  

  public ControladorRetirar() {
    clienteCRUD = new ClienteCRUD ();
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

  public String getMensaje() {
    return mensaje;
  }

  public String getPalabraSecreta() {
    return palabraSecreta;
  }
  
  
  
}
