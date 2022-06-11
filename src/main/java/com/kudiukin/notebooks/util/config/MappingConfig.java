//package com.kudiukin.notebooks.util.config;
//
//import com.kudiukin.notebooks.domain.Notebook;
//import com.kudiukin.notebooks.dto.NotebookDto;
//import ma.glasnost.orika.MapperFactory;
//import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;
//
//public class MappingConfig implements OrikaMapperFactoryConfigurer {
//
//    @Override
//    public void configure(MapperFactory mapperFactory) {
//
//        mapperFactory.classMap(Notebook.class, NotebookDto.class)
//                .customize(new NotebookMapper())
//                .byDefault()
//                .register();
//
//        mapperFactory.classMap(Notebook.class, NotebookDto.class)
//                .byDefault()
//                .register();
//    }
//}