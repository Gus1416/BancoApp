/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadevalidacion;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import logicadeaccesodedatos.CuentaCRUD;
import logicadenegocios.Cuenta;

/**
 *
 * @author Alejandra Merino
 */
public class ValidacionCuenta extends Validacion {
  public CuentaCRUD cuentaCRUD;
  public String palabraSecreta;

  public ValidacionCuenta() {
    cuentaCRUD = new CuentaCRUD ();
  }
  
  
  
  public void validarDatosCuenta (String pPin, String pNum) {
    validarPinCuenta (pPin);
    validarNumeroEntero (pNum);
  }
  
  public void validarCambioPin (String pPinActual, String pPinNuevo, String pNumCuenta) {
    validarNumeroCuenta (pNumCuenta);
    validarPinCuenta (pPinActual);
    validarPinCuenta (pPinNuevo);
    if(esValido) {
      validarPinIngresadoPinActual (pPinActual,pNumCuenta);
    }
  }
  
  public void validarDatosDeposito (String pNumCuenta, String pNum) {
    validarNumeroCuenta (pNumCuenta);
    validarNumeroEntero (pNum);
  }
  
  public void validarDatosPrevioRetiro (String pNumCuenta, String pPin) {
    validarNumeroCuenta (pNumCuenta);
    validarPinCuenta (pPin);
    if(esValido) {
      validarPinIngresadoPinActual (pPin,pNumCuenta);
    }
  }
  
  public void validarDatosRetiro (String pSecreta, String pRetiro) {
    validarPalabraSecreta (pSecreta);
    validarNumeroEntero (pRetiro);
  }
  
  public void validarDatosTransferencia (String pSecreta, String pRetiro, 
          String pNumCuenta) {
    validarPalabraSecreta (pSecreta);
    validarNumeroEntero (pRetiro);
    validarNumeroCuenta (pNumCuenta);
  }
  
  public void validarPinIngresadoPinActual (String pPinActual, String pNumCuenta) {
    Cuenta cuenta = cuentaCRUD.consultarCuenta(pNumCuenta);
    if (!(cuenta.getPin().equals(pPinActual))) {
      esValido = false;
      resultado+= "El número de PIN ingresado no corresponde al de su cuenta. \n";
    }
  }
  
  
  public void validarNumeroCuenta (String pNumCuenta) {
    ArrayList<Cuenta> cuentas = cuentaCRUD.consultarCuentas();
    for (Cuenta cuenta:cuentas) {
      if (cuenta.getNumeroCuenta().equals(pNumCuenta)) {
        return;
      }
    }
    esValido = false;
    resultado+= "Debe ingresar un número de cuenta válido. \n";
  }
  
  public void validarPinCuenta (String pPIN) {
    if(!validarPIN (pPIN)) {
      esValido = false;
      resultado += "Debe ingresar un PIN con al menos una letra mayúscula, al "
              + "menos un número y al menos un carácter especial. \n";
    }
  }
  
  public void validarPalabraSecreta (String pSecreta) {
    if(!(palabraSecreta.equals(pSecreta))) {
      esValido = false;
      resultado += "Debe ingresar la palabra secreta correspondiente \n";
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

  public void setPalabraSecreta(String palabraSecreta) {
    this.palabraSecreta = palabraSecreta;
  }
  
}
  
