package com.ajegames.picnic;

import java.util.HashSet;
import java.util.Set;

/**
 */
public class Player {

  private String name = "John Doe";
  Set<String> itemsGathered;

  private Player() {
    itemsGathered = new HashSet<String>();
  }

  public static Player createPlayer(String playerName) {
    Player results = new Player();
    results.setName(playerName);
    return results;
  }

  private void setName(String playerName) {
    name = playerName;
  }

  public String getName() {
    return name;
  }

  public void gatherItem(String item) {
    itemsGathered.add(item);
  }

  public int totalItems() {
    return itemsGathered.size();
  }
}
