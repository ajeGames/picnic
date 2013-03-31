package com.ajegames.utility;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 */
public class SpinnerTest extends TestCase {

  public void testSpinnerWithOneChoice() {
    Spinner spinner = Spinner.createSpinner(new MockSpinnerOption[]{new MockSpinnerOption("Amanda")});
    for (int i = 0; i < 1000; i++) {
      spinner.spin();
      assertEquals("Amanda", spinner.getSelected().getName());
    }
  }

  public void testSpinnerWithMultipleChoices() {

    ArrayList<SpinnerOption> options = new ArrayList<SpinnerOption>();
    options.add(new MockSpinnerOption("SpongeBob"));
    options.add(new MockSpinnerOption("Patrick"));
    options.add(new MockSpinnerOption("Squidward"));
    options.add(new MockSpinnerOption("Mr. Krabs"));
    options.add(new MockSpinnerOption("Sandra"));

    Map<String, Integer> counts = new HashMap<String, Integer>();
    for (SpinnerOption option : options) {
      counts.put(option.getName(), 0);
    }

    Spinner spinner = Spinner.createSpinner(options.toArray(new SpinnerOption[counts.size()]));
    for (int i = 0; i < 1000; i++) {
      spinner.spin();
      Integer count = counts.get(spinner.getSelected().getName());
      counts.put(spinner.getSelected().getName(), count+1);
    }

    // make sure every choice was selected at least once; highly unlikely
    for (String choice : counts.keySet()) {
      assertTrue("Choice " + choice + " should have been picked at least once.", counts.get(choice) > 0);
      System.out.println("Choice " + choice + " was picked " + counts.get(choice) + " times.");
    }
  }

  public void testFourChoices() {
    PluggableRandomizer fixedRandomNumber = MockRandomNumberGenerator.createMockRandomizer();
    Spinner spinner = Spinner.createSpinner(
            new SpinnerOption[] {new MockSpinnerOption("North"), new MockSpinnerOption("South"),
                    new MockSpinnerOption("East"), new MockSpinnerOption("West")},
            fixedRandomNumber);

    fixedRandomNumber.setValue(0.15d);
    spinner.spin();
    assertEquals("North", spinner.getSelected().getName());

    fixedRandomNumber.setValue(0.49d);
    spinner.spin();
    assertEquals("South", spinner.getSelected().getName());

    fixedRandomNumber.setValue(0.50d);
    spinner.spin();
    assertEquals("East", spinner.getSelected().getName());

    fixedRandomNumber.setValue(0.99d);
    spinner.spin();
    assertEquals("West", spinner.getSelected().getName());

    fixedRandomNumber.setValue(1.0d);
    spinner.spin();
    assertEquals("West", spinner.getSelected().getName());
  }
}
