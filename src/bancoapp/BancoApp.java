package bancoapp;

import java.util.ArrayList;
import java.util.Date;
import logicadeaccesodedatos.ClienteCRUD;
import logicadenegocios.Cliente;
import logicadevalidacion.ValidacionCuenta;
import logicadevalidacion.ValidacionPersona;

/**
 *
 * @author Gustavo
 */
public class BancoApp {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
          String mensaje = "576787878";
          ValidacionCuenta validar = new ValidacionCuenta ();
          boolean resultado = validar.esEntero(mensaje);
          System.out.println("Is this an integer?: "+ resultado);
          
	}
}
