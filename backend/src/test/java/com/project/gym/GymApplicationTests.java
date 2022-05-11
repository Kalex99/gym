package com.project.gym;

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

/**
 * A Gym applikáció teszt rétege.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GymApplicationTests {

	/**
	 * MockMvc objektumfüggöség beillesztése.
	 */
	@Autowired
	MockMvc mockMvc;


	/**
	 * Find termek by id.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void findTermekByID() throws Exception {
		mockMvc.perform(get("/termek/termekOlvasByID/2"))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}

	/**
	 * Find termek by id not found.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void findTermekByIDNotFound() throws Exception {
		mockMvc.perform(get("/termek/termekOlvasByID/"))
				.andExpect(status().isNotFound());
	}

	/**
	 * Find szemelyi edzo all.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void findSzemelyiEdzoAll() throws Exception {
		mockMvc.perform(get("/szemelyiEdzo/szemEdzoOlvas"))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}

	/**
	 * Delete felhasznalo.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void deleteFelhasznalo() throws Exception {
		mockMvc.perform(delete("/felhasznalo/felhTorles/2"))
				.andDo(print())
				.andExpect(status().isOk());
	}

}
