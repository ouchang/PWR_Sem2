import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Class of parameters given by a user
 */
class Params {
    int k; /* Change speed */
    int n; /* Number of rows */
    int m; /* Number of columns */
    double p; /* Probability */

    /**
     * Constructor.
     * Saves the user's parameters in one object
     * @param n number of rows
     * @param m number of columns   
     * @param k speed 
     * @param p probability
     */
    public Params(int n, int m, int k, double p) {
        this.n = n;
        this.m = m;
        this.k = k;
        this.p = p;
    }
}

/**
 * The main class of simulation. It reads the user's parameters stored in the config file
 * and saves them in an object of the class called Params. Then creates a frame/window for simulation using MyFrame class
 * @see MyFrame
 * @author Aleksandra Zaremba
 * @version 1.0
 */
public class App {
    /**
     * The main function which starts the whole simulation
     * @param args arguments from terminal
     */
    public static void main(String[] args) {
        MyFrame okno; 

        //Reading config file
        Properties prop = new Properties();
        String fileName = "src/sym.config";
        try {
            FileInputStream fis = new FileInputStream(fileName);
            prop.load(fis);
        } catch(FileNotFoundException e) {
            System.out.println("Config file was not open!");
        } catch(IOException e) {
            System.out.println("Config file was not open!");
        }

        //Saving parameteres
        Params param = new Params(
            Integer.parseInt(prop.getProperty("board_n")),
            Integer.parseInt(prop.getProperty("board_m")),
            Integer.parseInt(prop.getProperty("speed_k")),
            Double.parseDouble(prop.getProperty("rand_p"))
        );

        //Creating frame for simulation
        okno = new MyFrame(param);
        okno.setVisible(true);
    }
}
