import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import javax.swing.Action;
import java.io.*;

//Obsługa zamykania okna
class MyWindowAdapter extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}

//Obsługa guzika do kompilowania programu
class MyButtonAdapter implements ActionListener {
    Program p;

    MyButtonAdapter(Program p) {
        this.p = p;
    }

    public void actionPerformed(ActionEvent e) {
        p.action();
    }
}

class MyButton extends Button {
    MyButton(Program p) {
        super("Execute");
        addActionListener(new MyButtonAdapter(p));
    }
}

class MyFrame extends Frame {
    MyFrame(Program p) {
        super("Program");
        setBounds(100,100,640,480);
        addWindowListener(new MyWindowAdapter());
        setLayout(new BorderLayout());

        MyButton action = new MyButton(p);

        p.result = new TextArea(25, 80);
        p.data = new TextField(80);

        add(p.data, BorderLayout.NORTH);
        add(action, BorderLayout.SOUTH);
        add(p.result, BorderLayout.CENTER);

        setResizable(false);
    }
}

public class Program {
    MyFrame frame;
    TextArea result;
    TextField data;
    TextArea error;

    void action() {
        try {
            Process TrojkatPascala = Runtime.getRuntime().exec( data.getText() );

            BufferedReader in = new BufferedReader(new InputStreamReader(TrojkatPascala.getInputStream()));
            BufferedReader inErr = new BufferedReader(new InputStreamReader(TrojkatPascala.getErrorStream()));

            String s;
            result.setText("");

            while((s = in.readLine()) != null) {
                result.append(s+"\n");
            }
            in.close();

            while((s = inErr.readLine()) != null) {
                result.append("Error: " + s + "\n");
            }
            inErr.close();

        } catch(IOException e) {
            result.setText(e.getMessage());
        } catch(IllegalArgumentException e) {
            result.setText(e.getMessage());
        } finally {
            data.setText("");
        }
    }

    public static void main(String[] args) {
        Program p = new Program();
        p.frame = new MyFrame(p);
        p.frame.setVisible(true);
    }
}
