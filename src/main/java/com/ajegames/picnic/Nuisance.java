package com.ajegames.picnic;

import com.ajegames.utility.SpinnerOption;

/**
 */
public class Nuisance implements SpinnerOption {

  private String name = "No name";
  Item worksAgainstItem;
  ItemType worksAgainstAny;

  private Nuisance(String name) {
    this.name = name;
  }

  private Nuisance(String name, Item worksAgainstItem) {
    this.name = name;
    this.worksAgainstItem = worksAgainstItem;
  }

  private Nuisance(String name, ItemType worksAgainstAny) {
    this.name = name;
    this.worksAgainstAny = worksAgainstAny;
  }

  public String getName() {
    return name;
  }

  public static Nuisance create(String name) {
    return new Nuisance(name);
  }

  public static Nuisance createAgainstItem(String name, Item worksAgainstItem) {
    return new Nuisance(name, worksAgainstItem);
  }

  public static Nuisance createAgainstFood(String name) {
    return new Nuisance(name, ItemType.FOOD);
  }

  public static Nuisance createAgainstDrink(String name) {
    return new Nuisance(name, ItemType.DRINK);
  }

  public static Nuisance createAgainstUtensil(String name) {
    return new Nuisance(name, ItemType.UTENSIL);
  }
}
