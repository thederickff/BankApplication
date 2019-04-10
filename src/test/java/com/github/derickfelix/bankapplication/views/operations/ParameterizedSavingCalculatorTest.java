/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    //Parameterized tests are used for multiple iterations over a single input to stress the
    //object in test. The primary reason is to reduce the amount of test code.

package com.github.derickfelix.bankapplication.views.operations;

import java.util.Arrays;
import java.util.Collection;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.model.TestTimedOutException;

/**
 *
 * @author Tan Chek Wei
 * @reference Acharya, S. (2014). Mastering Unit Testing Using Mockito and
 * JUnit.
 * @sample code http://bit.ly/2D1yw7p
 */
@RunWith(Enclosed.class)
public class ParameterizedSavingCalculatorTest {

    @RunWith(Parameterized.class)
    public static class savingCalculatorValidInput {

        // {0}=depositAmount
        // {1}=interest
        // {2}=month
        // {3}=finalSaving
        @Parameters(name = "{index}: calculateSaving({0}, {1}, {2})={3}")
        public static Collection<Object[]> savingCalculatorValidData() {
            return Arrays.asList(new Object[][]{
                //{depositAmount, interest, month, finalSaving} 
                {2000.0, 3.0, 6.0, 2030.19},
                {100078.0, 60.0, 6.0, 134114.09},
                {6000.0, 5.0, 24.0, 6629.65},
                {45800.0, 10.0, 6.0, 48138.24}
            });
        }

        @Parameter(value = 0)
        public double depositAmount;
        @Parameter(value = 1)
        public double interest;
        @Parameter(value = 2)
        public double month;
        @Parameter(value = 3)
        public double finalSaving;

        @Test
        public void savingCalculatorValidInput() throws Exception {
            assertThat(Double.parseDouble(SavingCalculator.calculateSaving(depositAmount, interest, month)), equalTo(finalSaving));
        }
    }

    @RunWith(Parameterized.class)
    public static class savingCalculatorTimeout {
        @Rule
        public ExpectedException thrown= ExpectedException.none();
        
        @Parameters(name = "{index}: calculateSaving({0}, {1}, {2})")
        public static Collection<Object[]> savingCalculatorValidData() {
            return Arrays.asList(new Object[][]{
                //{depositAmount, interest, month}
                {999, 3.0, 9999999999999999.0}});
        }

        @Parameter(value = 0)
        public double depositAmount;
        @Parameter(value = 1)
        public double interest;
        @Parameter(value = 2)
        public double month;
        
        // When run this test, times out after 20 milliseconds.
        // Timeout is applied globally to all methods.
        @Test(timeout = 50)
        public void savingCalculatorInvalidInput() throws TestTimedOutException{
            thrown.expect(TestTimedOutException.class);
            SavingCalculator.calculateSaving(depositAmount, interest, month);
        }
    }
}
