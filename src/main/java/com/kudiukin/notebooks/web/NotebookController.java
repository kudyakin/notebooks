package com.kudiukin.notebooks.web;

import com.kudiukin.notebooks.domain.Notebook;
import com.kudiukin.notebooks.dto.NotebookDto;
import com.kudiukin.notebooks.service.NotebookService;
import com.kudiukin.notebooks.util.config.NotebookMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class NotebookController {

    private final NotebookService notebookService;

    @PostMapping("/notebooks")
    @ResponseStatus(value =HttpStatus.CREATED,reason = "Notebook Created")
    public NotebookDto createNotebook(@RequestBody @Valid NotebookDto notebookForSave) {
        Notebook notebook = NotebookMapper.INSTANCE.notebookDtoToNotebook(notebookForSave);;
        return NotebookMapper.INSTANCE.notebookToNotebookDto(notebook);
    }

    @PutMapping("/notebooks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Notebook putNotebook(@PathVariable("id") Integer id, @RequestBody Notebook notebook) {
        return notebookService.update(id, notebook);
    }

//    @GetMapping("/notebooks")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Notebook> getAllNotebooks() {
//        return notebookService.view();
//    }

    @GetMapping("/notebooks")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Notebook>findAllByDeletedIsFalse(){
        return notebookService.findAllByDeletedIsFalse();
    }

    @GetMapping("/notebooks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Notebook getNotebook(@PathVariable Integer id) {
//        return notebookService.viewById(id);
//        try {
//            return notebookService.viewById(id).toString();
//        } catch (EntityNotFoundException e) {
//            return e.getLocalizedMessage();
        Notebook notebook=notebookService.viewById(id);
        return notebook;
    }

    @PatchMapping("/notebooks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeNotebook(@PathVariable Integer id) {  // add message to client "Notebook by ID deleted "
        notebookService.delete(id);
    }

    @DeleteMapping("/notebooks")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllNotebooks() {
        notebookService.deleteAll();
    }

    @GetMapping(value = "/notebooks", params = {"nameBrand"})
    @ResponseStatus(HttpStatus.OK)
    public Collection<Notebook> findNotebookByNameBrand(String nameBrand){
        return notebookService.findNotebookByNameBrand(nameBrand);
    }

    @GetMapping(value = "/notebooks", params = {"displayDiagonal"})
    @ResponseStatus(HttpStatus.OK)
    public Collection<Notebook> findNotebookByDispayDiagonal(int displayDiagonal){
        return notebookService.findNotebookByDisplayDiagonal(displayDiagonal);
    }

    @GetMapping(value = "/notebooks", params = {"os"})
    @ResponseStatus(HttpStatus.OK)
    public Collection<Notebook> findNotebookByOs(String os){
        return notebookService.findNotebookByOs(os);
    }

    @GetMapping(value = "/notebooks/mac")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Notebook> findNotebookByMacOs(){
        return notebookService.findNotebookByMacOs();
    }

    @GetMapping(value = "/notebooks/win")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Notebook> findNotebookByWinOs(){
        return notebookService.findNotebookByWinOs();
    }

    @GetMapping(value = "/notebooks", params = {"memorySize"})
    @ResponseStatus(HttpStatus.OK)
    public Collection<Notebook> findNotebookByMemorySize(int memorySize){
        return notebookService.findNotebookByMemorySize(memorySize);
    }
}
