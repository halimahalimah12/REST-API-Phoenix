package com.indocyber.RestAPIPhoenix.models;

public enum ReservationMethod {
    OW("Official Web"),
    OS("On Site"),
    AW("Travel Agent Web");
    private final String label;

    ReservationMethod(String label) {
        this.label = label;
    }
}
