package com.kudiukin.notebooks.service;

import com.kudiukin.notebooks.domain.Notebook;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

public interface NotebookService {

    Notebook create (Notebook notebook);

    List<Notebook> view();

    Notebook viewById(Integer id);

    Notebook update(Integer id, Notebook notebook);

    void delete(Integer id);

    void deleteAll();

    Collection<Notebook> findNotebookByNameBrand (String nameBrand);

    Collection<Notebook> findNotebookByDisplayDiagonal (int displayDiagonal);

    Collection<Notebook> findNotebookByMacOs ();

    Collection<Notebook> findNotebookByWinOs ();

    Collection<Notebook> findNotebookByOs (String os);

    Collection<Notebook> findNotebookByMemorySize (int memorySize);
}
