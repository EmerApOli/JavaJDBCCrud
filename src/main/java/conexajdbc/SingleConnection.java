package conexajdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
	
	
	private static  String  url ="jdbc:postgresql://localhost:5432/postgres";
	private static String password ="123";
	private static String  user ="postgres";
	private static   Connection  connection= null;
	
	static {
		conectar();
		
		
	}
	
	
	
	private SingleConnection () {
		conectar();
	}
	
	
	
	private static void conectar() {
		
		try {
			if (connection == null) {
				Class.forName("org.postgresql.Driver");
				connection =  DriverManager.getConnection(url,user,password);
				connection.setAutoCommit(false);
				System.out.println("Conectou com sucesso");
			}
			
		}catch (Exception e) {
				// TODO: handle exception
			e.printStackTrace();
			}
		   
		
		
	}
	public  static Connection getConnection() {
		
		return connection;
	}
	
	

}
