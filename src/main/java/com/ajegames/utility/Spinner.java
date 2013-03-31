package com.ajegames.utility;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class Spinner {

  Randomizer randomSource;
  List<SpinnerOption> choices = new ArrayList<SpinnerOption>();
  double lastSpin = 0.0f;

  public static Spinner createSpinner(SpinnerOption[] choices) {
    return createSpinner(choices, new RandomNumberGenerator());
  }

  public static Spinner createSpinner(SpinnerOption[] choices, Randomizer randomizer){
    Spinner newSpinner = new Spinner(choices);
    newSpinner.setRandomizer(randomizer);
    return newSpinner;
  }

  private Spinner(SpinnerOption[] choices) {
    for (SpinnerOption choice : choices) {
      addChoice(choice);
    }
  }

  private void setRandomizer(Randomizer randomizer) {
    randomSource = randomizer;
  }

  private void addChoice(SpinnerOption choice) {
    choices.add(choice);
  }

  public void spin() {
    lastSpin = randomSource.getRandom();
  }

  public int getNumberOfChoices() {
    return choices.size();
  }

  public SpinnerOption getSelected() {
    int indexOfSelection = (int) Math.floor(lastSpin * choices.size());
    if (indexOfSelection == choices.size()) {
      indexOfSelection--;
    }
    return choices.get(indexOfSelection);
  }
}
