package bancoapp;

import java.util.ArrayList;
import java.util.Date;
import logicadeaccesodedatos.ClienteCRUD;
import logicadenegocios.Cliente;

/**
 *
 * @author Gustavo
 */
public class BancoApp {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		ClienteCRUD clienteCrud = new ClienteCRUD();
//		clienteCrud.registrarCliente(new Cliente("202220222", "Gonzales", "Figueres", "José", new Date(), "41168545", "chema@gmail.com"));
		ArrayList<Cliente> clientes = clienteCrud.consultarClientes();
		for (Cliente cliente : clientes){
			System.out.println(cliente.toString());
		}
	}
}
