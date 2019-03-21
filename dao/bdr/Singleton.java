package dao.bdr;

import java.sql.Connection;
import java.sql.DriverManager;

public class Singleton {

	private static Connection connection;

	public static final String ESQUEMA = "bdoo";

	// private static final String URL =
	// "jdbc:postgresql://labsql.fapce.edu.br:3024/fap_2019_1";
	// private static final String USUARIO = "bdoo_SuaMatricula";
	// private static final String SENHA = "SuaSenha";
	private static final String URL = System.getenv("URL");
	private static final String USUARIO = System.getenv("USUARIO");
	private static final String SENHA = System.getenv("SENHA");

	private static Singleton singleton;

	private Singleton() {
		try {
			connection = DriverManager.getConnection(URL, USUARIO, SENHA);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		if (singleton == null) {
			Singleton singleton = new Singleton();
		}
		return connection;
	}

}