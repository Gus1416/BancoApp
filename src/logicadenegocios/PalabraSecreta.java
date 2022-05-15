/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;

/**
 *
 * @author Gustavo
 */
public class PalabraSecreta {
	private static final int CANTIDAD_CARACTERES = 5;
	
	public static String generarPalabraSecreta(){
		String alfanumerico = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789";
		StringBuilder builder = new StringBuilder(CANTIDAD_CARACTERES);
		
		for (int i = 0; i < CANTIDAD_CARACTERES; i++){
			int index = (int)(alfanumerico.length() * Math.random());
			builder.append(alfanumerico.charAt(index));
		}
		
		return builder.toString();
	}
}
