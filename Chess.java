import javax.swing.*;
import java.awt.*;

public class Chess {

   public static void main(String[] args) {
   
      JFrame frame = new JFrame("An Attempt At Chess");
      frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      frame.setLayout(new FlowLayout());
      
      GamePanel gp = new GamePanel();
      
      frame.getContentPane().add(gp);
      
      frame.pack();
      frame.setVisible(true);
      
      gp.startGameThread();
   
   }

}