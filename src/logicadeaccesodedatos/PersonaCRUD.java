package logicadeaccesodedatos;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import logicadenegocios.Persona;

/**
 *
 * @author Gustavo
 */
public class PersonaCRUD extends Conexion{
	
	public ArrayList consultarPersonas(){
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();
		ArrayList clientesYUsuarios = new ArrayList<Persona>();
		
		String sql = "SELECT * FROM persona";
		
		try{
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()){
				String identificacion = rs.getString("identificacion");
				String primerApellido = rs.getString("primer_apellido");
				String segundoApellido = rs.getString("segundo_apellido");
				String nombre = rs.getString("nombre");
				Date fechaNacimiento = rs.getDate("fecha_nacimiento");
				clientesYUsuarios.add(new Persona(identificacion, primerApellido, segundoApellido, nombre, fechaNacimiento));
			}
			return clientesYUsuarios;
			
		} catch (SQLException e){
			System.err.println(e);
			return clientesYUsuarios;
		}
	}

	public Persona consultarPersona(String pIdentificacion) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();
		
		String sql = "SELECT FROM persona WHERE identificacion = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pIdentificacion);
			rs = ps.executeQuery();

			String identificacion = rs.getString("identificacion");
			String primerApellido = rs.getString("primer_apellido");
			String segundoApellido = rs.getString("segundo_apellido");
			String nombre = rs.getString("nombre");
			Date fechaNacimiento = rs.getDate("fecha_nacimiento");
			
			return new Persona(identificacion, primerApellido, segundoApellido, nombre, fechaNacimiento);

		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}
	}
}