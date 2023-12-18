package de.mimnu.school.ratespiel.gui.game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Database {
    
    private HashMap<Integer, String> playernames = new HashMap<>();
	private HashMap<Integer, Integer> rounds = new HashMap<>();
	private HashMap<Integer, Long> roundTime = new HashMap<>();
	
	public Database() {
		createTable();
	}
	
	private void createTable() {
		Connection connection = connect();
		
		String sql = "CREATE TABLE IF NOT EXISTS users ("
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "username TEXT NOT NULL,"
				+ "round INTEGER,"
				+ "roundTime LONG)";
		
		try(PreparedStatement statement = connection.prepareStatement(sql);) {
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

	public void addUser(String username) {
		Connection connection = connect();

		int id = getIdByUsername(username);

		String sql = "INSERT INTO users (username) VALUES (?)";

		try(PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, username);
			statement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection);

			if(!playernames.containsKey(id)) {
				playernames.put(getIdByUsername(username), username);
			}
		}
	}

	public void removeUser(String username) {
		playernames.remove(getIdByUsername(username), username);

		Connection connection = connect();

		String sql = "DELETE FROM users WHERE username=?";

		try(PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, username);
			statement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection);
		}
	}

	public int getIdByUsername(String username) {
		Connection connection = connect();

		String sql = "SELECT id FROM users WHERE username=?";

		try(PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, username);
			
			try(ResultSet resultSet = statement.executeQuery()) {
				if(resultSet.next()) {
					return resultSet.getInt("id");
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection);
		}

		return -1;
	}

	private int getIdByUsernameFromCache(String username) {
		for(Map.Entry<Integer, String> entry : playernames.entrySet()) {
        	if(entry.getValue().equals(username)) {
            	return entry.getKey();
        	}
    	}

		return -1;
	}

	public void setRound(String username, int round) {
		Connection connection = connect();

		int id = getIdByUsername(username);

		String sql = "UPDATE users SET round=? WHERE username=?";

		try(PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, round);
			statement.setString(2, username);
			statement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection);

			if(!rounds.containsKey(id)) {
				rounds.put(id, round);
			} else {
				rounds.replace(id, round);
			}
		}
	}

	public void setRoundTime(String username, long time) {
		Connection connection = connect();

		int id = getIdByUsername(username);

		String sql = "UPDATE users SET roundTime=? WHERE username=?";

		try(PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setLong(1, time);
			statement.setString(2, username);
			statement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection);

			if(!roundTime.containsKey(id)) {
				roundTime.put(id, time);
			} else {
				roundTime.replace(id, time);
			}
		}
	}

	public boolean userExists(String username) {
		return playernames.values().contains(username);
	}

	public int getRound(String username) {
		return rounds.get(getIdByUsernameFromCache(username));
	}

	public long getRoundTime(String username) {
		return roundTime.get(getIdByUsernameFromCache(username));
	}
}
