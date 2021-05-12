package com.the.advertising.agency.advertisements;

import com.the.advertising.agency.abstracts.Advertisement;
import com.the.advertising.agency.enums.CostOfPreparationRates;
import com.the.advertising.agency.enums.CostOfRunningRates;
import java.util.HashMap;

public class InternetAndMobileApps extends Advertisement {
    @Override
    public void userInputForPreparations() throws Exception{
        System.out.println("\nInternet Advertisement type - ");
        System.out.println("1) Static");
        System.out.println("2) Animated");
        System.out.println("Please select one option from above - ");
        int imageTypeInput = input.nextInt();
        if(imageTypeInput < 1 || imageTypeInput > 2){
            System.out.println("Wrong Input..!!");
            return;
        }
        CostOfPreparationRates selectedRunType = null;
        switch (imageTypeInput){
            case 1:
                selectedRunType = CostOfPreparationRates.INTERNET_STATIC_IMAGE;
                break;
            case 2:
                selectedRunType = CostOfPreparationRates.INTERNET_ANIMATED_IMAGE;
                break;
        }
        System.out.println("Please Enter number of images you want to create - ");
        int noOfImages = input.nextInt();
        insertIntoPreparationAd(selectedRunType, 1, noOfImages);
    }

    @Override
    public void userInputForRunning() throws Exception{
        System.out.println("Amount for running ad depends on you. You can add money and based on that we will run ads.");
        System.out.println("Please Enter amount for which you want to run ad - (Please enter round figures.)");
        int amount = input.nextInt();
        HashMap<Integer, Integer> advertisementData = listOfRunningAdCost.get(CostOfRunningRates.PREPAID_INTERNET_AD);
        if(advertisementData != null){
            amount += advertisementData.entrySet().iterator().next().getKey();
        }
        advertisementData = new HashMap<>();
        advertisementData.put(amount, 1);
        listOfRunningAdCost.put(CostOfRunningRates.PREPAID_INTERNET_AD, advertisementData);
    }
}
