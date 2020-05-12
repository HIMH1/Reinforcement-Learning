import javax.swing.JFrame;
import java.awt.*;
public class Display {
    private JFrame env;
    public Canvas canvas;
    private String title="Angry Bird";
    private int width=1200, height=600;
    public Display(){
        env=new JFrame();
        env.setTitle(title);
        env.setSize(width,height);
        env.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        env.setLocationRelativeTo(null);
        env.setResizable(false);
        env.setVisible(true);

        canvas=new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));

        env.add(canvas);
        env.pack();
    }
}
