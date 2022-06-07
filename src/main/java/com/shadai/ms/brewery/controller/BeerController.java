package com.shadai.ms.brewery.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shadai.ms.brewery.model.BeerDto;
import com.shadai.ms.brewery.service.BeerService;

@RestController
@RequestMapping("/api/beers")
public class BeerController {    

    final private BeerService beerService;

    public BeerController(BeerService beerService){
        this.beerService = beerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable(name="id") UUID id){
        return new ResponseEntity<>(beerService.getBeerById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BeerDto>> getAllBeers(){
        return new ResponseEntity<>(beerService.getAllTheBeers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDto> createBeerDto(@RequestBody BeerDto beerDto){
        return new ResponseEntity<>(beerService.createBeer(beerDto),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BeerDto> updateBeerDto(@PathVariable(name="id")UUID id, @RequestBody BeerDto beerDto ){
        return new ResponseEntity<>(beerService.updateBeer(id, beerDto),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBeerDto(@PathVariable(name="id")UUID id){
        beerService.deleteBeer(id);
        return new ResponseEntity<>("Beer deleted", HttpStatus.OK);
    }
}
