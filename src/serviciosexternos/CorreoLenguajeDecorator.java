package serviciosexternos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;

/**
 *
 * @author Gustavo
 */
public class CorreoLenguajeDecorator extends CorreoDecorator{
	
	public CorreoLenguajeDecorator(ICorreo pDecoratedCorreo){
		super(pDecoratedCorreo);
	}
	
	@Override
	public void enviarCorreo(String pCorreoElectronico){
		decoratedCorreo.setMensaje(concatenarMensaje());
		decoratedCorreo.enviarCorreo(pCorreoElectronico);
	}
	
	private String concatenarMensaje(){
		String mensajeEspanol = decoratedCorreo.getMensaje();
		String mensajeIngles = traducir(mensajeEspanol);
		return mensajeEspanol + "\n\n\n" + mensajeIngles;
	}
	
	private String traducir(String pTexto) {
		try {
			String urlStr = "https://script.google.com/macros/s/AKfycbytP8RrYg2b-sTIkKCWZ-xkAVBaK3Qzb9P_hoQnZf0sPc6-JzeZ-g6QsN-i4_-zuVsnvw/exec"
							+ "?q=" + URLEncoder.encode(pTexto, "UTF-8")
							+ "&target=" + "en"
							+ "&source=" + "es";

			URL url = new URL(urlStr);
			StringBuilder response = new StringBuilder();
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			return response.toString();
			
		} catch (IOException ex) {
			System.out.println(Arrays.toString(ex.getStackTrace()));
			return null;
		}
	}
}
