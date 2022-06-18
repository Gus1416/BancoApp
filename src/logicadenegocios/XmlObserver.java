/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 *
 * @author Alejandra Merino
 */
public class XmlObserver extends FormatoBitacoraObserver {

	public XmlObserver(Bitacora pBitacora) {
		subject = pBitacora;
		subject.attach(this);
	}

	@Override
	public void update() {
		String[] pBitacora = subject.getRegistro();
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document documento = null;

			if (new File("C:\\Users\\Gustavo\\OneDrive\\Documentos\\NetBeansProjects\\BancoApp\\Bitacoras.xml").exists()) {
				documento = builder.parse(new File("C:\\Users\\Gustavo\\OneDrive\\Documentos\\NetBeansProjects\\BancoApp\\Bitacoras.xml"));

			} else {
				DOMImplementation implementation = builder.getDOMImplementation();
				documento = implementation.createDocument(null, "Bitacoras.xml", null);
				documento.setXmlVersion("1.0");
			}

			Element nuevaBitacora = agregarBitacora(pBitacora, documento);
			documento.getDocumentElement().appendChild(nuevaBitacora);

			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			Result output = new StreamResult(new File("C:\\Users\\Gustavo\\OneDrive\\Documentos\\NetBeansProjects\\BancoApp\\Bitacoras.xml"));
			Source input = new DOMSource(documento);

			transformer.transform(input, output);
		} catch (TransformerException | SAXException | IOException | ParserConfigurationException ex) {
			System.out.println(ex.getMessage());
		}
	}

	private Element agregarBitacora(String[] pBitacora, Document pDocumento) {
		Element bitacora = pDocumento.createElement("bitacora");

		Element fecha = pDocumento.createElement("Fecha");
		Text textFecha = pDocumento.createTextNode(pBitacora[0]);
		fecha.appendChild(textFecha);
		bitacora.appendChild(fecha);

		Element hora = pDocumento.createElement("Hora");
		Text textHora = pDocumento.createTextNode(pBitacora[1]);
		hora.appendChild(textHora);
		bitacora.appendChild(hora);

		Element accion = pDocumento.createElement("Accion");
		Text textAccion = pDocumento.createTextNode(pBitacora[2]);
		accion.appendChild(textAccion);
		bitacora.appendChild(accion);

		Element vista = pDocumento.createElement("Vista");
		Text textVista = pDocumento.createTextNode(pBitacora[3]);
		vista.appendChild(textVista);
		bitacora.appendChild(vista);
		return bitacora;
	}
}