package logicadeintegracion.gui;

import java.util.ArrayList;
import logicadeaccesodedatos.ClienteCRUD;
import logicadeaccesodedatos.CuentaCRUD;
import logicadeaccesodedatos.OperacionCRUD;
import logicadenegocios.Cliente;
import logicadenegocios.Cuenta;
import logicadenegocios.Operacion;
import logicadenegocios.PalabraSecreta;
import logicadevalidacion.FondosInsuficientesExcepcion;
import serviciosexternos.Sms;

/**
 *
 * @author Alejandra Merino
 */
public class ControladorTransferencia extends Controlador {

	private ClienteCRUD clienteCRUD;
	private String palabraSecreta;
	private Cuenta cuenta;
	private CuentaCRUD cuentaCRUD;
	private OperacionCRUD operacionCRUD;

	public ControladorTransferencia() {
		clienteCRUD = new ClienteCRUD();
		cuentaCRUD = new CuentaCRUD();
		operacionCRUD = new OperacionCRUD();
	}

	public void controlarTransferencia(String pNumCuentaO, String pTransferencia,
					String pNumCuentaD) throws FondosInsuficientesExcepcion {
		cuenta = devolverCuentaDeposito(pNumCuentaO);
		double retiro = Double.parseDouble(pTransferencia);
		int numOperaciones = cuentaCRUD.obtenerCantidadOperaciones();
		int numOperacionesCuenta = operacionCRUD.obtenerCantidadOpeCuenta(pNumCuentaO);
		cuenta.setCantidadDepositosRetiros(numOperacionesCuenta);
		cuenta.retirarColones(retiro, numOperaciones);
		cuentaCRUD.actualizarSaldo(cuenta);
		ArrayList<Operacion> operaciones = cuenta.getOperaciones();
		Operacion operacion = operaciones.get(operaciones.size() - 1);
		operacionCRUD.registrarOperacion(operacion, pNumCuentaO);

		Cuenta cuentaDestino = new Cuenta();
		cuentaDestino = devolverCuentaDeposito(pNumCuentaD);
		numOperaciones = cuentaCRUD.obtenerCantidadOperaciones();
		int numOperacionesCuentaD = operacionCRUD.obtenerCantidadOpeCuenta(pNumCuentaD);
		cuentaDestino.setCantidadDepositosRetiros(numOperacionesCuentaD);
		cuentaDestino.depositarColones(retiro, numOperaciones);
		cuentaCRUD.actualizarSaldo(cuentaDestino);
		ArrayList<Operacion> operacionesD = cuentaDestino.getOperaciones();
		Operacion operacionD = operacionesD.get(operacionesD.size() - 1);
		operacionCRUD.registrarOperacion(operacionD, pNumCuentaD);
		registrarEnBitacora("Transferencia Bancaria (CRC)", "gui");
		super.mensaje = "Estimado usuario, la transferencia de fondos se ejecutó "
						+ "satisfactoriamente.\n" + "El monto retirado de la cuenta origen y"
						+ " depositado en la cuenta destino es: \n" + retiro + " colones.\n"
						+ "[El monto cobrado por concepto de comisión a la cuenta origen fue "
						+ "de: " + operacion.getMontoComision() + "\n"
						+ " colones, que fueron rebajados automáticamente de su saldo actual]";
	}

	public void controlarEnvioSms(String pNumCuenta) {
		Cliente cliente = clienteCRUD.consultarPropietarioCuenta(pNumCuenta);
		PalabraSecreta secreta = new PalabraSecreta();
		palabraSecreta = PalabraSecreta.generarPalabraSecreta();
		Sms mensajeTexto = new Sms();
		mensajeTexto.enviarSms(palabraSecreta, cliente.getNumeroTelefono());
		super.mensaje = "Estimado usuario se ha enviado una palabra por mensaje "
						+ "de texto, por favor revise sus mensajes y proceda a digitar la"
						+ " palabra enviada.";
	}

	public Cuenta devolverCuentaDeposito(String pNumCuenta) {
		Cuenta pCuenta = cuentaCRUD.consultarCuenta(pNumCuenta);
		return pCuenta;
	}

	public String getPalabraSecreta() {
		return palabraSecreta;
	}
}
