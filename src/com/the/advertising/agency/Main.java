package com.the.advertising.agency;

import com.the.advertising.agency.abstracts.Advertisement;
import com.the.advertising.agency.services.AdvertisementCampaign;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int id = 0;
    public static Scanner input = new Scanner(System.in);
    public static List<Advertisement> advertisementsRecords = new ArrayList<>();
    public static AdvertisementCampaign advertisementCampaign = new AdvertisementCampaign();

    public static Advertisement retrieveAdvertisement(){
        System.out.println("Enter Client ID - ");
        int clientId = input.nextInt();
        Advertisement advertisement = advertisementCampaign.searchAdvertisementCampaignById(clientId);
        if(advertisement == null){
            System.out.println("Not Found..!!!");
        }
        return advertisement;
    }

    public static void storeInMemory() throws Exception{
        FileOutputStream fileOutputStream = new FileOutputStream("saveRecords.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(advertisementsRecords);
        objectOutputStream.close();
    }

    public static void loadFromMemory(){
        try {
            FileInputStream fileInputStream = new FileInputStream("saveRecords.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            advertisementsRecords = (ArrayList<Advertisement>) objectInputStream.readObject();
            objectInputStream.close();
            for(Advertisement advertisement : advertisementsRecords){
                if(advertisement.clientId > id){
                    id = advertisement.clientId;
                }
            }
        } catch (Exception e) {
            System.out.println(e + "\nFile Loading Error");
        }
    }

    public static boolean mainMenu(){
        try{
            System.out.println("---------------------------------------------------------------");
            System.out.println("\nMain Menu - ");
            System.out.println("1) Create New AD Campaign");
            System.out.println("2) Resume Previous AD Campaign");
            System.out.println("3) Show All Current AD Campaign");
            System.out.println("4) Search AD Campaign By ID");
            System.out.println("5) Exit");
            System.out.println("Please select one option from above - ");
            int mainMenuInput = input.nextInt();
            Advertisement advertisement;
            switch (mainMenuInput){
                case 1:
                    advertisementCampaign.createNewAdCampaign();
                    break;
                case 2:
                    advertisement = retrieveAdvertisement();
                    if(advertisement != null) {
                        advertisement.managePhase();
                    }
                    break;
                case 3:
                    advertisementCampaign.showAllAdvertisementCampaign();
                    break;
                case 4:
                    advertisement = retrieveAdvertisement();
                    if(advertisement != null) {
                        System.out.println(advertisement);
                    }
                    break;
                case 5:
                    return true;
                default:
            }
            storeInMemory();
        } catch (Exception e){
            System.out.println(e+" \nOops Wrong Input...!!");
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to our Advertisement Agency - ");
        loadFromMemory();
        boolean closeProgram = false;
        while(!closeProgram){
            closeProgram = mainMenu();
        }
    }
}
