package logicadeaccesodedatos;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import logicadenegocios.Cliente;
import logicadenegocios.Cuenta;
import logicadenegocios.Encriptacion;

/**
 * 
 * @author Gustavo
 */
public class ClienteCRUD extends Conexion{
	
	public boolean registrarCliente(Cliente pCliente){
		PreparedStatement ps = null;
		Connection con = getConexion();
		
		String sql = "CALL registrar_cliente(?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pCliente.getIdentificacion());
			ps.setString(2, pCliente.getPrimerApellido());
			ps.setString(3, pCliente.getSegundoApellido());
			ps.setString(4, pCliente.getNombre());
			ps.setDate(5, new Date(pCliente.getFechaNacimiento().getTime()));
			ps.setString(6, pCliente.getCodigoCliente());
			ps.setString(7, pCliente.getNumeroTelefono());
			ps.setString(8, pCliente.getCorreoElectronico());
			ps.execute();
			return true;
			
		} catch (SQLException e){
			System.err.println(e);
			return false;
		}
	}
	
	public ArrayList consultarClientes() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();
		ArrayList clientes = new ArrayList<Cliente>();

		String sql = "CALL consultar_clientes()";

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String codigoCliente = rs.getString("codigo_cliente");
				String identificacion = rs.getString("identificacion");
				String primerApellido = rs.getString("primer_apellido");
				String segundoApellido = rs.getString("segundo_apellido");
				String nombre = rs.getString("nombre");
				java.util.Date fechaNacimiento = rs.getDate("fecha_nacimiento");
				String telefono = rs.getString("numero_telefono");
				String correo = rs.getString("correo_electronico");
				ArrayList<Cuenta> cuentas = new CuentaCRUD().consultarCuentasCliente(identificacion);
				
				
				Cliente cliente = new Cliente(identificacion, primerApellido, segundoApellido, nombre, fechaNacimiento, telefono, correo);
				cliente.setCodigoCliente(codigoCliente);	
				cliente.setCuentas(cuentas);
				
				clientes.add(cliente);
			}
			return clientes;

		} catch (SQLException e) {
			System.err.println(e);
			return clientes;
		}
	}
	
	public Cliente consultarCliente(String pIdentificacion) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();
		Cliente cliente = null;

		String sql = "CALL consultar_cliente(?)";

		try {

			ps = con.prepareStatement(sql);
			ps.setString(1, pIdentificacion);
			rs = ps.executeQuery();

			if (rs.next()) {

				String codigoCliente = rs.getString("codigo_cliente");
				String identificacion = rs.getString("identificacion");
				String primerApellido = rs.getString("primer_apellido");
				String segundoApellido = rs.getString("segundo_apellido");
				String nombre = rs.getString("nombre");
				java.util.Date fechaNacimiento = rs.getDate("fecha_nacimiento");
				String telefono = rs.getString("numero_telefono");
				String correo = rs.getString("correo_electronico");

				ArrayList<Cuenta> cuentas = new CuentaCRUD().consultarCuentasCliente(pIdentificacion);

				cliente = new Cliente(identificacion, primerApellido, segundoApellido, nombre, fechaNacimiento, telefono, correo);
				cliente.setCodigoCliente(codigoCliente);
				cliente.setCuentas(cuentas);
				
			}

			return cliente;

		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}
	}

	public Cliente consultarPropietarioCuenta (String pNumeroCuenta){
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();
		Cliente cliente = null;

		String sql = "CALL consultar_propietario_cuenta(?)";

		try {

			ps = con.prepareStatement(sql);
			ps.setString(1, Encriptacion.encriptar(pNumeroCuenta));
			rs = ps.executeQuery();

			if (rs.next()) {

				String codigoCliente = rs.getString("codigo_cliente");
				String identificacion = rs.getString("identificacion");
				String primerApellido = rs.getString("primer_apellido");
				String segundoApellido = rs.getString("segundo_apellido");
				String nombre = rs.getString("nombre");
				java.util.Date fechaNacimiento = rs.getDate("fecha_nacimiento");
				String telefono = rs.getString("numero_telefono");
				String correo = rs.getString("correo_electronico");

				ArrayList<Cuenta> cuentas = new CuentaCRUD().consultarCuentasCliente(pNumeroCuenta);

				cliente = new Cliente(identificacion, primerApellido, segundoApellido, nombre, fechaNacimiento, telefono, correo);
				cliente.setCodigoCliente(codigoCliente);
				cliente.setCuentas(cuentas);

			}

			return cliente;

		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}
	}
	
	public int obtenerCantidadClientes() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();
		int cantidad = 0;

		String sql = "SELECT COUNT(*) AS cantidad FROM bd_bancoapp.cliente;";

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				cantidad = rs.getInt("cantidad");
			}
			return cantidad;

		} catch (SQLException e) {
			System.err.println(e);
			return 0;
		}
	}
}
