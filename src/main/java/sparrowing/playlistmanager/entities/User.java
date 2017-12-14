package sparrowing.playlistmanager.entities;

import java.util.Date;

public class User {
	
	/*
	 * int userId - Unique user ID number
	 * String username - User's username
	 * Date dateTimeJoined - Time object of when the user first was created
	 */
	
	private int userId;
	
	private String username;
	
	private Date dateTimeJoined;
	
	// CONSTRUCTORS ==============================================
	
	@SuppressWarnings("unused")
	private User() {
		// Empty constructor for Hibernate
	}
	
	public User(String username) {
		this.username = username;
	}
	
	// GETTERS ===================================================
	
	public int getUserId() {
		return this.userId;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public Date getDateTimeJoined() {
		return this.dateTimeJoined;
	}
	
	// SETTERS ===================================================
	
	// Setters are required for Hibernate - these set to private because
	//    outside use is not wanted
	
	@SuppressWarnings("unused")
	private void setUserId(int userId) {
		this.userId = userId;
	}
	
	@SuppressWarnings("unused")
	private void setUsername(String username) {
		this.username = username;
	}
	
	@SuppressWarnings("unused")
	private void setDateTimeJoined(Date dateTimeJoined) {
		this.dateTimeJoined = dateTimeJoined;
	}
	
}
