package com.loteca.orangetalents.novaaposta;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
public class NovaApostaControllerTest {
    
	@Autowired
	private MockMvc mvc;

	public ResultActions post(String url, Map<String, Object> params) {
		try {
			String payload = new ObjectMapper()
					.writeValueAsString(params);
					
			
			MockHttpServletRequestBuilder content = MockMvcRequestBuilders
					.post(url)					
			.contentType(MediaType.APPLICATION_JSON_VALUE)
			.content(payload);
			
			return mvc.perform(content);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 

	}

    @Test
    @DisplayName("Quando email válido retorna uma nova aposta")
    void test1() throws Exception{

        String email = "email@email.com";

        post("/apostas", Map.of("email", email))
            .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }
}
