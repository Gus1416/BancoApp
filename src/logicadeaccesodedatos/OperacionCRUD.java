package logicadeaccesodedatos;

import logicadenegocios.Operacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import logicadenegocios.Encriptacion;

/**
 *
 * @author Gustavo
 */
public class OperacionCRUD extends Conexion{
	
	/**
	 * Registra una nueva operación
	 * 
	 * @param pOperacion Operacion a registrar
	 * @param pNumeroCuenta Número de cuenta a la que se asocia la operación
	 * @return Indicador del éxito de la operación
	 */
	public boolean registrarOperacion(Operacion pOperacion, String pNumeroCuenta) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "CALL registrar_operacion(?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, pOperacion.getIdOperacion());
			ps.setDate(2, new Date(pOperacion.getFechaOperacion().getTime()));
			ps.setString(3, pOperacion.getTipoOperacion());
			ps.setBoolean(4, pOperacion.isSeCobraComision());
			ps.setDouble(5, pOperacion.getMontoOperacion());
			ps.setDouble(6, pOperacion.getMontoComision());
			ps.setString(7, pOperacion.getMoneda());
			ps.setString(8, Encriptacion.encriptar(pNumeroCuenta));
			ps.execute();
			return true;

		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}
	
	/**
	 * Consulta las operaciones asociadas a una cuenta.
	 * 
	 * @param pNumeroCuenta Número de cuenta
	 * @return  Lista con las operaciones de la cuenta
	 */
	public ArrayList consultarOperacionesCuenta(String pNumeroCuenta) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();
		ArrayList operaciones = new ArrayList<Operacion>();

		String sql = "CALL consultar_operaciones_cuenta(?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Encriptacion.encriptar(pNumeroCuenta));
			rs = ps.executeQuery();

			while (rs.next()) {
				int idOperacion = rs.getInt("id_operacion");
				java.util.Date fechaOperacion = rs.getDate("fecha_operacion");
				String tipoOperacion = rs.getString("tipo_operacion");
				boolean seCobraComision = rs.getBoolean("se_cobra_comision");
				double montoOperacion = rs.getDouble("monto_operacion");
				double montoComision = rs.getDouble("monto_comision");
				String moneda = rs.getString("moneda");
				Operacion operacion = new Operacion(fechaOperacion, tipoOperacion, montoOperacion, seCobraComision, montoComision, moneda);
				operacion.setIdOperacion(idOperacion);
				operaciones.add(operacion);
			}
			return operaciones;

		} catch (SQLException e) {
			System.err.println(e);
			return operaciones;
		}
	}
	
	public boolean registrarEnBitacora(String[] pRegistro){
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "CALL registrar_en_bitacora(?,?,?,?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pRegistro[0]);
			ps.setString(2, pRegistro[1]);
			ps.setString(3, pRegistro[2]);
			ps.setString(4, pRegistro[3].toLowerCase());
			ps.execute();
			return true;

		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}
	
	public ArrayList<String[]> consultarBitacoraVista(String pVista){
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();
		ArrayList<String[]> registros = new ArrayList<>();

		String sql = "CALL consultar_bitacora_vista(?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pVista.toLowerCase());
			rs = ps.executeQuery();

			while (rs.next()) {
				String fecha = rs.getString("fecha");
				String hora = rs.getString("hora");
				String accion = rs.getString("accion");
				String vista = rs.getString("vista");
				String[] registro = {fecha, hora, accion, vista};
				registros.add(registro);
			}
			return registros;

		} catch (SQLException e) {
			System.err.println(e);
			return registros;
		}
	}
	
	public ArrayList<String[]> consultarBitacoraFecha(String pFecha){
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();
		ArrayList<String[]> registros = new ArrayList<>();

		String sql = "CALL consultar_bitacora_fecha(?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pFecha);
			rs = ps.executeQuery();

			while (rs.next()) {
				String fecha = rs.getString("fecha");
				String hora = rs.getString("hora");
				String accion = rs.getString("accion");
				String vista = rs.getString("vista");
				String[] registro = {fecha, hora, accion, vista};
				registros.add(registro);
			}
			return registros;

		} catch (SQLException e) {
			System.err.println(e);
			return registros;
		}
	}
	
	public ArrayList<String[]> consultarBitacora(){
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();
		ArrayList<String[]> registros = new ArrayList<>();

		String sql = "SELECT * FROM bitacora";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String fecha = rs.getString("fecha");
				String hora = rs.getString("hora");
				String accion = rs.getString("accion");
				String vista = rs.getString("vista");
				String[] registro = {fecha, hora, accion, vista};
				registros.add(registro);
			}
			return registros;

		} catch (SQLException e) {
			System.err.println(e);
			return registros;
		}
	}

	public int obtenerCantidadOpeCuenta(String numCuenta) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();
		int cantidad = 0;

		String sql = "SELECT COUNT(*) AS cantidad FROM bd_bancoapp.cuenta_operacion WHERE numero_cuenta = ?";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Encriptacion.encriptar(numCuenta));
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