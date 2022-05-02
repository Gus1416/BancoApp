package bancoapp;

import logicadenegocios.Encriptacion;
import logicadevalidacion.ValidacionCliente;
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
          String id = "604390302";
          ValidacionPersona valida = new ValidacionPersona ();
          System.out.println("Is this an ID?: " + valida.validarIdentificacion(id) + "\n");
	}
}