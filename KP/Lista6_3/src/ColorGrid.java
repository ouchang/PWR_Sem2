import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.util.Random;

/**
 * Class responsible for creating a grid of rectangles. Each rectangle is considered as 
 * individual thread. Class ColorGrid also supports the use of the mouse. 
 */
public class ColorGrid extends JPanel {
    Params param; /* The user's parameters */

    private static final int WIDTH = 100; /* The rectangle's width */
    private static final int HEIGHT = WIDTH; /* The rectangle's height */
    private static final Dimension PREF_SIZE = new Dimension(WIDTH, HEIGHT); /* Rectangle's size*/

    JPanel[][] GridElements; /* The array of rectangles used to index each of them */
    ChangeThread[][] GridThreads; /* The array of threads used to index each of them and associate them with a given rectangle */

    /**
     * Constructor. 
     * The constructor adds mouse service and creates a grid of rectangles with random colours
     * @param param The user's parameters
     */
    public ColorGrid(Params param) {
        this.param = param;
        this.GridElements = new JPanel[this.param.n][this.param.m];
        this.GridThreads = new ChangeThread[this.param.n][this.param.m];

        setLayout(new GridLayout(param.n, param.m, 1, 1));
        setBackground(Color.BLACK);

        Random rand = new Random();

        //Adding mouse service
        addMouseListener(new MouseTestAdapter());

        //Creating a grid of rectangles with random colours
        for(int i=0; i<param.n; i++) {            
            for(int j=0; j<param.m; j++) {
                JPanel rect = new JPanel();
                GridElements[i][j] = rect;

                //Setting name for each of the rectangles by using their indexes (ROW-COLUMN)
                rect.setName(String.format("%d-%d", i, j));

                //Setting size of the rectangle
                rect.setSize(PREF_SIZE);

                //Setting surrounding of the rectangle
                rect.setBorder(new MatteBorder(1,1,1,1,Color.BLACK));
                
                //Setting random colour as a rectangle's background
                rect.setBackground(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));

                //Adding rectangle to the grid
                add(rect);
            }
        }
    }

    /**
     * The method responsible for creating and starting a thread,
     * each connected with a given rectangle.
     */
    public void runThread() {
        for(int i=0; i<param.n; i++) {
            for(int j=0; j<param.m; j++) {
                //Creating threads
                ChangeThread thread = new ChangeThread(GridElements[i][j], param, i , j, this); 
                GridThreads[i][j] = thread;
            }
        }
        
        for(int i=0; i<param.n; i++) {
            for(int j=0; j<param.m; j++) {
                //Starting threads
                GridThreads[i][j].start();
            }
        }
        
    }

    /**
     * Inner class responsible for mouse service.
     * If we click a given rectangle, the rectangle's thread suspends and
     * colour of the rectangle does not change. After the second click, the rectangle
     * is back to normal.
     */
    private class MouseTestAdapter extends MouseAdapter {
        public void mousePressed(MouseEvent event) {
            Point p = event.getPoint();
            JPanel clickedRect = (JPanel) getComponentAt(p); /* The rectangle which was clicked */
            String namePanel = clickedRect.getName();
            String[] ij = namePanel.split("-");
            int i,j; /* The rectangle's indexes */

            i = Integer.parseInt(ij[0]);
            j = Integer.parseInt(ij[1]);

            if(clickedRect != null) {
                if(GridThreads[i][j].isSleeping()) {
                    GridThreads[i][j].toResume();
                    clickedRect.setBorder(new MatteBorder(1,1,1,1,Color.BLACK));
                } else {
                    GridThreads[i][j].toSleep();
                    clickedRect.setBorder(new MatteBorder(5,5,5,5,Color.BLACK));
                }
            }
        }
    }
}
