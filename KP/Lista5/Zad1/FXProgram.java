import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class FXProgram {
    @Override
    public void start(Stage stage) {
        java.awt.MenuBar myMenu = new MenuBar();
        java.awt.Menu menuFigury = new Menu("Figury");

        //Obsługa naciśnięcia opcji z menu
        EventHandler <ActionEvent> menuHandler = new EventHandler <ActionEvent>() {
            @Override
            public void handler(ActionEvent event) {
                MenuItem m = (MenuItem) event.getSource();
                if(m.getName().equals("Exit")) {
                    System.exit(0);
                } else if(m.getName().equals("Circle")) {
                    //KOŁO

                }  else if(m.getName().equals("Rectangle")) {
                    //PROSTOKĄT

                }  else if(m.getName().equals("Triangle")) {
                    //TRÓJKĄT
                }
            } 
        };

        //Tworzenie opcji (+ dodaje obsługe naciśniecia opcji)
        MenuItem c = new MenuItem("Circle");
        c.setOnAction(menuHandler);

        MenuItem r = new MenuItem("Rectangle");
        r.setOnAction(menuHandler);
        
        MenuItem t = new MenuItem("Triangle");
        t.setOnAction(menuHandler);

        //Dodawanie opcji do menu
        menuFigury.getItem().addAll(c,r,t);

        //Dodanie menu do menuBaru
        myMenu.getMenu().addAll(menuFigury);

        //Umieszczam menu na panelu
        BorderPane root = new BorderPane();
        root.setTop(myMenu);
    }
}
