/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicacreacional;

import logicadeaccesodedatos.CuentaCRUD;

/**
 *
 * @author sebcor
 */
public class CuentaCRUDSingleton {
    //Lazy version

    private static CuentaCRUD instance;

    private CuentaCRUDSingleton() {
    }

    public static CuentaCRUD getInstance() {
        if (instance == null) {
            instance = new CuentaCRUD();
        }
        return instance;
    }

}

