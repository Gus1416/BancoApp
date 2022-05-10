/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;

import java.util.ArrayList;

/**
 *
 * @author Alejandra Merino
 */
public class Ordenacion {
  
  public void insercion (ArrayList<Comparable> pArreglo) {
    for (int i = 1; i<pArreglo.size(); i++) {
      Comparable nuevo = pArreglo.get(i);
      int j = i-1;
      while(j>=0 && ! pArreglo.get(j).comparar(nuevo)) {
        pArreglo.add(j + 1, pArreglo.get(j));
        j--;
      }
      pArreglo.add(j+1, nuevo);
    }
  }
  
}
