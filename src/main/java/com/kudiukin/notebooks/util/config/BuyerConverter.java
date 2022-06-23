package com.kudiukin.notebooks.util.config;

import com.kudiukin.notebooks.domain.Buyer;
import com.kudiukin.notebooks.dto.BuyerDto;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;

@Component
public class BuyerConverter {
    private final MapperFacade mapperFacade;

    public BuyerConverter(MapperFacade mapperFacade) {
        this.mapperFacade = mapperFacade;
    }

    public MapperFacade getMapperFacade() {
        return mapperFacade;
    }

    public BuyerDto toDto(Buyer entity) {
        return mapperFacade.map(entity, BuyerDto.class);
    }

    public Buyer fromDto(BuyerDto dto) {
        return mapperFacade.map(dto, Buyer.class);
    }
}
