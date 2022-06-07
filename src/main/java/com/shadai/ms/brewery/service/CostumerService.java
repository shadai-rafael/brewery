package com.shadai.ms.brewery.service;

import java.util.UUID;

import com.shadai.ms.brewery.model.CostumerDto;

public interface CostumerService {
    
    public CostumerDto getCostumerDtoById(UUID id);
    
}
