package com.ajegames.picnic;

import com.ajegames.utility.Spinner;
import com.ajegames.utility.SpinnerOption;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class Game {

  List<Player> players;
  int indexCurrentPlayer = -1;
  Spinner spinner;
  boolean winner;

  public static void main(String[] args) {
    if (args.length == 0) {
      throw new IllegalArgumentException("Need to specify the name of at least one player");
    }
    Game game = new Game();
    for (String player : args) {
      game.addPlayer(player);
    }
    game.play();
  }

  public Game() {
    populateSpinner();
    players = new ArrayList<Player>();
  }

  private void populateSpinner() {
    ArrayList<SpinnerOption> choices = new ArrayList<SpinnerOption>();

//    spinner = Spinner.createSpinner(choices.toArray());
  }

  public void addPlayer(String playerName) {
    players.add(Player.createPlayer(playerName));
  }

  private void play() {
    // take turn; continue until player wins
    do {
      advanceCurrentPlayer();
      takeTurn();
    } while (!winner());
    print("The winner is " + players.get(indexCurrentPlayer).getName());
  }

  private void advanceCurrentPlayer() {
    indexCurrentPlayer++;
    if (indexCurrentPlayer >= players.size()) {
      indexCurrentPlayer = 0;
    }
  }

  private void print(String s) {
    System.out.println(s);
  }

  private boolean winner() {
    return winner;
  }

  private void takeTurn() {
    // spin
    spinner.spin();

    // do something about selection
    Player currentPlayer = players.get(indexCurrentPlayer);
    SpinnerOption selectedItem = spinner.getSelected();
//    currentPlayer.gatherItem(selectedItem);
    print(currentPlayer.getName() + " got " + selectedItem + ".");

    // decide if winner
    if (currentPlayer.totalItems() == spinner.getNumberOfChoices()) {
      winner = true;
    }
  }
}
