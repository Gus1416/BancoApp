/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadevalidacion;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import logicadeaccesodedatos.CuentaCRUD;
import logicadeintegracion.gui.ControladorInactivacionCuenta;
import logicadenegocios.Cuenta;

/**
 *
 * @author Alejandra Merino
 */
public class ValidacionCuenta extends Validacion {
  public CuentaCRUD cuentaCRUD;
  public String palabraSecreta;
  private static int fallaPin = 0;
  private static int fallaPalabra=0;
  private ControladorInactivacionCuenta control;

  public ValidacionCuenta() {
    cuentaCRUD = new CuentaCRUD ();
    control = new ControladorInactivacionCuenta ();
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
      validarEstatusNumeroCuenta (pNumCuenta);
      validarPinIngresadoPinActual (pPinActual,pNumCuenta);
    }
    esPinVulnerado (pNumCuenta);
  }
  
  public void validarDatosDeposito (String pNumCuenta, String pNum) {
    validarNumeroCuenta (pNumCuenta);
    validarNumeroEntero (pNum);
    if(esValido) {
      validarEstatusNumeroCuenta (pNumCuenta);
    }
  }
  
  public void validarDatosPrevioRetiro (String pNumCuenta, String pPin) {
    validarNumeroCuenta (pNumCuenta);
    validarPinCuenta (pPin);
    if(esValido) {
      validarPinIngresadoPinActual (pPin,pNumCuenta);
      validarEstatusNumeroCuenta (pNumCuenta);
    }
    esPinVulnerado (pNumCuenta);
  }
  
  public void validarDatosRetiro (String pSecreta, String pRetiro, String pNumCuenta) {
    validarPalabraSecreta (pSecreta);
    validarNumeroEntero (pRetiro);
    esPalabraVulnerada (pNumCuenta);
  }
  
  public void validarDatosTransferencia (String pSecreta, String pRetiro, 
          String pNumCuentaD, String pNumCuentaO) {
    validarPalabraSecreta (pSecreta);
    validarNumeroEntero (pRetiro);
    validarNumeroCuenta (pNumCuentaD);
    if(esValido) {
      validarEstatusNumeroCuenta (pNumCuentaD);
    }
    esPalabraVulnerada (pNumCuentaO);
  }
  
  public void validarPinIngresadoPinActual (String pPinActual, String pNumCuenta) {
    Cuenta cuenta = cuentaCRUD.consultarCuenta(pNumCuenta);
    System.out.println("Pin de la base: "+cuenta.getPin());
    System.out.println("Pin del GUI "+ pPinActual);
    if (!(cuenta.getPin().equals(pPinActual))) {
      esValido = false;
      resultado+= "El número de PIN ingresado no corresponde al de su cuenta. \n";
      fallaPin++;
      System.out.println("Hizo el ++");
    }
  }
  
  public void validarEstatusNumeroCuenta (String pNumCuenta) {
    Cuenta cuenta = cuentaCRUD.consultarCuenta(pNumCuenta);
    if(!(cuenta.getEstatus().equals("activa"))) {
      esValido = false;
      resultado+= "La cuenta ingresada está bloqueda.\nNo puede realizar la operación";
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
      fallaPalabra++;
    }
  }
  
  public void validarNumeroEntero (String pNum) {
    if(!esEntero (pNum)) {
      esValido = false;
      resultado += "Debe ingresar un número entero\n";
    }
  } 
  
  public void esPalabraVulnerada (String pNumCuenta) {
    if (fallaPalabra>=2) {
      esValido = false;
      resultado += "Ha ingresado su palabra secreta de forma incorrecta dos veces."
              + "\nSu cuenta ha sido bloqueada\n";
      control.controlarInactivarCuenta (pNumCuenta);
    }
  }
  
  public void esPinVulnerado (String pNumCuenta) {
    if (fallaPin>=2) {
      esValido = false;
      resultado += "Ha ingresado su PIN de forma incorrecta dos veces."
              + "\nSu cuenta ha sido bloqueada\n";
      control.controlarInactivarCuenta (pNumCuenta);
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

  public int getFallaPin() {
    return fallaPin;
  }

  public int getFallaPalabra() {
    return fallaPalabra;
  }

  
  
  
  
}
  
