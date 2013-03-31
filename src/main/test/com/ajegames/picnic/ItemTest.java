package com.ajegames.picnic;

import junit.framework.TestCase;

/**
 */
public class ItemTest extends TestCase {

  public void testItemCreation() {
    Item picnicItem = Item.createFood("Hamburgers");
    assertTrue(picnicItem.isFood());
    assertFalse(picnicItem.isDrink());
    assertFalse(picnicItem.isUtensil());
    assertFalse(picnicItem.isPrevention());

    picnicItem = Item.createDrink("Soda");
    assertTrue(picnicItem.isDrink());
    assertFalse(picnicItem.isFood());
    assertFalse(picnicItem.isUtensil());
    assertFalse(picnicItem.isPrevention());

    picnicItem = Item.createUtensil("Forks");
    assertTrue(picnicItem.isUtensil());
    assertFalse(picnicItem.isFood());
    assertFalse(picnicItem.isDrink());
    assertFalse(picnicItem.isPrevention());

    picnicItem = Item.createPrevention("Sunscreen", new Nuisance());
    assertTrue(picnicItem.isPrevention());
    assertFalse(picnicItem.isFood());
    assertFalse(picnicItem.isDrink());
    assertFalse(picnicItem.isUtensil());

  }

}
