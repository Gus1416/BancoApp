package serviciosexternos;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <code>TipoCambio</code> es una clase que se comunica con el WebService del BCCR para obtener el tipo de cambio en tiempo real. Se comunica mediante el protocolo <code>HTTP GET</code>. Sólo funciona
 * con la moneda <strong>USD</strong>.
 *
 * @author Hans Araya
 * @version 1.0
 */
public class TipoCambio {

	private int indicador = 0; //317: Compra, 318: Venta
	private String fechaInicial;
	private String fechaFinal;
	private final String nombre = "TEC";
	private final String subNiveles = "N";
	private final String correoElectronico = "guscalure43@gmail.com";
	private final String token = "GAPTEEAA0R";
	private final String HOST = "https://gee.bccr.fi.cr/Indicadores/Suscripciones/WS/wsindicadoreseconomicos.asmx/ObtenerIndicadoresEconomicosXML";
	private String url;
	private final String VALUE_TAG = "NUM_VALOR";

	public TipoCambio() {
		setFecha();
	}

	/**
	 * Devuelve el valor de <strong>COMPRA</strong> USD del BCCR
	 *
	 * @return <code>Double</code> con el valor del precio de compra.
	 */
	public double getCompra() {
		setCompra();

		double valor = Double.parseDouble(getValue());
		return valor;
	}

	/**
	 * Devuelve el valor de <strong>VENTA</strong> USD del BCCR
	 *
	 * @return <code>Double</code> con el valor del precio de venta.
	 */
	public double getVenta() {
		setVenta();

		double valor = Double.parseDouble(getValue());
		return valor;
	}
	
	public double convertirADolares(double pColones){
		double compra = getCompra();
		return pColones/compra;
	}
	
	public double convertirAColones(double pDolares){
		double venta = getVenta();
		return pDolares * venta;
	}

	/**
	 * Obtiene el XML del WebService del BCCR y parsea el documento para obtener el valor (dado por VALUE_TAG)
	 *
	 * @return String
	 */
	private String getValue() {
		try {
			setUrl(); //Set del Url con los Parámetros

			//Obtiene y Parsea el XML
			String data = GetMethod.getHTML(url);
			XmlParser xml = new XmlParser(data);

			//Retorna el valor del tag
			return xml.getValue(VALUE_TAG);
		} catch (Exception e) {
			System.out.println("Error al obtener el valor del BCCR.");
			return "0";
		}
	}

        public String getFechaFinal() {
                return fechaFinal;
        }
        

	private void setUrl() {
		String params = "Indicador=" + indicador + "&FechaInicio=" + fechaInicial + "&FechaFinal=" + fechaFinal + "&Nombre=" + nombre + "&SubNiveles=" + subNiveles +"&CorreoElectronico="+ correoElectronico +"&Token=" + token;
		this.url = HOST + "?" + params;
	}

	private void setFecha() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		this.fechaInicial = sdf.format(date);
		this.fechaFinal = fechaInicial;
	}

	private void setCompra() {
		this.indicador = 317;
	}

	private void setVenta() {
		this.indicador = 318;
	}
}