package com.kudiukin.notebooks.service;

import com.kudiukin.notebooks.domain.Notebook;
import com.kudiukin.notebooks.repository.NotebookRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
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
        Notebook notebook = notebookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Notebook not found with id = " + id));  // add to new method and use it
        if (notebook.getDeleted() || notebook.getDeleted().equals(null)){                      //see later Equals and ==
            throw new EntityNotFoundException("Notebook was deleted");
        }
        return notebook;
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
        Notebook notebook = notebookRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Notebook not found with id = " + id));
        notebook.setDeleted(Boolean.TRUE);
        notebookRepository.save(notebook);

//        notebookRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        notebookRepository.deleteAll();
    }

    @Override
    public Collection<Notebook> findNotebookByNameBrand(String nameBrand) {
        log.debug("findNotebookByNameBrand() - start: nameBrand = {}", nameBrand);
        Collection<Notebook> collection = notebookRepository.findByNameBrand(nameBrand);
        log.info("findNotebookByNameBrand() - end: collection = {}", collection);
        return collection;
    }

    @Override
    public Collection<Notebook> findNotebookByDisplayDiagonal(int displayDiagonal) {
        log.info("findNotebookByDisplayDiagonal() - start: displayDiagonal = {}", displayDiagonal);
        Collection<Notebook> collection = notebookRepository.findByDisplayDiagonal(displayDiagonal);
        log.info("findNotebookByDisplayDiagonal() - end: collection = {}", collection);
        return collection;
    }

    @Override
    public Collection<Notebook> findNotebookByOs(String os) {
        log.info("findNotebookByOs() - start: os = {}", os);
        Collection<Notebook> collection = notebookRepository.findByOs(os);
        log.info("findNotebookByOs() - end: collection = {}", collection);
        return collection;
    }

    @Override
    public Collection<Notebook> findNotebookByMacOs() {
        log.info("findNotebookByMacOs() - start");
        Collection<Notebook> collection = notebookRepository.findByMacOs();
        log.info("findNotebookByMacOs() - end: collection = {}", collection);
        return collection;
    }

    @Override
    public Collection<Notebook> findNotebookByWinOs() {
        log.info("findNotebookByWinOs() - start");
        Collection<Notebook> collection = notebookRepository.findByWinOs();
        log.info("findNotebookByWinOs() - end: collection = {}", collection);
        return collection;
    }

    @Override
    public Collection<Notebook> findNotebookByMemorySize(int memorySize) {
        log.info("findNotebookByMemorySize() - start: memorySize = {}", memorySize);
        Collection<Notebook> collection = notebookRepository.findByMemorySize(memorySize);
        log.info("findNotebookByMemorySize() - end: collection = {}", collection);
        return collection;
    }

    private void checkProduceDate(Notebook notebook) {
        if (notebook.getProduceDate().isBefore(LocalDate.of(2009, 5, 13))) {
            throw new RuntimeException("Notebook is very-very old (more that 13 years), we can't add this hardware to database!");
        }
    }
}