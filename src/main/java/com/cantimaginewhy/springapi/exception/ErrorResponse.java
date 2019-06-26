package com.cantimaginewhy.springapi.exception;

import java.util.Date;

public class ErrorResponse {

	private Date timestamp;
	private String status;
	private String message;
	private String details;
	
	/**
	 * Constructor
	 * 
	 * @param timestamp
	 * @param status
	 * @param message
	 * @param details
	 */
	public ErrorResponse(Date timestamp, String status, String message, String details) {
		this.timestamp = timestamp;
		this.status = status;
		this.message = message;
		this.details = details;
	}

	/**
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}
	
	
}
