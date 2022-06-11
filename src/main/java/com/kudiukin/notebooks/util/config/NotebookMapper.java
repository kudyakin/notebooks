package com.kudiukin.notebooks.util.config;

import com.kudiukin.notebooks.domain.Notebook;
import com.kudiukin.notebooks.dto.NotebookDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface NotebookMapper {
    NotebookMapper INSTANCE  = Mappers.getMapper(NotebookMapper.class);

    NotebookDto notebookToNotebookDto(Notebook notebook);
    Notebook notebookDtoToNotebook(NotebookDto dto);

}