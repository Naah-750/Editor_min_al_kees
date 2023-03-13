import javax.swing.*;
import java.awt.*;
import java.io.*;

public class mainScreen extends JFrame  {
    private JPanel container;
    private JButton rectangle;
    private JButton clearButton;
    private JButton undo;
    private JButton redo;
    public JPanel drawingField;
    private JButton circle;
    private JTextField test;

    RectangleAndCircle R;

    LinkedStack<Shape> Undo = new LinkedStack<>();
    LinkedStack<Shape> Redo = new LinkedStack<>();
    Shape live = null;

    public void addNewShape(Shape s) {
        if (live != null) Undo.add(live);
        live = s;
    }
    public mainScreen(JFrame parent) {
        super(String.valueOf(parent));
        setTitle("Editor Abu Rial");
        setContentPane(container);
        setSize(700, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(parent);

            //RectangleAndCircle Button
        rectangle.addActionListener(e -> R = new RectangleAndCircle(null) {
                @Override
                public void draw(int x1, int y1, int width1, int height1, Color color1, char type1) {
                    Shape s = new Shape(x1 , y1 , width1 , height1 , color1 , type1 , 'R');
                    s.draw(drawingField);
                    addNewShape(s);
                }
            });


        clearButton.addActionListener(e -> drawingField.repaint());

        circle.addActionListener(e -> R = new RectangleAndCircle(null) {
            @Override
            public void draw(int x, int y, int width, int height, Color color, char type) {
                Shape s = new Shape(x , y , width , height , color , type , 'C');
                s.draw(drawingField);
                addNewShape(s);
            }
        });
        setVisible(true);

        undo.addActionListener(e -> {
            if (live != null && !Undo.isEmpty()) {
                Redo.add(live);
                live = Undo.pop();
                live.draw(drawingField);
            }
        });

        redo.addActionListener(e -> {
            if (!Redo.isEmpty())
            {
                Undo.add(live);
                live = Redo.pop();
                live.draw(drawingField);
            }
        });
    }

    public static void main(String[] args) {
        mainScreen m = new mainScreen(null);

    }

}