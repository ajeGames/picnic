package com.ajegames.picnic;

import junit.framework.TestCase;

/**
 * Makes sure that Player behaves as expected.  Player holds picnic items in a basket, so make sure collection and
 * inspection works.
 */
public class PlayerTest extends TestCase {

  private Player genPlayer(String name) {
    return Player.createPlayer(name);
  }

  public void testCreatePlayer() {
    Player player = genPlayer("player 1");
    assertEquals("Expected name to be set", "player 1", player.getName());
  }

  public void testGatherItem() {
    Player tester = genPlayer("tester");
    tester.gatherItem(Item.createFood("peanuts"));
    assertEquals("expect one item in basket", 1, tester.getItemCount());
  }

  public void testGatherMultipleItems() {
    Player tester = genPlayer("tester");
    tester.gatherItem(Item.createFood("peanuts"));
    tester.gatherItem(Item.createFood("popcorn"));
    tester.gatherItem(Item.createFood("potato chips"));
    tester.gatherItem(Item.createFood("pretzels"));
    assertEquals("expect one item in basket", 4, tester.getItemCount());
  }

  public void testItemCounts() {
    Player tester = genPlayer("tester");
    tester.gatherItem(Item.createFood("peanuts"));
    tester.gatherItem(Item.createFood("popcorn"));
    tester.gatherItem(Item.createDrink("iced tea"));
    tester.gatherItem(Item.createDrink("fruit juice"));
    tester.gatherItem(Item.createDrink("mai tais"));
    tester.gatherItem(Item.createUtensil("napkins"));
    assertEquals("should have 2 food items", 2, tester.getFoodCount());
    assertEquals("should have 3 drink items", 3, tester.getDrinkCount());
    assertEquals("should have 1 utensil item", 1, tester.getUtensilCount());
  }

  public void testItemCountsWhenBasketEmpty() {
    Player tester = genPlayer("goober");
    assertEquals("should have none", 0, tester.getItemCount());
    assertEquals("should have none", 0, tester.getFoodCount());
    assertEquals("should have none", 0, tester.getDrinkCount());
    assertEquals("should have none", 0, tester.getUtensilCount());
  }

  public void testHasPrevention() {
    Nuisance rain = Nuisance.create("rain");
    Prevention umbrella = Prevention.createPrevention("umbrella", rain);

    Player tester = genPlayer("Little Miss Sunshine");
    tester.gatherItem(umbrella);
    assertTrue("umbrella should prevent rain", tester.hasPrevention(rain));
  }

  public void testHasPreventionWhenPlayerHasNothing() {
    Nuisance rain = Nuisance.create("rain");
    Prevention umbrella = Prevention.createPrevention("umbrella", rain);

    Player tester = genPlayer("Little Miss Sunshine");
    assertFalse("umbrella should prevent rain", tester.hasPrevention(rain));
  }

  public void testHasPreventionWhenPlayerDoesNot() {
    Nuisance rain = Nuisance.create("rain");

    Player tester = genPlayer("Little Miss Sunshine");
    tester.gatherItem(Item.createDrink("sweet tea"));
    tester.gatherItem(Item.createFood("popcorn"));
    assertFalse("umbrella should prevent rain", tester.hasPrevention(rain));
  }
}
