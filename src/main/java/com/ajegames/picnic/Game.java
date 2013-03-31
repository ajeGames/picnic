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
    Nuisance ants = Nuisance.createAgainstFood("Ants");
    Nuisance blackFlies = Nuisance.create("Black Flies");
    Nuisance sunburn = Nuisance.createAgainstFood("Sunburn");
    Nuisance rain = Nuisance.createAgainstFood("Rain");

    ArrayList<SpinnerOption> choices = new ArrayList<SpinnerOption>();
    choices.add(Item.createFood("Hamburgers"));
    choices.add(Item.createFood("Sandwiches"));
    choices.add(Item.createFood("Fried Chicken"));
    choices.add(Item.createFood("Sushi"));
    choices.add(Item.createFood("Potato Salad"));
    choices.add(Item.createFood("Macaroni Salad"));
    choices.add(Item.createFood("Potato Chips"));
    choices.add(Item.createFood("Carrot Sticks"));
    choices.add(Item.createFood("Fruit Salad"));
    choices.add(Item.createFood("Watermelon"));
    choices.add(Item.createFood("Brownies"));
    choices.add(Item.createDrink("Water"));
    choices.add(Item.createDrink("Soda"));
    choices.add(Item.createDrink("Juice Boxes"));
    choices.add(Item.createUtensil("Plastic Forks"));
    choices.add(Item.createUtensil("Plastic Spoons"));
    choices.add(Item.createUtensil("Chopsticks"));
    choices.add(Item.createUtensil("Plates and Napkins"));
    choices.add(Item.createPrevention("Sunscreen", sunburn));
    choices.add(Item.createPrevention("Bug Spray", blackFlies));
    choices.add(Item.createPrevention("Umbrella", rain));
    choices.add(ants);
    choices.add(ants);
    choices.add(ants);
    choices.add(ants);
    choices.add(blackFlies);
    choices.add(sunburn);
    choices.add(rain);
    spinner = Spinner.createSpinner(choices.toArray(new SpinnerOption[choices.size()]));
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
