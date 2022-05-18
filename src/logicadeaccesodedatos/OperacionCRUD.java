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
	 * Registra una nueva operaci�n
	 * 
	 * @param pOperacion Operacion a registrar
	 * @param pNumeroCuenta N�mero de cuenta a la que se asocia la operaci�n
	 * @return Indicador del �xito de la operaci�n
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
			System.out.println("DFSDFDFDSDDF" + Encriptacion.encriptar(pNumeroCuenta));
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
	 * @param pNumeroCuenta N�mero de cuenta
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
				System.out.println("Entra operaciones");
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