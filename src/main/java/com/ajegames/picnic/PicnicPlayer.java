package com.ajegames.picnic;

import java.util.HashSet;
import java.util.Set;

/**
 */
public class PicnicPlayer {

  private String name = "John Doe";
  Set<String> itemsGathered;

  private PicnicPlayer() {
    itemsGathered = new HashSet<String>();
  }

  public static PicnicPlayer createPlayer(String playerName) {
    PicnicPlayer results = new PicnicPlayer();
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
