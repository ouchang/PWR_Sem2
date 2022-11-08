import javax.swing.*;

/**
 * The main class for simulation's window/frame
 */
public class MyFrame extends JFrame {
    Params param; /* The parameters given by user */
    ColorGrid panel; /* The panel which is resonsible for a whole simulation */

    /**
     * Constructor.
     * The constructor sets the user's parameters as a given attribute and creates a panel (ColorGrid)
     * responsible for simulation. Then it modifies the frame's size, title etc. 
     * In the end, we start threads which are representing the rectangles.
     * @param param User's parameters
     * @see ColorGrid
     */
    public MyFrame(Params param) {
        this.param = param;
        this.panel = new ColorGrid(param);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(this.panel);
        setTitle("Symulacja");
        setSize(200*param.n, 200*param.m);
        setLocationRelativeTo(null);
        setVisible(true);

        //Starting threads
        this.panel.runThread();
    }
}
