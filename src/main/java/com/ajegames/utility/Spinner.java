package com.ajegames.utility;

import java.util.ArrayList;
import java.util.List;

/**
 * Acts like a game spinner, which is shaped like a pie with each wedge being an option.  Spinning the spinner
 * results in it pointing to one of the wedges at random.
 */
public class Spinner {

  Randomizer randomSource;
  List<SpinnerOption> choices = new ArrayList<SpinnerOption>();
  double lastSpin = 0.0f;

  public static Spinner createSpinner() {
    return createSpinner(new RandomNumberGenerator());
  }

  /**
   * Provides opening for tests to fix the random number generation.
   *
   * @param randomizer
   * @return
   */
  public static Spinner createSpinner(Randomizer randomizer){
    Spinner newSpinner = new Spinner();
    newSpinner.setRandomizer(randomizer);
    return newSpinner;
  }

  private void setRandomizer(Randomizer randomizer) {
    randomSource = randomizer;
  }

  public Spinner addOption(String value) {
    choices.add(new BaseSpinnerOption(value));
    return this;
  }

  protected Spinner addOption(SpinnerOption option) {
    choices.add(option);
    return this;
  }

  public int getNumberOfChoices() {
    return choices.size();
  }

  public void spin() {
    lastSpin = randomSource.getRandom();
  }

  public String getSelectedValue() {
    return getSelected().getValue();
  }

  public SpinnerOption getSelected() {
    int indexOfSelection = (int) Math.floor(lastSpin * choices.size());
    if (indexOfSelection == choices.size()) {
      indexOfSelection--;
    }
    return choices.get(indexOfSelection);
  }
}
