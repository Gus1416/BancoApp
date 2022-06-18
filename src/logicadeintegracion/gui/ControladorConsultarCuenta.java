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
public class ControladorConsultarCuenta extends Controlador {

	public ArrayList cargarCuentas() {
		CuentaCRUD cuentaCRUD = new CuentaCRUD();
		ArrayList<Cuenta> listaCuentas = cuentaCRUD.consultarCuentas();
		Cuenta[] cuentasOrdenadas = ordenarCuenta(listaCuentas);
		return presentarCuenta(cuentasOrdenadas);
	}

	public Cuenta[] ordenarCuenta(ArrayList<Cuenta> pListaCuentas) {
		Cuenta[] cuentasOrdenadas = new Cuenta[pListaCuentas.size()];
		for (int i = 0; i < pListaCuentas.size(); i++) {
			cuentasOrdenadas[i] = pListaCuentas.get(i);
		}
		Ordenacion ordena = new Ordenacion();
		ordena.insercion(cuentasOrdenadas);
		return cuentasOrdenadas;
	}

	public ArrayList presentarCuenta(Cuenta[] pCuentasOrdenadas) {
		ArrayList presentaCuentas = new ArrayList();
		for (Cuenta cuenta : pCuentasOrdenadas) {
			String mensaje = "" + cuenta.getNumeroCuenta() + " "
							+ cuenta.getEstatus() + " " + cuenta.getSaldo();
			presentaCuentas.add(mensaje);
		}
		return presentaCuentas;
	}

	public void cargarPropietarioCuenta(String pNumCuenta) {
		ClienteCRUD clienteCRUD = new ClienteCRUD();
		Cliente cliente = clienteCRUD.consultarPropietarioCuenta(pNumCuenta);
		super.mensaje = "" + cliente.getIdentificacion() + " "
						+ cliente.getPrimerApellido() + " " + cliente.getSegundoApellido() + " "
						+ cliente.getNombre();
	}

	public void cargarCuenta(String pNumCuenta) {
		CuentaCRUD cuentaCRUD = new CuentaCRUD();
		Cuenta cuenta = cuentaCRUD.consultarCuenta(pNumCuenta);
		registrarEnBitacora("Consulta Detalle Cuenta", "gui");
		super.mensaje = cuenta.estadoCuentaColones();
	}
}