package de.mimnu.school.ratespiel.gui.game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

public class Database {
    
    HashMap<Integer, String> playernames = new HashMap<>();
	HashMap<Integer, Integer> games = new HashMap<>();
	HashMap<Integer, Integer> rounds = new HashMap<>();
	HashMap<Integer, Long> roundTime = new HashMap<>();
	
	public Database() {
		createTable();
	}
	
	private void createTable() {
		Connection connection = connect();
		
		String sql = "CREATE TABLE IF NOT EXISTS users ("
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "username TEXT NOT NULL,"
				+ "game INTEGER,"
				+ "round INTEGER,"
				+ "roundTime LONG)";
		
		try(PreparedStatement statement = connect().prepareStatement(sql);) {
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection);
		}
	}
	
	private Connection connect() {
		try {
			return DriverManager.getConnection("jdbc:sqlite:Ratespiel.db");
		} catch(SQLException e) {
			return null;
		}
	}
	
	private void close(Connection connection) {
		try {
			if(connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
