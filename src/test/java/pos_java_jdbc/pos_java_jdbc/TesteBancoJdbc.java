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
	
	@Test
	public void initLista() {
		
		 usuarioDAO usrdao = new usuarioDAO();
		 try {
			 
			 List<Usuario> list = usrdao.listarusuario();
			 
			 for (Usuario usuario: list) {
				 System.out.println(usuario);
				 System.out.println("----------------");
			 }
			 
			 
		 }catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		 
	}
	@Test
	public void initBuscar() {
		
		usuarioDAO usrdao = new usuarioDAO();
		
		try {
			
			Usuario usr =  usrdao.buscarusaurio(2L);
			System.out.println(usr);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Test
	public void initatualizar() {
		try {
		 usuarioDAO usrdao = new usuarioDAO();
			 Usuario obj = usrdao.buscarusaurio(1L);
		 obj.setNome("zoio");
		 usrdao.atualizar(obj);
		 
	}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
	

}}
