package com.yamasan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yamasan.entity.RomanNumber;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ConverterControllerTest {
	
	@Autowired
	private MockMvc mvc;

	@Test
	public void testConvertSuccess() throws Exception {
		
		int wholeNumber = 14;
		RomanNumber expectedRomanNumber = new RomanNumber();
		expectedRomanNumber.setRomanNumber("XIV");
		expectedRomanNumber.setWholeNumber(wholeNumber);
		
		ObjectMapper mapper = new ObjectMapper();
		String expectedResponse = mapper.writeValueAsString(expectedRomanNumber);
		mvc.perform(MockMvcRequestBuilders.get("/convert?whole-number="+wholeNumber).accept(MediaType.APPLICATION_JSON))
			 .andExpect(MockMvcResultMatchers.status().isOk())
			 .andExpect(MockMvcResultMatchers.content().json(expectedResponse));
	}

	@Test
	public void testConvertInvalidInput() throws Exception {
		
		mvc.perform(MockMvcRequestBuilders.get("/convert?whole-number=").accept(MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN))
			 .andExpect(MockMvcResultMatchers.status().is4xxClientError())
			 .andExpect(MockMvcResultMatchers.content().string("Input must be positive integer"));
	}
}
