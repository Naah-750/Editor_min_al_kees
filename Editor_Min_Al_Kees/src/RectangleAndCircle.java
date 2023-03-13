import javax.swing.*;
import java.awt.*;

public abstract class RectangleAndCircle extends JFrame  {
    public abstract void draw(int x1 , int y1 , int height1 , int width1 , Color color1 , char type1);

    private JButton confirmButton;
    private JPanel RectangleComponents;
    private JLabel title;
    private JButton whiteButton;
    private JButton blueButton;
    private JButton redButton;
    private JButton yellowButton;
    private JButton blackButton;
    private JTextArea inputXTextArea;
    private JLabel firstDimension;
    private JTextArea inputYTextArea;
    private JLabel secondDimension;
    private JTextArea inputWidthTextArea;
    private JLabel objectWidth;
    private JTextArea inputHeightTextArea;
    private JLabel objectHeight;
    private JButton fill;
    private JButton stroke;
    private JPanel graphicInitialize;

    private int X = -1;
    private int Y = -1;
    private int width = -1;
    private int height = -1;
    private Color color;
    private char type;
    public RectangleAndCircle(JFrame parent) {
        super(String.valueOf(parent));
        setTitle("Editor Abu Rial");
        setContentPane(RectangleComponents);
        setSize(700, 450);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(parent);

        inputXTextArea.setText("0");
        inputYTextArea.setText("0");
        inputHeightTextArea.setText("0");
        inputWidthTextArea.setText("0");

        //Color Buttons
        whiteButton.addActionListener(e -> color=Color.white);
        blueButton.addActionListener(e -> color=Color.blue);
        redButton.addActionListener(e -> color=Color.red);
        yellowButton.addActionListener(e -> color=Color.yellow);
        blackButton.addActionListener(e -> color=Color.black);

        //Type Buttons
        fill.addActionListener(e -> type = 'F');
        stroke.addActionListener(e -> type = 'S');

        confirmButton.addActionListener(e -> {
            if (!(inputXTextArea.getText().equals("0") || inputYTextArea.getText().equals("0") || inputWidthTextArea.getText().equals("0") || inputHeightTextArea.getText().equals("0")))
            {
                X = Integer.parseInt(inputXTextArea.getText());
                Y = Integer.parseInt(inputYTextArea.getText());
                width = Integer.parseInt(inputWidthTextArea.getText());
                height = Integer.parseInt(inputHeightTextArea.getText());
            }
            if(X == -1 || Y == -1 || width == -1  || height == -1 || color == null)
            {
                JOptionPane.showMessageDialog(null,"You must fill all boxes and select color and type.");
            }
            else
            {
                draw(X, Y, height, width, color, type);
                dispose();
            }

        });

        setVisible(true);
    }
}