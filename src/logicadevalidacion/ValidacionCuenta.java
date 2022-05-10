/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadevalidacion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Alejandra Merino
 */
public class ValidacionCuenta extends Validacion {
  
  public void validarDatosCuenta (String pPin, String pNum) {
    validarPinCuenta (pPin);
    validarNumeroEntero (pNum);
  }
  
  public void validarPinCuenta (String pPIN) {
    if(!validarPIN (pPIN)) {
      esValido = false;
      resultado += "Debe ingresar un PIN con al menos una letra mayúscula, al "
              + "menos un número y al menos un carácter especial. \n";
    }
  }
  
  public void validarNumeroEntero (String pNum) {
    if(!esEntero (pNum)) {
      esValido = false;
      resultado += "Debe ingresar un número entero\n";
    }
  } 
  
  public boolean validarPIN (String pPIN ) {
    Pattern patron = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=.*[@#$%^&-+=])(?=\\S+$).{6,6}$");
    Matcher compara = patron.matcher(pPIN);
    return compara.matches();
  }
  
  public boolean esEntero (String pNum){
    try {
      Integer.parseInt(pNum);
        return true;
    } catch (NumberFormatException nfe){
      return false;
    }
  }
  
}
  
