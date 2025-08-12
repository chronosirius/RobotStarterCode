import javax.swing.*;
import java.awt.event.*;
import kareltherobot.*;
//This is the starter code for Karel the Robot AP CSA Thai

public class Main implements Directions {
  public static void main(String[] args) 
	{
		//My robot's name is karel
    Robot karel = new Robot(5,1,South,200);
    World.setVisible(true);
    World.setSize(10,10);
    World.setDelay(1);

    multiMove(karel, 4, false);
    rotate(karel, East);
    karel.putBeeper();
    multiMove(karel, 8, true);
    rotate(karel, North);
    karel.move();
    karel.putBeeper();
    diagSE(karel);

  }

  public static void multiMove(Robot bot, int count, boolean penDown) {
    for (int i=0;i<count;i++) {
      bot.move();
      if (penDown) bot.putBeeper();
    }
  }
  
  public static void rotate(Robot bot, Direction dir) {
    while (bot.direction() != dir) {
      System.out.println(bot.direction());
      bot.turnLeft();
    }
  }

  public static void diagSE(Robot bot) {
    rotate(bot, East);
    bot.move();
    rotate(bot, South);
    bot.move();
    bot.putBeeper();
  }

    
}