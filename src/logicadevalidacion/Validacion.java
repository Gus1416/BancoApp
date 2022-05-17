/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadevalidacion;

/**
 *
 * @author Alejandra Merino
 */
public class Validacion {
  public boolean esValido = true;
  public String resultado = "";
  
  public void setResultado(String resultado) {
    this.resultado = resultado;
  }

  public String getResultado() {
    return resultado;
  }

  public boolean esValido() {
    return esValido;
  }
  
  public void setValido () {
    this.esValido = true;
  }
  
  
  
}
