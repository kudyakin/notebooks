package com.kudiukin.notebooks;


import com.kudiukin.notebooks.domain.Notebook;
import com.kudiukin.notebooks.repository.NotebookRepository;
import com.kudiukin.notebooks.service.NotebookServiceBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NotebookServiceTests {

    @Mock
    private NotebookRepository notebookRepository;

    @InjectMocks
    private NotebookServiceBean notebookService;

    @Test
    public void whenSaveNotebook_shouldReturnNotebook() {
        Notebook notebook = new Notebook();
        notebook.setNameBrand("Samsung");

        when(notebookRepository.save(ArgumentMatchers.any(Notebook.class))).thenReturn(notebook);

        Notebook created = notebookService.create(notebook);

        assertThat(created.getNameBrand()).isSameAs(notebook.getNameBrand());
        verify(notebookRepository).save(notebook);
    }

    @Test
    public void whenGivenId_shouldReturnNotebook_ifFound() {
        Notebook notebook = new Notebook();
        notebook.setId(777);

        when(notebookRepository.findById(notebook.getId())).thenReturn(Optional.of(notebook));

        Notebook expected = notebookService.viewById(notebook.getId());

        assertThat(expected).isSameAs(notebook);
//        verify(notebookRepository).findById(notebook.getId());
    }

//    @Test(expected = EntityNotFoundException.class)
//    public void should_throw_exception_when_notebook_doesnt_exist() {
//        Notebook notebook = new Notebook();
//        notebook.setId(888);
//        notebook.setNameBrand("DELL");
//
//        given(notebookRepository.findById(anyInt())).willReturn(Optional.empty());
//        notebookService.viewById(notebook.getId());
//    }
}
