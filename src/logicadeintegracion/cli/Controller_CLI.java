package logicadeintegracion.cli;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import logicacreacional.BitacoraSingleton;
import logicadeaccesodedatos.ClienteCRUD;
import logicadeaccesodedatos.CuentaCRUD;
import logicadeaccesodedatos.OperacionCRUD;
import logicadenegocios.Bitacora;
import logicadenegocios.Cliente;
import logicadenegocios.Cuenta;
import logicadenegocios.Ordenacion;
import logicadenegocios.Busqueda;
import logicadenegocios.Operacion;
import logicadenegocios.PalabraSecreta;
import logicadevalidacion.FondosInsuficientesExcepcion;
import static logicadevalidacion.ValidacionCliente.validarCorreoElectronico;
import static logicadevalidacion.ValidacionCliente.validarNumeroTelefonico;
import static logicadevalidacion.ValidacionCuenta.validarPIN;
import static logicadevalidacion.ValidacionFecha.validarFormatoFecha;
import static logicadevalidacion.ValidacionPersona.validarApellido;
import static logicadevalidacion.ValidacionPersona.validarIdentificacion;
import static logicadevalidacion.ValidacionPersona.validarNombre;
import serviciosexternos.Correo;
import serviciosexternos.Sms;
import serviciosexternos.TipoCambio;

/**
 *
 * @author SebCor
 */
public class Controller_CLI {
    

// VALIDACIONES / VERIFICACIONES ------------------------------------------------------------------------------------------   
    public String validacionApellido(String pApellidoInicial) {

        if (validarApellido(pApellidoInicial) == true) {
            return pApellidoInicial;
        } else {
            System.out.println("Por favor ingrese carácteres válidos para el apellido del nuevo cliente");
            return null;
        }
    }

    public String validacionNombre(String pNombre) {
        if (validarNombre(pNombre) == true) {
            return pNombre;
        } else {
            System.out.println("Por favor ingrese carácteres válidos para el nombre del nuevo cliente");
            return null;
        }
    }

    public String validacionIdentificacion(String pIdentificacion) {
        if (validarIdentificacion(pIdentificacion) == true) {
            return pIdentificacion;
        } else {
            System.out.println("Por favor ingrese carácteres válidos para la identificación del nuevo cliente");
            return null;
        }

    }

    public String validacionFechaNacimiento(String pFechaNacimiento) {
        if (validarFormatoFecha(pFechaNacimiento) == true) {
            return pFechaNacimiento;
        } else {
            System.out.println("Por favor ingrese una fecha válida");
            return null;
        }

    }

    public String validacionNumTel(String pNumTel) {
        if (validarNumeroTelefonico(pNumTel) == true) {
            return pNumTel;
        } else {
            System.out.println("Por favor ingrese un número válido");
            return null;
        }

    }

    public String validacionCorreoElectronico(String pMail) {
        if (validarCorreoElectronico(pMail) == true) {
            return pMail;
        } else {
            System.out.println("Por favor ingrese un formato de correo válido");
            return null;
        }

    }

    public static String validacionPIN(String pPIN) {
        if (validarPIN(pPIN) == true) {
            return pPIN;

        } else {
            System.out.println("Por favor ingrese un formato de PIN válido");
            System.out.println("debe incluir al menos una letra mayúscula, al menos un número y al menos un \n"
                    + "carácter especial)");
            return null;
        }

    }

    public Double validacionSaldoInicial(int pSaldo) {
        if ((pSaldo % 1) == 0) {
            Double convert = new Double(pSaldo);
            return convert;
        } else {
            System.out.println("Favor ingrese un numero sin decimales");
            return 0.0;
        }

    }

    public static Cliente verificarCliente_Sistema(String pIdentificacion) {

        ClienteCRUD clientesBD = new ClienteCRUD();
        ArrayList<Cliente> clientes = clientesBD.consultarClientes();

        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getIdentificacion().equals(pIdentificacion) == true) {
                return clientes.get(i);
            }
        }
        System.out.println("El sistema no ha registrado un cliente con la identificación ingresada");
        return null;

    }

    public Cuenta validarCuenta(String pNumCuenta) {
        CuentaCRUD crudCuenta = new CuentaCRUD();
        Cuenta cuentaActual;
        cuentaActual = crudCuenta.consultarCuenta(pNumCuenta);

        if (cuentaActual != null) {
            return cuentaActual;
        } else {
            System.out.println("El numero de cuenta ingresado no está asociado a ninguna cuenta del sistema");
            return null;
        }
    }

    public boolean verificarPIN(Cuenta cuentaActual) {
        Cliente tempClient;

        Scanner rd = new Scanner(System.in);
        System.out.println("Ingrese el PIN de la cuenta: ");
        String pAntiguo = rd.nextLine();
        String pAntiguoDos;

        if (cuentaActual.verificarPin(pAntiguo) == true) {
            System.out.println("El PIN ingresado es correcto");
            return true;
        } else {
            System.out.println("El PIN ingresado no pertenece a esta cuenta, favor ingrese el PIN nuevamente");
            pAntiguoDos = rd.nextLine();
            if (cuentaActual.verificarPin(pAntiguoDos) == true) {
                System.out.println("El PIN ingresado es correcto");
                return true;
            } else {
                System.out.println("La cuenta ha sido bloqueda por ingreso de pin incorrecto en dos ocasiones");
                cuentaActual.inactivarCuenta();
                System.out.println("f--------------------------------------" + cuentaActual.getEstatus());
                CuentaCRUD cuentaCrud = new CuentaCRUD();
                cuentaCrud.cambiarEstatus(cuentaActual);
                tempClient = obtenerCliente_Cuenta(cuentaActual.getNumeroCuenta());
                envioCorreo(tempClient.getCorreoElectronico(), tempClient.getNombre(), cuentaActual.getNumeroCuenta());
                return false;
            }
        }
    }
// VALIDACIONES / VERIFICACIONES ------------------------------------------------------------------------------------------ 



// REGISTROS / CREACIONES --------------------------------------------------------------------------    
    public static Cuenta crearCuentaCliente(Cliente clienteActual, String PinFinal, Double SaldoFinal) {
        int numeroCuentas = new CuentaCRUD().obtenerCantidadCuentas();
        clienteActual.crearCuenta(PinFinal, SaldoFinal, numeroCuentas);

        Cuenta cuentaTemp;
        Busqueda obtenerCuenta = new Busqueda();
        cuentaTemp = obtenerCuenta.buscarCuenta(PinFinal, clienteActual.getCuentas());

        // Registrar la nueva cuenta en la BD 
        CuentaCRUD cuentaNueva = new CuentaCRUD();
        cuentaNueva.registrarCuenta(cuentaTemp, clienteActual.getIdentificacion());
        
        
        registrarEnBitacora("Creación de Cuenta Bancaria","CLI");
        return cuentaTemp;

    }

    public static Cliente registrarCliente(String pIdentificacionFinal, String pPrimerApellidoFinal, String pSegundoApellidoFinal,
            String pNombreFinal, Date dateCliente, String pNumeroTelefonicoFinal, String pCorreoElectronicoFinal) {

        Cliente nuevoCliente = new Cliente(pIdentificacionFinal, pPrimerApellidoFinal, pSegundoApellidoFinal,
                pNombreFinal, dateCliente, pNumeroTelefonicoFinal, pCorreoElectronicoFinal);

        ClienteCRUD clienteBD = new ClienteCRUD();

        // Enviar el registro del cliente a la BD 
        clienteBD.registrarCliente(nuevoCliente);
        
        
        registrarEnBitacora("Registro de Cliente","CLI");
        
        return nuevoCliente;
    }

// REGISTROS / CREACIONES -------------------------------------------------------------------------- 



// DETALLE -------------------------------------------------------------   
    public void detalleNuevoCliente(String identificacionFinal, String primerApellidoFinal, String segundoApellidoFinal, String nombreFinal, String dateC, String numeroTelefonicoFinal, String correoElectronicoFinal) throws ParseException {

        SimpleDateFormat formate = new SimpleDateFormat("dd/MM/yyyy");
        Date dates = formate.parse(dateC);

        Cliente cliente_temp;
        cliente_temp = registrarCliente(identificacionFinal, primerApellidoFinal, segundoApellidoFinal, nombreFinal, dates, numeroTelefonicoFinal, correoElectronicoFinal);

        System.out.println("-------------------------------------");
        System.out.println("Se ha creado un nuevo cliente en el sistema, los datos que fueron almacenados son:");
        System.out.println("Código: " + cliente_temp.getCodigoCliente());
        System.out.println("Nombre: " + nombreFinal);
        System.out.println("Identificación: " + identificacionFinal);
        System.out.println("Fecha Nacimiento: " + dateC);
        System.out.println("Número Telefónico: " + numeroTelefonicoFinal);
        System.out.println("");
    }

    public void detalleNuevaCuenta(String IDcliente, String PinFinal, double SaldoFinal) {
        Cliente clienteActual;
        Cuenta cuentaTemporary;

        clienteActual = verificarCliente_Sistema(IDcliente);
        cuentaTemporary = crearCuentaCliente(clienteActual, PinFinal, SaldoFinal);

        System.out.println("");
        System.out.println("El numero de la cuenta es: " + cuentaTemporary.getNumeroCuenta());
        System.out.println("Estatus de la cuenta: " + cuentaTemporary.getEstatus());
        System.out.println("Saldo actual de la cuenta: " + String.format("%.2f", cuentaTemporary.getSaldo()));

        System.out.println("Nombre del dueño de la cuenta: " + clienteActual.getNombre());
        System.out.println("Número de télefono asociado al cliente: " + clienteActual.getNumeroTelefono());
        System.out.println("Direccion de correo electrónico asociado a la cuenta: " + clienteActual.getCorreoElectronico());
    }

// DETALLE ------------------------------------------------------------- 



// LISTADOS ****************************************
    public static void listarClientes(Cliente[] pListadoClientes) {
        String msj = "";
        Ordenacion orderClient = new Ordenacion();
        orderClient.insercion(pListadoClientes);

        for (int i = 0; i < pListadoClientes.length; i++) {
            msj += "\n " + pListadoClientes[i].getPrimerApellido() + " ";
            msj += "\n " + pListadoClientes[i].getSegundoApellido() + " ";
            msj += "\n " + pListadoClientes[i].getNombre() + " ";
            msj += "\n " + pListadoClientes[i].getIdentificacion() + " ";
            msj += "\n ";
        }
        System.out.println(msj);
    }

    public static void listarCuentas(Cuenta[] pListadoCuentas) {
        String msj = "";
        Ordenacion orderClient = new Ordenacion();
        orderClient.insercion(pListadoCuentas);
        Cliente temp;

        for (int i = 0; i < pListadoCuentas.length; i++) {
            temp = obtenerCliente_Cuenta(pListadoCuentas[i].getNumeroCuenta());

            msj += "\n Número de cuenta: " + pListadoCuentas[i].getNumeroCuenta() + " ";
            msj += "\n Estatus de la cuenta: " + pListadoCuentas[i].getEstatus() + " ";
            msj += "\n El saldo de la cuenta es: " + String.format("%.2f", pListadoCuentas[i].getSaldo()) + " ";
            msj += "\n Identificación dueño de la cuenta: " + temp.getIdentificacion() + " ";
            msj += "\n Nombre completo del dueño de la cuenta: ";
            msj += "\n " + temp.getNombre() + " ";
            msj += "\n " + temp.getPrimerApellido() + " ";
            msj += "\n " + temp.getSegundoApellido() + " ";
            msj += "\n ";

        }
        System.out.println(msj);
    }

    public void listarClientesOrdenados() {
        ClienteCRUD clientela = new ClienteCRUD();
        ArrayList<Cliente> clientes = clientela.consultarClientes();

        Cliente[] orderClientela;
        orderClientela = convertirClientesEnArreglo(clientes);

        listarClientes(orderClientela);
        
        registrarEnBitacora("Listar Clientes Ordenados","CLI");
        
    }

    public void listarCuentasOrdenadas() {
        CuentaCRUD account = new CuentaCRUD();
        ArrayList<Cuenta> cuentas = account.consultarCuentas();

        Cuenta[] orderCuentas;
        orderCuentas = convertirCuentasEnArreglo(cuentas);

        listarCuentas(orderCuentas);
        
        registrarEnBitacora("Listar Cuentas Ordenadas","CLI");
    }

    public void listarCliente(ArrayList<Cliente> clientela, String identificadorConsulta) {
        for (int i = 0; i < clientela.size(); i++) {
            if (clientela.get(i).getIdentificacion().equals(identificadorConsulta)) {
                System.out.println("Nombre Cliente: " + clientela.get(i).getNombre());
                System.out.println("Primer Apellido Cliente: " + clientela.get(i).getPrimerApellido());
                System.out.println("Segundo Apellido Cliente: " + clientela.get(i).getSegundoApellido());
                System.out.println("Identificación Cliente: " + clientela.get(i).getIdentificacion());
                System.out.println("Fecha Nacimiento Cliente: " + clientela.get(i).getFechaNacimiento());
                System.out.println("Código Cliente: " + clientela.get(i).getCodigoCliente());
                System.out.println("Número Télefono Cliente: " + clientela.get(i).getNumeroTelefono());
                System.out.println("Correo Electrónico Cliente: " + clientela.get(i).getCorreoElectronico());

                System.out.println("----Cuentas Asociadas al cliente----");
                System.out.println("");

                CuentaCRUD accounts = new CuentaCRUD();

                ArrayList<Cuenta> cuentasClienteActual = accounts.consultarCuentasCliente(identificadorConsulta);

                if (cuentasClienteActual != null) {
                    for (int j = 0; j < cuentasClienteActual.size(); j++) {
                        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");

                        System.out.println("El número de la cuenta " + j + " del cliente es: ");
                        System.out.println(cuentasClienteActual.get(j).getNumeroCuenta());
                        System.out.println("La fecha de creación de la cuenta es: ");
                        System.out.println(cuentasClienteActual.get(j).getFechaCreacion());
                        System.out.println("El estatus de la cuenta es: ");
                        System.out.println(cuentasClienteActual.get(j).getEstatus());

                        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");

                    }
                } else {
                    System.out.println("El cliente no tiene cuentas asociadas");
                }

            }
          registrarEnBitacora("Consulta Detalle Cliente","CLI");  
        }

        System.out.println("No hay un cliente registrado en el sistema con la identificación ingresada");

    }

    public void listarDetalleCuenta(String numCuenta) {

        ClienteCRUD clienteCRUD = new ClienteCRUD();

        ArrayList<Cliente> clientela = clienteCRUD.consultarClientes();

        for (int i = 0; i < clientela.size(); i++) {

            Cliente ClienteTempo = clientela.get(i);

            CuentaCRUD cuentas = new CuentaCRUD();

            ArrayList<Cuenta> accounts = cuentas.consultarCuentasCliente(clientela.get(i).getIdentificacion());

            for (int j = 0; j < accounts.size(); j++) {

                if (accounts.get(j).getNumeroCuenta().equals(numCuenta)) {

                    System.out.println("--------------------------------");
                    System.out.println("Cuenta #" + j);
                    System.out.println("Numero de la cuenta: " + accounts.get(j).getNumeroCuenta());
                    System.out.println("Fecha Creación: " + accounts.get(j).getFechaCreacion());
                    System.out.println("Estatus de la cuenta: " + accounts.get(j).getEstatus());
                    System.out.println("Pin de la cuenta: " + accounts.get(j).getPin());
                    System.out.println("Cantidad de operaciones de la cuenta: " + accounts.get(j).getCantidadDepositosRetiros());

                    /// Necesario meterse en cada operación ??????
                    /// Necesario poner toda la data del cliente ????
                    System.out.println("--------- Dueñ@ de la cuenta ---------");

                    System.out.println("Identificación: " + ClienteTempo.getIdentificacion());
                    System.out.println("Nombre Completo: " + ClienteTempo.getNombre() + " " + ClienteTempo.getPrimerApellido() + " " + ClienteTempo.getSegundoApellido());

                    System.out.println("-------------------------------");
                }
            }
            
        }
        registrarEnBitacora("Consulta Detalle Cuenta","CLI");

    }

// LISTADOS ****************************************



// OPERACIONES ////////////////////////////////////////////////////////////////////////////////////// 
    public int cambiarPIN(Cuenta cuentaActual, String pNuevoPin) {
        CuentaCRUD cuenta = new CuentaCRUD();
        if (validacionPIN(pNuevoPin) != null) {
            cuentaActual.cambiarPin(pNuevoPin);
            System.out.println("Estimado usuario, se ha cambiado satisfactoriamente el PIN de su cuenta: " + cuentaActual.getNumeroCuenta());
            cuenta.cambiarPin(cuentaActual);
             registrarEnBitacora("Cambio de PIN","CLI");
            
            
            return 1;
        } else {
            System.out.println("Favor ingrese un formato de pin correcto");
            return cambiarPIN(cuentaActual, pNuevoPin);
        }

    }

    public void realizarDeposito(Cuenta cuentaActual, String montoDeposito) {
        CuentaCRUD cuentacrud = new CuentaCRUD();
        OperacionCRUD opecrud = new OperacionCRUD();
        Operacion opeCuenta = new Operacion();
        int cantOPE = 0;

        double deposito = Double.parseDouble(montoDeposito);
        if ((deposito % 1) == 0) {

            System.out.println("Monto ingresado es válido");
            cantOPE = opecrud.obtenerCantidadOpeCuenta(cuentaActual.getNumeroCuenta());
            cuentaActual.depositarColones(deposito, cantOPE);

            cuentacrud.actualizarSaldo(cuentaActual);
            opeCuenta = cuentaActual.getOperaciones().get(cuentaActual.getOperaciones().size() - 1);
            opecrud.registrarOperacion(opeCuenta, cuentaActual.getNumeroCuenta());
            registrarEnBitacora("Depósito en Colones","CLI");
        } else {
            System.out.println("El monto ingresado contiene decimales, favor no ingrese decimales en su monto de depósito");
        }

    }

    public void realizarDepositoDolares(Cuenta cuentaActual, String montoDeposito) {
        CuentaCRUD cuentacrud = new CuentaCRUD();
        OperacionCRUD opecrud = new OperacionCRUD();
        Operacion opeCuenta = new Operacion();
        double deposito = Double.parseDouble(montoDeposito);
        int cantOPE = 0;

        if ((deposito % 1) == 0) {
            System.out.println("Monto ingresado es válido");
            cantOPE = opecrud.obtenerCantidadOpeCuenta(cuentaActual.getNumeroCuenta());
            cuentaActual.depositarDolares(deposito, cantOPE);

            cuentacrud.actualizarSaldo(cuentaActual);
            opeCuenta = cuentaActual.getOperaciones().get(cuentaActual.getOperaciones().size() - 1);
            opecrud.registrarOperacion(opeCuenta, cuentaActual.getNumeroCuenta());
            registrarEnBitacora("Depósito en Dólares","CLI");

        } else {
            System.out.println("El monto ingresado contiene decimales, favor no ingrese decimales en su monto de depósito");
        }

    }

    public void realizarRetiro(Cuenta cuentaActual, String montoRetiro) throws FondosInsuficientesExcepcion {
        CuentaCRUD cuentacrud = new CuentaCRUD();
        OperacionCRUD opecrud = new OperacionCRUD();
        Operacion opeCuenta = new Operacion();
        int cantOPE = 0;

        double retiro = Double.parseDouble(montoRetiro);
        if ((retiro % 1) == 0) {
            cantOPE = opecrud.obtenerCantidadOpeCuenta(cuentaActual.getNumeroCuenta());
            cuentaActual.retirarColones(retiro, cantOPE);

            cuentacrud.actualizarSaldo(cuentaActual);
            opeCuenta = cuentaActual.getOperaciones().get(cuentaActual.getOperaciones().size() - 1);
            opecrud.registrarOperacion(opeCuenta, cuentaActual.getNumeroCuenta());
            registrarEnBitacora("Retiro en Colones","CLI");

        } else {
            System.out.println("El monto ingresado contiene decimales, favor no ingrese decimales en su monto de depósito");
        }

    }

    public void realizarRetiroDolares(Cuenta cuentaActual, String montoRetiro) throws FondosInsuficientesExcepcion {
        CuentaCRUD cuentacrud = new CuentaCRUD();
        OperacionCRUD opecrud = new OperacionCRUD();
        Operacion opeCuenta = new Operacion();
        int cantOPE = 0;

        double retiro = Double.parseDouble(montoRetiro);
        if ((retiro % 1) == 0) {
            cantOPE = opecrud.obtenerCantidadOpeCuenta(cuentaActual.getNumeroCuenta());
            cuentaActual.retirarDolares(retiro, cantOPE);

            cuentacrud.actualizarSaldo(cuentaActual);
            opeCuenta = cuentaActual.getOperaciones().get(cuentaActual.getOperaciones().size() - 1);
            opecrud.registrarOperacion(opeCuenta, cuentaActual.getNumeroCuenta());
            registrarEnBitacora("Retiro en Dólares","CLI");

        } else {
            System.out.println("El monto ingresado contiene decimales, favor no ingrese decimales en su monto de depósito");
        }

    }
// OPERACIONES //////////////////////////////////////////////////////////////////////////////////////    



// AUXILIARES ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    public static Cliente[] convertirClientesEnArreglo(ArrayList<Cliente> clientela) {
        Cliente[] arregloClientes = new Cliente[clientela.size()];
        for (int i = 0; i < clientela.size(); i++) {
            arregloClientes[i] = clientela.get(i);
        }
        return arregloClientes;
    }

    public static Cuenta[] convertirCuentasEnArreglo(ArrayList<Cuenta> cuentas) {
        Cuenta[] arregloCuentas = new Cuenta[cuentas.size()];
        for (int i = 0; i < cuentas.size(); i++) {
            arregloCuentas[i] = cuentas.get(i);
        }
        return arregloCuentas;
    }
    
   
    
    public static void registrarEnBitacora(String pTipoOperacion, String pVista) {
        Date dateR = new Date(System.currentTimeMillis());
        SimpleDateFormat formatterFecha = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatterHora = new SimpleDateFormat("HH:mm:ss");
        String[] registro1 = {formatterFecha.format(dateR), formatterHora.format(dateR), pTipoOperacion, pVista};
        Bitacora bitacora = BitacoraSingleton.getInstance();
 		bitacora.setRegistro(registro1);
		OperacionCRUD opeCrud = new OperacionCRUD();
		opeCrud.registrarEnBitacora(registro1);
    }

// AUXILIARES ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^



// GETS / OBTENER DATOS PUNTUALES   ++++++++++++++++++++++++++++++++++++++++++++++++++++++    
    public void ObtenerTCcompra() {
        TipoCambio tc = new TipoCambio();
        System.out.println("El tipo de cambio actual de compra de divisa extranjera es: ");
        System.out.println(tc.getCompra());
        System.out.println("TC obtenido al día: ");
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
        registrarEnBitacora("Obtener TC Compra","CLI");

    }

    public void ObtenerTCventa() {
        TipoCambio tc = new TipoCambio();
        System.out.println("El tipo de cambio actual de venta de divisa extranjera es: ");
        System.out.println(tc.getVenta());
        System.out.println("TC obtenido al día: ");
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
        registrarEnBitacora("Obtener TC Venta","CLI");

    }

    public void ObtenerSaldoActualColones(Cuenta cuentaActual) {
        System.out.println("Estimado usuario el saldo actual de su cuenta es: " + String.format("%.2f", cuentaActual.getSaldo()) + " colones.");
        registrarEnBitacora("Obtener Saldo Actual (CRC)","CLI");
    }

    public void ObtenerSaldoActualDolares(Cuenta cuentaActual) {
        TipoCambio tc = new TipoCambio();
        System.out.println("Estimado usuario el saldo actual de su cuenta es: " + String.format("%.2f", cuentaActual.getSaldoDolares()) + " colones.");
        System.out.println("Para esta conversión se utilizó el tipo de cambio del dólar, precio de compra.");
        System.out.println("[Según el BCCR, el tipo de cambio de compra del dólar de hoy es: " + tc.getCompra());
        registrarEnBitacora("Obtener Saldo Actual (USD)","CLI");
    }

    public static ArrayList<Cliente> obtenerClientela() {
        ClienteCRUD clientesBDs = new ClienteCRUD();
        ArrayList<Cliente> clientela = clientesBDs.consultarClientes();
        return clientela;
    }

    public static Cliente obtenerCliente_Cuenta(String numCuenta) {
        ClienteCRUD clientes = new ClienteCRUD();
        ArrayList<Cliente> clientela = clientes.consultarClientes();

        for (int i = 0; i < clientela.size(); i++) {
            CuentaCRUD cuentas = new CuentaCRUD();
            ArrayList<Cuenta> accounts = cuentas.consultarCuentasCliente(clientela.get(i).getIdentificacion());

            for (int j = 0; j < accounts.size(); j++) {

                if (accounts.get(j).getNumeroCuenta().equals(numCuenta) == true) {
                    return clientela.get(i);
                }

            }

        }
        return null;
    }

// GETS / OBTENER DATOS PUNTUALES   ++++++++++++++++++++++++++++++++++++++++++++++++++++++


// CONSULTAS ##########################################################################################
    public void consultaEstadoCuenta(Cuenta cuentaActual, int tipoConsulta) {

        ClienteCRUD crudClient = new ClienteCRUD();
        ArrayList<Cliente> clientela = crudClient.consultarClientes();

        for (int i = 0; i < clientela.size(); i++) {

            Cliente ClienteTempo = clientela.get(i);
            CuentaCRUD accountCRUD = new CuentaCRUD();
            ArrayList<Cuenta> cuentas = accountCRUD.consultarCuentasCliente(ClienteTempo.getIdentificacion());

            for (int j = 0; j < cuentas.size(); j++) {

                if (cuentas.get(j).getNumeroCuenta().equals(cuentaActual.getNumeroCuenta()) == true) {

                    System.out.println("Identificación del cliente dueño de la cuenta: ");
                    System.out.println(ClienteTempo.getIdentificacion());

                    System.out.println("Nombre del cliente dueño de la cuenta: ");
                    System.out.println(ClienteTempo.getNombre());

                    System.out.println("Numero de Cuenta: ");
                    System.out.println(cuentas.get(j).getNumeroCuenta());

                    System.out.println("Fecha de creación de la cuenta: ");
                    System.out.println(cuentas.get(j).getFechaCreacion().toString());

                    if (tipoConsulta == 0) {
                        System.out.println("El saldo actual de la cuenta en colones es: ");
                        System.out.println(String.format("%.2f", cuentas.get(j).getSaldo()));
                    } else if (tipoConsulta == 1) {
                        System.out.println("El saldo actual de la cuenta en dólares es: ");
                        System.out.println(String.format("%.2f", cuentas.get(j).getSaldoDolares()));
                    }

                    System.out.println("El estado actual de la cuenta es: ");
                    System.out.println(cuentas.get(j).getEstatus());

                    // se debe verificar si aplican los montos en $$$
                    System.out.println("Las operaciones que se han ejecutado en esta cuenta son: ");
                    System.out.println(cuentas.get(j).consultarDetallesOperaciones());
                }
            }
        }
        registrarEnBitacora("Consulta Estado de Cuenta","CLI");
        
    }

    public double consultaGananciasComision(int tipoConsulta) {

        CuentaCRUD accountCRUD = new CuentaCRUD();
        double montoTotal = 0.0;
        String numCuenta;
        Scanner sn = new Scanner(System.in);

        if (tipoConsulta == 0) {

            ArrayList<Cuenta> cuentasSistemas = accountCRUD.consultarCuentas();

            for (int i = 0; i < cuentasSistemas.size(); i++) {
                montoTotal = montoTotal + cuentasSistemas.get(i).calcularTotalComisiones();

            }
            registrarEnBitacora("Consulta Ganancias Totales Comisión (General)","CLI");
            return montoTotal;

        } else {
            System.out.println("Ingrese el número de la cuenta que desea consultar: ");
            numCuenta = sn.nextLine();
            if (validarCuenta(numCuenta) != null) {
                ArrayList<Cuenta> cuentaEspecifica = accountCRUD.consultarCuentas();

                for (int i = 0; i < cuentaEspecifica.size(); i++) {
                    if (cuentaEspecifica.get(i).getNumeroCuenta().equals(numCuenta) == true) {
                        montoTotal = cuentaEspecifica.get(i).calcularTotalComisiones();
                        return montoTotal;
                    }

                }
            registrarEnBitacora("Consulta Ganancias Totales Comisión (Específico)","CLI");

            } else {
                System.out.println("Ingrese un número de cuenta válido");
            }

            System.out.println("No existen ganancias por comisiones actualmente");
            return 0.0;
        }
    }

// CONSULTAS ##########################################################################################  


// SERVICIOS EXTERNOS----------------    
    public void envioCorreo(String pCorreoReceptor, String pNombreCliente, String pNumCuenta) {
        Correo mail = new Correo();
        mail.enviarCorreo(pCorreoReceptor, pNombreCliente, pNumCuenta);

    }

    public String envioSMS(String tel) {
        PalabraSecreta secret = new PalabraSecreta();
        Sms mensaje = new Sms();
        String secretWord = secret.generarPalabraSecreta();
        mensaje.enviarSms(secretWord, tel);
        return secretWord;
    }
// SERVICIOS EXTERNOS---------------

}
