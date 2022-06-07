package com.shadai.ms.brewery.service.serviceimpl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.shadai.ms.brewery.model.CostumerDto;
import com.shadai.ms.brewery.service.CostumerService;

@Service
public class CostumerServiceImpl implements CostumerService {
    
    @Override
    public CostumerDto getCostumerDtoById(UUID id){
        return CostumerDto.builder()
                    .id(UUID.randomUUID())
                    .name("name")
                    .build();
    }
}
