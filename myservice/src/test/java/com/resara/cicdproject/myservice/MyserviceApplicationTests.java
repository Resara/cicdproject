package com.resara.cicdproject.myservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MyserviceApplicationTests {

	@Test
	void contextLoads() {
	}


	@Test
	void sampleAdditionTest() {
		int sum = 2 + 3;
		assertEquals(5, sum, "2 + 3 should equal 5");
	}

}
