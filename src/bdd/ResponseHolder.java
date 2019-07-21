package bdd;

import io.restassured.http.Headers;
import io.restassured.response.Response;

public class ResponseHolder {
	
	public static Response response;
	public static int responseCode;
	public static String responseBody;
	public static Headers responseHeaders;
	
	public static Response getResponse() {
		return response;
	}
	public static void setResponse(Response response) {
		ResponseHolder.response = response;
	}
	public static int getResponseCode() {
		return responseCode = response.getStatusCode();
	}
	public static void setResponseCode(int responseCode) {
		ResponseHolder.responseCode = responseCode;
	}
	public static String getResponseBody() {
		return responseBody = response.asString();
	}
	public static void setResponseBody(String responseBody) {
		ResponseHolder.responseBody = responseBody;
	}
	public static Headers getResponseHeaders() {
		return responseHeaders = response.getHeaders();
	}
	public static void setResponseHeaders(Headers responseHeaders) {
		ResponseHolder.responseHeaders = responseHeaders;
	}
	
	
}
