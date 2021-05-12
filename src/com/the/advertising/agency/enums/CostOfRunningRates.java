package com.the.advertising.agency.enums;

public enum CostOfRunningRates {

    RADIO_AND_SPOTIFY_BUSINESS_HOURS_FOR_1_WEEK("RADIO AD Campaign Business Hours - for $$ weeks :             $", 70.00),
    RADIO_AND_SPOTIFY_EVENINGS_FOR_1_WEEK(      "RADIO AD Campaign Evening Hours - for $$ weeks :              $", 60.00),
    RADIO_AND_SPOTIFY_OTHER_HOURS_FOR_1_WEEK(   "RADIO AD Campaign Other Hours - for $$ weeks :                $", 35.00),
    TELEVISION_HIGH_EXPOSURE_FOR_1_WEEK(        "HIGH Exposure TV Campaign - for $$ weeks :                    $", 400.00),
    TELEVISION_MEDIUM_EXPOSURE_FOR_1_WEEK(      "MEDIUM Exposure TV Campaign - for $$ weeks :                  $", 280.00),
    TELEVISION_LOW_EXPOSURE_FOR_1_WEEK(         "LOW Exposure TV Campaign - for $$ weeks :                     $", 150.00),
    TELEVISION_SPECIFIC_CHANNEL_FOR_1_WEEK(     "Feature in specific TV program - for $$ weeks :               $", 100.00),
    NEWSPAPER_BLACK_AND_WHITE_PER_SQUARE_CM(    "NEWSPAPER AD Campaign Black and White - for $$ square cm. :  $", 2.20),
    NEWSPAPER_COLOURED_PER_SQUARE_CM(           "NEWSPAPER AD Campaign Coloured - for $$ square cm. :         $", 4.80),
    NEWSPAPER_PROMINENT_PLACE(                  "NEWSPAPER AD in Prominent Place :                            $", 10.00),
    PREPAID_INTERNET_AD(                        "INTERNET AD Campaign for amount :                            $", 1.00),
    ;

    private final String info;
    private final double cost;

    CostOfRunningRates(String info, double cost) {
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
