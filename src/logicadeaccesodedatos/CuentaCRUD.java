package logicadeaccesodedatos;

import logicadenegocios.Cuenta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class CuentaCRUD extends Conexion{
	
	/**
	 * Registra una cuenta y la enlaza con la persona due�a.
	 * 
	 * @param pCuenta Cuenta a registrar
	 * @param pIdentificacionPersona Identificaci�n de la persona due�a de la cuenta
	 * @return Indica el �xito de la operaci�n
	 */
	public boolean registrarCuenta(Cuenta pCuenta, String pIdentificacionPersona){
		PreparedStatement ps = null;
		Connection con = getConexion();
		
		String sql = "CALL registrar_cuenta(?, ?, ?, ?, ?, ?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pCuenta.getNumeroCuenta());
			ps.setDate(2, new Date(pCuenta.getFechaCreacion().getTime()));
			ps.setDouble(3, pCuenta.getSaldo());
			ps.setString(4, pCuenta.getEstatus());
			ps.setString(5, pCuenta.getPin());
			ps.setString(6, pIdentificacionPersona);
			ps.execute();
			return true;
			
		} catch (SQLException e){
			System.err.println(e);
			return false;
		}
	}
	
	/**
	 * Consulta el universo de cuentas de la base de datos.
	 * 
	 * @return Lista con todas las cuentas registradas
	 */
	public ArrayList consultarCuentas(){
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();
		ArrayList cuentas = new ArrayList<Cuenta>();
		
		String sql = "CALL consultar_cuentas()";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()){
				String numeroCuenta = rs.getString("numero_cuenta");
				java.util.Date fechaCreacion = rs.getDate("fecha_creacion");
				double saldo = rs.getDouble("saldo");
				String estatus = rs.getString("estatus");
				String pin = rs.getString("pin");
				
				Cuenta cuenta = new Cuenta(pin, saldo);
				cuenta.setNumeroCuenta(numeroCuenta);
				cuenta.setFechaCreacion(fechaCreacion);
				cuenta.setEstatus(estatus);
				cuentas.add(cuenta);
			}
			return cuentas;
			
		} catch (SQLException e){
			System.err.println(e);
			return cuentas;
		}
	}
	
	/**
	 * Consulta las cuentas pertenecientes a un cliente espec�fico.
	 * 
	 * @param pIdentificacionCliente Identificacion del cliente
	 * @return Una lista con las cuentas de un cliente
	 */
	public ArrayList consultarCuentasCliente(String pIdentificacionCliente) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();
		ArrayList cuentas = new ArrayList<Cuenta>();

		String sql = "CALL consultar_cuentas_cliente(?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pIdentificacionCliente);
			rs = ps.executeQuery();

			while (rs.next()) {
				String numeroCuenta = rs.getString("numero_cuenta");
				java.util.Date fechaCreacion = rs.getDate("fecha_creacion");
				double saldo = rs.getDouble("saldo");
				String estatus = rs.getString("estatus");
				String pin = rs.getString("pin");
				Cuenta cuenta = new Cuenta(pin, saldo);
				cuenta.setNumeroCuenta(numeroCuenta);
				cuenta.setFechaCreacion(fechaCreacion);
				cuenta.setEstatus(estatus);
				cuentas.add(cuenta);
			}
			return cuentas;

		} catch (SQLException e) {
			System.err.println(e);
			return cuentas;
		}
	}
	
	/**
	 * Consulta una cuenta en espec�fico.
	 * 
	 * @param pNumeroCuenta N�mero de la cuenta a consultar
	 * @return La cuenta consultada
	 */
	public Cuenta consultarCuenta(String pNumeroCuenta) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();

		String sql = "CALL consultar_cuenta(?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pNumeroCuenta);
			rs = ps.executeQuery();

			String numeroCuenta = rs.getString("numero_cuenta");
			java.util.Date fechaCreacion = rs.getDate("fecha_creacion");
			double saldo = rs.getDouble("saldo");
			String estatus = rs.getString("estatus");
			String pin = rs.getString("pin");
			
			Cuenta cuenta = new Cuenta(pin, saldo);
			cuenta.setNumeroCuenta(numeroCuenta);
			cuenta.setFechaCreacion(fechaCreacion);
			cuenta.setEstatus(estatus);
			
			return cuenta;

		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}
	}
}