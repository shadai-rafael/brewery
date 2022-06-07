package com.shadai.ms.brewery.service.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.shadai.ms.brewery.model.BeerDto;
import com.shadai.ms.brewery.service.BeerService;

import lombok.Data;

@Data
@Service
public class BeerServiceImpl implements BeerService{

    private Map<String,BeerDto> listOfBeers;

    public BeerServiceImpl(){
        listOfBeers = new HashMap<String, BeerDto>();
        listOfBeers.put("64faf272-4292-4706-a8cb-bfaede8c0cd2",
                    BeerDto.builder()
                    .id(UUID.fromString("64faf272-4292-4706-a8cb-bfaede8c0cd2"))                        
                    .beerName("default")
                    .beerStyle("default")
                    .upc(123456789012L)
                    .build()
        );
    }
    
    @Override
    public BeerDto getBeerById(UUID id){
        return listOfBeers.get(id.toString());
    }

    @Override
    public List<BeerDto> getAllTheBeers(){        
        return new ArrayList<BeerDto>(listOfBeers.values());
    }

    @Override
    public BeerDto createBeer(BeerDto beerDto){
        BeerDto newbeerDto = new BeerDto();
        newbeerDto.setId(UUID.randomUUID());
        newbeerDto.setBeerName(beerDto.getBeerName());
        newbeerDto.setBeerStyle(beerDto.getBeerStyle());
        newbeerDto.setUpc(beerDto.getUpc());
        listOfBeers.put(newbeerDto.getId().toString(),newbeerDto);
        return newbeerDto;
    }

    @Override
    public BeerDto updateBeer(UUID id, BeerDto beerDto){

        BeerDto beer = listOfBeers.get(id.toString());

        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle());
        beer.setUpc(beerDto.getUpc());
        
        listOfBeers.replace(beer.getId().toString(), beer);
        
        return beer;
    }

    @Override
    public void deleteBeer(UUID id){
        listOfBeers.remove(id.toString());
    }
}
