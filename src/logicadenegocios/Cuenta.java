/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Alejandra Merino
 */
public class Cuenta implements IComisiones, Comparable {

    private String numeroCuenta;
    private Date fechaCreacion;
    private double saldo;
    private String estatus = "activa";
    private String pin;
    private ArrayList<Operacion> operaciones;

    public Cuenta(String numeroCuenta, Date fechaCreacion, double saldo, String pin, ArrayList<Operacion> operaciones) {
        this.numeroCuenta = numeroCuenta;
        this.fechaCreacion = fechaCreacion;
        this.saldo = saldo;
        this.pin = pin;
        this.operaciones = operaciones;
    }

    public Cuenta(String pPin, double pMontoInicial) {
        pin = pPin;
        saldo = pMontoInicial;
        fechaCreacion = obtenerFechaSistema();
    }

    private Date obtenerFechaSistema() {
        Date fecha = new Date();
        return fecha;
    }

    private int contarDepositosRetiro() {
        return 1;
    }

    public void depositar(double pMontoDeposito) {
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void agregarOperacion(Date fechaOperacion, String tipoOperacion, boolean seCobraComision, double montoOperacion, double montoComision, String moneda) {
        Operacion ope = new Operacion(fechaOperacion, tipoOperacion, seCobraComision, montoOperacion, montoComision, moneda);
        operaciones.add(ope);
    }

}
