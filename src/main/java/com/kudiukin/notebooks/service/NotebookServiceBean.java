package com.kudiukin.notebooks.service;

import com.kudiukin.notebooks.domain.Notebook;
import com.kudiukin.notebooks.repository.NotebookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class NotebookServiceBean implements NotebookService{

    private NotebookRepository notebookRepository;

    @Override
    public Notebook create(Notebook notebook) {
        checkProduceDate(notebook);
        return notebookRepository.save(notebook);
    }

    @Override
    public List<Notebook> view() {
        return notebookRepository.findAll();
    }

    @Override
    public Notebook viewById(Integer id) {
        return notebookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Not Found id = " + id));
    }

    @Override
    public Notebook update(Integer id, Notebook notebook) {
        checkProduceDate(notebook);
        return notebookRepository.findById(id)
                .map(entity -> {
                    entity.setNameBrand(notebook.getNameBrand());
                    entity.setModel(notebook.getModel());
                    entity.setDisplayDiagonal(notebook.getDisplayDiagonal());
                    entity.setProcessor(notebook.getProcessor());
                    entity.setMemorySize(notebook.getMemorySize());
                    entity.setSsdSize(notebook.getSsdSize());
                    entity.setVideocard(notebook.getVideocard());
                    entity.setOs(notebook.getOs());
                    entity.setProduceDate(notebook.getProduceDate());
                    return notebookRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Not Found id = " + id));
    }

    @Override
    public void delete(Integer id) {
        notebookRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        notebookRepository.deleteAll();
    }

    private void checkProduceDate(Notebook notebook) {
        if (notebook.getProduceDate().isBefore(LocalDate.of(2009, 5, 13))) {
            throw new RuntimeException("Notebook is very-very old (more that 13 years), we can't add this hardware to database!");
        }
    }
}