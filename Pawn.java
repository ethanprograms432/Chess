import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.ArrayList;

public class Pawn {

   public int xPos;
   public int yPos;
   public String name;
   public BufferedImage image;
   
   public Pawn(int xPos,int yPos, String name) {
   
      this.xPos = xPos;
      this.yPos = yPos;
      this.name = name;
      pickImage();  
   
   }
   
   public void pickImage() {
   
      if(this.name.contains("White")) {
      
         try {
         
            image = ImageIO.read(getClass().getResourceAsStream("actualwhitepawn.png"));
            
         } catch(IOException e) {
            
            e.printStackTrace();
            
         }
       
      } else {
      
         try {
         
            image = ImageIO.read(getClass().getResourceAsStream("otherpawn.png"));
            
         } catch(IOException e) {
            
            e.printStackTrace();
            
         }
         
      }
   
   }
   
   public boolean checkQueenSwitch() {
   
      boolean SWITCH = false;
      
      if(this.name.contains("White")) {
      
         if(this.yPos == 8) {
         
            PieceManager.queens.add(new Queen(this.xPos,this.yPos,"New White Queen"));
            PieceManager.piecesOnMap[this.xPos - 1][this.yPos - 1] = "New White Queen";
            this.xPos = 13;
            this.yPos = 13;
            SWITCH = true;
            
         }  else {
            
            SWITCH = false;
            
         }
            
      
      } else {
      
         if(this.yPos == 1) {
         
            PieceManager.queens.add(new Queen(this.xPos,this.yPos,"New Other Queen"));
            PieceManager.piecesOnMap[this.xPos - 1][this.yPos - 1] = "New Other Queen";
            this.xPos = 13;
            this.yPos = 13;
            SWITCH = true;
            
         } else {
            
            SWITCH = false;
            
         }
      
      }
      return SWITCH;
   
   }
   
   public boolean checkIfAllowed(String tileDestination) { // DOESN'T WORK

      ArrayList<String> availablePoints = new ArrayList<String>();
      boolean allowed = false;
         
      int X = Integer.valueOf(tileDestination.substring(0,1));
      int Y = Integer.valueOf(tileDestination.substring(2,3));
      
      if(this.name.contains("White")) {
      
         System.out.println(PieceManager.piecesOnMap[this.xPos-1][this.yPos]);
         if(PieceManager.piecesOnMap[this.xPos-1][this.yPos] == null) {
         
            
            availablePoints.add(this.xPos + "," + (this.yPos + 1));
            
            if(this.yPos < 7) {
            
               if(PieceManager.piecesOnMap[this.xPos-1][this.yPos+1] == null && this.yPos == 2) {
               
                  availablePoints.add(this.xPos + "," + (this.yPos + 2));
                  
               }
               
            }
         }
         
         if(this.xPos != 8) {
         
            if(PieceManager.piecesOnMap[this.xPos][this.yPos] != null) {
         
               availablePoints.add((this.xPos + 1) + "," + (this.yPos + 1));
            
            }
            
         }
         
         if(this.xPos != 1) {
         
            if(PieceManager.piecesOnMap[this.xPos-2][this.yPos] != null) {
         
               availablePoints.add((this.xPos - 1) + "," + (this.yPos + 1));
            
            }
            
         }
         
      } else {
      

         if(PieceManager.piecesOnMap[this.xPos-1][this.yPos - 2] == null) {
         
            availablePoints.add(this.xPos + "," + (this.yPos - 1));
            
            if(this.yPos > 2) {
            
               if(PieceManager.piecesOnMap[this.xPos-1][this.yPos - 3] == null && this.yPos == 7) {
               
                  availablePoints.add(this.xPos + "," + (this.yPos - 2));
                  
               }
               
            }
         }
         
         if(this.xPos != 8) {
         
            if(PieceManager.piecesOnMap[this.xPos][this.yPos - 2] != null) {
         
               availablePoints.add((this.xPos + 1) + "," + (this.yPos - 1));
            
            }
            
         }
         
         if(this.xPos != 1) {
         
            if(PieceManager.piecesOnMap[this.xPos-2][this.yPos - 2] != null) {
         
               availablePoints.add((this.xPos - 1) + "," + (this.yPos - 1));
            
            }
            
         }
      
      
      
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