package de.mimnu.school.ratespiel.gui.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {

	public Database() {
		createTable();
	}
	
	public Connection connect() {
		try {
			return DriverManager.getConnection("jdbc:sqlite:Ratespiel.db");
		} catch(SQLException e) {
			return null;
		}
	}
	
	public void close(Connection connection) {
		try {
			if(connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void createTable() {
		Connection connection = connect();
		
		String sql = "CREATE TABLE IF NOT EXISTS user ("
				+ "username TEXT PRIMARY KEY,"
				+ "bestRound INTEGER NOT NULL,"
				+ "bestRoundTime LONG NOT NULL)";
		
		try(PreparedStatement statement = connection.prepareStatement(sql);) {
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection);
		}
	}
}
