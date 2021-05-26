package com.loteca.orangetalents.compartilhado;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class CustomMockMvc {
    @Autowired
	private MockMvc mockMvc;

	public ResultActions post(String url, Map<String, Object> params) {
		try {
			String payload = new ObjectMapper()
					.writeValueAsString(params);
					
			
			MockHttpServletRequestBuilder content = MockMvcRequestBuilders
					.post(url)					
			.contentType(MediaType.APPLICATION_JSON_VALUE)
			.content(payload);
			
			return mockMvc.perform(content);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 

	}
}
