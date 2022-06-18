package logicadeintegracion.gui;

import serviciosexternos.TipoCambio;

/**
 *
 * @author Alejandra Merino
 */
public class ControladorTipoCambio extends Controlador {

	private TipoCambio tc;

	public ControladorTipoCambio() {
		tc = new TipoCambio();
	}

	public void controlarTipoCambio(String pTipo) {
		if (pTipo.equals("Compra")) {
			registrarEnBitacora("Obtener TC Compra", "gui");
			super.mensaje = "El tipo de cambio de compra del \ndólar para día "
							+ tc.getFechaFinal() + " es de: " + tc.getCompra();
		} else {
			registrarEnBitacora("Obtener TC Venta", "gui");
			super.mensaje = "El tipo de cambio de venta del \ndólar para día "
							+ tc.getFechaFinal() + " es de: " + tc.getVenta();
		}
	}
}
