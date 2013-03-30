package com.ajegames.utility;

import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

/**
 */
public class SpinnerTest extends TestCase {

  public void testSpinnerWithOneChoice() {
    Spinner spinner = Spinner.createSpinner(new String[]{"Amanda"});
    for (int i = 0; i < 1000; i++) {
      spinner.spin();
      assertEquals("Amanda", spinner.getSelected());
    }
  }

  public void testSpinnerWithMultipleChoices() {
    Map<String, Integer> choiceCounts = new HashMap<String, Integer>();
    choiceCounts.put("Amanda", 0);
    choiceCounts.put("Jesse", 0);
    choiceCounts.put("Evangeline", 0);
    choiceCounts.put("Mommy", 0);
    choiceCounts.put("Daddy", 0);

    Spinner spinner = Spinner.createSpinner(choiceCounts.keySet().toArray(new String[choiceCounts.size()]));
    for (int i = 0; i < 1000; i++) {
      spinner.spin();
      Integer count = choiceCounts.get(spinner.getSelected());
      choiceCounts.put(spinner.getSelected(), count+1);
    }

    // make sure every choice was selected at least once; highly unlikely
    for (String choice : choiceCounts.keySet()) {
      assertTrue("Choice " + choice + " should have been picked at least once.", choiceCounts.get(choice) > 0);
      System.out.println("Choice " + choice + " was picked " + choiceCounts.get(choice) + " times.");
    }
  }

  public void testFourChoices() {
    PluggableRandomizer fixedRandomNumber = MockRandomNumberGenerator.createMockRandomizer();
    Spinner spinner = Spinner.createSpinner(new String[] {"North", "South", "East", "West"}, fixedRandomNumber);

    fixedRandomNumber.setValue(0.15d);
    spinner.spin();
    assertEquals("North", spinner.getSelected());

    fixedRandomNumber.setValue(0.49d);
    spinner.spin();
    assertEquals("South", spinner.getSelected());

    fixedRandomNumber.setValue(0.50d);
    spinner.spin();
    assertEquals("East", spinner.getSelected());

    fixedRandomNumber.setValue(0.99d);
    spinner.spin();
    assertEquals("West", spinner.getSelected());

    fixedRandomNumber.setValue(1.0d);
    spinner.spin();
    assertEquals("West", spinner.getSelected());
  }
}
