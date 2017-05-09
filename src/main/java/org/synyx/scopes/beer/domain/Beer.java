package org.synyx.scopes.beer.domain;


public class Beer {

    private final String name;
    private final Integer score;

    public Beer(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }

}
