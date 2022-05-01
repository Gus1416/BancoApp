package bancoapp;

import serviciosexternos.TipoCambio;

/**
 *
 * @author Gustavo
 */
public class BancoApp {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		TipoCambio tc = new TipoCambio();
		System.out.println(tc.convertirAColones(100));
	}
	
}
