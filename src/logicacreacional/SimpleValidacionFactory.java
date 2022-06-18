/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicacreacional;

import logicadevalidacion.Validacion;

/**
 * Esta es una abstraccion de una clase que incorpora el patron de diseño Simple
 * Factory para Validacion
 * @author merin
 */
public class SimpleValidacionFactory {
     /**
     * Este metodo encierra la logica de instanciacion de la clase Validacion
     * @return validacion
     */
	public Validacion crearValidacion(String pTipo) throws
					ClassNotFoundException, InstantiationException,
					IllegalAccessException {
		
		Validacion validacion = (Validacion) Class.forName("logicadevalidacion." + pTipo).newInstance();
		
		return validacion;
	}
}