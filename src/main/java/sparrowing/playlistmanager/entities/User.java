package sparrowing.playlistmanager.entities;

import java.util.Date;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import sparrowing.playlistmanager.util.Functions;

public class User {
	
	/*
	 * int userId - Unique user ID number
	 * String username - User's username
	 * Date dateTimeJoined - Time object of when the user first was created
	 */
	
	private int userId;
	
	private String username;
	
	private String passwordHash;
	
	private Date dateTimeJoined;
	
	// Password encoder
	private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	// CONSTRUCTORS -----------------------------------------------------------
	
	@SuppressWarnings("unused")
	private User() {
		// Empty constructor for Hibernate
	}
	
	public User(String username, String rawPassword) {
		this.username = username;
		this.passwordHash = User.hashPassword(rawPassword);
	}
	
	// PRIVATE METHODS --------------------------------------------------------
	
	private static String hashPassword(String password) {
		return encoder.encode(password);
	}
	
	// PUBLIC STATIC METHODS --------------------------------------------------
	
	public static boolean isValidUsername(String username) {
		return Functions.isRegexMatch("[a-zA-Z0-9_-]{3,15}", username);
	}
	
	public static boolean isValidPassword(String password) {
		return Functions.isRegexMatch("([1-zA-Z0-1@.\\s]{2,10})", password);
	}
	
	// PUBLIC INSTANCE METHODS ------------------------------------------------
	
	public boolean isPasswordMatch(String password) {
		return encoder.matches(password, this.passwordHash);
	}
	
	// GETTERS ----------------------------------------------------------------
	
	public int getUserId() {
		return this.userId;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public Date getDateTimeJoined() {
		return this.dateTimeJoined;
	}
	
	// SETTERS ----------------------------------------------------------------
	
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
