package org.synyx.scopes.beer.business;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.synyx.scopes.beer.domain.Beer;
import org.synyx.scopes.beer.persistence.BeerRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BeerService {

    private final BeerRepository beerRepository;

    @Autowired
    public BeerService(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    public List<Beer> getBestBeers(int amount){
        return beerRepository.getAll().stream()
            .sorted(Comparator.comparing(Beer::getScore).reversed())
            .limit(amount)
            .collect(Collectors.toList());
    }

    public void addBeer(Beer beer) {
        if (beer.getScore() < 0){
            throw new IllegalArgumentException("Score of a beer must be positive!");
        }

        beerRepository.addBeer(beer);
    }
}
