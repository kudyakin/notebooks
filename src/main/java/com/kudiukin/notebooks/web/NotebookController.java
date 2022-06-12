package com.kudiukin.notebooks.web;

import com.kudiukin.notebooks.domain.Notebook;
import com.kudiukin.notebooks.dto.NotebookDto;
import com.kudiukin.notebooks.service.NotebookService;
import com.kudiukin.notebooks.util.config.NotebookConverter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Notebook", description = "Notebook API")
public class NotebookController {

    private final NotebookService notebookService;

    private final NotebookConverter notebookConverter;

    @PostMapping("/notebooks")
    @ResponseStatus(value =HttpStatus.CREATED,reason = "Notebook Created")
    @Operation(summary = "This is endpoint to add a new notebook", description = "Create request to add a new notebook", tags = {"Notebook"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "CREATED. The new notebook is successfully created and added to database"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified notebook request not found"),
            @ApiResponse(responseCode = "409", description = "Notebook already exists")})
    public NotebookDto createNotebook(@RequestBody @Valid NotebookDto requestForSave) {
        var notebook = notebookConverter.getMapperFacade().map(requestForSave, Notebook.class);
        var dto = notebookConverter.toDto(notebookService.create(notebook));
        return dto;
    }

    @PutMapping("/notebooks/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "This is endpoint to change notebook by ID", description = "Create request to change notebook by ID", tags = {"Notebook"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "UPDATED. This notebook is successfully updated and added to database"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified notebook request not found"),
            @ApiResponse(responseCode = "409", description = "Notebook already exists")})
    public Notebook putNotebook(@PathVariable("id") Integer id, @RequestBody Notebook notebook) {
        return notebookService.update(id, notebook);
    }

//    @GetMapping("/notebooks")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Notebook> getAllNotebooks() {
//        return notebookService.view();
//    }

    @GetMapping("/notebooks/all")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "This is endpoint to view all notebooks in database", description = "Create request to view all notebooks in database", tags = {"Notebook"})
    public Collection<Notebook>findAllByDeletedIsFalse(){
        return notebookService.findAllByDeletedIsFalse();
    }

    @GetMapping("/notebooks/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "This is endpoint to view notebook by ID", description = "Create request to view notebook by ID", tags = {"Notebook"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "OK. Pls see requested notebook by ID"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified notebook request not found"),
            @ApiResponse(responseCode = "409", description = "Notebook already exists")})
    public Notebook getNotebook(@PathVariable Integer id) {
        Notebook notebook=notebookService.viewById(id);
        return notebook;
    }

//        return notebookService.viewById(id);
//        try {
//            return notebookService.viewById(id).toString();
//        } catch (EntityNotFoundException e) {
//            return e.getLocalizedMessage();


    @PatchMapping("/notebooks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "This is endpoint to safe delete notebook by ID", description = "Create request to safe delete notebook by ID", tags = {"Notebook"})
    public void removeNotebook(@PathVariable Integer id) {  // add message to client "Notebook by ID deleted "
        notebookService.delete(id);
    }

    @DeleteMapping("/notebooks")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "This is endpoint to delete all notebooks in database", description = "NOW THIS ENDPOINT IS BLOCKED!!!", tags = {"Notebook"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Notebook by requested ID deleted successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified notebook request not found"),
            @ApiResponse(responseCode = "409", description = "Notebook already deleted")})
    public void removeAllNotebooks() {
//        notebookService.deleteAll();
    }

    @GetMapping(value = "/notebooks/brand", params = {"nameBrand"})
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "This is endpoint to view notebook by brand name", description = "Create request to view notebooks by brand name", tags = {"Notebook"})
    public Collection<Notebook> findNotebookByNameBrand(String nameBrand){
        return notebookService.findNotebookByNameBrand(nameBrand);
    }

    @GetMapping(value = "/notebooks/display", params = {"displayDiagonal"})
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "This is endpoint to view notebooks by display diagonal", description = "Create request to view notebooks by display diagonal", tags = {"Notebook"})
    public Collection<Notebook> findNotebookByDispayDiagonal(int displayDiagonal){
        return notebookService.findNotebookByDisplayDiagonal(displayDiagonal);
    }

    @GetMapping(value = "/notebooks/os", params = {"os"})
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "This is endpoint to view notebooks by operating system", description = "Create request to view notebooks by operating system", tags = {"Notebook"})
    public Collection<Notebook> findNotebookByOs(String os){
        return notebookService.findNotebookByOs(os);
    }

    @GetMapping(value = "/notebooks/mac")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "This is endpoint to view notebooks with MacOS", description = "Create request to view notebooks with MacOS", tags = {"Notebook"})
    public Collection<Notebook> findNotebookByMacOs(){
        return notebookService.findNotebookByMacOs();
    }

    @GetMapping(value = "/notebooks/win")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "This is endpoint to view notebooks with Win7 and Win10", description = "Create request to view notebooks with Win7 and Win10", tags = {"Notebook"})
    public Collection<Notebook> findNotebookByWinOs(){
        return notebookService.findNotebookByWinOs();
    }

    @GetMapping(value = "/notebooks/memory", params = {"memorySize"})
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "This is endpoint to view notebooks by memory size", description = "Create request to view notebooks by memory size", tags = {"Notebook"})
    public Collection<Notebook> findNotebookByMemorySize(int memorySize){
        return notebookService.findNotebookByMemorySize(memorySize);
    }
}
