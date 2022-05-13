package com.kudiukin.notebooks.web;

import com.kudiukin.notebooks.domain.Notebook;
import com.kudiukin.notebooks.service.NotebookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class NotebookController {

    private final NotebookService notebookService;

    public NotebookController(NotebookService notebookService) {
        this.notebookService = notebookService;
    }

    @PostMapping("/notebooks")
    @ResponseStatus(HttpStatus.CREATED)
    public Notebook createNotebook(@RequestBody Notebook notebook) {
        return notebookService.create(notebook);
    }

    @PutMapping("/notebooks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Notebook putNotebook(@PathVariable("id") Integer id, @RequestBody Notebook notebook) {
        return notebookService.update(id, notebook);
    }

    @GetMapping("/notebooks")
    @ResponseStatus(HttpStatus.OK)
    public List<Notebook> getAllNotebooks() {
        return notebookService.view();
    }

    @GetMapping("/notebooks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Notebook getNotebook(@PathVariable Integer id) {
        return notebookService.viewById(id);
    }

    @DeleteMapping("/notebooks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeNotebook(@PathVariable Integer id) {
        notebookService.delete(id);
    }
    @DeleteMapping("/notebooks")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllNotebooks() {
        notebookService.deleteAll();
    }


}
