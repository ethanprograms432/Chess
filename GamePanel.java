import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable {

   Thread gameThread;
   static int counter = 0;
   
   PieceManager pM = new PieceManager(this);
   MouseManager mL = new MouseManager(pM);
   public static String[] DeathMessages = {" had a rock thrown at him by "," was less of an Alpha than "," was too stupid to avoid the death of "," thought they were brave but were idiotic and died to "," got their ass melted by "," was thrown out of the board by ", " was too cocky and got humbled by "," was too scared to fight, and got wrecked by "," got distracted by a good looking chess piece, and died to "," thought they were Andrew Tate, and got humbled by "," watched too much skibidi brainrot, and had to get euthanised by "};
   static ArrayList<String> deaths = new ArrayList<String>();
   public static boolean kill = false;
   public static boolean idiotMove;
   public static boolean idiotMove2;
   public static int killY = 850;
   
   public GamePanel() {
   
      this.setPreferredSize(new Dimension(1200,1500));
      this.setFocusable(true);
      this.addMouseListener(mL);
   
   }
   
   public void startGameThread() {
   
      gameThread = new Thread(this);
      gameThread.start();
   
   }
   
   public void run() {
   
      while (gameThread != null) {
      
         try {
         
         TimeUnit.MILLISECONDS.sleep(17);
         
         } catch(InterruptedException e) {
            
            e.printStackTrace();
            
         }
         repaint();
         mL.getMouseCoordinates();
      
      }
   }
   
   public void paintComponent(Graphics g) {
   
      super.paintComponent(g);
      
      drawBackground(g);
      drawInfo(g);
      drawKillMessage(g);
      

      Graphics2D g2 = (Graphics2D)g;
      pM.drawPieces(g2);
      g2.dispose();

   
   }
   
   public void drawBackground(Graphics g) {
   
      boolean black = true;
      g.setColor(Color.black);
      for (int i = 0; i < 8; i++) {
      
         for (int j = 0; j < 8; j++) {
         
            g.fillRect(100*i,100*j,100,100);
            
            if(black == true) {
               
               if(j != 7) {
                  g.setColor(Color.white);
                  black = false;
                  
               }
               
            } else {
            
               if(j != 7) {
               
                  g.setColor(Color.black);
                  black = true;
               }
               
            }
         
         }
      
      }
   
   }
   
   public void drawInfo(Graphics g) {
   
      g.setFont(new Font("TimesRoman",Font.PLAIN,30));
      String turn = "";
      String choosing = "";
      String idiotMSG = "";
      String idiotMSG2 = "";
      
      if(mL.whiteTurn == true) {
      
         turn = "White";
         
      } else {
      
         turn = "Black";
         
      }
      
      
      if(mL.isChoosing == true) {
      
         choosing = "Selecting Piece To Move";
         
      } else {
      
         choosing = "Placing Piece";
         
      }
      
      if(idiotMove == true) {
      
         idiotMSG = "pick a piece dummy";
         
      }
      
      if(idiotMove2 == true) {
      
         idiotMSG2 = "have you ever played chess? u cant MOVE THERE!";
         
      }
      
      
      g.drawString("Turn: " + turn,820,100);
      g.drawString(choosing,820,150);
      
  
      g.setFont(new Font("TimesRoman",Font.BOLD,34));
      g.setColor(Color.red);
      g.drawString(idiotMSG,400,400);
      g.drawString(idiotMSG2,20,400);
      g.setFont(new Font("TimesRoman",Font.PLAIN,11));
      g.setColor(Color.black);
    
   
   }
   
   public void drawKillMessage(Graphics g) {
   
      Random rand = new Random();
      int deathIndex = rand.nextInt(0,DeathMessages.length - 1);
      String deathMessage = DeathMessages[deathIndex];
      g.setFont(new Font("TimesRoman",Font.PLAIN,22));
      
      if(kill == true) {
      
         deaths.add(pM.pieceTwo + deathMessage + pM.pieceOne);
         kill = false;
         pM.pieceTwo = "";
         
      }
      
      if(deaths.size() > 0) {
      
         int starterY = 850;
         for (int i = 0; i < deaths.size(); i++) {
         
            g.drawString(deaths.get(i),30,starterY);
            starterY += 20;
         
         }
         
      }
      
      if(deaths.size() > 9) {
      
         for (int i = 0; i < deaths.size(); i++) {
         
            deaths.remove(deaths.get(i));
            
         }
         
      }
   
   }

}