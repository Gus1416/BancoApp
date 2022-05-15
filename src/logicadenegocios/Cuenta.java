package logicadenegocios;

import java.util.ArrayList;
import java.util.Date;
import logicadevalidacion.FondosInsuficientesExcepcion;
import serviciosexternos.TipoCambio;

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
    private int cantidadDepositosOperaciones = 0;
    private static int identificadorCuenta = 0;  ////
 
    public Cuenta() {
    }

    public Cuenta(String pPin, double pMontoInicial) {
        pin = pPin;
        saldo = pMontoInicial;
        estatus = "activa" ;   ////
        numeroCuenta = "CTA_" + ++identificadorCuenta;  ///
        fechaCreacion = obtenerFechaSistema();
        operaciones = new ArrayList<>();
    }
    
    public Cuenta(String pPin, double pMontoInicial, int pNum) {
        identificadorCuenta = pNum;  
        pin = pPin;
        saldo = pMontoInicial;
        estatus = "activa" ;   ////
        numeroCuenta = "CTA_" + ++identificadorCuenta;  ///
        fechaCreacion = obtenerFechaSistema();
        operaciones = new ArrayList<>();
    }

    private Date obtenerFechaSistema() {
        Date fecha = new Date();
        return fecha;
    }

    //La comision deberia restarse o se suma?
    public void depositarColones(double pMontoDeposito) {
        boolean seCobraComision = determinarCobroComision();
        double comision = 0.00;

        if (seCobraComision) {
            comision = pMontoDeposito * 0.02;
        }

        this.saldo += (pMontoDeposito - comision);
        registrarOperacion("Depósito", pMontoDeposito, seCobraComision, comision, "Colones");
    }
    
    public void depositarColones(double pMontoDeposito, int pNum) {
        boolean seCobraComision = determinarCobroComision();
        double comision = 0.00;

        if (seCobraComision) {
            comision = pMontoDeposito * 0.02;
        }

        this.saldo += (pMontoDeposito - comision);
        registrarOperacion("Depósito", pMontoDeposito, seCobraComision, comision, "Colones", pNum);
    }

    public void depositarDolares(double pMontoDepositoDolares) {
        TipoCambio tc = new TipoCambio();
        double depositoEnColones = tc.convertirAColones(pMontoDepositoDolares);
        boolean seCobraComision = determinarCobroComision();
        double comision = 0.00;

        if (seCobraComision) {
            comision = depositoEnColones * 0.02;
        }

        this.saldo += (depositoEnColones - comision);
        registrarOperacion("Depósito", pMontoDepositoDolares, seCobraComision, comision, "Dólares");
    }
    
    public void depositarDolares(double pMontoDepositoDolares, int pNum) {
        TipoCambio tc = new TipoCambio();
        double depositoEnColones = tc.convertirAColones(pMontoDepositoDolares);
        boolean seCobraComision = determinarCobroComision();
        double comision = 0.00;

        if (seCobraComision) {
            comision = depositoEnColones * 0.02;
        }

        this.saldo += (depositoEnColones - comision);
        registrarOperacion("Depósito", pMontoDepositoDolares, seCobraComision, comision, "Dólares", pNum);
    }

    public void retirarColones(double pMontoRetiro) throws FondosInsuficientesExcepcion {
        boolean seCobraComision = determinarCobroComision();
        double comision = 0.00;
        double montoTotalRetiro = pMontoRetiro;

        if (seCobraComision) {
            comision = pMontoRetiro * 0.02;
            montoTotalRetiro += comision;
        }

        if (validarRetiro(montoTotalRetiro)) {
            this.saldo -= (montoTotalRetiro);
            registrarOperacion("Retiro", pMontoRetiro, seCobraComision, comision, "Colones");
        } else {
            double saldoFaltante = montoTotalRetiro - this.saldo;
            throw new FondosInsuficientesExcepcion(saldoFaltante);
        }
    }
    
    public void retirarColones(double pMontoRetiro, int pNum) throws FondosInsuficientesExcepcion {
        boolean seCobraComision = determinarCobroComision();
        double comision = 0.00;
        double montoTotalRetiro = pMontoRetiro;

        if (seCobraComision) {
            comision = pMontoRetiro * 0.02;
            montoTotalRetiro += comision;
        }

        if (validarRetiro(montoTotalRetiro)) {
            this.saldo -= (montoTotalRetiro);
            registrarOperacion("Retiro", pMontoRetiro, seCobraComision, comision, "Colones", pNum);
        } else {
            double saldoFaltante = montoTotalRetiro - this.saldo;
            throw new FondosInsuficientesExcepcion(saldoFaltante);
        }
    }

    public void retirarDolares(double pMontoRetiro) throws FondosInsuficientesExcepcion {
        boolean seCobraComision = determinarCobroComision();
        double comision = 0.00;

        TipoCambio tc = new TipoCambio();
        double montoTotalRetiro = tc.convertirAColones(pMontoRetiro);

        if (seCobraComision) {
            comision = pMontoRetiro * 0.02;
            montoTotalRetiro += comision;
        }

        if (validarRetiro(montoTotalRetiro)) {
            this.saldo -= montoTotalRetiro;
            registrarOperacion("Retiro", pMontoRetiro, seCobraComision, comision, "Dólares");
        } else {
            double saldoFaltante = montoTotalRetiro - this.saldo;
            throw new FondosInsuficientesExcepcion(saldoFaltante);
        }
    }
    
    public void retirarDolares(double pMontoRetiro, int pNum) throws FondosInsuficientesExcepcion {
        boolean seCobraComision = determinarCobroComision();
        double comision = 0.00;

        TipoCambio tc = new TipoCambio();
        double montoTotalRetiro = tc.convertirAColones(pMontoRetiro);

        if (seCobraComision) {
            comision = pMontoRetiro * 0.02;
            montoTotalRetiro += comision;
        }

        if (validarRetiro(montoTotalRetiro)) {
            this.saldo -= montoTotalRetiro;
            registrarOperacion("Retiro", pMontoRetiro, seCobraComision, comision, "Dólares", pNum);
        } else {
            double saldoFaltante = montoTotalRetiro - this.saldo;
            throw new FondosInsuficientesExcepcion(saldoFaltante);
        }
    }

    public void recibirTransferencia(double pMontoRecibido) {
        this.saldo += pMontoRecibido;
        registrarOperacion("Transferencia", pMontoRecibido, false, 0.00, "Colones");
    }
    
    public void recibirTransferencia(double pMontoRecibido, int pNum) {
        this.saldo += pMontoRecibido;
        registrarOperacion("Transferencia", pMontoRecibido, false, 0.00, "Colones", pNum);
    }

    private boolean validarRetiro(double pMontoTotalRetiro) {
        return pMontoTotalRetiro + (pMontoTotalRetiro * 0.02) <= this.saldo;
    }

    private boolean determinarCobroComision() {
        return this.cantidadDepositosOperaciones > 3;
    }

    private void registrarOperacion(String pTipoOperacion, double pMontoOperacion, boolean pSeCobraComision, double pMontoComision, String pMoneda) {
        Operacion operacion = new Operacion(obtenerFechaSistema(), pTipoOperacion, pMontoOperacion, pSeCobraComision, pMontoComision, pMoneda);
        operaciones.add(operacion);
        this.cantidadDepositosOperaciones++;
    }
    
    private void registrarOperacion(String pTipoOperacion, double pMontoOperacion,
            boolean pSeCobraComision, double pMontoComision, String pMoneda, int pNum) {
        Operacion operacion = new Operacion(obtenerFechaSistema(), pTipoOperacion,
                pMontoOperacion, pSeCobraComision, pMontoComision, pMoneda, pNum);
        operaciones.add(operacion);
        this.cantidadDepositosOperaciones++;
    }

    private void registraOperacion() {
        Operacion operacion = new Operacion(obtenerFechaSistema(), "Consulta", false);
        operaciones.add(operacion);
    }

    @Override
    public double calcularTotalComisionesDepositos() {
        ArrayList<Operacion> depositos = obtenerListaDepositos();
        double totalComisionesDepositos = 0.0;
        for (Operacion deposito : depositos) {
            totalComisionesDepositos += deposito.getMontoComision();
        }
        return totalComisionesDepositos;
    }

    @Override
    public double calcularTotalComisionesRetiros() {
        ArrayList<Operacion> retiros = obtenerListaRetiros();
        double totalComisionesRetiros = 0.0;
        for (Operacion retiro : retiros) {
            totalComisionesRetiros += retiro.getMontoComision();
        }

        return totalComisionesRetiros;
    }

    @Override
    public double calcularTotalComisiones() {
        double totalComisiones = 0.0;

        for (Operacion operacion : this.operaciones) {
            totalComisiones += operacion.getMontoComision();
        }
        return totalComisiones;
    }

    private ArrayList obtenerListaDepositos() {
        ArrayList depositos = new ArrayList<Operacion>();
        for (Operacion operacion : this.operaciones) {
            if (operacion.getTipoOperacion().equals("Depósito")) {
                depositos.add(operacion);
            }
        }
        return depositos;
    }

    private ArrayList obtenerListaRetiros() {
        ArrayList retiros = new ArrayList<Operacion>();
        for (Operacion operacion : this.operaciones) {
            if (operacion.getTipoOperacion().equals("Retiros")) {
                retiros.add(operacion);
            }
        }
        return retiros;
    }

    public String consultarDetallesOperaciones() {
        String mensaje = "Operaciones: \n";
        for (Operacion elemento : operaciones) {
            mensaje += operaciones.toString();
        }
        return mensaje;
    }

    public String consultarEstatus() {
        String mensaje = "La cuenta número XXXXXX tiene estatus de: " + estatus;
        return mensaje;
    }

    public void inactivarCuenta() {
        this.estatus = "inactiva";
    }

    public void cambiarPin(String pNuevoPin) {
        this.pin = pNuevoPin;
    }

    public boolean verificarPin(String pPinAntiguo) {
        return this.getPin().equals(pPinAntiguo) == true;
    }

    @Override
    public boolean comparar(Comparable b) {
        return false;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getEstatus() {
        return estatus;
    }

    public Date getFechaCreacion() {    ///// 
        return fechaCreacion;
    }
    
    

    public double getSaldo() {
        return this.saldo;
    }

    public double getSaldoDolares() {
        TipoCambio tc = new TipoCambio();
        return tc.convertirADolares(this.saldo);
    }

    @Override
    public String toString() {
        return "Cuenta{" + "numeroCuenta=" + numeroCuenta + ", fechaCreacion=" + fechaCreacion + ", saldo=" + saldo + ", estatus=" + estatus + ", pin=" + getPin() + ", operaciones=" + operaciones + '}';
    }

    /**
     * @return the pin
     */
    public String getPin() {
        return pin;
    }
    
    /**
     * @return the operaciones
     */
    public ArrayList<Operacion> getOperaciones() {
      return operaciones;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    /**
     * @param operaciones the operaciones to set
     */
    public void setOperaciones(ArrayList<Operacion> operaciones) {
      this.operaciones = operaciones;
    }

    public void setPin(String pin) {
      this.pin = pin;
    }
     
    
    
}

