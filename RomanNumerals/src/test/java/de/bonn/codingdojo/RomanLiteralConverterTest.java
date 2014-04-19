package de.bonn.codingdojo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RomanLiteralConverterTest {

    @Test(expectedExceptions = { IllegalArgumentException.class })
    public void convertZeroAnExceptionIsRaised() {
        RomanLiteralConverter.convert(0);
    }

    @Test(expectedExceptions = { IllegalArgumentException.class })
    public void convertForThousandAnExceptionIsRaised() {
        RomanLiteralConverter.convert(4000);
    }

    @DataProvider
    Iterator<Object[]> expectedConversion() throws Exception {
        List<Object[]> testData = new ArrayList<Object[]>();
        BufferedReader testCases = new BufferedReader(new InputStreamReader(
                ClassLoader.getSystemResourceAsStream("roman.literals"), "UTF-8"));
        String readLine = null;
        while ((readLine = testCases.readLine()) != null) {
            String[] split = readLine.split("\\|");
            testData.add(new Object[] { Integer.parseInt(split[0].trim()), split[1].trim() });
        }
        return testData.iterator();
    }

    @Test(dataProvider = "expectedConversion")
    public void convertNumberAndExpectRomanLiteral(int number, String converted) {
        Assert.assertEquals(RomanLiteralConverter.convert(number), converted);
    }

}
