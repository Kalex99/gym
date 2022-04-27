package com.project.gym;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GymApplicationTests {

	@Autowired
	MockMvc mockMvc;


	@Test
	public void findTermekByID() throws Exception {
		mockMvc.perform(get("/termek/termekOlvasByID/2"))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}
	@Test
	public void findTermekByIDNotFound() throws Exception {
		mockMvc.perform(get("/termek/termekOlvasByID/"))
				.andExpect(status().isNotFound());
	}

	@Test
	public void findSzemelyiEdzoAll() throws Exception {
		mockMvc.perform(get("/szemelyiEdzo/szemEdzoOlvas"))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void deleteFelhasznalo() throws Exception {
		mockMvc.perform(delete("/felhasznalo/felhTorles/2"))
				.andDo(print())
				.andExpect(status().isOk());
	}

}
