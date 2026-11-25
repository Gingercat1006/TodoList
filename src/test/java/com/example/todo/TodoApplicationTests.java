package com.example.todo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
@AutoConfigureMockMvc
class TodoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	void redirectsRootToTaskList() throws Exception {
		mockMvc.perform(get("/"))
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("/taskLists"));
	}

	@Test
	void displaysTaskList() throws Exception {
		mockMvc.perform(get("/taskLists"))
				.andExpect(status().isOk())
				.andExpect(view().name("task/list"));
	}

	@Test
	void validatesTaskOnInsert() throws Exception {
		mockMvc.perform(post("/taskLists/insert")
						.param("name", "")
						.param("detail", "")
						.param("dueDate", ""))
				.andExpect(status().isOk())
				.andExpect(view().name("task/form"));
	}

	@Test
	void insertsTaskAndRedirects() throws Exception {
		mockMvc.perform(post("/taskLists/insert")
						.param("name", "テストタスク")
						.param("detail", "テスト詳細")
						.param("categoryId", "1")
						.param("dueDate", "2026-12-31"))
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("/taskLists"));
	}

	@Test
	void displaysCategoryManagement() throws Exception {
		mockMvc.perform(get("/categories"))
				.andExpect(status().isOk())
				.andExpect(view().name("category/list"));
	}

	@Test
	void insertsCategoryAndRedirects() throws Exception {
		mockMvc.perform(post("/categories/insert")
						.param("name", "学習"))
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("/categories"));
	}

}
