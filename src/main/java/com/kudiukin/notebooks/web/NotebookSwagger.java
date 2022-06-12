package com.kudiukin.notebooks.web;

import com.kudiukin.notebooks.domain.Notebook;
import com.kudiukin.notebooks.dto.NotebookDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.Collection;

@Tag(name = "Notebook", description = "Notebook API")
public interface NotebookSwagger {

    @Operation(summary = "This is endpoint to add a new notebook", description = "Create request to add a new notebook", tags = {"Notebook"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "CREATED. The new notebook is successfully created and added to database"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified notebook request not found"),
            @ApiResponse(responseCode = "409", description = "Notebook already exists")})
    NotebookDto createNotebook(NotebookDto requestForSave);

    @Operation(summary = "This is endpoint to change notebook by ID", description = "Create request to change notebook by ID", tags = {"Notebook"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "UPDATED. This notebook is successfully updated in database"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified notebook request not found"),
            @ApiResponse(responseCode = "409", description = "Notebook already exists")})
    Notebook putNotebook(Integer id, Notebook notebook);

    @Operation(summary = "This is endpoint to view all notebooks in database", description = "Create request to view all notebooks in database", tags = {"Notebook"})
    Collection<Notebook> findAllByDeletedIsFalse();

    @Operation(summary = "This is endpoint to view notebook by ID", description = "Create request to view notebook by ID", tags = {"Notebook"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK. Pls see requested notebook by ID"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified notebook request not found"),
            @ApiResponse(responseCode = "500", description = "Notebook already deleted")})
    Notebook getNotebook(Integer id);

    @Operation(summary = "This is endpoint to safe delete notebook by ID", description = "Create request to safe delete notebook by ID", tags = {"Notebook"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Notebook by requested ID deleted successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified notebook request not found"),
            @ApiResponse(responseCode = "500", description = "Notebook already deleted")})
    void removeNotebook(Integer id);

    @Operation(summary = "This is endpoint to delete all notebooks in database - BLOCKED!!!", description = "NOW THIS ENDPOINT IS BLOCKED!!!", tags = {"Notebook"})
    void removeAllNotebooks();

    @Operation(summary = "This is endpoint to view notebook by brand name", description = "Create request to view notebooks by brand name", tags = {"Notebook"})
    Collection<Notebook> findNotebookByNameBrand(String nameBrand);

    @Operation(summary = "This is endpoint to view notebooks by display diagonal", description = "Create request to view notebooks by display diagonal", tags = {"Notebook"})
    Collection<Notebook> findNotebookByDisplayDiagonal(int displayDiagonal);

    @Operation(summary = "This is endpoint to view notebooks by memory size", description = "Create request to view notebooks by memory size", tags = {"Notebook"})
    Collection<Notebook> findNotebookByMemorySize(int memorySize);

    @Operation(summary = "This is endpoint to view notebooks by operating system", description = "Create request to view notebooks by operating system", tags = {"Notebook"})
    Collection<Notebook> findNotebookByOs(String os);

    @Operation(summary = "This is endpoint to view notebooks with MacOS as operating system", description = "Create request to view notebooks with MacOS", tags = {"Notebook"})
    Collection<Notebook> findNotebookByMacOs();

    @Operation(summary = "This is endpoint to view notebooks with Windows as operating system", description = "Create request to view notebooks with Win7 and Win10", tags = {"Notebook"})
    Collection<Notebook> findNotebookByWinOs();
}
