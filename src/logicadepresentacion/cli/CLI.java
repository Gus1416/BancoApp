/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadepresentacion.cli;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import logicadeaccesodedatos.CuentaCRUD;
import logicadeaccesodedatos.OperacionCRUD;

import logicadeintegracion.cli.Controller_CLI;
import logicadevalidacion.FondosInsuficientesExcepcion;

/**
 *
 * @author SebCor
 */
public class CLI {

    public static void main(String[] args) throws ParseException, FondosInsuficientesExcepcion {

        Scanner sn = new Scanner(System.in);
        Scanner op = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        Controller_CLI controlador = new Controller_CLI();

        while (!salir) {

            System.out.println("");
            System.out.println("");
            System.out.println("--- --- --- --- --- --- --- --- --- --- --- ---");
            System.out.println("Bienvenido a Banco App");
            System.out.println("--- --- --- --- --- --- --- --- --- --- --- ---");
            System.out.println("");
            System.out.println("¿Qué desea hacer?");
            System.out.println("");
            System.out.println("");

            System.out.println("1. Registrar Cliente");
            System.out.println("2. Crear Cuenta");
            System.out.println("3. Listar Clientes Ascendentemente");
            System.out.println("4. Consultar datos de Cliente");
            System.out.println("5. Listar cuentas descendentemente");
            System.out.println("6. Consulta de datos de una cuenta");
            System.out.println("7. Cambiar PIN");
            System.out.println("8. Realizar depósito");
            System.out.println("9. Realizar retiro");
            System.out.println("10. Realizar transferencia (colones) ");
            System.out.println("11. Consultar tipo de cambio de compra de divisa extranjera");
            System.out.println("12. Consultar tipo de cambio de venta de divisa extranjera");
            System.out.println("13. Consultar saldo actual de cuenta ");
            System.out.println("14. Consultar estado de la cuenta ");
            System.out.println("15. Consultar estatus de una cuenta");
            System.out.println("16. Consultar ganancias del banco producto del cobro de comisiones ");
            System.out.println("17. Salir");

            System.out.println("");
            System.out.println("-------------------------------------------");
            System.out.println("Por favor seleccione una de las opciones");
            System.out.println("");

            opcion = op.nextInt();

            switch (opcion) {

                case 1:

                    String primerApellidoInicial;
                    String primerApellidoFinal = null;
                    String segundoApellidoInicial;
                    String segundoApellidoFinal = null;
                    String nombreInicial;
                    String nombreFinal = null;
                    String identificacionInicial;
                    String identificacionFinal = null;
                    String fechaNacimientoinicial;
                    String fechaNacimientofinal = null;
                    String numeroTelefonicoInicial;
                    String numeroTelefonicoFinal = null;
                    String correoElectronicoInicial;
                    String correoElectronicoFinal = null;

                    System.out.println("Ingrese el primer apellido del cliente: ");
                    primerApellidoInicial = sn.nextLine();
                    primerApellidoFinal = controlador.validacionApellido(primerApellidoInicial);
                    if (primerApellidoFinal == null) {
                        break;
                    }

                    System.out.println("Ingrese el segundo apellido del cliente: ");
                    segundoApellidoInicial = sn.nextLine();
                    segundoApellidoFinal = controlador.validacionApellido(segundoApellidoInicial);
                    if (segundoApellidoFinal == null) {
                        break;
                    }

                    System.out.println("Ingrese el nombre del cliente: ");
                    nombreInicial = sn.nextLine();
                    nombreFinal = controlador.validacionNombre(nombreInicial);
                    if (nombreFinal == null) {
                        break;
                    }

                    System.out.println("Ingrese el identificador del cliente: ");
                    identificacionInicial = sn.nextLine();
                    identificacionFinal = controlador.validacionIdentificacion(identificacionInicial);
                    if (identificacionFinal == null) {
                        break;
                    }

                    System.out.println("Ingrese la fecha de nacimiento del cliente: ");
                    fechaNacimientoinicial = sn.nextLine();
                    fechaNacimientofinal = controlador.validacionFechaNacimiento(fechaNacimientoinicial);
                    if (fechaNacimientofinal == null) {
                        break;
                    }

                    System.out.println("Ingrese el número de télefono del cliente: ");
                    numeroTelefonicoInicial = sn.nextLine();
                    numeroTelefonicoFinal = controlador.validacionNumTel(numeroTelefonicoInicial);
                    if (numeroTelefonicoFinal == null) {
                        break;
                    }

                    System.out.println("Ingrese el correo electrónico del cliente: ");
                    correoElectronicoInicial = sn.nextLine();
                    correoElectronicoFinal = controlador.validacionCorreoElectronico(correoElectronicoInicial);
                    if (correoElectronicoFinal == null) {
                        break;
                    }

                    controlador.detalleNuevoCliente(identificacionFinal, primerApellidoFinal, segundoApellidoFinal, nombreFinal, fechaNacimientofinal, numeroTelefonicoFinal, correoElectronicoFinal);
                    break;

                case 2:

                    String PinInicial;
                    String PinFinal;

                    int SaldoInicial;
                    double SaldoFinal = 0.0;

                    String IDclienteInicial;
                    String IDclienteFinal;

                    System.out.println("Ingrese su identificacion:  ");
                    IDclienteInicial = sn.nextLine();
                    IDclienteFinal = controlador.validacionIdentificacion(IDclienteInicial);
                    if (IDclienteFinal == null) {
                        break;
                    }

                    System.out.println("Ingrese el PIN de la nueva cuenta: ");
                    PinInicial = sn.nextLine();
                    PinFinal = PinInicial;
                    PinFinal = controlador.validacionPIN(PinInicial);
                    if (PinFinal == null) {
                        break;
                    }

                    System.out.println("Ingrese el monto inicial de la nueva cuenta (monto entero): ");
                    SaldoInicial = Integer.parseInt(sn.nextLine());
                    SaldoFinal = controlador.validacionSaldoInicial(SaldoInicial);
                    if (SaldoFinal == 0.0) {
                        break;
                    }

                    controlador.detalleNuevaCuenta(IDclienteFinal, PinFinal, SaldoFinal);

                    break;

                case 3:
                    controlador.listarClientesOrdenados();
                    break;

                case 4:
                    String identificadorConsulta;
                    System.out.println("Ingrese el identificador del cliente que desea consultar: ");
                    identificadorConsulta = sn.nextLine();

                    controlador.listarCliente(controlador.obtenerClientela(), identificadorConsulta);
                    break;

                case 5:
                    controlador.listarCuentasOrdenadas();
                    break;

                case 6:
                    String numCuenta;
                    numCuenta = sn.nextLine();
                    if (controlador.validarCuenta(numCuenta) != null) {
                        System.out.println("Se adjunta el detalle de la cuenta ingresada: ");
                        controlador.listarDetalleCuenta(numCuenta);
                    } else {
                        System.out.println("El numero de cuenta ingresado no pertenece a ninguna cuenta del sistema");
                    }

                    break;

                case 7:
                    String NumCuenta;
                    String nuevoPin;

                    System.out.println("Ingrese el numero de la cuenta: ");
                    NumCuenta = sn.nextLine();
                    if (controlador.validarCuenta(NumCuenta) != null) {

                        if (controlador.verificarPIN(controlador.validarCuenta(NumCuenta)) == true) {
                            System.out.println("Ingrese el nuevo pin para la cuenta: ");
                            nuevoPin = sn.nextLine();
                            controlador.cambiarPIN(controlador.validarCuenta(NumCuenta), nuevoPin);
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                    break;

                case 8:
                    String NumeCuenta;
                    String montoDeposito;
                    int tipoDeposito;

                    System.out.println("Ingrese el numero de la cuenta: ");
                    NumeCuenta = sn.nextLine();
                    if (controlador.validarCuenta(NumeCuenta) != null) {

                        System.out.println("Ingrese 0 para depositar en colones ó 1 para depositar en dólares");
                        tipoDeposito = Integer.parseInt(sn.nextLine());

                        if (tipoDeposito == 0) {

                            System.out.println("Ingrese el monto a depositar en la cuenta: ");
                            montoDeposito = sn.nextLine();
                            controlador.realizarDeposito(controlador.validarCuenta(NumeCuenta), montoDeposito);
                            

                        } else if (tipoDeposito == 1) {
                            System.out.println("Ingrese el monto a depositar en la cuenta: ");
                            montoDeposito = sn.nextLine();
                            controlador.realizarDepositoDolares(controlador.validarCuenta(NumeCuenta), montoDeposito);

                        } else {
                            System.out.println("Favor ingrese un número de operación válido");
                        }
                    } else {
                        break;
                    }

                    break;

                case 9:
                    String Cuentanum;
                    String code = null;
                    String autenticar;
                    String montoRetiro;
                    int tipoRetiro;

                    System.out.println("Ingrese el numero de la cuenta: ");
                    Cuentanum = sn.nextLine();

                    if (controlador.validarCuenta(Cuentanum) != null) {
                        if (controlador.verificarPIN(controlador.validarCuenta(Cuentanum)) == true) {

                            code = controlador.envioSMS(controlador.obtenerCliente_Cuenta(Cuentanum).getNumeroTelefono());

                            System.out.println("Estimado usuario se ha \n"
                                    + "enviado una palabra por mensaje de texto, por favor revise sus mensajes y \n"
                                    + "proceda a digitar la palabra enviada");

                            System.out.println("Ingrese el código de acceso enviado a su teléfono celular: ");
                            autenticar = sn.nextLine();

                            if (autenticar.equals(code) == true) {
                                System.out.println("Autenticación realizada de manera exitosa");
                                System.out.println("Ingrese 0 para retirar en colones ó 1 para retirar en dólares");
                                tipoRetiro = Integer.parseInt(sn.nextLine());

                                if (tipoRetiro == 0) {
                                    System.out.println("Ingrese el monto a retirar en la cuenta: ");
                                    montoRetiro = sn.nextLine();
                                    controlador.realizarRetiro(controlador.validarCuenta(Cuentanum), montoRetiro);
                                } else if (tipoRetiro == 1) {
                                    System.out.println("Ingrese el monto a retirar en la cuenta: ");
                                    montoRetiro = sn.nextLine();
                                    controlador.realizarRetiroDolares(controlador.validarCuenta(Cuentanum), montoRetiro);
                                } else {
                                    System.out.println("Ingrese un número de operación válido");
                                    break;
                                }
                            } else {
                                System.out.println("El código ingresado no corresponde con el enviado vía correo");
                            }
                        }
                        break;
                    }
                    break;

                case 10:
                    String accountOrigen;
                    String token = null;
                    String verify;
                    String monto;
                    String accountDestino;

                    System.out.println("Ingrese el numero de la cuenta origen: ");
                    accountOrigen = sn.nextLine();
                    if (controlador.validarCuenta(accountOrigen) != null) {
                        if (controlador.verificarPIN(controlador.validarCuenta(accountOrigen)) == true) {

                            token = controlador.envioSMS(controlador.obtenerCliente_Cuenta(accountOrigen).getNumeroTelefono());

                            System.out.println("Estimado usuario se ha \n"
                                    + "enviado una palabra por mensaje de texto, por favor revise sus mensajes y \n"
                                    + "proceda a digitar la palabra enviada");

                            System.out.println("Ingrese el código de acceso enviado a su teléfono celular: ");
                            verify = sn.nextLine();

                            if (verify.equals(token) == true) {
                                System.out.println("Por favor ingrese el monto que desea transferir: ");
                                monto = sn.nextLine();

                                if (controlador.validacionSaldoInicial(Integer.parseInt(monto)) != null) {
                                    System.out.println("Ingrese el numero de cuenta destino: ");
                                    accountDestino = sn.nextLine();
                                    if (controlador.validarCuenta(accountOrigen) != null) {

                                        controlador.realizarRetiro(controlador.validarCuenta(accountOrigen), monto);
                                        controlador.realizarDeposito(controlador.validarCuenta(accountOrigen), monto);
                                        controlador.registrarEnBitacora("Transferencia Bancaria CRC","CLI");
                                        
                                        
                                        System.out.println("Estimado usuario, la transferencia de fondos se ejecutó satisfactoriamente.");
                                        System.out.println("El monto retirado de la cuenta origen y depositado en la cuenta destino es: ");
                                        System.out.println(monto + " colones");

                                        System.out.println("El monto cobrado por concepto de comisión a la cuenta origen fue de: ");
                                        double comision = 0.00;
                                        comision = Integer.parseInt(monto) * 0.02;
                                        System.out.println(comision);
                                        System.out.println("colones, que fueron rebajados automáticamente de su saldo actual");

                                    }

                                } else {
                                    break;
                                }

                            } else {
                                break;
                            }

                        }
                        break;
                    }

                    break;

                case 11:
                    controlador.ObtenerTCcompra();
                    break;

                case 12:
                    controlador.ObtenerTCventa();
                    break;

                case 13:
                    String NumerCuenta;
                    int tipoConsulta;

                    System.out.println("Ingrese el numero de la cuenta: ");
                    NumerCuenta = sn.nextLine();

                    if (controlador.validarCuenta(NumerCuenta) != null) {
                        if (controlador.verificarPIN(controlador.validarCuenta(NumerCuenta)) == true) {
                            System.out.println("Ingrese 0 para consulta en colones ó 1 para consulta en dólares");
                            tipoConsulta = Integer.parseInt(sn.nextLine());
                            if (tipoConsulta == 0) {
                                controlador.ObtenerSaldoActualColones(controlador.validarCuenta(NumerCuenta));
                            }
                            if (tipoConsulta == 1) {
                                controlador.ObtenerSaldoActualDolares(controlador.validarCuenta(NumerCuenta));
                            }
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }

                    break;

                case 14:
                    String NumeroCuenta;
                    String PinAccount;
                    int typeConsult;

                    System.out.println("Ingrese el numero de la cuenta: ");
                    NumeroCuenta = sn.nextLine();
                    if (controlador.validarCuenta(NumeroCuenta) != null) {

                        if (controlador.verificarPIN(controlador.validarCuenta(NumeroCuenta)) == true) {
                            System.out.println("Ingrese 0 para realizar consulta de estado en colones, 1 para consulta en dólares");
                            typeConsult = Integer.parseInt(sn.nextLine());
                            controlador.consultaEstadoCuenta(controlador.validarCuenta(NumeroCuenta), typeConsult);
                            break;
                        }
                        break;
                    }

                    break;

                case 15:
                    String accountNumber;
                    System.out.println("Ingrese el número de la cuenta: ");
                    accountNumber = sn.nextLine();
                    if (controlador.validarCuenta(accountNumber) != null) {
                        System.out.println("La cuenta número: " + accountNumber + " tiene el estatus de: ");
                        System.out.println(controlador.validarCuenta(accountNumber).getEstatus());
                        controlador.registrarEnBitacora("Consulta Estatus de Cuenta","CLI");
                    } else {
                        break;
                    }
                    break;

                case 16:
                    int ope;
                    System.out.println("Por favor ingrese el número de la acción que desea ejecutar");
                    System.out.println(" 0. Consultar ganancias TOTALES del banco producto de comisiones");
                    System.out.println(" 1. Consultar ganacias del banco producto de comisiones para UNA cuenta especifica");
                    ope = Integer.parseInt(sn.nextLine());
                    controlador.consultaGananciasComision(ope);

                case 17:
                    salir = true;
                    break;

                default:
                    System.out.println("Favor seleccione una opción existente. Gracias");
            }

        }

    }

}
