package de.mimnu.school.ratespiel.gui.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class User {

    private Database database = new Database();
    
    private ArrayList<String> user = new ArrayList<>();

	private HashMap<String, Integer> bestRounds = new HashMap<>();
	private HashMap<String, Long> bestRoundTimes = new HashMap<>();

	private String activePlayer;

	public void loadCache() {
		Connection connection = database.connect();

		String sql = "SELECT username, bestRound, bestRoundTime FROM user";

		try(PreparedStatement statement = connection.prepareStatement(sql)) {
			try(ResultSet resultSet = statement.executeQuery()) {
				while(resultSet.next()) {
		   			String username = resultSet.getString("username");
		   			int bestRound = resultSet.getInt("bestRound");
		   			long bestRoundTime = resultSet.getLong("bestRoundTime");

                    user.add(username);
		   			bestRounds.put(username, bestRound);
		   			bestRoundTimes.put(username, bestRoundTime);
	  			}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			database.close(connection);
		}
	}

	public void add(String username) {
		Connection connection = database.connect();

		String sql = "INSERT INTO user (username, bestRound, bestRoundTime) VALUES (?, ?, ?)";

		try(PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, username);
			statement.setInt(2, 0);
			statement.setLong(3, 0);
			statement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			database.close(connection);

            if(!exists(username)) {
                user.add(username);
				bestRounds.put(username, 0);
				bestRoundTimes.put(username, 0L);
            }
		}
	}

	public void remove(String username) {
		Connection connection = database.connect();

		String sql = "DELETE FROM user WHERE username=?";

		try(PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, username);
			statement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			database.close(connection);

            if(exists(username)) {
                user.remove(username);
            }
		}
	}

	public void setBestRound(String username, int bestRound) {
		Connection connection = database.connect();

		String sql = "UPDATE user SET bestRound=? WHERE username=?";

		try(PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, bestRound);
			statement.setString(2, username);
			statement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			database.close(connection);

			if(!bestRounds.containsKey(username)) {
				bestRounds.put(username, bestRound);
			} else {
				bestRounds.replace(username, bestRound);
			}
		}
	}

	public void setBestRoundTime(String username, long bestRoundTime) {
		Connection connection = database.connect();

		String sql = "UPDATE user SET bestRoundTime=? WHERE username=?";

		try(PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setLong(1, bestRoundTime);
			statement.setString(2, username);
			statement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			database.close(connection);

			if(!bestRoundTimes.containsKey(username)) {
				bestRoundTimes.put(username, bestRoundTime);
			} else {
				bestRoundTimes.replace(username, bestRoundTime);
			}
		}
	}

	public void setActivePlayer(String username) {
		activePlayer = username;
	}

	public String getActiveUsername() {
		return activePlayer;
	}

	public boolean exists(String username) {
		return user.contains(username);
	}

	public int getBestRound(String username) {
		return bestRounds.get(username);
	}

	public long getBestRoundTime(String username) {
		return bestRoundTimes.get(username);
	}
}
