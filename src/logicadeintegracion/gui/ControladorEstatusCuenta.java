package logicadeintegracion.gui;

import logicadeaccesodedatos.CuentaCRUD;
import logicadenegocios.Cuenta;

/**
 *
 * @author Alejandra Merino
 */
public class ControladorEstatusCuenta extends Controlador {

	private Cuenta cuenta;
	private CuentaCRUD cuentaCRUD;

	public ControladorEstatusCuenta() {
		cuentaCRUD = new CuentaCRUD();
	}

	public void controlarEstatusCuenta(String pNunCuenta) {
		cuenta = cuentaCRUD.consultarCuenta(pNunCuenta);
		registrarEnBitacora("Consulta Estatus de Cuenta", "gui");
		super.mensaje = "La cuenta número " + cuenta.getNumeroCuenta() + " tiene estatus "
						+ "de " + cuenta.getEstatus();
	}
}