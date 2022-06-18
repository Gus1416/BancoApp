/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicacreacional;

import logicadeaccesodedatos.OperacionCRUD;

/**
 *
 * @author sebcor
 */
public class OperacionCRUDSingleton {
    //Lazy version

    private static OperacionCRUD instance;

    private OperacionCRUDSingleton() {
    }

    public static OperacionCRUD getInstance() {
        if (instance == null) {
            instance = new OperacionCRUD();
        }
        return instance;
    }

}

