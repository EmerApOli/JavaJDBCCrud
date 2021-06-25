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
		insert.setLong(1, 2);
		insert.setString(2,"Carlos");
		insert.setString(3, "carlos@gamil");
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
	
	//buscar nao retorna lista apenas objeto
	
	public Usuario buscarusaurio(Long id) throws SQLException{
		Usuario retorno = new Usuario();
		String sql =  "select * from usuario where id = " + id;
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet  resultado = statement.executeQuery();
		
		while (resultado.next()) {
			
			// Usuario usuario = new Usuario();
			 retorno.setId(resultado.getLong("id"));
			 retorno.setNome(resultado.getString("nome"));
			 retorno.setEmail(resultado.getString("email"));
			
			 
			 
		}
		
		 return retorno;
		}
	
	public void atualizar(Usuario usuario) throws SQLException {
		
		String sql = "update usuario set nome = ? where id = " + usuario.getId();
			PreparedStatement  statement = connection.prepareStatement(sql);
		statement.setString(1, usuario.getNome());
		statement.execute();
		connection.commit();
		
		
		
		
	}
	
	
}
