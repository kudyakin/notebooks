package com.kudiukin.notebooks.util.config;

import com.kudiukin.notebooks.domain.Notebook;
import com.kudiukin.notebooks.dto.NotebookDto;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

public class NotebookMapper extends CustomMapper<Notebook, NotebookDto> {

    @Override
    public void mapBtoA(NotebookDto dto, Notebook entity, MappingContext context) {
        super.mapBtoA(dto, entity, context);
    }
}