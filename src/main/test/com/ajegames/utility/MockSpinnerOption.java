package com.ajegames.utility;

/**
 */
public class MockSpinnerOption implements SpinnerOption {

  private String name = "No Name";

  public MockSpinnerOption() {
  }

  public MockSpinnerOption(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }
}
