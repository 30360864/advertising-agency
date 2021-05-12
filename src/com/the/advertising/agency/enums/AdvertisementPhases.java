package com.the.advertising.agency.enums;

public enum AdvertisementPhases {

    START("START"),
    QUOTE_ACCEPTED("QUOTE_ACCEPTED"),
    QUOTE_REJECTED("QUOTE_REJECTED"),
    DESIGN_ACCEPTED("DESIGN_ACCEPTED"),
    DESIGN_REJECTED("DESIGN_REJECTED"),
    COMPLETED("COMPLETED")
    ;

    private String phase;

    AdvertisementPhases(String phase) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }
}
