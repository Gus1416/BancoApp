package logicadeintegracion.gui;

import logicadeaccesodedatos.CuentaCRUD;
import logicadenegocios.Cuenta;

/**
 *
 * @author Alejandra Merino
 */
public class ControladorCambioPin extends Controlador {

	public void controlarCambioPin(String pNumCuenta, String pPinNuevo) {
		CuentaCRUD cuentaCRUD = new CuentaCRUD();
		Cuenta cuenta = cuentaCRUD.consultarCuenta(pNumCuenta);
		cuenta.setPin(pPinNuevo);
		cuentaCRUD.cambiarPin(cuenta);
		registrarEnBitacora("Cambio de PIN", "gui");
		super.mensaje = "Estimado usuario, se ha cambiado satisfactoriamente el "
						+ "PIN de su cuenta: " + cuenta.getNumeroCuenta();
	}
}