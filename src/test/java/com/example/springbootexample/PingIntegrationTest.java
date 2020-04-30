package com.example.springbootexample;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PingIntegrationTest {

  @Autowired
  private MockMvc mvc;

  @Test
  public void testHelloWorldEndpoint() throws Exception {
    String response = mvc
        .perform(get("/api/ping"))
        .andReturn().getResponse().getContentAsString();
    assertEquals("pong", response);
  }
}