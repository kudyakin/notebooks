package com.kudiukin.notebooks.util.config;

import com.kudiukin.notebooks.domain.Buyer;
import com.kudiukin.notebooks.dto.BuyerDto;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

public class BuyerMapper extends CustomMapper<Buyer, BuyerDto> {

    @Override
    public void mapAtoB(Buyer buyer, BuyerDto buyerDto, MappingContext context) {
        super.mapAtoB(buyer, buyerDto, context);
    }
}
