import kareltherobot.*;
import java.util.HashMap;

public class JumpThoseHurdles {
  // Find the hurdle with the max height!!
  // This is the Robot we will use to jump the hurdles
 
    Robot hurdler = new Robot(1,1,Directions.East, 0); // What is different about the
                                                    //  location of this line of code?
   
    public static void main(String[] args) {
        new JumpThoseHurdles().start();
    }

    public void start() {
        loadWorld();

        int w = 0; //This creates a variable to save your width
        int h = 0; //This creates a variable to save your height.
        int maxH = 0; //This creates a variable to save your max height.
        int minH = Integer.MAX_VALUE;
        int tallestW = 0; // location of highest hurdle
        int shortestW = 0; // location of shortest hurdle
        int lastW = 0; //This creates a variable to save your max width.
        HashMap<Integer, Integer> map = new HashMap<>();
        
        while (true) {
            w = findHurdle(); //Discuss with your partner what this line of code is intended to do.
            if (w == -1) {
                break; //This breaks the loop if there are no more hurdles.
            }
            lastW += w; //This adds the width to the last width.
            lastW++; //This adds one to the last width to account for the hurdle.
            System.out.println("The width is " + lastW + " " + w); //This prints out the width.
            h = climbHurdle(); //This sets the height variable to the height of the hurdle.
            map.put(lastW, h);
            if (h > maxH) { //This checks to see if the height is greater than the max height.
                maxH = h; //If it is, it sets the max height to the current height.
                tallestW = lastW;
            }
            if (h < minH) {
                minH = h;
                shortestW = lastW;
            }

            clearHurdle();
        }
        System.out.println("The maximum height is " + maxH + " at width " + tallestW);
        System.out.println("The minimum height is " + minH + " at width " + shortestW);
        System.out.println("W to H hurdles: " + map.toString());
    } 

    public void turnRight() {
        hurdler.turnLeft();
        hurdler.turnLeft();
        hurdler.turnLeft();
    }

    /**
     * This method assumes the Robot is named hurdler and is facing East
     * This moves hurdler to the next wall (hurdle). It returns the number
     * of moves it took to get to the hurdle.
   * When the method is called. It will return an int. You can set it to anything you want
     */
    private int findHurdle() {
        int steps = 0;
        while (hurdler.frontIsClear()) {
            hurdler.move();
            steps++;
            if (hurdler.avenue() > World.numberOfAvenues()) {
                return -1; // No more hurdles
            }
        }

        return steps;
    }
    /**
     * This method assumes the Robot is named hurdler, is facing East and
     * is at the base of the hurdle.
     * This moves the Robot to the top of the hurdle so that it can clear
     * the wall.  
     * @return The number of steps to get above the hurdle (height)
     */
    private int climbHurdle() {
        int height = 0;
        while (!hurdler.frontIsClear()) {
            hurdler.turnLeft();
            hurdler.move();
            turnRight();
            height++;
        }
        return height;
    }

    /**
     * Moves the Robot (hurdler) over the wall and moves it to the ground so
     * that the Robot has its back to the hurdle and is facing the next one.
     */
    private void clearHurdle() {
        hurdler.move();
        turnRight();
        while (hurdler.frontIsClear() && hurdler.avenue() <= World.numberOfAvenues()) {
            hurdler.move();
        }
        hurdler.turnLeft();
    }

    private void loadWorld() {
        // line below "hardcodes" this to use one specific world
        // it would be better to ask the user...
        String worldName = "Worldb.wld";
        World.readWorld(worldName);
        World.setVisible(true);
        World.setDelay(5);
    }

}