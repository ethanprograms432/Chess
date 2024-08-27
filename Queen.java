import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.ArrayList;

public class Queen {

   public int xPos;
   public int yPos;
   public String name;
   public BufferedImage image;
   
   public Queen(int xPos,int yPos, String name) {
   
      this.xPos = xPos;
      this.yPos = yPos;
      this.name = name;
      pickImage();  
   
   }
   
   public void pickImage() {
   
      if(this.name.contains("White")) {
      
         try {
         
            image = ImageIO.read(getClass().getResourceAsStream("whitequeenimg.png"));
            
         } catch(IOException e) {
            
            e.printStackTrace();
            
         }
       
      } else {
      
         try {
         
            image = ImageIO.read(getClass().getResourceAsStream("otherqueenimg.png"));
            
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
      
      // UP
      
      if(this.yPos != 8) {
      
         int arrayPosition = this.yPos;
         boolean killed = false;
         
         while(arrayPosition < 8 && killed == false) {
         
            if(PieceManager.piecesOnMap[this.xPos - 1][arrayPosition] == null) {
            
               availablePoints.add(this.xPos + "," + (arrayPosition + 1));
               arrayPosition++;
               
            } else {
            
               
               availablePoints.add(this.xPos + "," + (arrayPosition + 1));
               killed = true;
            }
               
            
         }
      
      }
      
      // DOWN
      
     if(this.yPos != 1) {
      
        int arrayPosition = this.yPos - 2;
        boolean killed = false;
         
        while(arrayPosition > -1 && killed == false) {
         
           if(PieceManager.piecesOnMap[this.xPos - 1][arrayPosition] == null) {
            
              availablePoints.add(this.xPos + "," + (arrayPosition + 1));
              arrayPosition--;
               
           } else {
           
              availablePoints.add(this.xPos + "," + (arrayPosition + 1));
              killed = true; 
              
           }
           
        }
      
     }
     
     // RIGHT
     
     if(this.xPos != 8) {
      
        int arrayPosition = this.xPos;
        boolean killed = false;
         
        while(arrayPosition < 8 && killed == false) {
         
           if(PieceManager.piecesOnMap[arrayPosition][this.yPos - 1] == null) {
            
              availablePoints.add((arrayPosition + 1) + "," + this.yPos);
              arrayPosition++;
               
           } else {
           
               availablePoints.add((arrayPosition + 1) + "," + this.yPos);
               killed = true;
            
           }
           
        }
      
     }
     
     // LEFT
     
     if(this.xPos != 1) {
      
        int arrayPosition = this.xPos - 2;
        boolean killed = false;
         
        while(arrayPosition > -1 && killed == false) {
         
           if(PieceManager.piecesOnMap[arrayPosition][this.yPos - 1] == null) {
            
              availablePoints.add((arrayPosition + 1) + "," + this.yPos);
              arrayPosition--;
               
           } else {
           
              availablePoints.add((arrayPosition + 1) + "," + this.yPos);
              killed = true; 
           
           }
           
        }
      
     }
     
     // NORTH WEST
     
     if(this.xPos != 1 && this.yPos != 8) {
      
        int arrayPositionX = this.xPos - 2;
        int arrayPositionY = this.yPos;
        boolean killed = false;
         
        while(arrayPositionY < 8 && arrayPositionX > -1 && killed == false) {
         
           if(PieceManager.piecesOnMap[arrayPositionX][arrayPositionY] == null) {
            
              availablePoints.add((arrayPositionX + 1) + "," + (arrayPositionY + 1));
              arrayPositionX--;
              arrayPositionY++;
               
           } else {
           
              availablePoints.add((arrayPositionX + 1) + "," + (arrayPositionY + 1));
              killed = true;
              
           }
           
        }
      
     }
     
     // NORTH EAST
     
     if(this.xPos != 8 && this.yPos != 8) {
      
        int arrayPositionX = this.xPos;
        int arrayPositionY = this.yPos;
        boolean killed = false;
         
        while(arrayPositionY < 8 && arrayPositionX < 8 && killed == false) {
         
           if(PieceManager.piecesOnMap[arrayPositionX][arrayPositionY] == null) {
            
              availablePoints.add((arrayPositionX + 1) + "," + (arrayPositionY + 1));
              arrayPositionX++;
              arrayPositionY++;
               
           } else {
           
              availablePoints.add((arrayPositionX + 1) + "," + (arrayPositionY + 1));
              killed = true; 
           
           }
           
        }
      
     }
     
     // SOUTH WEST
     
     if(this.xPos != 1 && this.yPos != 1) {
      
        int arrayPositionX = this.xPos - 2;
        int arrayPositionY = this.yPos - 2;
        boolean killed = false;
         
        while(arrayPositionY > -1 && arrayPositionX > -1 && killed == false) {
         
           if(PieceManager.piecesOnMap[arrayPositionX][arrayPositionY] == null) {
            
              availablePoints.add((arrayPositionX + 1) + "," + (arrayPositionY + 1));
              arrayPositionX--;
              arrayPositionY--;
               
           } else {
           
              availablePoints.add((arrayPositionX + 1) + "," + (arrayPositionY + 1));
              killed = true;
           
           }
           
        }
      
     }
     
     // SOUTH EAST
     
     if(this.xPos != 8 && this.yPos != 1) {
      
        int arrayPositionX = this.xPos;
        int arrayPositionY = this.yPos - 2;
        boolean killed = false;
         
        while(arrayPositionY > -1 && arrayPositionX < 8 && killed == false) {
         
           if(PieceManager.piecesOnMap[arrayPositionX][arrayPositionY] == null) {
            
              availablePoints.add((arrayPositionX + 1) + "," + (arrayPositionY + 1));
              arrayPositionX++;
              arrayPositionY--;
               
           } else {
           
              availablePoints.add((arrayPositionX + 1) + "," + (arrayPositionY + 1));
              killed = true;
              
           }
           
        }
      
     }
     
     
     for (int i = 0; i < availablePoints.size(); i++) {
     
        if(tileDestination.equals(availablePoints.get(i))) {
        
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