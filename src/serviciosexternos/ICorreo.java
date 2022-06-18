/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package serviciosexternos;

/**
 *
 * @author Gustavo
 */
public interface ICorreo {
	public abstract void enviarCorreo(String pCorreoElectronico);
	public abstract String getMensaje();
	public abstract void setMensaje(String pMensaje);
}
