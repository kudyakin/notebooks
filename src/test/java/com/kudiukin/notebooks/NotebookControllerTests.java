package com.kudiukin.notebooks;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kudiukin.notebooks.domain.Notebook;
import com.kudiukin.notebooks.repository.NotebookRepository;
import com.kudiukin.notebooks.web.NotebookController;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//@WebMvcTest(NotebookController.class)
@SpringBootTest(classes = NotebooksApplication.class)
@AutoConfigureMockMvc
public class NotebookControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    NotebookRepository notebookRepository;

    @MockBean
    NotebookController notebookController;

    @Ignore
    @Test
    public void createNotebook_success() throws Exception {
        Notebook notebook = Notebook.builder()
                .nameBrand("Lenovo")
                .build();

        Mockito.when(notebookRepository.save(notebook)).thenReturn(notebook);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("api/notebooks")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(notebook));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.firstNameBrand", is("Lenovo")));
    }



    @Test
    public void getNotebookById_success() throws Exception {

        Notebook notebook = Notebook.builder()
                .nameBrand("Lenovo")
                .model("X100")
                .os("Win7")
                .build();

        Mockito.when(notebookRepository.findById(notebook.getId())).thenReturn(java.util.Optional.of(notebook));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/notebooks/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
//                .andExpect(jsonPath("$", notNullValue()))
//                .andExpect(jsonPath("$.firstName", is("Lenovo")));
    }



    @Ignore
    @Test
    public void getAllNotebook_success() throws Exception {

        Notebook notebook = Notebook.builder()
                .nameBrand("Samsung")
                .model("x2300")
                .build();

        List<Notebook> records = new ArrayList<>(Arrays.asList(notebook));

        notebookRepository.save(notebook);

        Mockito.when(notebookRepository.findAll()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/notebooks/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
//                .andExpect(jsonPath("$", hasSize(1)))
//                .andExpect(jsonPath("$[1].firstNameBrand", is("Samsung")));
    }
}
