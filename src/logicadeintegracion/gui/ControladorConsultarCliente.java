package logicadeintegracion.gui;

import logicadeaccesodedatos.ClienteCRUD;
import logicadenegocios.Cliente;

/**
 *
 * @author Alejandra Merino
 */
public class ControladorConsultarCliente extends Controlador {

	public void controlarConsultaCliente(String pIdentificacion) {
		ClienteCRUD clienteCRUD = new ClienteCRUD();
		Cliente cliente = clienteCRUD.consultarCliente(pIdentificacion);
		registrarEnBitacora("Consulta Detalle Cliente", "gui");
		
		super.mensaje = cliente.toString();
	}
}
