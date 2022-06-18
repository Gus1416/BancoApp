package logicadeintegracion.gui;

import java.util.ArrayList;
import logicadeaccesodedatos.CuentaCRUD;
import logicadenegocios.Cuenta;

/**
 *
 * @author Alejandra Merino
 */
public class ControladorComisionGanada extends Controlador {

	public void controlarComisionesGanadasTotal() {
		CuentaCRUD cuentaCRUD = new CuentaCRUD();
		ArrayList<Cuenta> cuentas = new ArrayList();
		cuentas = cuentaCRUD.consultarCuentas();
		double comisionRetiro = 0;
		double comisionDeposito = 0;
		double comisionTotal = 0;
		for (Cuenta cuenta : cuentas) {
			comisionRetiro += cuenta.calcularTotalComisionesRetiros();
			comisionDeposito += cuenta.calcularTotalComisionesDepositos();
			comisionTotal += cuenta.calcularTotalComisiones();
		}
		registrarEnBitacora("Consulta Ganancias Totales Comisión (General)", "gui");
		super.mensaje = "Comisiones de retiro: " + comisionRetiro + " \n"
						+ "Comisiones de depositos: " + comisionDeposito + " \n"
						+ "Comisiones totales: " + comisionTotal;
	}
}