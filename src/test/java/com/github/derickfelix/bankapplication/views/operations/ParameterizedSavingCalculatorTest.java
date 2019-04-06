/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.derickfelix.bankapplication.views.operations;

import java.util.Arrays;
import java.util.Collection;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author Tan Chek Wei
 */
@RunWith(Parameterized.class)
public class ParameterizedSavingCalculatorTest {

    @Parameters(name = "{index}: calculateSaving({0}, {1}, {2})={3}")
    public static Collection<Object[]> savingData() {
        return Arrays.asList(new Object[][]{
            {2000.0, 3.0, 6.0, 2030.19},
            {100078.0, 60.0, 6.0, 134114.09},
            {6000.0, 5.0, 24.0, 6629.65},
            {45800.0, 10.0, 6.0, 48138.24}
        });
    }
    
    @Parameter(value=0)
    public double n1;
    @Parameter(value=1)
    public double n2;
    @Parameter(value=2)
    public double n3;
    @Parameter(value=3)
    public double expectedResult;

    @Test
    public void calculateSaving() throws Exception {
        assertThat(Double.parseDouble(SavingCalculator.calculateSaving(n1, n2, n3)), equalTo(expectedResult));
    }
}
