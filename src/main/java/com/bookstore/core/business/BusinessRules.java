package com.bookstore.core.business;

import org.springframework.stereotype.Component;

import com.bookstore.core.utilities.results.Result;

@Component
public class BusinessRules {
	 public static Result Run(Result... logics) {
		  for(Result logic:logics) {
			  if(!logic.isSuccess()) {
				  return logic;
			  }
		  }
		  return null;
	  }
}
