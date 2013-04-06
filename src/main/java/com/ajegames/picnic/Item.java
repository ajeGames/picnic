package com.ajegames.picnic;

import com.ajegames.utility.BaseSpinnerOption;

/**
 * Something you collect in order to assemble a picnic and win.
 */
public class Item extends BaseSpinnerOption {

  private ItemType type;

  protected Item(String name, ItemType type) {
    super(name);
    this.type = type;
  }

  public static Item createPicnicItem(String name, ItemType type) {
    return new Item(name, type);
  }

  public static final Item createFood(String name) {
    return createPicnicItem(name, ItemType.FOOD);
  }

  public static Item createDrink(String name) {
    return createPicnicItem(name, ItemType.DRINK);
  }

  public static Item createUtensil(String name) {
    return createPicnicItem(name, ItemType.UTENSIL);
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

  public ItemType getType() {
    return type;
  }


}
