/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicacreacional;

import logicadenegocios.Operacion;

/**
 *
 * @author sebcor
 */
public class OperacionSingleton {
        //Lazy version

    private static Operacion instance;

    private OperacionSingleton() {
    }

    public static Operacion getInstance() {
        if (instance == null) {
            instance = new Operacion();
        }
        return instance;
    }
}
