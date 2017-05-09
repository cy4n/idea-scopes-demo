package org.synyx.scopes.beer.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.synyx.scopes.beer.business.BeerService;
import org.synyx.scopes.beer.domain.Beer;

@Configuration
public class DefaultBeerInitializer implements ApplicationListener<ContextRefreshedEvent> {

    private final BeerService beerService;

    @Autowired
    public DefaultBeerInitializer(BeerService beerService) {
        this.beerService = beerService;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (beerService.getBestBeers(1).isEmpty()) {
            beerService.addBeer(new Beer("Rothaus Tannenzäpfle", 90));
            beerService.addBeer(new Beer("Rössel Pils", 12));
            beerService.addBeer(new Beer("Augustiner Hell", 85));
        }
    }
}
