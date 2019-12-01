package com.inventory.util;

public class RecordNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RecordNotFoundException(String error, Integer id) {
		super(error+ ": " + id);
	}
}
