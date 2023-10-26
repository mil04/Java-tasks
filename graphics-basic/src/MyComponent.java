import javax.swing.*;
import java.awt.*;


public class MyComponent extends JComponent {

    @Override
    protected void paintComponent(Graphics g){
        g.setColor(Color.YELLOW);
        g.fillRect(0, 0,400, 400);
        int [] x={0,200,400};
        int [] y= {0,400,0};
        g.setColor(Color.WHITE);
        g.drawPolygon(x,y,3);
        g.fillOval(150,150,100,100);
        g.setColor(Color.RED);
        g.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        g.drawString("N A P I S", 150, 450);
    }
}


