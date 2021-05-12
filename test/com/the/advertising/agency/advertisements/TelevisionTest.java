package com.the.advertising.agency.advertisements;

import com.the.advertising.agency.abstracts.Advertisement;
import com.the.advertising.agency.enums.CostOfPreparationRates;
import com.the.advertising.agency.enums.CostOfRunningRates;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

public class TelevisionTest {

    Advertisement advertisement;
    @Before
    public void setup(){
        advertisement = new Television();
        HashMap<Integer, Integer> samplePreparationData1 = new HashMap<>();
        samplePreparationData1.put(1,2);
        advertisement.listOfPreparationAdCost.put(CostOfPreparationRates.TELEVISION_BASIC_ADVERTISEMENT, samplePreparationData1);

        HashMap<Integer, Integer> sampleRunningData1 = new HashMap<>();
        sampleRunningData1.put(4,4);
        advertisement.listOfRunningAdCost.put(CostOfRunningRates.TELEVISION_HIGH_EXPOSURE_FOR_1_WEEK, sampleRunningData1);

        HashMap<Integer, Integer> sampleRunningData2 = new HashMap<>();
        sampleRunningData2.put(4,3);
        advertisement.listOfRunningAdCost.put(CostOfRunningRates.TELEVISION_MEDIUM_EXPOSURE_FOR_1_WEEK, sampleRunningData2);

        HashMap<Integer, Integer> sampleRunningData3 = new HashMap<>();
        sampleRunningData3.put(4,2);
        advertisement.listOfRunningAdCost.put(CostOfRunningRates.TELEVISION_LOW_EXPOSURE_FOR_1_WEEK, sampleRunningData3);

        advertisement.totalPreparationCost = 220.0;
        advertisement.totalRunningCost = 10960.0;
    }

    @Test
    public void testCostOfPreparation() throws Exception {
        Assert.assertEquals(220.0, advertisement.costOfPreparation(), 0.005);
    }

    @Test
    public void testCostOfRunning() throws Exception {
        Assert.assertEquals(10960.0, advertisement.costOfRunning(), 0.005);
    }

    @Test
    public void testCostOfRunningFor1Week() throws Exception {
        Assert.assertEquals(2740.0, advertisement.costOfRunningFor1Week(), 0.005);
    }

    @Test
    public void testInsertIntoPreparationAd() throws Exception {
        advertisement.insertIntoPreparationAd(CostOfPreparationRates.TELEVISION_BASIC_ADVERTISEMENT, 1, 1);
        advertisement.insertIntoPreparationAd(CostOfPreparationRates.TELEVISION_VOICE_ADVERTISEMENT, 1, 2);
        Assert.assertEquals(2, advertisement.listOfPreparationAdCost.size());
        Assert.assertEquals(1, advertisement.listOfPreparationAdCost.get(CostOfPreparationRates.TELEVISION_BASIC_ADVERTISEMENT).size());
        Assert.assertEquals(1, advertisement.listOfPreparationAdCost.get(CostOfPreparationRates.TELEVISION_VOICE_ADVERTISEMENT).size());
        Assert.assertEquals(3, (int) advertisement.listOfPreparationAdCost.get(CostOfPreparationRates.TELEVISION_BASIC_ADVERTISEMENT).get(1));
        Assert.assertEquals(2, (int) advertisement.listOfPreparationAdCost.get(CostOfPreparationRates.TELEVISION_VOICE_ADVERTISEMENT).get(1));
    }

    @Test
    public void testInsertIntoRunningAd() throws Exception {
        advertisement.insertIntoRunningAd(CostOfRunningRates.TELEVISION_HIGH_EXPOSURE_FOR_1_WEEK, 3, 1);
        advertisement.insertIntoRunningAd(CostOfRunningRates.TELEVISION_SPECIFIC_CHANNEL_FOR_1_WEEK, 4, 1);
        Assert.assertEquals(4, advertisement.listOfRunningAdCost.size());
        Assert.assertEquals(2, advertisement.listOfRunningAdCost.get(CostOfRunningRates.TELEVISION_HIGH_EXPOSURE_FOR_1_WEEK).size());
        Assert.assertEquals(4, (int) advertisement.listOfRunningAdCost.get(CostOfRunningRates.TELEVISION_HIGH_EXPOSURE_FOR_1_WEEK).get(4));
        Assert.assertEquals(1, (int) advertisement.listOfRunningAdCost.get(CostOfRunningRates.TELEVISION_HIGH_EXPOSURE_FOR_1_WEEK).get(3));
        Assert.assertEquals(1, (int) advertisement.listOfRunningAdCost.get(CostOfRunningRates.TELEVISION_SPECIFIC_CHANNEL_FOR_1_WEEK).get(4));
    }

    @Test
    public void testDisplayQuote() throws Exception {
        String output =
                "---------------------------------------------------------------\n" +
                "2 X TELEVISION AD Preparation - Still Images :                   $220.0\n" +
                "3 X MEDIUM Exposure TV Campaign - for 4 weeks :                  $3360.0\n" +
                "2 X LOW Exposure TV Campaign - for 4 weeks :                     $1200.0\n" +
                "4 X HIGH Exposure TV Campaign - for 4 weeks :                    $6400.0\n" +
                "\n" +
                "Quote Total                                                      $11180.0\n" +
                "Paid So Far                                                      $0.0\n";
        Assert.assertEquals(output, advertisement.displayQuote());
    }
}
