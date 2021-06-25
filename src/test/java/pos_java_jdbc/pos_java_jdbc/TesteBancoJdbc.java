package pos_java_jdbc.pos_java_jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

//import conexajdbc.SingleConnection;
import dao.usuarioDAO;
import model.Usuario;

public class TesteBancoJdbc {
	@Test
	public void  initbanco() throws SQLException {
		usuarioDAO  usdao = new usuarioDAO();
		Usuario usuario = new Usuario();
		
		
		usdao.Salvar(usuario);
		
	}
	
	
	

}
