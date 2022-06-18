package logicadeintegracion.gui;

import java.util.ArrayList;
import logicadeaccesodedatos.ClienteCRUD;
import logicadeaccesodedatos.CuentaCRUD;
import logicadenegocios.Cliente;
import logicadenegocios.Cuenta;
import logicadenegocios.Ordenacion;

/**
 *
 * @author Alejandra Merino
 */
public class ControladorCrearCuenta extends Controlador {

	public ArrayList cargarClientes() {
		ClienteCRUD clienteCRUD = new ClienteCRUD();
		ArrayList<Cliente> listaClientes = clienteCRUD.consultarClientes();
		Cliente[] clientesOrdenados = ordenarCliente(listaClientes);
		return presentarCliente(clientesOrdenados);
	}

	public Cliente[] ordenarCliente(ArrayList<Cliente> pListaClientes) {
		Cliente[] clientesOrdenados = new Cliente[pListaClientes.size()];
		for (int i = 0; i < pListaClientes.size(); i++) {
			clientesOrdenados[i] = pListaClientes.get(i);
		}
		Ordenacion ordena = new Ordenacion();
		ordena.insercion(clientesOrdenados);
		return clientesOrdenados;
	}

	public ArrayList presentarCliente(Cliente[] pClientesOrdenados) {
		ArrayList presentaClientes = new ArrayList();
		for (Cliente cliente : pClientesOrdenados) {
			String mensaje = "" + cliente.getPrimerApellido() + " "
							+ cliente.getSegundoApellido() + " " + cliente.getNombre()
							+ " " + cliente.getIdentificacion();
			presentaClientes.add(mensaje);
		}
		return presentaClientes;
	}

	public void controlarRegistroCuenta(String pPin, String pNum, String pIdentificacion) {
		double deposito = Double.parseDouble(pNum);
		CuentaCRUD cuentaCRUD = new CuentaCRUD();
		int numeroCuentas = cuentaCRUD.obtenerCantidadCuentas();
		ClienteCRUD clienteCRUD = new ClienteCRUD();
		Cliente clienteRegistrado = clienteCRUD.consultarCliente(pIdentificacion);
		clienteRegistrado.crearCuenta(pPin, deposito, numeroCuentas);
		int ultimo = clienteRegistrado.getCuentas().size();
		Cuenta cuenta = (clienteRegistrado.getCuentas()).get(ultimo - 1);
		cuentaCRUD.registrarCuenta(cuenta, pIdentificacion);
		registrarEnBitacora("Creación de Cuenta Bancaria", "gui");

		super.mensaje = "Se ha creado una nueva cuenta en el sistema, los datos de"
						+ " la cuenta son:\n Número de cuenta: " + cuenta.getNumeroCuenta()
						+ "\n Estatus de la cuenta: " + cuenta.getEstatus() + "\n"
						+ "Saldo actual: " + cuenta.getSaldo() + "\n ---\n "
						+ "Nombre del dueño de la cuenta: " + clienteRegistrado.getNombre()
						+ " " + clienteRegistrado.getPrimerApellido() + " "
						+ clienteRegistrado.getSegundoApellido() + "\n "
						+ "Número de teléfono asociado a la cuenta: "
						+ clienteRegistrado.getNumeroTelefono() + "\n "
						+ "Dirección de correo electrónico asociada a la cuenta: "
						+ clienteRegistrado.getCorreoElectronico();

	}
}
