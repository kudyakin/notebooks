package com.kudiukin.notebooks.service;

import com.kudiukin.notebooks.domain.Notebook;

import java.util.List;

public interface NotebookService {

    Notebook create (Notebook notebook);

    List<Notebook> view();

    Notebook viewById(Integer id);

    Notebook update(Integer id, Notebook notebook);

    void delete(Integer id);

    void deleteAll();
}
