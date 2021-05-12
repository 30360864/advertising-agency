package com.the.advertising.agency.advertisements;

import com.the.advertising.agency.abstracts.Advertisement;
import com.the.advertising.agency.enums.CostOfPreparationRates;
import com.the.advertising.agency.enums.CostOfRunningRates;

public class Television extends Advertisement {

    @Override
    public void userInputForPreparations() throws Exception{
        System.out.println("\nPlease Enter type of ad to be prepared - ");
        System.out.println("1) Basic");
        System.out.println("2) Actors Involved");
        System.out.println("Please select one option from above - ");
        int adType = input.nextInt();
        if(adType < 1 || adType > 2){
            System.out.println("Wrong Input..!!");
            return;
        }
        CostOfPreparationRates selectedPreparationType = null;
        switch (adType){
            case 1:
                selectedPreparationType = CostOfPreparationRates.TELEVISION_BASIC_ADVERTISEMENT;
                break;
            case 2:
                selectedPreparationType = CostOfPreparationRates.TELEVISION_VOICE_ADVERTISEMENT;
                break;
        }
        System.out.println("Please Enter number of ads to be prepared - ");
        int noOfAds = input.nextInt();
        insertIntoPreparationAd(selectedPreparationType, 1, noOfAds);
    }

    @Override
    public void userInputForRunning() throws Exception{
        System.out.println("\nExposure for TV advertisement - ");
        System.out.println("1) High Exposure");
        System.out.println("2) Medium Exposure");
        System.out.println("3) Low Exposure");
        System.out.println("Please select one option from above - ");
        int exposure = input.nextInt();
        if(exposure < 1 || exposure > 3){
            System.out.println("Wrong Input..!!");
            return;
        }
        CostOfRunningRates selectedRunType = null;
        switch (exposure){
            case 1:
                selectedRunType = CostOfRunningRates.TELEVISION_HIGH_EXPOSURE_FOR_1_WEEK;
                break;
            case 2:
                selectedRunType = CostOfRunningRates.TELEVISION_MEDIUM_EXPOSURE_FOR_1_WEEK;
                break;
            case 3:
                selectedRunType = CostOfRunningRates.TELEVISION_LOW_EXPOSURE_FOR_1_WEEK;
                break;
        }
        System.out.println("Please Enter number of weeks for which you want to play ad for - ");
        int noOfWeeks = input.nextInt();
        System.out.println("Please Enter number of channels you want to play ad on for selected exposure- ");
        int countOfchannels = input.nextInt();
        insertIntoRunningAd(selectedRunType, noOfWeeks, countOfchannels);

        System.out.println("Please Enter number of specific channels you want to play ad on - (Enter 0 for no specific channels)");
        int countOfSpecificChannels = input.nextInt();
        if(countOfSpecificChannels > 0){
            insertIntoRunningAd(CostOfRunningRates.TELEVISION_SPECIFIC_CHANNEL_FOR_1_WEEK, noOfWeeks, countOfSpecificChannels);
        }
    }
}
