/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadeintegracion.gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import logicadenegocios.Cliente;

/**
 *
 * @author Alejandra Merino
 */
public class ControladorRegistroCliente {
  private Date fechaNacimiento;
  
  //Conversiones
  //Construir los objetos y guardarlos en la BD
  public String controlarRegistroCliente (String pIdentificacion, 
          String pPrimerApellido, String pSegundoApellido, String pNombre, 
          Date pFechaNacimiento, String pNumeroTelefono, 
          String pCorreoElectronico) {
    //convertirDate (pFechaNacimiento);
    Cliente cliente = new Cliente(pIdentificacion, pPrimerApellido, 
            pSegundoApellido, pNombre, fechaNacimiento, pNumeroTelefono, 
            pCorreoElectronico);
    
    String mensaje = "Se ha creado un nuevo cliente en el sistema, los datos que"
            + " fueron almacenados son: \nCodigo: "+cliente.getCodigoCliente() 
            +"\nNombre: "+cliente.getNombre()+"\nIdentificacion: "
            +cliente.getIdentificacion()+"\nFecha de Nacimiento: " 
            +pFechaNacimiento.toString()+"\nNumero telefonico: "+cliente.getNumeroTelefono();
    return mensaje;
  }
  
  private void convertirDate (String pFechaNacimiento) {
    SimpleDateFormat formato = new SimpleDateFormat ("dd/MM/yyyy");
    Date fecha;
    try {
      fecha = formato.parse(pFechaNacimiento);
      fechaNacimiento = fecha;
    } catch (ParseException ex) {
      Logger.getLogger(ControladorRegistroCliente.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
