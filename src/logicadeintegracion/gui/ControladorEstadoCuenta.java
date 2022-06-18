package logicadeintegracion.gui;

import logicadeaccesodedatos.CuentaCRUD;
import logicadenegocios.Cuenta;

/**
 *
 * @author Alejandra Merino
 */
public class ControladorEstadoCuenta extends Controlador {

	private CuentaCRUD cuentaCRUD;
	private Cuenta cuenta;

	public ControladorEstadoCuenta() {
		cuentaCRUD = new CuentaCRUD();
		cuenta = new Cuenta();
	}

	public void controlarEstadoCuenta(String pNumCuenta) {
		cuenta = cuentaCRUD.consultarCuenta(pNumCuenta);
		registrarEnBitacora("Consulta Estado de Cuenta (CRC)", "gui");
		super.mensaje = cuenta.estadoCuentaColones();
	}
}