import javax.swing.*;
import java.awt.event.*;
import kareltherobot.*;
import java.util.Scanner;

public class Main0 implements Directions
{
    public static void main(String[] args){
        // Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        // System.out.println("Please enter your user name");

  //   String userName = myObj.nextLine();  // Read user input of a String
  //   System.out.println("Hello " + userName + "! It is good to meet you!");  // Returns user output user input
   
        Scanner in = new Scanner(System.in); // Read the user input of an int
    System.out.println("How many beepers do you want on each side of the diamond?");
    int side = in.nextInt(); //Stores the number of beepers on each side of the diamond
    in.close();
   
    Robot fred = new Robot(1, 1, North, Integer.MAX_VALUE);
    World.setSize(side*2-1, side*2-1);
    World.setVisible(true);
    World.setDelay(1);

    for (int i = 0; i < side-1; i++) {
        fred.move(); // Move the robot forward by one step
    }

    //fred.putBeeper(); // Place a beeper at the current position
    // Place a beeper at the current position
    for (int i = 0; i < side; i++) {
      makeDiamond(fred, side-i);
      rotate(fred, East); // Rotate the robot to face East
      fred.move(); // Move the robot forward by one step
    }
    rotate(fred, West); // Rotate the robot to face West
    fred.move(); // Move the robot forward by one step
    fred.putBeeper(); // Place a beeper at the current position
    rotate(fred, East);
    for (int i = 0; i < side+2; i++) {
        fred.move(); // Move the robot forward by one step
    }
  }

    public static void makeDiamond(Robot fred, int side) {
      for (int i = 0; i < side-1; i++) {
        fred.putBeeper();
        rotate(fred, East);
        fred.move();
        rotate(fred, North);
        fred.move();
    } 


    for (int i = 0; i < side-1; i++) {
        fred.putBeeper();
        rotate(fred, East);
        fred.move();
        rotate(fred, South);
        fred.move();
    }

    //fred.putBeeper();

    for (int i=0; i < side-1; i++) {
        fred.putBeeper();
        rotate(fred, West);
        fred.move();
        rotate(fred, South);
        fred.move();
    }

    //fred.putBeeper();

    for (int i=0; i < side-1; i++) {
        fred.putBeeper();
        rotate(fred, West);
        fred.move();
        rotate(fred, North);
        fred.move();
    }
    }

    public static void rotate(Robot r, Direction dir) {
      while (r.direction() != dir) {
        r.turnLeft();
      }
    }
    //write a method that will turn right
public static void turnRight(Robot r) //create a new method using a Robot parameter. r is a temp placeholder.
    {
        r.turnLeft(); //turn left 3 times to turn right
        r.turnLeft();
        r.turnLeft();
        //This is a method that will turn the robot right.
        //It will take in a Robot parameter and use it to turn the robot right.
    }
    //write a method that will go 5 steps and leave beepers each time.
public static void leaveFive(Robot r) //create a method bringing in a Robot parameter. r is a temp placeholder.
    {
      for (int i = 0; i<5; i++) {
        r.move();
        r.putBeeper();
      }
    }

    //Here we are going to learn how to make a loop
    public static void leaveAnotherFive(Robot bob){

    }
}