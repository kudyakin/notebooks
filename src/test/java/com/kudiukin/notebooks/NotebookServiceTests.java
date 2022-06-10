package com.kudiukin.notebooks;


import com.kudiukin.notebooks.domain.Notebook;
import com.kudiukin.notebooks.repository.NotebookRepository;
import com.kudiukin.notebooks.service.NotebookServiceBean;
import com.kudiukin.notebooks.util.exception.ResourceNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NotebookServiceTests {

    @Mock
    private NotebookRepository Repository;

    @InjectMocks
    private NotebookServiceBean Service;

    @Test
    public void whenSaveNotebook_shouldReturnNotebook() {
        Notebook notebook = new Notebook();
        notebook.setNameBrand("Samsung");

        when(Repository.save(ArgumentMatchers.any(Notebook.class))).thenReturn(notebook);

        Notebook created = Service.create(notebook);

        assertThat(created.getNameBrand()).isSameAs(notebook.getNameBrand());
        verify(Repository).save(notebook);
    }

    @Test
    public void whenGivenId_shouldReturnNotebook_ifFound() {
        Notebook notebook = new Notebook();
        notebook.setId(58);

        when(Repository.findById(notebook.getId())).thenReturn(Optional.of(notebook));

        Notebook expected = Service.viewById(notebook.getId());

        assertThat(expected).isSameAs(notebook);
//         verify(Repository).findById(notebook.getId());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void should_throw_exception_when_notebook_doesnt_exist() {
        Notebook notebook = new Notebook();
        notebook.setId(58);
        notebook.setNameBrand("DELL");

       given(Repository.findById(anyInt())).willReturn(Optional.empty());
       Service.viewById(notebook.getId());
    }
}
