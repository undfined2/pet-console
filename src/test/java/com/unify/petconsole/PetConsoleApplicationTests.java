package com.unify.petconsole;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class PetConsoleApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	@DisplayName("Test name")
	void testName() {
		
		fail("Not implemented");
	}

}
