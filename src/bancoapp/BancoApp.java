package bancoapp;

import java.util.ArrayList;
import java.util.Date;
import logicadeaccesodedatos.ClienteCRUD;
import logicadeaccesodedatos.CuentaCRUD;
import logicadenegocios.Cliente;
import logicadenegocios.Cuenta;
import logicadenegocios.Encriptacion;
import logicadenegocios.PalabraSecreta;
import logicadevalidacion.ValidacionCuenta;

/**
 *
 * @author Gustavo
 */
public class BancoApp {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		
		System.out.println(Encriptacion.desencriptar("MTAwMDAwLjA="));
		
	
		//System.out.println(new ClienteCRUD().consultarCliente("305220710").getCuentas().get(0));
	}
}
