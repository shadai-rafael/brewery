package com.shadai.ms.brewery.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shadai.ms.brewery.model.CostumerDto;
import com.shadai.ms.brewery.service.CostumerService;

@RestController
@RequestMapping("/api/costumers")
public class CostumerController {

    final private CostumerService costumerService;

    public CostumerController(CostumerService costumerService){
        this.costumerService = costumerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CostumerDto> getCostumer(@PathVariable(name="id") UUID id){
        return new ResponseEntity<CostumerDto>(costumerService.getCostumerDtoById(id),HttpStatus.OK);
    }
    
}
