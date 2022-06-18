/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadeintegracion.gui;

import java.text.SimpleDateFormat;
import java.util.Date;
import logicacreacional.BitacoraSingleton;
import logicadeaccesodedatos.OperacionCRUD;
import logicadenegocios.Bitacora;

/**
 *
 * @author Alejandra Merino
 */
public class Controlador {
  protected String mensaje;

  public Controlador() {
    mensaje = "";
  }

  public String getMensaje() {
    return mensaje;
  }
  
	protected void registrarEnBitacora(String pTipoOperacion, String pVista) {
		Date pFechaHora = obtenerFechaHoraSistema();
		SimpleDateFormat formatterFecha = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatterHora = new SimpleDateFormat("HH:mm:ss");
		String[] registro = {formatterFecha.format(pFechaHora), formatterHora.format(pFechaHora), pTipoOperacion, pVista};
		Bitacora bitacora = BitacoraSingleton.getInstance();
		new OperacionCRUD().registrarEnBitacora(registro);
		bitacora.setRegistro(registro);
	}

	private Date obtenerFechaHoraSistema() {
		return new Date(System.currentTimeMillis());
	}

}
