//package com.kudiukin.notebooks.util.config;
//
//import com.kudiukin.notebooks.domain.Notebook;
//import com.kudiukin.notebooks.dto.NotebookDto;
//import ma.glasnost.orika.MapperFacade;
//import org.springframework.stereotype.Component;
//
//@Component
//public class NotebookConverter {
//    private final MapperFacade mapperFacade;
//
//    public NotebookConverter(MapperFacade mapperFacade) {
//        this.mapperFacade = mapperFacade;
//    }
//
//    public MapperFacade getMapperFacade() {
//        return mapperFacade;
//    }
//
//    public NotebookDto toDto(Notebook entity) {
//        return mapperFacade.map(entity, NotebookDto.class);
//    }
//
////    public NotebooReadDto toReadDto(Notebook entity) {
////        return mapperFacade.map(entity, NotebookReadDto.class);
////    }
//
//
//    public Notebook fromDto(NotebookDto dto) {
//        return mapperFacade.map(dto, Notebook.class);
//    }
//}
