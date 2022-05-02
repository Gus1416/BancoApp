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
public class ValidacionCuenta {
  
  
  public boolean validarPIN (String pPIN ) {
    Pattern patron = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=.*[@#$%^&-+=])(?=\\S+$).{6,6}$");
    Matcher compara = patron.matcher(pPIN);
    return compara.matches();
  }
}
  
