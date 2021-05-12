package com.the.advertising.agency.advertisements;

import com.the.advertising.agency.abstracts.Advertisement;
import com.the.advertising.agency.enums.CostOfPreparationRates;
import com.the.advertising.agency.enums.CostOfRunningRates;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;


public class RadioAndSpotifyTest{

    Advertisement advertisement;
    @Before
    public void setup(){
        advertisement = new RadioAndSpotify();
        HashMap<Integer, Integer> samplePreparationData1 = new HashMap<>();
        samplePreparationData1.put(1,2);
        samplePreparationData1.put(2,1);
        advertisement.listOfPreparationAdCost.put(CostOfPreparationRates.RADIO_AND_SPOTIFY_PER_15_SECONDS, samplePreparationData1);

        HashMap<Integer, Integer> sampleRunningData1 = new HashMap<>();
        sampleRunningData1.put(4,4);
        advertisement.listOfRunningAdCost.put(CostOfRunningRates.RADIO_AND_SPOTIFY_BUSINESS_HOURS_FOR_1_WEEK, sampleRunningData1);

        HashMap<Integer, Integer> sampleRunningData2 = new HashMap<>();
        sampleRunningData2.put(4,3);
        advertisement.listOfRunningAdCost.put(CostOfRunningRates.RADIO_AND_SPOTIFY_EVENINGS_FOR_1_WEEK, sampleRunningData2);

        HashMap<Integer, Integer> sampleRunningData3 = new HashMap<>();
        sampleRunningData3.put(4,2);
        advertisement.listOfRunningAdCost.put(CostOfRunningRates.RADIO_AND_SPOTIFY_OTHER_HOURS_FOR_1_WEEK, sampleRunningData3);

        advertisement.totalPreparationCost = 80.0;
        advertisement.totalRunningCost = 2160.0;
    }

    @Test
    public void testCostOfPreparation() throws Exception {
        Assert.assertEquals(80.0, advertisement.costOfPreparation(), 0.005);
    }

    @Test
    public void testCostOfRunning() throws Exception {
        Assert.assertEquals(2120.0, advertisement.costOfRunning(), 0.005);
    }

    @Test
    public void testCostOfRunningFor1Week() throws Exception {
        Assert.assertEquals(530.0, advertisement.costOfRunningFor1Week(), 0.005);
    }

    @Test
    public void testInsertIntoPreparationAd() throws Exception {
        advertisement.insertIntoPreparationAd(CostOfPreparationRates.RADIO_AND_SPOTIFY_PER_15_SECONDS, 4, 1);
        advertisement.insertIntoPreparationAd(CostOfPreparationRates.RADIO_AND_SPOTIFY_PER_15_SECONDS, 1, 1);
        Assert.assertEquals(3, advertisement.listOfPreparationAdCost.get(CostOfPreparationRates.RADIO_AND_SPOTIFY_PER_15_SECONDS).size());
        Assert.assertEquals(1, (int) advertisement.listOfPreparationAdCost.get(CostOfPreparationRates.RADIO_AND_SPOTIFY_PER_15_SECONDS).get(4));
        Assert.assertEquals(3, (int) advertisement.listOfPreparationAdCost.get(CostOfPreparationRates.RADIO_AND_SPOTIFY_PER_15_SECONDS).get(1));
    }

    @Test
    public void testInsertIntoRunningAd() throws Exception {
        advertisement.insertIntoRunningAd(CostOfRunningRates.RADIO_AND_SPOTIFY_BUSINESS_HOURS_FOR_1_WEEK, 3, 1);
        advertisement.insertIntoRunningAd(CostOfRunningRates.RADIO_AND_SPOTIFY_BUSINESS_HOURS_FOR_1_WEEK, 4, 1);
        Assert.assertEquals(2, advertisement.listOfRunningAdCost.get(CostOfRunningRates.RADIO_AND_SPOTIFY_BUSINESS_HOURS_FOR_1_WEEK).size());
        Assert.assertEquals(1, (int) advertisement.listOfRunningAdCost.get(CostOfRunningRates.RADIO_AND_SPOTIFY_BUSINESS_HOURS_FOR_1_WEEK).get(3));
        Assert.assertEquals(5, (int) advertisement.listOfRunningAdCost.get(CostOfRunningRates.RADIO_AND_SPOTIFY_BUSINESS_HOURS_FOR_1_WEEK).get(4));
    }

    @Test
    public void testDisplayQuote() throws Exception {
        String output =
                "---------------------------------------------------------------\n" +
                "2 X RADIO AD Preparation - for 15 seconds :                      $40.0\n" +
                "1 X RADIO AD Preparation - for 30 seconds :                      $40.0\n" +
                "3 X RADIO AD Campaign Evening Hours - for 4 weeks :              $720.0\n" +
                "2 X RADIO AD Campaign Other Hours - for 4 weeks :                $280.0\n" +
                "4 X RADIO AD Campaign Business Hours - for 4 weeks :             $1120.0\n" +
                "\n" +
                "Quote Total                                                      $2240.0\n" +
                "Paid So Far                                                      $0.0\n";
        Assert.assertEquals(output, advertisement.displayQuote());
    }
}
