package com.Java_Developer_Test.Brilloconnetz;

import com.Java_Developer_Test.Brilloconnetz.security.AppJwt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BrilloconnetzApplicationTests {

	@Test
	void validateToken(){
		String jwt= AppJwt.generateToken("Anayochukwu James");
		boolean isTokenValid= AppJwt.verifyToken(jwt);

		Assertions.assertTrue(isTokenValid,"This token is valid");
	}

	@Test
	void validateTokenFalse(){
		String jwt= AppJwt.generateToken("Anayochukwu James");
		boolean isTokenValid= AppJwt.verifyToken(jwt);

		Assertions.assertFalse(isTokenValid,"This token is not valid");
	}

}
