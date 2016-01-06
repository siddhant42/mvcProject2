package com.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;

import com.controllers.SpitterController;
import com.data.Spitter;
import com.data.SpitterRepository;

public class SpitterControllerTest {
	@InjectMocks
	SpitterController controller ;
	@Mock
	SpitterRepository mockRepository;
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void shouldProcessRegistration() throws Exception {
		
		Spitter unsaved =
				new Spitter("jbauer", "24hours", "Jack", "Bauer");
		Spitter saved =
				new Spitter(24L, "jbauer", "24hours", "Jack", "Bauer");
		Mockito.when(mockRepository.save(unsaved)).thenReturn(saved);
		
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(post("/spitter/register")
				.param("firstName", "Jack")
				.param("lastName", "Bauer")
				.param("username", "jbauer")
				.param("password", "24hours"))
		.andExpect(redirectedUrl("/spitter/jbauer"));
		Mockito.verify(mockRepository).save(unsaved);
	}
}
