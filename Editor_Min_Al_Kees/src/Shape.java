import javax.swing.*;
import java.awt.*;

public class Shape extends JComponent  {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Color color;
    protected char type;

    private final char shape;

    public Shape(int x, int y, int width, int height, Color color, char type, char shape) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.type = type;
        this.shape = shape;
    }

    public void draw(JPanel panel) {
        Color c = color;
        Graphics g = panel.getGraphics();
        g.setColor(Color.getColor("" +
                "373737"));
        g.fillRect(0, 0, 1000, 1000);
        g.setColor(c);

        if (shape == 'R')
        {
            if (type == 'S') g.drawRect(x, y, width, height);
            else g.fillRect(x, y, width, height);
        }
        else
        {
            if (type == 'S') g.drawOval(x, y, width, height);
            else g.fillOval(x, y, width, height);
        }
    }
}
