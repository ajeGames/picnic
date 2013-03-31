package com.ajegames.picnic;

import com.ajegames.utility.SpinnerOption;

/**
 * Something you collect in order to assemble a picnic and win.
 */
public class Item implements SpinnerOption {

  private String name;
  private ItemType type;
  private Nuisance counteracts;

  private Item(String name, ItemType type) {
    this.name = name;
    this.type = type;
  }

  public static Item createPicnicItem(String name, ItemType type) {
    return new Item(name, type);
  }

  public static Item createFood(String name) {
    return createPicnicItem(name, ItemType.FOOD);
  }

  public static Item createDrink(String name) {
    return createPicnicItem(name, ItemType.DRINK);
  }

  public static Item createUtensil(String name) {
    return createPicnicItem(name, ItemType.UTENSIL);
  }

  public static Item createPrevention(String name, Nuisance counteracts) {
    Item item = createPicnicItem(name, ItemType.PREVENTION);
    item.counteracts = counteracts;
    return item;
  }

  public String getName() {
    return name;
  }

  public boolean isFood() {
    return type.equals(ItemType.FOOD);
  }

  public boolean isDrink() {
    return type.equals(ItemType.DRINK);
  }

  public boolean isUtensil() {
    return type.equals(ItemType.UTENSIL);
  }

  public boolean isPrevention() {
    return type.equals(ItemType.PREVENTION);
  }

}
