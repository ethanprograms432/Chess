import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.ArrayList;

public class King {

   public int xPos;
   public int yPos;
   public String name;
   public BufferedImage image;
   
   public King(int xPos,int yPos, String name) {
   
      this.xPos = xPos;
      this.yPos = yPos;
      this.name = name;
      pickImage();  
   
   }
   
   public void pickImage() {
   
      if(this.name.contains("White")) {
      
         try {
         
            image = ImageIO.read(getClass().getResourceAsStream("whitekingimg.png"));
            
         } catch(IOException e) {
            
            e.printStackTrace();
            
         }
       
      } else {
      
         try {
         
            image = ImageIO.read(getClass().getResourceAsStream("otherkingimg.png"));
            
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
      
         if(this.yPos != 8) {

               availablePoints.add(this.xPos + "," + (this.yPos + 1));
               
         }
         
         if(this.xPos != 8) {
         
            availablePoints.add((this.xPos + 1) + "," + (this.yPos + 1));
            availablePoints.add((this.xPos + 1) + "," + (this.yPos));
            
         }
         
         if(this.xPos != 1) { 

            availablePoints.add((this.xPos - 1) + "," + (this.yPos + 1));
            availablePoints.add((this.xPos - 1) + "," + (this.yPos + 1));
            
         }
         
         if(this.yPos != 1) {

               availablePoints.add(this.xPos + "," + (this.yPos - 1));

         }
         
         if(this.xPos != 8) {

            availablePoints.add((this.xPos + 1) + "," + (this.yPos - 1));

         }
         
         if(this.xPos != 1) {

            availablePoints.add((this.xPos - 1) + "," + (this.yPos - 1));
            
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