package com.the.advertising.agency.advertisements;

import com.the.advertising.agency.abstracts.Advertisement;
import com.the.advertising.agency.enums.CostOfPreparationRates;
import com.the.advertising.agency.enums.CostOfRunningRates;

public class RadioAndSpotify extends Advertisement {
    @Override
    public void userInputForPreparations() throws Exception{
        int time = 1;
        while(time%15 != 0){
            System.out.println("\nPlease Enter number of seconds (in multiple of 15 seconds) - ");
            time = input.nextInt();
        }
        time = time/15;
        System.out.println("Please Enter number of ads to be prepared - ");
        int noOfAds = input.nextInt();
        insertIntoPreparationAd(CostOfPreparationRates.RADIO_AND_SPOTIFY_PER_15_SECONDS, time, noOfAds);
    }

    @Override
    public void userInputForRunning() throws Exception{
        System.out.println("\nTime Slot for radio advertisement - ");
        System.out.println("1) Business Hours");
        System.out.println("2) Evening Hours");
        System.out.println("3) Other Hours");
        System.out.println("Please select one option from above - ");
        int timeSlot = input.nextInt();
        if(timeSlot < 1 || timeSlot > 3){
            System.out.println("Wrong Input..!!");
            return;
        }

        CostOfRunningRates selectedRunType = null;
        switch (timeSlot){
            case 1:
                selectedRunType = CostOfRunningRates.RADIO_AND_SPOTIFY_BUSINESS_HOURS_FOR_1_WEEK;
                break;
            case 2:
                selectedRunType = CostOfRunningRates.RADIO_AND_SPOTIFY_EVENINGS_FOR_1_WEEK;
                break;
            case 3:
                selectedRunType = CostOfRunningRates.RADIO_AND_SPOTIFY_OTHER_HOURS_FOR_1_WEEK;
                break;
        }
        System.out.println("Please Enter number of weeks for which you want to play ad for - ");
        int noOfWeeks = input.nextInt();
        System.out.println("Please Enter number of radio station you want to play ad on - ");
        int countOfRadioStations = input.nextInt();
        insertIntoRunningAd(selectedRunType, noOfWeeks, countOfRadioStations);
    }

}
