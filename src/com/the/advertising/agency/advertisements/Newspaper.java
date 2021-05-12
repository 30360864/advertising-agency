package com.the.advertising.agency.advertisements;

import com.the.advertising.agency.abstracts.Advertisement;
import com.the.advertising.agency.enums.CostOfPreparationRates;
import com.the.advertising.agency.enums.CostOfRunningRates;

public class Newspaper extends Advertisement {
    public int calculateAreaForAd() throws Exception{
        System.out.println("\nPlease Enter width of ad to be prepared in cm (Enter integer value no decimal) - ");
        int width = input.nextInt();
        System.out.println("Please Enter height of ad to be prepared in cm (Enter integer value no decimal) - ");
        int height = input.nextInt();
        return width * height;
    }

    @Override
    public void userInputForPreparations() throws Exception{
        int area = calculateAreaForAd();
        insertIntoPreparationAd(CostOfPreparationRates.NEWSPAPER_PER_SQUARE_CM, area, 1);
        System.out.println("Do you want to add graphic design work for ad ? (Enter 1 for yes) - ");
        int addGraphicDesign = input.nextInt();
        if(addGraphicDesign == 1){
            insertIntoPreparationAd(CostOfPreparationRates.NEWSPAPER_GRAPHICS_DESIGNER, 1, 1);
        }
    }

    @Override
    public void userInputForRunning() throws Exception{
        int area = calculateAreaForAd();
        System.out.println("\nNewspaper advertisement type - ");
        System.out.println("1) Black and White");
        System.out.println("2) Coloured");
        System.out.println("Please select one option from above - ");
        int adColourInput = input.nextInt();
        if(adColourInput < 1 || adColourInput > 2){
            System.out.println("Wrong Input..!!");
            return;
        }
        CostOfRunningRates selectedRunType = null;
        switch (adColourInput){
            case 1:
                selectedRunType = CostOfRunningRates.NEWSPAPER_BLACK_AND_WHITE_PER_SQUARE_CM;
                break;
            case 2:
                selectedRunType = CostOfRunningRates.NEWSPAPER_COLOURED_PER_SQUARE_CM;
                break;
        }
        System.out.println("Please Enter number of newspapers for which you want to publish ad for - ");
        int noOfNewspapers = input.nextInt();
        insertIntoRunningAd(selectedRunType, area, noOfNewspapers);

        System.out.println("Do you want to publish ad on prominent place in newspaper- (Enter 1 for yes)");
        int prominentPlace = input.nextInt();
        if(prominentPlace == 1){
            insertIntoRunningAd(CostOfRunningRates.NEWSPAPER_PROMINENT_PLACE, 1, 1);
        }
    }
}
