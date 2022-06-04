/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadeaccesodedatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gustavo
 */
public class UsuarioCRUD extends Conexion {

	public boolean iniciarSesion(String pNombreUsuario, String pContrasena) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();

		String sql = "SELECT * FROM usuario WHERE nombre_usuario = ?";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pNombreUsuario);
			rs = ps.executeQuery();

			if (rs.next()) {
				if (rs.getString("contrasena").equals(pContrasena)) {
					return true;
				}
			}
			return false;

		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}
}
