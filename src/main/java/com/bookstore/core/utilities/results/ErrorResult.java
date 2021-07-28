package com.bookstore.core.utilities.results;

public class ErrorResult extends Result{

	public ErrorResult(boolean success) {
		super(false);
		// TODO Auto-generated constructor stub
	}
	public ErrorResult(String message) {
		super(false,message);
	}
	
}
