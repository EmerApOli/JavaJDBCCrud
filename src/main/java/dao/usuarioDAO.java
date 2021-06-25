package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexajdbc.SingleConnection;
import model.Usuario;

public class usuarioDAO {
	
	private Connection connection;
	
	public usuarioDAO(){
		
		connection = SingleConnection.getConnection();
		
	}

	
	public void  Salvar(Usuario usuario) throws SQLException {
		String sql = "insert into usuario (id, nome, email) values(?,?,?)";
		PreparedStatement insert = connection.prepareStatement(sql);
		insert.setLong(1, 1);
		insert.setString(2,"Emerson");
		insert.setString(3, "emerson@gamil");
		insert.execute();
		connection.commit();
		
	}
	
	
	
	public List<Usuario>listarusuario() throws SQLException{
		List<Usuario> list = new ArrayList<Usuario>();
		String sql =  "select * from usuario";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet  resultado = statement.executeQuery();
		
		while (resultado.next()) {
			
			 Usuario usuario = new Usuario();
			 usuario.setId(resultado.getLong("id"));
			 usuario.setNome(resultado.getString("nome"));
			 usuario.setEmail(resultado.getString("email"));
			 list.add(usuario);
			 
			 
		}
		
		 return list;
		}
	
	
	
}
