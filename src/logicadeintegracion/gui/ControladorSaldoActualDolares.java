package logicadeintegracion.gui;

import logicadeaccesodedatos.CuentaCRUD;
import logicadenegocios.Cuenta;

/**
 *
 * @author Alejandra Merino
 */
public class ControladorSaldoActualDolares extends Controlador {

	private CuentaCRUD cuentaCRUD;
	private Cuenta cuenta;

	public ControladorSaldoActualDolares() {
		cuentaCRUD = new CuentaCRUD();
		cuenta = new Cuenta();
	}

	public void controlarSaldoActualDolares(String pNumCuenta) {
		cuenta = cuentaCRUD.consultarCuenta(pNumCuenta);
		double saldoDolares = cuenta.getSaldoDolares();
		double redondeo = Math.round(saldoDolares * 100.0) / 100.0;
		registrarEnBitacora("Obtener Saldo Actual (USD)", "gui");
		super.mensaje = "Estimado usuario el saldo actual de su cuenta es: "
						+ redondeo + " dólares.";
	}
}