package com.resara.cicdproject.myservice.controller;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloControllerTest {

    private final HelloController controller = new HelloController();

    @Test
    void testSayHello() {
        String response = controller.sayHello();
        assertThat(response).isEqualTo("Hello from CI/CD pipeline project with Docker!");
    }
}