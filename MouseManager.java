import java.awt.event.*;
import java.awt.MouseInfo;
import java.util.concurrent.TimeUnit;

public class MouseManager implements MouseListener {

   public static boolean mouseDown;
   public static boolean mouseEntered;
   public static boolean whiteTurn = true;
   public static boolean isChoosing = true;
   public static double mouseX;
   public static double mouseY;
   public static String pointOne = "";
   public static String pointTwo = "";
   
   PieceManager pM;
   
   public MouseManager(PieceManager pM) {
   
      this.pM = pM;
   
   }
   
   
   @Override
   public void mouseClicked(MouseEvent e) {
   
      mouseDown = true;
      
      if(mouseEntered == true) {
      
         
         
         
         if(isChoosing == true) {
         
            
            pointOne = detectTileClicked(mouseX,mouseY);
            boolean NULL = pM.isNull(pointOne);
            
            
            if(GamePanel.idiotMove == true) {
            
               GamePanel.idiotMove = false;
               
            }
            
            if(GamePanel.idiotMove2 == true) {
            
               GamePanel.idiotMove2 = false;
               
            }
            
            
            if(NULL != true) {
            
               isChoosing = false;
               
            } else {
            
               GamePanel.idiotMove = true;
 
            }
            
         } else {
         
            
            pointTwo = detectTileClicked(mouseX,mouseY);
            pM.updatePieceInfo(pointOne,pointTwo);
            boolean wrongMove = pM.wrongMove;
            
            if(wrongMove == true) {
            
               isChoosing = true;
               GamePanel.idiotMove2 = true;
               
            } else {
            
               isChoosing = true;
               switchTurn();
            
            }
         }
         
      }
   }
   
   @Override
   public void mousePressed(MouseEvent e) {
   
     
   
   }
   
   @Override
   public void mouseReleased(MouseEvent e) {
   
      mouseDown = false;  
   
   }
   
   @Override
   public void mouseEntered(MouseEvent e) {
   
      mouseEntered = true;  
   
   }
   
   @Override
   public void mouseExited(MouseEvent e) {
   
      mouseEntered = false;  
   
   }
   
   public void getMouseCoordinates() {
   
      mouseX = MouseInfo.getPointerInfo().getLocation().x;
      mouseY = MouseInfo.getPointerInfo().getLocation().y;
   
   }
   
   public void switchTurn() {
   
      if(whiteTurn == true) {
      
         whiteTurn = false;
         
      } else {
      
         whiteTurn = true;
         
      }
      
   }
   
   public static String detectTileClicked(double mouseX,double mouseY) {
   
      int tileX = 0;
      int tileY = 0;
      
      if(mouseX < 100) {
      
         tileX = 1;
         
      } else if (mouseX < 200) {
      
         tileX = 2;
         
      } else if (mouseX < 300) {
      
         tileX = 3;
         
      } else if (mouseX < 400) {
      
         tileX = 4;
         
      } else if (mouseX < 500) {
      
         tileX = 5;
         
      } else if (mouseX < 600) {
      
         tileX = 6;
         
      } else if (mouseX < 700) {
      
         tileX = 7;
         
      } else if (mouseX < 800) {
      
         tileX = 8;
         
      }
      
      if(mouseY < 100) {
      
         tileY = 8;
         
      } else if (mouseY < 200) {
      
         tileY = 7;
         
      } else if (mouseY < 300) {
      
         tileY = 6;
         
      } else if (mouseY < 400) {
      
         tileY = 5;
         
      } else if (mouseY < 500) {
      
         tileY = 4;
         
      } else if (mouseY < 600) {
      
         tileY = 3;
         
      } else if (mouseY < 700) {
      
         tileY = 2;
         
      } else if (mouseY < 800) {
      
         tileY = 1;
         
      }
     
      return (tileX + "," + tileY);   
            
         
      
   }
   
   

}