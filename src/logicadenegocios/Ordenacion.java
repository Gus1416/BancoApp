package logicadenegocios;

/**
 *
 * @author Alejandra Merino
 */
public class Ordenacion {
  
  public void insercion (Comparable[] pArreglo) {
    for (int i = 1; i<pArreglo.length; i++) {
      Comparable nuevo = pArreglo[i];
      int j = i-1;
      while(j>=0 && ! pArreglo [j].comparar(nuevo)) {
        pArreglo [j + 1] = pArreglo [j];
        j--;
      }
      pArreglo [j+1] = nuevo;
    }
  }
}
