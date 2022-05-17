package logicadenegocios;

import java.util.ArrayList;

/**
 *
 * @author SebCor
 */
public class Busqueda {
	// a

	public static Cuenta buscarCuenta(String pNumCuenta, ArrayList<Cuenta> pListaCuentas) {
		for (int i = 0; i < pListaCuentas.size(); i++) {
			if (pListaCuentas.get(i).getNumeroCuenta().equals(pNumCuenta)) {
				return pListaCuentas.get(i);
			}
		}
		return pListaCuentas.get(0);
	}

	public static Cliente buscarCliente(String pIdentificacion, ArrayList<Cliente> pClientes) {
		Cliente clienteBuscado = null;
		for (Cliente cliente : pClientes) {
			if (cliente.getIdentificacion().equals(pIdentificacion)) {
				clienteBuscado = cliente;
			}
		}
		return clienteBuscado;
	}

}
