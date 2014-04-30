package tr.metu.edu.sm.cookbook.exception;

public enum CookBookErrorCodes {

	SQLITE_ERROR("SQLITE.FILE", "Cannot open sqlite file."),
	SQLITE_SQL_ERROR("SQLITE.SQL", "SQL error or missing database"),
	TOTAL_UNIQUE_USERS_NOT_FOUND("TOT.UNQ.USR.NOT.FND", "Total unique users not found.");

	private String code;
	private String message;

	private CookBookErrorCodes(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public String getMessage() {
		return "An error has occured: " + code + " - " + message;
		
	}

}
