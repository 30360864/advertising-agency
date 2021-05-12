package com.the.advertising.agency.advertisements;

import com.the.advertising.agency.abstracts.Advertisement;
import com.the.advertising.agency.enums.CostOfPreparationRates;
import com.the.advertising.agency.enums.CostOfRunningRates;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

public class InternetAndMobileAppsTest {

    Advertisement advertisement;
    @Before
    public void setup(){
        advertisement = new InternetAndMobileApps();
        HashMap<Integer, Integer> samplePreparationData1 = new HashMap<>();
        samplePreparationData1.put(1,2);
        advertisement.listOfPreparationAdCost.put(CostOfPreparationRates.INTERNET_STATIC_IMAGE, samplePreparationData1);

        HashMap<Integer, Integer> sampleRunningData1 = new HashMap<>();
        sampleRunningData1.put(400,1);
        advertisement.listOfRunningAdCost.put(CostOfRunningRates.PREPAID_INTERNET_AD, sampleRunningData1);

        advertisement.totalPreparationCost = 10.0;
        advertisement.totalRunningCost = 400.0;
    }

    @Test
    public void testCostOfPreparation() throws Exception {
        Assert.assertEquals(10.0, advertisement.costOfPreparation(), 0.005);
    }

    @Test
    public void testCostOfRunning() throws Exception {
        Assert.assertEquals(400.0, advertisement.costOfRunning(), 0.005);
    }

    @Test
    public void testInsertIntoPreparationAd() throws Exception {
        advertisement.insertIntoPreparationAd(CostOfPreparationRates.INTERNET_ANIMATED_IMAGE, 1, 2);
        Assert.assertEquals(2, advertisement.listOfPreparationAdCost.size());
        Assert.assertEquals(1, advertisement.listOfPreparationAdCost.get(CostOfPreparationRates.INTERNET_ANIMATED_IMAGE).size());
        Assert.assertEquals(2, (int) advertisement.listOfPreparationAdCost.get(CostOfPreparationRates.INTERNET_ANIMATED_IMAGE).get(1));
    }

    @Test
    public void testDisplayQuote() throws Exception {
        String output =
                "---------------------------------------------------------------\n" +
                "2 X INTERNET AD Preparation - Static Images :                    $10.0\n" +
                "1 X INTERNET AD Campaign for amount :                            $400.0\n" +
                "\n" +
                "Quote Total                                                      $410.0\n" +
                "Paid So Far                                                      $0.0\n";
        Assert.assertEquals(output, advertisement.displayQuote());
    }
}
