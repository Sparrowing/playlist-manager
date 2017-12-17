package sparrowing.playlistmanager.entities.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import sparrowing.playlistmanager.util.Functions;

@Entity
@Table(name = "users")
public class User {
	
	/*
	 * int userId - Unique user ID number
	 * String username - User's username
	 * String passwordHash - BCrypt-hashed String of user's password
	 * Date dateTimeJoined - Time object of when the user first was created
	 */
	
	@Id @GeneratedValue @NotNull
	@Column(name = "user_id", unique = true)
	private int userId;
	
	@NotNull
	@Column(name = "username", unique = true)
	private String username;
	
	@NotNull
	@Column(name = "password_hash")
	private String passwordHash;
	
	@Temporal(TemporalType.TIMESTAMP) @NotNull
	@Column(name = "date_time_joined")
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
