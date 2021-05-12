package com.the.advertising.agency.enums;

public enum CostOfPreparationRates {
    RADIO_AND_SPOTIFY_PER_15_SECONDS("RADIO AD Preparation - for $$ seconds :                      $", 20.00),
    TELEVISION_BASIC_ADVERTISEMENT(  "TELEVISION AD Preparation - Still Images :                   $", 110.00),
    TELEVISION_VOICE_ADVERTISEMENT(  "TELEVISION AD Preparation - Actors Involved :                $", 250.00),
    NEWSPAPER_PER_SQUARE_CM(         "NEWSPAPER AD Preparation- for $$ square cm. :                $", 1.35),
    NEWSPAPER_GRAPHICS_DESIGNER(     "NEWSPAPER AD Preparation - Graphics Designer Involved :      $", 20.00),
    INTERNET_STATIC_IMAGE(           "INTERNET AD Preparation - Static Images :                    $", 5.00),
    INTERNET_ANIMATED_IMAGE(         "INTERNET AD Preparation - Animated Images :                  $", 7.00),
    ;

    private final String info;
    private final double cost;

    CostOfPreparationRates(String info, double cost) {
        this.info = info;
        this.cost = cost;
    }

    public String getInfo() {
        return info;
    }

    public double getCost() {
        return cost;
    }
}
