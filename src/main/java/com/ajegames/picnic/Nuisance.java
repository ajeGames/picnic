package com.ajegames.picnic;

import com.ajegames.utility.SpinnerOption;

/**
 */
public class Nuisance implements SpinnerOption {

  private String name = "No name";
  Item worksAgainstItem;
  ItemType worksAgainstAny;

  public String getName() {
    return name;
  }
}
