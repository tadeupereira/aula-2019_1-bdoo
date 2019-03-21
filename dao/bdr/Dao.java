package dao.bdr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.InterfaceDao;

public abstract class Dao<T> implements InterfaceDao<T> {
	
	String esquema = Singleton.ESQUEMA;
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	
	public Dao() {
		connection = Singleton.getConnection();
	}

}
