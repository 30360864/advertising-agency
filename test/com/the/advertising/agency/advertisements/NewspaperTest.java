package com.the.advertising.agency.advertisements;

import com.the.advertising.agency.abstracts.Advertisement;
import com.the.advertising.agency.enums.CostOfPreparationRates;
import com.the.advertising.agency.enums.CostOfRunningRates;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

public class NewspaperTest {

    Advertisement advertisement;
    @Before
    public void setup(){
        advertisement = new Newspaper();
        HashMap<Integer, Integer> samplePreparationData1 = new HashMap<>();
        samplePreparationData1.put(32,1);
        samplePreparationData1.put(24,1);
        advertisement.listOfPreparationAdCost.put(CostOfPreparationRates.NEWSPAPER_PER_SQUARE_CM, samplePreparationData1);

        HashMap<Integer, Integer> sampleRunningData1 = new HashMap<>();
        sampleRunningData1.put(32,2);
        advertisement.listOfRunningAdCost.put(CostOfRunningRates.NEWSPAPER_BLACK_AND_WHITE_PER_SQUARE_CM, sampleRunningData1);

        HashMap<Integer, Integer> sampleRunningData2 = new HashMap<>();
        sampleRunningData2.put(24,1);
        advertisement.listOfRunningAdCost.put(CostOfRunningRates.NEWSPAPER_COLOURED_PER_SQUARE_CM, sampleRunningData2);

        advertisement.totalPreparationCost = 75.600000000000006;
        advertisement.totalRunningCost = 255.99999999999999;
    }

    @Test
    public void testCostOfPreparation() throws Exception {
        Assert.assertEquals(75.60, advertisement.costOfPreparation(), 0.005);
    }

    @Test
    public void testCostOfRunning() throws Exception {
        Assert.assertEquals(256.0, advertisement.costOfRunning(), 0.005);
    }

    @Test
    public void testInsertIntoPreparationAd() throws Exception {
        advertisement.insertIntoPreparationAd(CostOfPreparationRates.NEWSPAPER_GRAPHICS_DESIGNER, 1, 1);
        advertisement.insertIntoPreparationAd(CostOfPreparationRates.NEWSPAPER_PER_SQUARE_CM, 28, 1);
        Assert.assertEquals(2, advertisement.listOfPreparationAdCost.size());
        Assert.assertEquals(3, advertisement.listOfPreparationAdCost.get(CostOfPreparationRates.NEWSPAPER_PER_SQUARE_CM).size());
        Assert.assertEquals(1, (int) advertisement.listOfPreparationAdCost.get(CostOfPreparationRates.NEWSPAPER_PER_SQUARE_CM).get(28));
        Assert.assertEquals(1, (int) advertisement.listOfPreparationAdCost.get(CostOfPreparationRates.NEWSPAPER_GRAPHICS_DESIGNER).get(1));
    }

    @Test
    public void testInsertIntoRunningAd() throws Exception {
        advertisement.insertIntoRunningAd(CostOfRunningRates.NEWSPAPER_COLOURED_PER_SQUARE_CM, 28, 1);
        advertisement.insertIntoRunningAd(CostOfRunningRates.NEWSPAPER_PROMINENT_PLACE, 1, 1);
        Assert.assertEquals(3, advertisement.listOfRunningAdCost.size());
        Assert.assertEquals(2, advertisement.listOfRunningAdCost.get(CostOfRunningRates.NEWSPAPER_COLOURED_PER_SQUARE_CM).size());
        Assert.assertEquals(1, (int) advertisement.listOfRunningAdCost.get(CostOfRunningRates.NEWSPAPER_COLOURED_PER_SQUARE_CM).get(28));
        Assert.assertEquals(1, (int) advertisement.listOfRunningAdCost.get(CostOfRunningRates.NEWSPAPER_PROMINENT_PLACE).get(1));
    }

    @Test
    public void testDisplayQuote() throws Exception {
        String output =
                "---------------------------------------------------------------\n" +
                "1 X NEWSPAPER AD Preparation- for 32 square cm. :                $43.2\n" +
                "1 X NEWSPAPER AD Preparation- for 24 square cm. :                $32.400000000000006\n" +
                "1 X NEWSPAPER AD Campaign Coloured - for 24 square cm. :         $115.19999999999999\n" +
                "2 X NEWSPAPER AD Campaign Black and White - for 32 square cm. :  $140.8\n" +
                "\n" +
                "Quote Total                                                      $331.6\n" +
                "Paid So Far                                                      $0.0\n";
        Assert.assertEquals(output, advertisement.displayQuote());
    }
}
