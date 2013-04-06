package com.ajegames.utility;

import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

/**
 */
public class SpinnerTest extends TestCase {

  public void testSpinnerWithOneChoice() {
    Spinner spinner = Spinner.createSpinner().addOption("Amanda");

    for (int i = 0; i < 1000; i++) {
      spinner.spin();
      assertEquals("Amanda", spinner.getSelectedValue());
    }
  }

  public void testSpinnerWithMultipleChoices() {

    String[] options = new String[] { "SpongeBob", "Patrick", "Squidward", "Mr. Krabs", "Sandra" };

    Spinner spinner = Spinner.createSpinner();
    Map<String, Integer> counts = new HashMap<String, Integer>();
    for (String option : options) {
      spinner.addOption(option);
      counts.put(option, 0);
    }

    for (int i = 0; i < 1000; i++) {
      spinner.spin();
      String selectedValue = spinner.getSelectedValue();
      Integer count = counts.get(selectedValue);
      counts.put(selectedValue, count+1);
    }

    // make sure every choice was selected at least once; highly unlikely to have missed one after so many tries
    for (String choice : counts.keySet()) {
      assertTrue("Choice " + choice + " should have been picked at least once.", counts.get(choice) > 0);
      System.out.println("Choice " + choice + " was picked " + counts.get(choice) + " times.");
    }
  }

  public void testFourChoices() {
    String[] options = new String[] { "North", "South", "East", "West" };
    PluggableRandomizer fixedRandomNumber = MockRandomNumberGenerator.createMockRandomizer();
    Spinner spinner = Spinner.createSpinner(fixedRandomNumber);
    for (String option : options) {
      spinner.addOption(option);
    }

    fixedRandomNumber.setValue(0.15d);
    spinner.spin();
    assertEquals(options[0], spinner.getSelectedValue());

    fixedRandomNumber.setValue(0.49d);
    spinner.spin();
    assertEquals(options[1], spinner.getSelectedValue());

    fixedRandomNumber.setValue(0.50d);
    spinner.spin();
    assertEquals(options[2], spinner.getSelectedValue());

    fixedRandomNumber.setValue(0.99d);
    spinner.spin();
    assertEquals(options[3], spinner.getSelectedValue());

    fixedRandomNumber.setValue(1.0d);
    spinner.spin();
    assertEquals(options[3], spinner.getSelectedValue());
  }
}
