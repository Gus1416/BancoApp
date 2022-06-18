package logicadeintegracion.gui;

import logicadeaccesodedatos.CuentaCRUD;
import logicadenegocios.Cuenta;

/**
 *
 * @author Alejandra Merino
 */
public class ControladorComisionGanadaCuenta extends Controlador {

	public void controlarComisionesGanadasCuenta(String pNumCuenta) {
		CuentaCRUD cuentaCRUD = new CuentaCRUD();
		Cuenta cuenta = cuentaCRUD.consultarCuenta(pNumCuenta);
		registrarEnBitacora("Consulta Ganancias Totales Comisión (Específico)", "gui");
		super.mensaje = "Comisiones de retiro: " + cuenta.calcularTotalComisionesRetiros() + " \n"
						+ "Comisiones de depositos: " + cuenta.calcularTotalComisionesDepositos() + " \n"
						+ "Comisiones totales: " + cuenta.calcularTotalComisiones();
	}

}
