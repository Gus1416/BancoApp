package serviciosexternos;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Clase que permite la conexión con Gmail para enviar el correo electrónico
 *
 * @author Gustavo
 * @version 09/10/2021
 */
public class Correo {
  //Propiedades para la conexión con Gmail
  
  private final String username = "iBancoApp@gmail.com";
  private final String password = "DS2022*MAY";
  private final String fromEmail = "iBancoApp@gmail.com";
  private Properties prop;
  
  public Correo(){

    //Establecimiento de las propiedades
    this.prop = new Properties();
    prop.put("mail.smtp.host", "smtp.gmail.com");
    prop.put("mail.smtp.port", "587");
    prop.put("mail.smtp.auth", "true");
    prop.put("mail.smtp.starttls.enable", "true"); //TLS
    prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
    prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
  }

  /**
   * Constructor de la clase
   * 
   * @param pCorreo     la dirección de correo electrónico del destinatario
   * @param pPaciente
   * @param pCita
   * @return Un booleano que indica si el envío fue exitoso.
   */
  public boolean enviarCorreo(String pCorreoReceptor, String pNombreCliente , String pNumCuenta){
    String toEmail = pCorreoReceptor;

    //Creación de la sesión
    Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
      @Override
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
      }
    });

    MimeMessage msg = new MimeMessage(session);
    
    try{
      msg.setFrom(new InternetAddress(fromEmail));
      msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
      msg.setSubject("Prueba Envio Mail iBanco DS");

      Multipart emailContent = new MimeMultipart();

      //Cuerpo del correo
      MimeBodyPart textBodyPart = new MimeBodyPart(); 
      textBodyPart.setText(crearCuerpoInactivacion(pNombreCliente, pNumCuenta));
        
      emailContent.addBodyPart(textBodyPart);

      msg.setContent(emailContent);

      Transport.send(msg);
      System.out.println("Sent message");
      return true;
      
    } catch (MessagingException e){
      System.err.println(e.getMessage());
      return false;
    }
  }
  
  
  
  private String crearCuerpoInactivacion(String pNombreCliente, String pNumCuenta){ 
    String cuerpo = "";
    cuerpo += "Estimad@ usuario " + pNombreCliente;
    cuerpo += "\n";
    cuerpo += "Le informamos que su cuenta número: " + pNumCuenta + " ha sido "
            + "desactivada debido al ingreso incorrecto del PIN o palabra "
            + "secreta en múltiples ocasiones" ;
    return cuerpo;
  }
  
  
}
