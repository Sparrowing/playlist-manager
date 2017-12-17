package sparrowing.playlistmanager.util.base;

import java.util.HashMap;

import sparrowing.playlistmanager.util.Functions;

public abstract class Form {
	
	private HashMap<String, String> errors;
	
	// CONSTRUCTOR ------------------------------------------------------------
	
	public Form() {
		this.errors = this.instantiateAndGetErrors();
	}
	
	// PRIVATE METHODS --------------------------------------------------------
	
	/**
	 * Utility function of the Form class that builds a dictionary of error field names (keys)
	 * to error values (values).  All error values by default are instantiated to null and
	 * must be set manually when validating the form.
	 *   
	 * @return A HashMap object of type <String, String> instantiated with error field names as
	 *         keys and empty values
	 */
	private HashMap<String, String> instantiateAndGetErrors() {
		
		HashMap<String, String> errors = new HashMap<String, String>();
		String[] fields = this.getErrorFields(); // Get field names specific to form
		
		for (String f : fields) { errors.put(f, null); } // Instantiate values to null by default
		
		return errors;
	}
	
	// STATIC UTILITY METHODS -------------------------------------------------
	
	/**
	 * Determines if provided field value is empty 'blank' or not.  COUNTS WHITESPACE AS NOT EMPTY.
	 * Add allowJustSpaces parameter as false to trim whitespace before counting as empty.
	 *   
	 * @param field Field value to check content of
	 * @return True if field is blank, else false
	 */
	protected static boolean isBlankField(String field) {
		return isBlankField(field, false);
	}
	
	/**
	 * Determines if provided field value is empty or 'blank' or not, with an added parameter whether
	 * or not a String made up of just whitespace counts as not empty.
	 * 
	 * @param field Field value to check content of
	 * @param allowWhitespace Whether or not a String of only whitespace qualifies as NOT blank
	 * @return True if field is blank, else false
	 */
	protected static boolean isBlankField(String field, boolean allowWhitespace) {
		if (allowWhitespace) {
			return Functions.isStringEmpty(field);
		} else {
			return Functions.isStringEmpty(field.trim());
		}
	}
	
	// INSTANCE UTILITY METHODS -----------------------------------------------
	
	/**
	 * Check if specified error field exists on this form.
	 * 
	 * @param field Field to check if exists or not
	 * @return True if error field exists on form class, else false
	 */
	protected boolean doesErrorFieldExist(String field) {
		return errors.containsKey(field);
	}
	
	/**
	 * Retrieves the plain error message (if one exists) of passed error field name in this form.
	 * Throws IllegalArgumentException if the field does not exist in form object.
	 *   
	 * @param errorName Name of error field to retrieve
	 * @return The value of provided error field within this form.  If there is no error, this will
	 *         equal null.
	 */
	public String getErrorMessageByName(String errorName) {
		
		if (!doesErrorFieldExist(errorName)) {
			// Error field name does not exist on this form
			throw new IllegalArgumentException(
					String.format("Error field of name %s does not exist", errorName)
			);
		}
		
		return errors.get(errorName);
	}
	
	/**
	 * Set the value of a form error by name.
	 * 
	 * @param errorName The name of the error field to set the value of
	 * @param errorMessage The error message to 
	 */
	public void setError(String errorName, String errorMessage) {
		
		if (!doesErrorFieldExist(errorName)) {
			// Handle if error field does not exist on this form
			throw new IllegalArgumentException(
					String.format("Error field of name %s does not exist", errorName)
			);
		}
		
		errors.put(errorName, errorMessage);
	}
	
	// ABSTRACT METHODS -------------------------------------------------------
	
	/**
	 * Validates all set fields of a form in whatever way the type of form calls for.
	 * More importantly, sets applicable values to errors in the form's errors dictionary.
	 *   
	 * @return True if form went through without generating any errors, else false
	 */
	public abstract boolean validate();
	
	/**
	 * Gives an array of Strings that are the names of error fields on this form type.  All
	 * classes that extend the Form class must implement this so the errors property can be
	 * properly instantiated.
	 *   
	 * @return All error field names as an array of Strings
	 */
	protected abstract String[] getErrorFields();
	
	// GETTERS ----------------------------------------------------------------
	
	/**
	 * Errors property getter
	 * 
	 * @return this.errors
	 */
	public HashMap<String, String> getErrors() {
		return this.errors;
	}

}
