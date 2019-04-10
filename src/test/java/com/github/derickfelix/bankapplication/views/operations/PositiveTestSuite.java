/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.derickfelix.bankapplication.views.operations;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Tan Chek Wei
 */
@RunWith(Categories.class)
@Categories.IncludeCategory(PositiveTest.class)
@Suite.SuiteClasses({RegisterStaffTest.class, SavingCalculatorTest.class})
public class PositiveTestSuite {
    
}
