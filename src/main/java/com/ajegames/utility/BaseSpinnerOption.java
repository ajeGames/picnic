package com.ajegames.utility;

/**
 * base implementation that takes care of things like name, value, weight, image
 *
 * TODO add support for value, weight, image, etc
 */
public class BaseSpinnerOption implements SpinnerOption {

  protected String name;

  public BaseSpinnerOption(String name) {
    this.name = name;
  }

  public String getValue() {
    return name;
  }
}
