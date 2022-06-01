package bancoapp;

import java.text.SimpleDateFormat;
import java.util.Date;
import logicacreacional.BitacoraSingleton;
import logicadenegocios.Bitacora;

/**
 *
 * @author Gustavo
 */
public class BancoApp {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		
//		Bitacora bitacora = BitacoraSingleton.getInstance();
//		
//		String[] registro1 = {"27/05/2022", "11:44", "Consulta", "GUI"};
//		String[] registro2 = {"28/05/2022", "9:00", "Retiro", "CLI"};
//		String[] registro3 = {"29/05/2022", "18:44", "Deposito", "WEB"};
//		
//		bitacora.setRegistro(registro1);
//		bitacora.setRegistro(registro2);
//		bitacora.setRegistro(registro3);		

		Date fecha = new Date(System.currentTimeMillis());
		
		registrarEnBitacora(fecha, "Consulta", "CLI");
	}
	
	public static void registrarEnBitacora(Date pFechaHora, String pTipoOperacion, String pVista) {
		SimpleDateFormat formatterFecha = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatterHora = new SimpleDateFormat("HH:mm:ss");
		String[] registro1 = {formatterFecha.format(pFechaHora), formatterHora.format(pFechaHora), pTipoOperacion, pVista};
		Bitacora bitacora = BitacoraSingleton.getInstance();
		bitacora.setRegistro(registro1);
	}
					
}
