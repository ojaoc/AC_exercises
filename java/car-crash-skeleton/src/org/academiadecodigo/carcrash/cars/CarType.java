package org.academiadecodigo.carcrash.cars;

public enum CarType {

    FIAT("F"),
    MUSTANG("M"),
    CRASHED("C");

    private String identifier;

    CarType(String identifier) {

        this.identifier = identifier;

    }

    public String getIdentifier() {

        return this.identifier;

    }

}
