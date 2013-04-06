package com.ajegames.picnic;

import com.ajegames.utility.Spinner;
import com.ajegames.utility.SpinnerOption;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class Picnic {

  List<Player> players = new ArrayList<Player>();
  int indexCurrentPlayer = -1;
  Spinner spinner;
  boolean winner;

  public static void main(String[] args) {
    if (args.length == 0) {
      throw new IllegalArgumentException("Need to specify the name of at least one player");
    }
    Picnic picnic = new Picnic();
    for (String player : args) {
      picnic.addPlayer(player);
    }
    picnic.play();
  }

  public Picnic() {
    populateSpinner();
  }

  private void populateSpinner() {
    Nuisance ants = Nuisance.createAgainstFood("Ants");  // lose an item of food
    Nuisance blackFlies = Nuisance.create("Black Flies");  // lose a turn
    Nuisance sunburn = Nuisance.create("Sunburn");  // lose points at the end
    Nuisance rain = Nuisance.create("Rain");  // picnic is cancelled

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
    choices.add(Item.createUtensil("Plastic Forks and Spoons"));
    choices.add(Item.createUtensil("Chopsticks"));
    choices.add(Item.createUtensil("Plates and Napkins"));
    choices.add(Prevention.createPrevention("Sunscreen", sunburn));
    choices.add(Prevention.createPrevention("Bug Spray", blackFlies));
    choices.add(Prevention.createPrevention("Umbrella", rain));
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
    if (currentPlayer.getItemCount() == spinner.getNumberOfChoices()) {
      winner = true;
    }
  }
}
