package de.bonn.codingdojo;


import org.junit.Assert;
import org.junit.Test;

public class RomanLiteralConverterTest {

    @Test(expected = IllegalArgumentException.class)
    public void convertZeroAnExceptionIsRaised() {
        RomanLiteralConverter.convert(0);
    }

    @Test(expected =IllegalArgumentException.class)
    public void convertForThousandAnExceptionIsRaised() {
        RomanLiteralConverter.convert(4000);
    }
    
    @Test
    public void convertOneAndExpectI() {
        Assert.assertEquals("I", RomanLiteralConverter.convert(1));
    }

}
