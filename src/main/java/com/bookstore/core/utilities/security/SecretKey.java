package com.bookstore.core.utilities.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SecretKey {

	private String secretKey;
	private long expirationInMiliseconds;
	
}
