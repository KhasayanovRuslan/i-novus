package com.khasayanovruslan.autonumbers;

import com.khasayanovruslan.autonumbers.controllers.AutonumberController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AutonumbersApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private AutonumberController autonumberController;

	@Test
	void contextLoads() {
		assertThat(autonumberController).isNotNull();
	}

	@Test
	public void random() throws Exception {
		this.mockMvc.perform(get("/number/random"))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void next() throws Exception {
		this.mockMvc.perform(get("/number/next"))
				.andDo(print())
				.andExpect(status().isOk());
	}
}
