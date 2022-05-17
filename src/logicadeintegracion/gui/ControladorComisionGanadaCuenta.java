/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadeintegracion.gui;

import java.util.ArrayList;
import logicadeaccesodedatos.CuentaCRUD;
import logicadenegocios.Cuenta;

/**
 *
 * @author Alejandra Merino
 */
public class ControladorComisionGanadaCuenta extends Controlador {
  
  public void controlarComisionesGanadasCuenta (String pNumCuenta) {
    CuentaCRUD cuentaCRUD = new CuentaCRUD ();
    Cuenta cuenta = cuentaCRUD.consultarCuenta(pNumCuenta);
    super.mensaje="Comisiones de retiro: "+cuenta.calcularTotalComisionesRetiros() +" \n"
            + "Comisiones de depositos: "+cuenta.calcularTotalComisionesDepositos() +" \n"
            + "Comisiones totales: "+cuenta.calcularTotalComisiones();
  }
  
}
