package org.synyx.scopes.beer.persistence;


import org.springframework.stereotype.Repository;
import org.synyx.scopes.beer.domain.Beer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class BeerRepository {
    private final List<Beer> store = new ArrayList<>();

    public List<Beer> getAll() {
        return Collections.unmodifiableList(store);
    }

    public void addBeer(Beer beer){
        this.store.add(beer);
    }
}
