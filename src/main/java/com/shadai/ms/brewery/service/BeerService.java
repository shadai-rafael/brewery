package com.shadai.ms.brewery.service;

import java.util.List;
import java.util.UUID;
import com.shadai.ms.brewery.model.BeerDto;


public interface BeerService {
    public BeerDto getBeerById(UUID id);
    public List<BeerDto> getAllTheBeers();
    public BeerDto createBeer(BeerDto beerDto);
    public BeerDto updateBeer(UUID id, BeerDto beerDto);
    public void deleteBeer(UUID id);
}
