/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadeintegracion.gui;

import java.text.ParseException;
import java.util.Date;
import logicadeaccesodedatos.ClienteCRUD;
import logicadenegocios.Cliente;

/**
 *
 * @author Alejandra Merino
 */
public class ControladorRegistroCliente {
  
  //Conversiones
  //Construir los objetos y guardarlos en la BD
  public String controlarRegistroCliente (String pIdentificacion, 
          String pPrimerApellido, String pSegundoApellido, String pNombre, 
          Date pFechaNacimiento, String pNumeroTelefono, 
          String pCorreoElectronico) {
    
    Cliente cliente = new Cliente(pIdentificacion, pPrimerApellido, 
            pSegundoApellido, pNombre, pFechaNacimiento, pNumeroTelefono, 
            pCorreoElectronico);
    ClienteCRUD clienteCRUD = new ClienteCRUD();
    clienteCRUD.registrarCliente(cliente);
    
    String mensaje = "Se ha creado un nuevo cliente en el sistema, los datos que"
            + " fueron almacenados son: \nCodigo: "+cliente.getCodigoCliente() 
            +"\nNombre: "+cliente.getNombre()+"\nIdentificacion: "
            +cliente.getIdentificacion()+"\nFecha de Nacimiento: " 
            +pFechaNacimiento.toString()+"\nNumero telefonico: "+cliente.getNumeroTelefono();
    return mensaje;
  }
  
  
}
