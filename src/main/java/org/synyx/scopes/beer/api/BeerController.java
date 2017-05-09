package org.synyx.scopes.beer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.synyx.scopes.beer.business.BeerService;
import org.synyx.scopes.beer.domain.Beer;

import java.util.List;

@RestController
@RequestMapping("/beer/")
public class BeerController {

    private final BeerService beerService;

    @Autowired
    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @RequestMapping("/top10")
    public ResponseEntity<List<Beer>> top10(){
        List<Beer> bestBeers = beerService.getBestBeers(10);
        return ResponseEntity.ok(bestBeers);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Void> addBeer(@RequestBody Beer beer) {
        beerService.addBeer(beer);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
