package sparrowing.playlistmanager.entities.forms;

import sparrowing.playlistmanager.entities.persistence.User;
import sparrowing.playlistmanager.util.base.Form;

public class UserForm extends Form {
	
	private String username;
	private String password;
	private String passwordVerification;
	
	// ERROR FIELDS -----------------------------------------------------------
	
	private static final String USERNAME_ERROR_FIELD = "username";
	private static final String PASSWORD_ERROR_FIELD = "password";
	private static final String PASSWORD_VERIFICATION_ERROR_FIELD = "password_verification";
	
	private static final String[] ERROR_FIELDS = {
			USERNAME_ERROR_FIELD,
			PASSWORD_ERROR_FIELD,
			PASSWORD_VERIFICATION_ERROR_FIELD
	};

	// ERROR MESSAGES ---------------------------------------------------------
	
	private static final String FIELD_EMPTY_MESSAGE = "Field may not be empty.";
	private static final String INVALID_USERNAME_MESSAGE = "Username invalid, "
			+ "please select something else.";
	private static final String USERNAME_IN_USE_MESSAGE = "Username already in use, "
			+ "please select something else.";
	private static final String INVALID_PASSWORD_MESSAGE = "Password invalid, "
			+ "please select something else.";
	private static final String PASSWORD_VER_MISMATCH_MESSAGE = "Verification does "
			+ "not match entered password.";
	
	// CONSTRUCTOR ------------------------------------------------------------
	
	public UserForm(String username, String password, String passwordVerification) {
		this.username = username;
		this.password = password;
		this.passwordVerification = passwordVerification;
	}
	
	// FIELD-CHECKING METHODS -------------------------------------------------
	
	/**
	 * Performs validation on the set username field of this form object, setting the
	 * 'username' error field if field content is invalid.
	 *   
	 * <br><br>
	 * 
	 * Specifically checks for:
	 * 
	 * <ol>
	 * 	<li>If the username field is empty or made up of only whitespace.</li>
	 * 	<li>If the username text is valid by the rules of the User class.</li>
	 * 	<li>If the username is already in use by a user within the database.</li>
	 * </ol>
	 *   
	 * @return True if field content was valid, else false
	 */
	private boolean checkUsername() {
		
		String username = this.username;
		
		if (isBlankField(username)) {
			// Username field empty (or filled with just spaces/whitespace)
			setError(USERNAME_ERROR_FIELD, FIELD_EMPTY_MESSAGE);
			
		} else if (!User.isValidUsername(username)) {
			// Username text not valid
			setError(USERNAME_ERROR_FIELD, INVALID_USERNAME_MESSAGE);
			
		} else if (username == "IN USE") {
			// TODO: Check here if username is already in use once user table can be queried
			// Username already in use by another user
			setError(USERNAME_ERROR_FIELD, USERNAME_IN_USE_MESSAGE);
			
		} else {
			// Username confirmed to be valid
			return true;
		}
		
		// Code runs down here if any errors happened
		return false;
	}
	
	/**
	 * Performs validation on the password field, setting the 'password' error field if
	 * field content is invalid.
	 * 
	 * <br><br>
	 * 
	 * Specifically checks for 1: if the password field is blank or only whitespace;
	 * and 2: if the password text is invalid based on the rules of this application's
	 * User class.
	 *   
	 * @return True if field content was valid, else false
	 */
	private boolean checkPassword() {
		
		String pw = this.password;
		
		if (isBlankField(pw)) {
			// Password field empty or just whitespace
			setError(PASSWORD_ERROR_FIELD, FIELD_EMPTY_MESSAGE);
			
		} else if (!User.isValidPassword(pw)) {
			// Password text not valid
			setError(PASSWORD_ERROR_FIELD, INVALID_PASSWORD_MESSAGE);
			
		} else {
			// Password confirmed valid on all fronts
			return true;
		}
		
		// Code runs down here if any errors came up
		return false;
	}
	
	/**
	 * Performs validation on the password verification field, setting the
	 * 'password_verification' error field if field content is invalid.
	 * 
	 * <br><br>
	 * 
	 * Needs only check if the verification matches the password field of this form.
	 *   
	 * @return True if field content was valid, else false
	 */
	private boolean checkPasswordVerification() {
		
		if (!passwordVerification.equals(password)) {
			// Verification doesn't match password
			setError(PASSWORD_VERIFICATION_ERROR_FIELD, PASSWORD_VER_MISMATCH_MESSAGE);
			
		} else {
			return true;
		}
		
		// Code runs down here if any errors came up
		return false;
	}
	
	// OVERRIDED ABSTRACT METHODS ---------------------------------------------
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean validate() {
		
		// Run error checks
		if (checkUsername() && checkPassword() && checkPasswordVerification()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String[] getErrorFields() {
		return ERROR_FIELDS;
	}

}
