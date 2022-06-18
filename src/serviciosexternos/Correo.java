package serviciosexternos;

import java.util.Properties;
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
public class Correo implements ICorreo{
	//Propiedades para la conexión con Gmail

	private final String username = "iBancoApp@gmail.com";
	//private final String password = "DS2022*MAY";
	private final String password = "jkkwipmfqtrybixj";
	private final String fromEmail = "iBancoApp@gmail.com";
	private Properties prop;
	private String mensaje;

	public Correo(String pNombreCliente, String pNumCuenta) {
		//Establecimiento de las propiedades
		this.prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); //TLS
		prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		escribirMensaje(pNombreCliente, pNumCuenta);
	}

	/**
	 * Constructor de la clase
	 *
	 * @param pCorreo la dirección de correo electrónico del destinatario
	 * @param pPaciente
	 * @param pCita
	 * @return Un booleano que indica si el envío fue exitoso.
	 */
	@Override
	public void enviarCorreo(String pCorreoReceptor) {
		String toEmail = pCorreoReceptor;

		//Creación de la sesión
		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		MimeMessage msg = new MimeMessage(session);

		try {
			msg.setFrom(new InternetAddress(fromEmail));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			msg.setSubject("Prueba Envio Mail iBanco DS");

			Multipart emailContent = new MimeMultipart();

			//Cuerpo del correo
			MimeBodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setText(this.mensaje);

			emailContent.addBodyPart(textBodyPart);

			msg.setContent(emailContent);

			Transport.send(msg);
			System.out.println("Sent message");
			//return true;

		} catch (MessagingException e) {
			System.err.println(e.getMessage());
			//return false;
		}
	}
	
	private void escribirMensaje(String pNombreCliente, String pNumCuenta){
		this.mensaje = "Estimado cliente " + pNombreCliente;
		this.mensaje += "\n Lamentamos informarle que su cuenta número " + pNumCuenta + " ha sido desactivada"
						+ "debido al ingreso erróneo del pin en el sistema BancoApp en dos ocasiones. Por esa razón no podrá "
						+ "continuar realizando varias de las operaciones principales que se ofrecen al usuario.";
	}
	
	@Override
	public void setMensaje(String pMensaje){
		this.mensaje = pMensaje;
	}
	
	@Override
	public String getMensaje(){
		return this.mensaje;
	}
	
//	public String crearCuerpoInactivacion(String pNombreCliente, String pNumCuenta) {
//		String mensaje = "";
//		mensaje += "Estimad@ usuario " + pNombreCliente + "\n";
//		mensaje += "Le informamos que su cuenta número: " + pNumCuenta + " ha sido desactivada debido al ingreso de PIN incorrecto en múltiples ocasiones";
//		return mensaje;
//	}
}
