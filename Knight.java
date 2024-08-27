import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.ArrayList;

public class Knight {

   public int xPos;
   public int yPos;
   public String name;
   public BufferedImage image;
   
   public Knight(int xPos,int yPos, String name) {
   
      this.xPos = xPos;
      this.yPos = yPos;
      this.name = name;
      pickImage();  
   
   }
   
   public void pickImage() {
   
      if(this.name.contains("White")) {
      
         try {
         
            image = ImageIO.read(getClass().getResourceAsStream("whiteknightimg.png"));
            
         } catch(IOException e) {
            
            e.printStackTrace();
            
         }
       
      } else {
      
         try {
         
            image = ImageIO.read(getClass().getResourceAsStream("otherknight.png"));
            
         } catch(IOException e) {
            
            e.printStackTrace();
            
         }
         
      }
   
   }
   
   public boolean checkIfAllowed(String tileDestination) {
   
      ArrayList<String> availablePoints = new ArrayList<String>();
      boolean allowed = false;
         
      int X = Integer.valueOf(tileDestination.substring(0,1));
      int Y = Integer.valueOf(tileDestination.substring(2,3));

      if(this.xPos < 7 && this.yPos < 8) {
      
         availablePoints.add((this.xPos + 2) + "," + (this.yPos + 1));
      
      }
      
      if(this.xPos < 8 && this.yPos < 7) {
      
         availablePoints.add((this.xPos + 1) + "," + (this.yPos + 2));
      
      }
      
      if(this.xPos > 1 && this.yPos < 7) {
      
         availablePoints.add((this.xPos - 1) + "," + (this.yPos + 2));
      
      }
      
      if(this.xPos > 2 && this.yPos < 8) {
      
         availablePoints.add((this.xPos - 2) + "," + (this.yPos + 1));
      
      }
      
      if(this.xPos > 2 && this.yPos > 1) {
      
         availablePoints.add((this.xPos - 2) + "," + (this.yPos - 1));
      
      }
      
      if(this.xPos > 1 && this.yPos > 2) {
      
         availablePoints.add((this.xPos - 1) + "," + (this.yPos - 2));
      
      }
      
      if(this.xPos < 8 && this.yPos > 2) {
      
         availablePoints.add((this.xPos + 1) + "," + (this.yPos - 2));
      
      }
      
      if(this.xPos < 7 && this.yPos > 1) {
      
         availablePoints.add((this.xPos + 2) + "," + (this.yPos - 1));
      
      }
      
      for (int i = 0; i < availablePoints.size(); i++) {
      
         if(availablePoints.get(i).equals(tileDestination)) {
         
            allowed = true;
         
         }
         
      }
      
         if(this.name.contains("White")) {
         
                  if(MouseManager.whiteTurn == false) {
                  
                     allowed = false;
                     
                  }
               } else {
               
                  if(MouseManager.whiteTurn == true) {
                  
                     allowed = false;
                     
                  }
               
               }
      return allowed;
   
   }

}