package com.the.advertising.agency.abstracts;

import com.the.advertising.agency.Main;
import com.the.advertising.agency.advertisements.InternetAndMobileApps;
import com.the.advertising.agency.advertisements.Newspaper;
import com.the.advertising.agency.advertisements.RadioAndSpotify;
import com.the.advertising.agency.advertisements.Television;
import com.the.advertising.agency.enums.AdvertisementPhases;
import com.the.advertising.agency.enums.CostOfPreparationRates;
import com.the.advertising.agency.enums.CostOfRunningRates;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class Advertisement implements Serializable {
    public static Scanner input = new Scanner(System.in);
    public int clientId;
    public String clientFirstName;
    public String clientLastName;
    public double totalPreparationCost = 0;
    public double totalRunningCost = 0;
    public double totalPaid = 0;
    public AdvertisementPhases phase = AdvertisementPhases.START;
    public HashMap<CostOfPreparationRates, HashMap<Integer,Integer>> listOfPreparationAdCost = new HashMap<>();
    public HashMap<CostOfRunningRates, HashMap<Integer,Integer>> listOfRunningAdCost = new HashMap<>();
    public abstract void userInputForPreparations() throws Exception;
    public abstract void userInputForRunning() throws Exception;

    public void userInputForCampaign() throws Exception{
        getBasicDetails();
        System.out.println("---------------------------------------------------------------");
        System.out.println("Let's Start building our campaign -");

        System.out.println("---------------------------------------------------------------");
        System.out.println("Welcome to Preparations for your campaign - ");
        while(true){
            userInputForPreparations();
            System.out.println("Do you want to add more preparation work ? (1 for yes)");
            int userInput = input.nextInt();
            if(userInput != 1){
                break;
            }
        }
        totalPreparationCost = costOfPreparation();
        System.out.println("\n"+displayQuote());

        System.out.println("---------------------------------------------------------------");
        System.out.println("Welcome to Running your campaign - ");
        while(true){
            userInputForRunning();
            System.out.println("Do you want to add more running campaign ? (1 for yes)");
            int userInput = input.nextInt();
            if(userInput != 1){
                break;
            }
        }
        totalRunningCost = costOfRunning();
        System.out.println("\n"+displayQuote());
    }

    public void getBasicDetails() throws Exception{
        System.out.println("Enter Client's First Name (Without Space): ");
        clientFirstName = input.next();
        System.out.println("Enter Client's Last Name (Without Space): ");
        clientLastName = input.next();
        clientId = ++Main.id;
        System.out.println("Client's ID for this new campaign : "+ clientId);
    }

    public void userInputForPreparationsAdditions() throws Exception{
        System.out.println("---------------------------------------------------------------");
        System.out.println("Welcome back to Preparations for your campaign - ");
        while(true){
            userInputForPreparations();
            System.out.println("Do you want to add more preparation work ? (1 for yes)");
            int userInput = input.nextInt();
            if(userInput != 1){
                break;
            }
        }
        totalPreparationCost = costOfPreparation();
    }

    public void userInputForRunningAdditions() throws Exception{
        System.out.println("---------------------------------------------------------------");
        System.out.println("Welcome back to Running your campaign - ");
        while(true){
            userInputForRunning();
            System.out.println("Do you want to add more running campaign ? (1 for yes)");
            int userInput = input.nextInt();
            if(userInput != 1){
                break;
            }
        }
        totalRunningCost = costOfRunning();
    }

    public double costOfPreparation() throws Exception{
        double adPreparationCost = 0;
        for(CostOfPreparationRates adPreparationRates : listOfPreparationAdCost.keySet()){
            HashMap<Integer, Integer> advertisementData = listOfPreparationAdCost.get(adPreparationRates);
            for(Map.Entry<Integer, Integer> data : advertisementData.entrySet()){
                adPreparationCost += ((adPreparationRates.getCost()*data.getKey())*data.getValue());
            }
        }
        return adPreparationCost;
    }

    public double costOfRunning() throws Exception{
        double adRunningCost = 0;
        for(CostOfRunningRates adRunningRates : listOfRunningAdCost.keySet()){
            HashMap<Integer, Integer> advertisementData = listOfRunningAdCost.get(adRunningRates);
            for(Map.Entry<Integer, Integer> data : advertisementData.entrySet()){
                adRunningCost += ((adRunningRates.getCost()*data.getKey())*data.getValue());
            }
        }
        return adRunningCost;
    }

    public double costOfRunningFor1Week() throws Exception{
        double adRunningCost = 0;
        for(CostOfRunningRates adRunningRates : listOfRunningAdCost.keySet()){
            HashMap<Integer, Integer> advertisementData = listOfRunningAdCost.get(adRunningRates);
            for(Map.Entry<Integer, Integer> data : advertisementData.entrySet()){
                adRunningCost += (adRunningRates.getCost()*data.getValue());
            }
        }
        return adRunningCost;
    }

    public boolean acceptPayment(double amountToCollect) throws Exception{
        System.out.println("Amount to be paid : $"+amountToCollect);
        System.out.println("Please enter amount to pay - ");
        double amountPaid = input.nextDouble();
        if(amountPaid < amountToCollect){
            System.out.println("Amount paid is less than pending payment : $"+amountToCollect);
            System.out.println("Please pay again.");
            return false;
        } else if(amountPaid > (amountToCollect+0.05)){
            System.out.println("Amount paid is more than pending payment : $"+amountToCollect);
            System.out.println("Please pay again.");
            return false;
        }
        totalPaid += amountPaid;
        return true;
    }

    public void insertIntoPreparationAd(CostOfPreparationRates costOfPreparationRates, int key, int count) throws Exception{
        HashMap<Integer, Integer> advertisementData = listOfPreparationAdCost.get(costOfPreparationRates);
        if(advertisementData != null){
            if(advertisementData.containsKey(key)){
                int prevCount = advertisementData.get(key);
                advertisementData.put(key, prevCount+count);
            } else {
                advertisementData.put(key, count);
            }
        } else {
            advertisementData = new HashMap<>();
            advertisementData.put(key, count);
            listOfPreparationAdCost.put(costOfPreparationRates, advertisementData);
        }
    }

    public void insertIntoRunningAd(CostOfRunningRates costOfRunningRates, int key, int count) throws Exception{
        HashMap<Integer, Integer> advertisementData = listOfRunningAdCost.get(costOfRunningRates);
        if(advertisementData != null){
            if(advertisementData.containsKey(key)){
                int prevCount = advertisementData.get(key);
                advertisementData.put(key, prevCount+count);
            } else {
                advertisementData.put(key, count);
            }
        } else {
            advertisementData = new HashMap<>();
            advertisementData.put(key, count);
            listOfRunningAdCost.put(costOfRunningRates, advertisementData);
        }
    }

    public String displayQuote() throws Exception{
        StringBuilder displayMessage = new StringBuilder();
        displayMessage.append("---------------------------------------------------------------\n");
        for(CostOfPreparationRates preparationRates : listOfPreparationAdCost.keySet()){
            HashMap<Integer, Integer> advertisementData = listOfPreparationAdCost.get(preparationRates);
            for(Map.Entry<Integer, Integer> data : advertisementData.entrySet()){
                if(this instanceof RadioAndSpotify){
                    displayMessage
                            .append(data.getValue())
                            .append(" X ")
                            .append(preparationRates.getInfo().replace("$$", String.valueOf(data.getKey() * 15)))
                            .append(((preparationRates.getCost() * data.getKey()) * data.getValue()))
                            .append("\n");
                } else if(this instanceof Television || this instanceof InternetAndMobileApps){
                    displayMessage
                            .append(data.getValue())
                            .append(" X ")
                            .append(preparationRates.getInfo())
                            .append(((preparationRates.getCost() * data.getKey()) * data.getValue()))
                            .append("\n");
                } else if(this instanceof Newspaper){
                    displayMessage
                            .append(data.getValue())
                            .append(" X ")
                            .append(preparationRates.getInfo().replace("$$", String.valueOf(data.getKey())))
                            .append(((preparationRates.getCost() * data.getKey()) * data.getValue()))
                            .append("\n");
                }
            }
        }

        for(CostOfRunningRates runningRates : listOfRunningAdCost.keySet()){
            HashMap<Integer, Integer> advertisementData = listOfRunningAdCost.get(runningRates);
            for(Map.Entry<Integer, Integer> data : advertisementData.entrySet()){
                if(runningRates == CostOfRunningRates.NEWSPAPER_PROMINENT_PLACE || runningRates == CostOfRunningRates.PREPAID_INTERNET_AD){
                    displayMessage
                            .append(data.getValue())
                            .append(" X ")
                            .append(runningRates.getInfo())
                            .append(((runningRates.getCost() * data.getKey()) * data.getValue()))
                            .append("\n");
                } else {
                    displayMessage
                            .append(data.getValue())
                            .append(" X ")
                            .append(runningRates.getInfo().replace("$$", String.valueOf(data.getKey())))
                            .append(((runningRates.getCost() * data.getKey()) * data.getValue()))
                            .append("\n");
                }
            }
        }

        displayMessage.append("\n");
        displayMessage.append("Quote Total                                                      $").append(totalPreparationCost + totalRunningCost).append("\n");
        displayMessage.append("Paid So Far                                                      $").append(totalPaid).append("\n");
        return displayMessage.toString();
    }

    public void managePhase() throws Exception{
        System.out.println("---------------------------------------------------------------");
        System.out.println("Current Phase - " + phase.getPhase());
        int userInput;
        switch (phase){
            case START:
            case QUOTE_REJECTED:
                System.out.println("---------------------------------------------------------------");
                System.out.println("You want to edit quotation ? (1 for yes)");
                userInput = input.nextInt();
                if(userInput == 1){
                    System.out.println("You want to edit preparation ad quotation ? (1 for yes)");
                    userInput = input.nextInt();
                    if(userInput == 1) {
                        userInputForPreparationsAdditions();
                    }
                    System.out.println("\n"+displayQuote());

                    System.out.println("You want to edit running ad quotation ? (1 for yes)");
                    userInput = input.nextInt();
                    if(userInput == 1) {
                        userInputForRunningAdditions();
                    }
                    System.out.println("\n"+displayQuote());
                }
                System.out.println("Do you accept quotation ? (1 for yes)");
                int acceptQuotation = input.nextInt();
                if(acceptQuotation == 1){
                    totalPaid = totalPreparationCost;
                    phase = AdvertisementPhases.QUOTE_ACCEPTED;
                    System.out.println("Received amount : $"+totalPaid);
                    System.out.println("Starting working on design..!!!");
                    System.out.println("\n"+displayQuote());
                } else {
                    phase = AdvertisementPhases.QUOTE_REJECTED;
                }
                break;
            case QUOTE_ACCEPTED:
            case DESIGN_REJECTED:
                System.out.println("---------------------------------------------------------------");
                System.out.println("Do you like the design ? (1 for Accept / other for Reject)");
                userInput = input.nextInt();
                if(userInput == 1){
                    double runningCost = 0;
                    boolean payment = false;
                    if(this instanceof RadioAndSpotify || this instanceof Television){
                        phase = AdvertisementPhases.DESIGN_ACCEPTED;
                        System.out.println("Note: Advance Payment for 1 week is required");
                        runningCost = costOfRunningFor1Week();
                        if(runningCost == totalRunningCost){
                            phase = AdvertisementPhases.COMPLETED;
                        }
                    } else if(this instanceof Newspaper || this instanceof InternetAndMobileApps){
                        phase = AdvertisementPhases.COMPLETED;
                        System.out.println("Note: Full Advance Payment is required");
                        runningCost = totalRunningCost;
                    }
                    System.out.println(displayQuote());
                    while(!payment) {
                        payment = acceptPayment(runningCost);
                    }
                } else {
                    phase = AdvertisementPhases.DESIGN_REJECTED;
                }
                break;
            case DESIGN_ACCEPTED:
                boolean payment = false;
                double cost = totalPreparationCost + totalRunningCost - totalPaid;
                System.out.println(displayQuote());
                if(cost <= 0){
                    phase = AdvertisementPhases.COMPLETED;
                    System.out.println("All payment done. Campaign is closed...!!!");
                    break;
                }
                while(!payment) {
                    payment = acceptPayment(cost);
                }
                phase = AdvertisementPhases.COMPLETED;
                break;
            case COMPLETED:
                System.out.println(displayQuote());
                System.out.println("\nAll payment done. Campaign is closed...!!!");
        }
    }

    @Override
    public String toString(){
        StringBuilder displayRecords = new StringBuilder();
        try {
            displayRecords.append("\n---------------------------------------------------------------")
                    .append("\nClient ID -         " + clientId)
                    .append("\nClient First Name - " + clientFirstName)
                    .append("\nClient Last Name -  " + clientLastName)
                    .append("\nCampaign Phase -    " + phase.getPhase()+"\n")
                    .append(displayQuote());
        } catch (Exception e) {
            System.out.println(e+" \nerror displaying Records");
        }
        return displayRecords.toString();
    }
}
