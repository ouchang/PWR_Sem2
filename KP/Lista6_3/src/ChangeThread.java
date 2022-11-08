import javax.swing.*;
import java.awt.*;
import java.util.Random;
import javafx.util.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Class responsible for handling threads. A given thread changes the colour of the rectangle
 * after a small period of time. If the user clicked on one of the rectangles, the associated 
 * thread becomes suspended. 
 */
public class ChangeThread extends Thread {
    ColorGrid mainPanel; /* The main panel with a grid of rectangles */
    JPanel rect; /* The rectangle (Panel) which is assosiated with a given thread */
    Params param; /* The user's parameters */
    int x,y; /* The rectangle's indexes */
    
    private volatile boolean sleep = false; /* Flag which shows if a given thread is suspended */

    /**
     * Constructor
     * @param rect Rectangle (Panel) which is associated with a given thread
     * @param param User's parameters
     * @param x Rectangle's index for a position in rows
     * @param y Rectangle's index for a position in columns
     * @param mainPanel Panel on which we are creating the main grid
     */
    public ChangeThread(JPanel rect, Params param, int x, int y, ColorGrid mainPanel) {
        this.rect = rect;
        this.param = param;
        this.x = x;
        this.y = y;
        this.mainPanel = mainPanel;
    }

    /**
     * The method responsible for making a thread suspended by changing a flag
     */
    public void toSleep() {
        synchronized(this.rect) {
            this.sleep = true;
        }
    }

    /**
     * The method responsible for unblocking the thread and getting it back to normal
     */
    public void toResume() {
        synchronized(this.rect) {
            this.sleep = false;
            rect.notify(); 
        }
    }

    /**
     * The method which tells if a given thread is suspended.
     * @return Boolean information if a given thread is suspended.
     */
    public synchronized boolean isSleeping() {
        return this.sleep;
    }

    /**
     * The main method used by threads. It is responsible for changing
     * the rectangles' colours.
     */
    public void run() {
        Random rand = new Random();
        long timePeriod = param.k / 2 + rand.nextInt(param.k); /* Number of milliseconds in which a thread does not change the rectangle's colour */
        double decision; /* Random double number which decides if the colour of the rectangle is an average of the neighbours' colours or a random colour */
        
        while(true) {
            decision = rand.nextDouble();

            synchronized(this.rect) {
                if(this.sleep) { //Thread becomes suspended
                    try {
                        while(this.sleep)
                            rect.wait();
                    } catch(InterruptedException e) {}
                }
            }

            synchronized(mainPanel) { 
                System.out.println("Zaczynam zmiane koloru w RECT: " + rect.getName());
                if(decision < param.p) { //The rectangle's colour is an average of the neighbours' colours
                    Color rectColor = setColor();
                    rect.setBackground(rectColor);
                } else { //The rectangle's colour is a random colour
                    rect.setBackground(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
                }
                System.out.println("Koncze zmiane koloru w RECT: " + rect.getName());
            }

            //Pausing thread after changing rectangle's colour
            try{
                //Thread.sleep(timePeriod);
                Thread.sleep(2000);
            } catch(InterruptedException e) {}
        }
    }

    /**
     * The method responsible for calculating the average of the neighbours' colours
     * @return Average colour based on the neighbours
     */
    private Color setColor() {
        List<Pair<Integer, Integer>> Moves = new ArrayList<>(); /* List of moves to get to the left, right, upper and lower neighbour */
        Moves.add(new Pair<Integer, Integer>(0,-1)); //Left
        Moves.add(new Pair<Integer, Integer>(0,1)); //Right
        Moves.add(new Pair<Integer, Integer>(-1,0)); //Up
        Moves.add(new Pair<Integer, Integer>(1,0)); //Down

        int Red=0,Green=0,Blue=0; /* The intensity of red, green and blue color */

        int neighbour_x, neighbour_y; /* Neighbour's indexes */
        int coutNeighbour=0; /* Number of not suspended neighbours */

        for(Pair<Integer, Integer> p : Moves) {
            neighbour_x = (x + p.getKey());
            neighbour_y = (y + p.getValue());

            if(neighbour_x < 0)
                neighbour_x += param.n;
            if(neighbour_y < 0)
                neighbour_y += param.m;

            neighbour_x = neighbour_x % param.n;
            neighbour_y = neighbour_y % param.m;

            synchronized(mainPanel.GridThreads[neighbour_x][neighbour_y]) {
                //Checking if the neighbours are not suspended, then counting the average
                if(!mainPanel.GridThreads[neighbour_x][neighbour_y].isSleeping()) {
                    Red += mainPanel.GridElements[neighbour_x][neighbour_y].getBackground().getRed();
                    Green += mainPanel.GridElements[neighbour_x][neighbour_y].getBackground().getGreen();
                    Blue += mainPanel.GridElements[neighbour_x][neighbour_y].getBackground().getBlue();
                    coutNeighbour++;
                }
            }
        }

        if(coutNeighbour != 0) {
            Red = Math.round(Red / coutNeighbour);
            Green = Math.round(Green / coutNeighbour);
            Blue = Math.round(Blue / coutNeighbour);

            return (new Color(Red, Green, Blue));
        } else {
            //In case all the four neighbours are suspended, the rectangle's colour does not change
            return rect.getBackground();
        }
    }
}
