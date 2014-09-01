package eu.execom.collections.utility;

import java.util.HashMap;

public class Response {

	private static HashMap<String, String> create(String message, String status) {
		final HashMap<String, String> response = new HashMap<String, String>();
		response.put("Message", message);
		response.put("status", status);
		return response;
	}

	public static HashMap<String, String> setError(String message) {
		return create(message, "error");
	}

	public static HashMap<String, String> setSuccess(String message) {
		return create(message, "success");
	}

}
