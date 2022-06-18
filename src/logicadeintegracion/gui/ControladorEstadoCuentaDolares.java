package logicadeintegracion.gui;

import logicadeaccesodedatos.CuentaCRUD;
import logicadenegocios.Cuenta;

/**
 *
 * @author Alejandra Merino
 */
public class ControladorEstadoCuentaDolares extends Controlador {

	private CuentaCRUD cuentaCRUD;
	private Cuenta cuenta;

	public ControladorEstadoCuentaDolares() {
		cuentaCRUD = new CuentaCRUD();
		cuenta = new Cuenta();
	}

	public void controlarEstadoCuentaDolares(String pNumCuenta) {
		cuenta = cuentaCRUD.consultarCuenta(pNumCuenta);
		registrarEnBitacora("Consulta Estado de Cuenta (USD)", "gui");
		super.mensaje = cuenta.estadoCuentaDolares();
	}
}
