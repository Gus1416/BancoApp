package bancoapp;

import java.util.ArrayList;
import java.util.Date;
import logicadeaccesodedatos.ClienteCRUD;
import logicadenegocios.Cliente;
import logicadenegocios.Ordenacion;
import logicadenegocios.Comparable;
import logicadevalidacion.ValidacionCuenta;
import logicadevalidacion.ValidacionPersona;

/**
 *
 * @author Gustavo
 */
public class BancoApp {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
          Date fecha = new Date ();
          Cliente cliente = new Cliente ("504380302", "Sanchez", "Ramirez", "Eduardo", fecha, "87784533","edu33@hotmail.com");
          Date fecha2 = new Date ();
          Cliente cliente2 = new Cliente ("404380302", "Arias", "Ramirez", "Pepe", fecha, "77784533","ari@hotmail.com");
          Date fecha3 = new Date ();
          Cliente cliente3 = new Cliente ("404380302", "Cespedes", "Ramirez", "Maribel", fecha, "81184533","mari@hotmail.com");
          Date fecha4 = new Date ();
          Cliente cliente4 = new Cliente ("404380302", "Duarte", "Ramirez", "Ana Yancy", fecha, "97784533","yancy@hotmail.com");
          
          ArrayList <Comparable> listaClientes = new ArrayList ();
          listaClientes.add((Comparable) cliente);
          listaClientes.add((Comparable) cliente2);
          listaClientes.add((Comparable) cliente3);
          listaClientes.add((Comparable) cliente4);
          
          Ordenacion ordena = new Ordenacion ();
          ordena.insercion(listaClientes);
          for(int i = 0; i<listaClientes.size(); i++) {
            System.out.println(listaClientes.get(i).toString());
          }
	}
}
