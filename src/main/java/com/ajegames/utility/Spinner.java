package com.ajegames.utility;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class Spinner {

  Randomizer randomSource;
  List<String> choices = new ArrayList<String>();
  double lastSpin = 0.0f;

  public static Spinner createSpinner(String[] choices) {
    Spinner newSpinner = new Spinner(choices);
    newSpinner.setRandomizer(new RandomNumberGenerator());
    return newSpinner;
  }

  public static Spinner createSpinner(String[] choices, Randomizer randomizer){
    Spinner newSpinner = new Spinner(choices);
    newSpinner.setRandomizer(randomizer);
    return newSpinner;
  }

  private Spinner(String[] choices) {
    for (String choice : choices) {
      addChoice(choice);
    }
  }

  private void setRandomizer(Randomizer randomizer) {
    randomSource = randomizer;
  }

  private void addChoice(String choice) {
    choices.add(choice);
  }

  public void spin() {
    lastSpin = randomSource.getRandom();
  }

  public int getNumberOfChoices() {
    return choices.size();
  }

  public String getSelected() {
    int indexOfSelection = (int) Math.floor(lastSpin * choices.size());
    if (indexOfSelection == choices.size()) {
      indexOfSelection--;
    }
    return choices.get(indexOfSelection);
  }
}
