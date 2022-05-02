
package logicadenegocios;

import java.util.ArrayList;

/**
 *
 * @author SebCor
 */


public class Busqueda {
    // a
    
    public Cuenta buscarCuenta(String pNumCuenta,ArrayList<Cuenta>pListaCuentas){
        for (int i = 0; i < pListaCuentas.size(); i++) {
            if(pListaCuentas.get(i).getNumeroCuenta().equals(pNumCuenta)){
                return pListaCuentas.get(i);
            }
        }
       return pListaCuentas.get(0);
    }
    
    public Cliente buscarCliente(String pCodigoCliente,ArrayList<Cliente>pListaClientes){
        for (int i = 0; i < pListaClientes.size(); i++) {
            if(pListaClientes.get(i).getNumeroCuenta().equals(pCodigoCliente)){
                return pListaClientes.get(i);
            }
        }
       return pListaClientes.get(0);
    }
    
    
}
