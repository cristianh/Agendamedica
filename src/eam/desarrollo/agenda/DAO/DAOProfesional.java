package eam.desarrollo.agenda.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;

import com.mysql.jdbc.Connection;

import com.mysql.jdbc.ResultSet;

import eam.desarollo.agenda.modelo.Profesional;
import eam.desarrollo.agenda.interfaces.IntProfesional;

public class DAOProfesional implements IntProfesional {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void crear(Profesional pro) {
		// TODO Auto-generated method stub
		//
		try {

			String sql = "INSERT INTO  profesional(Idprofesional,nombre_profesional,apellido_profesional,identificacion_profesional,area_profesional,telefono_profesional,direccion_profesional)"
					+ " VALUES(?,?,?,?,?,?,?)";
			// System.out.println(sql);

			Connection con = Conexion.getConexion();
			PreparedStatement stm = con.prepareStatement(sql);

			stm.setInt(1, pro.getIdprofesional());
			stm.setString(2, pro.getNombreProfesional());
			stm.setString(3, pro.getApellidoProfesional());
			stm.setInt(4, pro.getIdentificacionProfesional());
			stm.setString(5, pro.getAreaProfesional());
			stm.setString(6, pro.getTelefonoProfesional());
			stm.setString(7, pro.getDireccionProfesional());
			stm.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			// Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE,
			// null, ex);
		}

	}

	

	@Override
	public void actualizar(Profesional pro) {

		try {

			String sql = "UPDATE profesional SET Idprofesional=?,nombre_profesional=?,apellido_profesional=?,area_profesional=?,telefono_profesional=?,direccion_profesional=? WHERE identificacion_profesional=?";
			// System.out.println(sql);

			Connection con = Conexion.getConexion();
			java.sql.PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, pro.getIdprofesional());
			stm.setString(2, pro.getNombreProfesional());
			stm.setString(3, pro.getApellidoProfesional());

			stm.setString(4, pro.getAreaProfesional());
			stm.setString(5, pro.getTelefonoProfesional());
			stm.setString(6, pro.getDireccionProfesional());
			stm.setInt(7, pro.getIdentificacionProfesional());
			stm.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			// Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE,
			// null, ex);
		}
	}

	@Override
	public void listarProfesional(Profesional pro) {
		// TODO Auto-generated method stub

	}

	@Override
	public Profesional buscar(int identificacion) throws Exception {
		// TODO Auto-generated method stub
		Connection con = Conexion.getConexion();

		String sql = "SELECT * from profesional WHERE identificacion_profesional=?";
		java.sql.PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setInt(1, identificacion);
		// ejecutar consulta
		java.sql.ResultSet res = pstmt.executeQuery();
		Profesional cust = null;
		// hubo un registro....
		if (res.next()) {
			int id = res.getInt(1);
			String nombre = res.getString(2);
			String apellido = res.getString(3);
			int cedula = res.getInt(4);
			String area = res.getString(5);
			String telefono = res.getString(6);
			String direccion = res.getString(7);

			cust = new Profesional(id, nombre, apellido, cedula, area, telefono, direccion);
			System.out.println(cust);

		}
		con.close();
		return cust;

	}

	@Override
	public void eliminar(String identificacion) throws Exception {
		// TODO Auto-generated method stub
				try {

					// System.out.println(sql);
					Connection con = Conexion.getConexion();
					String sql2 = "DELETE from profesional WHERE identificacion_profesional=?";
					java.sql.PreparedStatement stm2 = con.prepareStatement(sql2);
					stm2.setString(1, identificacion);
					stm2.executeUpdate();

				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
					// Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE,
					// null, ex);
				}
	}
}
