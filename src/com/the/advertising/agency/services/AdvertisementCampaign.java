package com.the.advertising.agency.services;

import com.the.advertising.agency.Main;
import com.the.advertising.agency.abstracts.Advertisement;
import com.the.advertising.agency.advertisements.InternetAndMobileApps;
import com.the.advertising.agency.advertisements.Newspaper;
import com.the.advertising.agency.advertisements.RadioAndSpotify;
import com.the.advertising.agency.advertisements.Television;

public class AdvertisementCampaign {
    public void createNewAdCampaign() throws Exception {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Let's get started to create new Ad Campaign.");
        System.out.println("Create New Advertisement Campaign Menu - ");
        System.out.println("1) Radio and Spotify AD Campaign");
        System.out.println("2) Television AD Campaign");
        System.out.println("3) Newspaper AD Campaign");
        System.out.println("4) Internet and Mobile Apps AD Campaign");
        System.out.println("5) Exit");
        System.out.println("Please select one option from above - ");
        int createNewAdCampaignInput = Main.input.nextInt();
        Advertisement advertisement =  null;
        switch (createNewAdCampaignInput){
            case 1:
                advertisement = new RadioAndSpotify();
                break;
            case 2:
                advertisement = new Television();
                break;
            case 3:
                advertisement = new Newspaper();
                break;
            case 4:
                advertisement = new InternetAndMobileApps();
                break;
            case 5:
                return;
            default:
        }
        createQuoteForAd(advertisement);
    }

    public void createQuoteForAd(Advertisement advertisement) throws Exception {
        advertisement.userInputForCampaign();
        advertisement.managePhase();
        Main.advertisementsRecords.add(advertisement);
    }

    public void showAllAdvertisementCampaign(){
        for(Advertisement advertisement : Main.advertisementsRecords){
            System.out.println(advertisement);
        }
    }

    public Advertisement searchAdvertisementCampaignById(int clientId){
        for(Advertisement advertisement : Main.advertisementsRecords){
            if(advertisement.clientId == clientId){
                return advertisement;
            }
        }
        return null;
    }
}
