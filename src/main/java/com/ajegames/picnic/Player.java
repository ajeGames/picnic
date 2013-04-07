package com.ajegames.picnic;

import java.util.*;

/**
 * Someone playing Picnic.  Player holds a basket that must be filled sufficiently to win.
 */
public class Player {

  private String name = "Mr. Nobody";
  private List<Item> basket;
  private int foodCount;
  private int drinkCount;
  private int utensilCount;

  private Player() {
    basket = new ArrayList<Item>();
  }

  public static Player createPlayer(String playerName) {
    Player newPlayer = new Player();
    newPlayer.setName(playerName);
    return newPlayer;
  }

  private void setName(String playerName) {
    name = playerName;
  }

  public String getName() {
    return name;
  }

  public void gatherItem(Item item) {
    basket.add(item);
    if (ItemType.FOOD.equals(item.getType())) {
      foodCount++;
    } else if (ItemType.DRINK.equals(item.getType())) {
      drinkCount++;
    } else if (ItemType.UTENSIL.equals(item.getType())) {
      utensilCount++;
    }
  }

  public int getItemCount() {
    return basket.size();
  }

  public int getFoodCount() {
    return foodCount;
  }

  public int getDrinkCount() {
    return drinkCount;
  }

  public int getUtensilCount() {
    return utensilCount;
  }

  public List<Item> getFoods() {
    List<Item> foodItems = new ArrayList<Item>();
    for (Item item : basket) {
      if (item.isFood()) {
        foodItems.add(item);
      }
    }
    return foodItems;
  }

  public List<Item> getDrinks() {
    List<Item> foodItems = new ArrayList<Item>();
    for (Item item : basket) {
      if (item.isDrink()) {
        foodItems.add(item);
      }
    }
    return foodItems;
  }

  public List<Item> getUtensils() {
    List<Item> foodItems = new ArrayList<Item>();
    for (Item item : basket) {
      if (item.isUtensil()) {
        foodItems.add(item);
      }
    }
    return foodItems;
  }

  public List<Item> getPreventions() {
    List<Item> foodItems = new ArrayList<Item>();
    for (Item item : basket) {
      if (item.isPrevention()) {
        foodItems.add(item);
      }
    }
    return foodItems;
  }

  public boolean hasPrevention(Nuisance rain) {
    for (Item picnicItem : basket) {
      if (picnicItem instanceof Prevention) {
        if (((Prevention) picnicItem).getCounteracts().equals(rain)) {
          return true;
        }
      }
    }
    return false;
  }

  @Override
  public String toString() {
    StringBuilder out = new StringBuilder();
    out.append("Player ")
            .append(name)
            .append(" { food: ");
    for (Item item : getFoods()) {
      out.append(item.getValue()).append(", ");
    }
    out.append(" drinks: ");
    for (Item item : getDrinks()) {
      out.append(item.getValue()).append(", ");
    }
    out.append(" utensils: ");
    for (Item item : getUtensils()) {
      out.append(item.getValue()).append(", ");
    }
    out.append(" preventions: ");
    for (Item item : getPreventions()) {
      out.append(item.getValue()).append(", ");
    }
    out.append(" }");
    return out.toString();
  }
}
