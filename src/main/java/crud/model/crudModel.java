package crud.model;

import org.json.simple.JSONArray;
import org.springframework.http.HttpStatus;

public class crudModel {
	private String responseMessage;
	private HttpStatus responseCode;
	private int statusCode;
	private String responseDescription;
	private JSONArray data;
	private Object jData;
	private boolean validation;

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public HttpStatus getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(HttpStatus responseCode) {
		this.responseCode = responseCode;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getResponseDescription() {
		return responseDescription;
	}

	public void setResponseDescription(String responseDescription) {
		this.responseDescription = responseDescription;
	}

	public JSONArray getData() {
		return data;
	}

	public void setData(JSONArray data) {
		this.data = data;
	}

	public Object getjData() {
		return jData;
	}

	public void setjData(Object jData) {
		this.jData = jData;
	}

	public boolean isValidation() {
		return validation;
	}

	public void setValidation(boolean validation) {
		this.validation = validation;
	}

}