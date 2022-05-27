package com.kudiukin.notebooks;

import com.kudiukin.notebooks.web.NotebookController;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(NotebookController.class)
public class NotebookControllerTests {

//    @Autowired
//    MockMvc mockMvc;
//
//    @Autowired
//    ObjectMapper mapper;
//
//    @MockBean
//    NotebookRepository repository;
//
//    @Ignore
//    @Test
//    public void createNotebook_success() throws Exception {
//        Notebook notebook = Notebook.builder()
//                .nameBrand("Lenovo")
//                .build();
//
//        Mockito.when(repository.save(notebook)).thenReturn(notebook);
//
//        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/notebooks")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(this.mapper.writeValueAsString(notebook));
//
//        mockMvc.perform(mockRequest)
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", notNullValue()))
//                .andExpect(jsonPath("$.firstName", is("Lenovo")));
//    }
}
