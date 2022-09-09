package com.GoogleCalcTests.Tests;
import com.GoogleCalcTests.Models.CalculatorBlock;
import org.testng.Assert;
import org.testng.annotations.*;

@Test
public class AdditionTests extends TestBase {

    @Test
    public void AddAscendRangeAndDescendRange()
    {
        CalculatorBlock.ClickWholeEquation("0123456789+9876543210");
        double result = calculatorBlock.GetDoubleResult();

        if (!(result == 1111111110E10 || result == 9.999999999E9))
            Assert.fail();
    }

    @Test()
    public void AddZeroAndZero()
    {
        CalculatorBlock.ClickWholeEquation("0+0");
        Assert.assertEquals(calculatorBlock.GetDoubleResult(), 0 );
    }

    @Test
    public void AddZeroAndOne()
    {
        CalculatorBlock.ClickWholeEquation("0+1");
        Assert.assertEquals(calculatorBlock.GetDoubleResult(), 1 );
    }

    @Test
    public void AddOneAndZero()
    {
        CalculatorBlock.ClickWholeEquation("1+0");
        Assert.assertEquals(calculatorBlock.GetDoubleResult(), 1 );
    }

    @Test(description = "Addition test of zero and minus one")
    public void AddBracketsFiveAndTwo()
    {
        CalculatorBlock.ClickWholeEquation("(+5)+(+2)");
        Assert.assertEquals(calculatorBlock.GetDoubleResult(), 7 );
    }

    @Test(description = "Addition test of zero and minus one")
    public void AddDecimalTwoPointTwoMinusOne()
    {
        CalculatorBlock.ClickWholeEquation("2.2+1");
        Assert.assertEquals(calculatorBlock.GetDoubleResult(), 3.2 );
    }

    @Test(description = "Addition test of zero and minus one")
    public void AddHundredAndTwentyFivePercent()
    {
        CalculatorBlock.ClickWholeEquation("100+25%");
        Assert.assertEquals(calculatorBlock.GetDoubleResult(), 125 );
    }

}
