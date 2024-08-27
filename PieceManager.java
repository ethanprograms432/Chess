import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

public class PieceManager {

   GamePanel gp;
   Pawn[] pawns = new Pawn[16];
   Rook[] rooks = new Rook[4];
   Knight[] knights = new Knight[4];
   King[] kings = new King[2];
   public static ArrayList<Queen> queens = new ArrayList<Queen>();
   
   Bishop[] bishops = new Bishop[4];
   public static String pieceOne = "";
   public static String pieceTwo = "";
   public static boolean wrongMove = false;
         
   public static String[][] piecesOnMap = new String[8][8];
   
   public PieceManager(GamePanel gp) {
   
      this.gp = gp;
      createPieces();
   
   }
   
   public void createPieces() {
   
      for (int i = 0; i < 8; i++) {
      
         pawns[i] = new Pawn(i + 1,2,"White Pawn " + (i + 1));
         piecesOnMap[i][1] = ("White Pawn " + (i + 1));
         
      }
      
      for (int i = 8; i < 16; i++) {
      
         pawns[i] = new Pawn((i - 7),7,"Other Pawn " + (i - 7));
         piecesOnMap[i-8][6] = ("Other Pawn " + (i - 7));
         
      }
      
      rooks[0] = new Rook(1,1,"White Rook 1");
      piecesOnMap[0][0] = ("White Rook 1");
      rooks[1] = new Rook(8,1,"White Rook 2");
      piecesOnMap[7][0] = ("White Rook 2");
      rooks[2] = new Rook(1,8,"Other Rook 1");
      piecesOnMap[0][7] = ("Other Rook 1");
      rooks[3] = new Rook(8,8,"Other Rook 2");
      piecesOnMap[7][7] = ("Other Rook 2");
      
      knights[0] = new Knight(2,1,"White Knight 1");
      piecesOnMap[1][0] = ("White Knight 1");
      knights[1] = new Knight(7,1,"White Knight 2");
      piecesOnMap[6][0] = ("White Knight 2");
      knights[2] = new Knight(2,8,"Other Knight 1");
      piecesOnMap[1][7] = ("Other Knight 1");
      knights[3] = new Knight(7,8,"Other Knight 2");
      piecesOnMap[6][7] = ("Other Knight 2");
      
      bishops[0] = new Bishop(3,1,"White Bishop 1");
      piecesOnMap[2][0] = ("White Bishop 1");
      bishops[1] = new Bishop(6,1,"White Bishop 2");
      piecesOnMap[5][0] = ("White Bishop 2");
      bishops[2] = new Bishop(3,8,"Other Bishop 1");
      piecesOnMap[2][7] = ("Other Bishop 1");
      bishops[3] = new Bishop(6,8,"Other Bishop 2");
      piecesOnMap[5][7] = ("Other Bishop 2");
      
      kings[0] = new King(4,1,"White King");
      piecesOnMap[3][0] = ("White King");
      kings[1] = new King(4,8,"Other King");
      piecesOnMap[3][7] = ("Other King");
      
      queens.add(new Queen(5,1,"White Queen"));
      piecesOnMap[4][0] = ("White Queen");
      queens.add(new Queen(5,8,"Other Queen"));
      piecesOnMap[4][7] = ("Other Queen");
   
 
   }
   
   public void drawPieces(Graphics2D g2) {
   
      for (int i = 0; i < 16; i++) {
      
        int currX = pawns[i].xPos;
        int currY = pawns[i].yPos;
        int xCoordinate = ((100*currX) - 80);
        int yCoordinate = 820 - (100*currY);
         
        boolean SWITCH = pawns[i].checkQueenSwitch();
        
        if(SWITCH == false) {
        
           g2.drawImage(pawns[i].image, xCoordinate, yCoordinate,60,60,null);
           
        }
      
      }
      
      for (int i = 0; i < 4; i++) {
      
        int currX = rooks[i].xPos;
        int currY = rooks[i].yPos;
        int xCoordinate = ((100*currX) - 80);
        int yCoordinate = 820 - (100*currY);
         
        g2.drawImage(rooks[i].image, xCoordinate, yCoordinate,60,60,null);
      
      }
      
      for (int i = 0; i < 4; i++) {
      
         int currX = knights[i].xPos;
         int currY = knights[i].yPos;
         int xCoordinate = ((100*currX) - 80);
         int yCoordinate = 820 - (100*currY);
         
         g2.drawImage(knights[i].image, xCoordinate, yCoordinate,60,60,null);
      
      }
      
      for (int i = 0; i < 4; i++) {
      
         int currX = bishops[i].xPos;
         int currY = bishops[i].yPos;
         int xCoordinate = ((100*currX) - 80);
         int yCoordinate = 820 - (100*currY);
         
         g2.drawImage(bishops[i].image, xCoordinate, yCoordinate,60,60,null);
      
      }
      
      for (int i = 0; i < 2; i++) {
      
         int currX = kings[i].xPos;
         int currY = kings[i].yPos;
         int xCoordinate = ((100*currX) - 80);
         int yCoordinate = 820 - (100*currY);
         
         g2.drawImage(kings[i].image, xCoordinate, yCoordinate,60,60,null);
      
      }
      
      for (int i = 0; i < queens.size(); i++) {
      
         int currX = (queens.get(i)).xPos;
         int currY = (queens.get(i)).yPos;
         int xCoordinate = ((100*currX) - 80);
         int yCoordinate = 820 - (100*currY);
         
         g2.drawImage((queens.get(i)).image, xCoordinate, yCoordinate,60,60,null);
      
      }
   
   }
   
   public boolean isNull(String point) {
   
      int X = Integer.valueOf(point.substring(0,1));
      int Y = Integer.valueOf(point.substring(2,3));
      
      if(piecesOnMap[X-1][Y-1] == null) {
      
         return true;
         
      } else {
      
         return false;
         
      }
   
   }
   
   public void updatePieceInfo(String pointOne,String pointTwo) {
   
      int xOne = Integer.valueOf(pointOne.substring(0,1));
      int yOne = Integer.valueOf(pointOne.substring(2,3));
      
      int xTwo = Integer.valueOf(pointTwo.substring(0,1));
      int yTwo = Integer.valueOf(pointTwo.substring(2,3));
      
      if(piecesOnMap[xOne-1][yOne-1] != null) {
      
         
         if(piecesOnMap[xTwo-1][yTwo-1] == null ) {
         
            pieceOne = piecesOnMap[xOne-1][yOne-1];
            
            
            if(pieceOne.contains("Pawn")) {
         
               Pawn p = getPawnInPosition(pieceOne);
               boolean allowed = p.checkIfAllowed(pointTwo);

               if(allowed == true) {
               
                  wrongMove = false;
                  piecesOnMap[xOne-1][yOne-1] = piecesOnMap[xTwo-1][yTwo-1];
                  piecesOnMap[xTwo-1][yTwo-1] = pieceOne;
                  p.xPos = xTwo;
                  p.yPos = yTwo;
                  
               } else {
               
                  wrongMove = true;
                  
               }
               
            } else if(pieceOne.contains("Rook")) {
         
               Rook r = getRookInPosition(pieceOne);
               boolean allowed = r.checkIfAllowed(pointTwo);

               if(allowed == true) {
               
                  wrongMove = false;
                  piecesOnMap[xOne-1][yOne-1] = piecesOnMap[xTwo-1][yTwo-1];
                  piecesOnMap[xTwo-1][yTwo-1] = pieceOne;
                  r.xPos = xTwo;
                  r.yPos = yTwo;
                  
               } else {
               
                  wrongMove = true;
                  
               }
            
            } else if(pieceOne.contains("Bishop")) {
            
               Bishop b = getBishopInPosition(pieceOne);
               boolean allowed = b.checkIfAllowed(pointTwo);

               if(allowed == true) {
               
                  wrongMove = false;
                  piecesOnMap[xOne-1][yOne-1] = piecesOnMap[xTwo-1][yTwo-1];
                  piecesOnMap[xTwo-1][yTwo-1] = pieceOne;
                  b.xPos = xTwo;
                  b.yPos = yTwo;
                  
               } else {
               
                  wrongMove = true;
                  
               }
               
            } else if(pieceOne.contains("Knight")) {
         
               Knight k = getKnightInPosition(pieceOne);
               boolean allowed = k.checkIfAllowed(pointTwo);

               if(allowed == true) {
               
                  wrongMove = false;
                  piecesOnMap[xOne-1][yOne-1] = piecesOnMap[xTwo-1][yTwo-1];
                  piecesOnMap[xTwo-1][yTwo-1] = pieceOne;
                  k.xPos = xTwo;
                  k.yPos = yTwo;
                  
               } else {
               
                  wrongMove = true;
                  
               }
               
            } else if(pieceOne.contains("King")) {
         
               King k = getKingInPosition(pieceOne);
               boolean allowed = k.checkIfAllowed(pointTwo);

               if(allowed == true) {
               
                  wrongMove = false;
                  piecesOnMap[xOne-1][yOne-1] = piecesOnMap[xTwo-1][yTwo-1];
                  piecesOnMap[xTwo-1][yTwo-1] = pieceOne;
                  k.xPos = xTwo;
                  k.yPos = yTwo;
                  
               } else {
               
                  wrongMove = true;
                  
               }
               
            } else if(pieceOne.contains("Queen")) {
         
               Queen q = getQueenInPosition(pieceOne);
               boolean allowed = q.checkIfAllowed(pointTwo);
               
               if(allowed == true) {
               
                  wrongMove = false;
                  piecesOnMap[xOne-1][yOne-1] = piecesOnMap[xTwo-1][yTwo-1];
                  piecesOnMap[xTwo-1][yTwo-1] = pieceOne;
                  q.xPos = xTwo;
                  q.yPos = yTwo;
                  
               } else {
               
                  wrongMove = true;
               
               }
               
            }
            
         } else {
         
            pieceOne = piecesOnMap[xOne-1][yOne-1];
            pieceTwo = piecesOnMap[xTwo-1][yTwo-1];
            
            /* FIGURE OU HOW TO CHECK ALLOWED */
      
            if(pieceOne.contains("Pawn")) {
            
               Pawn p = getPawnInPosition(pieceOne);
               boolean allowed = p.checkIfAllowed(pointTwo);

               if(allowed == true) {
               
                  wrongMove = false;
                  piecesOnMap[xOne-1][yOne-1] = null;
                  piecesOnMap[xTwo-1][yTwo-1] = pieceOne;
                  p.xPos = xTwo;
                  p.yPos = yTwo;
                  killPieces();
                  
               } else {
               
                  wrongMove = true;
                  
               }
               
            } else if(pieceOne.contains("Rook")) {
            
               Rook r = getRookInPosition(pieceOne);
               boolean allowed = r.checkIfAllowed(pointTwo);

               if(allowed == true) {
               
                  wrongMove = false;
                  piecesOnMap[xOne-1][yOne-1] = null;
                  piecesOnMap[xTwo-1][yTwo-1] = pieceOne;
                  r.xPos = xTwo;
                  r.yPos = yTwo;
                  killPieces();
                  
               } else {
               
                  wrongMove = true;
                  
               }
               
            } else if(pieceOne.contains("Bishop")) {
            
               Bishop b = getBishopInPosition(pieceOne);
               boolean allowed = b.checkIfAllowed(pointTwo);

               if(allowed == true) {
               
                  wrongMove = false;
                  piecesOnMap[xOne-1][yOne-1] = null;
                  piecesOnMap[xTwo-1][yTwo-1] = pieceOne;
                  b.xPos = xTwo;
                  b.yPos = yTwo;
                  killPieces();
                  
               } else {
               
                  wrongMove = true;
                  
               }
               
            } else if(pieceOne.contains("Knight")) {
            
               Knight k = getKnightInPosition(pieceOne);
               boolean allowed = k.checkIfAllowed(pointTwo);

               if(allowed == true) {
               
                  wrongMove = false;
                  piecesOnMap[xOne-1][yOne-1] = null;
                  piecesOnMap[xTwo-1][yTwo-1] = pieceOne;
                  k.xPos = xTwo;
                  k.yPos = yTwo;
                  killPieces();
                  
               } else {
               
                  wrongMove = true;
                  
               }
               
            } else if(pieceOne.contains("King")) {
            
               King K = getKingInPosition(pieceOne);
               boolean allowed = K.checkIfAllowed(pointTwo);

               if(allowed == true) {
               
                  wrongMove = false;
                  piecesOnMap[xOne-1][yOne-1] = null;
                  piecesOnMap[xTwo-1][yTwo-1] = pieceOne;
                  K.xPos = xTwo;
                  K.yPos = yTwo;
                  killPieces();
                  
               } else {
               
                  wrongMove = true;
                  
               }
               
            } else if(pieceOne.contains("Queen")) {
            
               Queen q = getQueenInPosition(pieceOne);
               boolean allowed = q.checkIfAllowed(pointTwo);
               
               if(allowed == true) {
               
                  wrongMove = false;
                  piecesOnMap[xOne-1][yOne-1] = null;
                  piecesOnMap[xTwo-1][yTwo-1] = pieceOne;
                  q.xPos = xTwo;
                  q.yPos = yTwo;
                  killPieces();
                  
               } else {
               
                  wrongMove = true;
               
               }
               
            }
            
         }
         
         
          
         
         if(!pieceTwo.equals("") && wrongMove == false) {
      
            gp.kill = true;
            
         } else {
         
            pieceTwo = "";
            
         }
         
      }
       
   
   }
   
   public void killPieces() {
   
            if(pieceTwo.contains("Pawn")) {
         
               Pawn p = getPawnInPosition(pieceTwo);
               p.xPos = 134;
               p.yPos = 134;
               
            } else if(pieceTwo.contains("Rook")) {
         
               Rook r = getRookInPosition(pieceTwo);
               r.xPos = 134;
               r.yPos = 134;
            
            } else if(pieceTwo.contains("Bishop")) {
         
               Bishop b = getBishopInPosition(pieceTwo);
               b.xPos = 134;
               b.yPos = 134;
            
            } else if(pieceTwo.contains("Knight")) {
         
               Knight k = getKnightInPosition(pieceTwo);
               k.xPos = 134;
               k.yPos = 134;
            
            } else if(pieceTwo.contains("King")) {
         
               King K = getKingInPosition(pieceTwo);
               K.xPos = 134;
               K.yPos = 134;
            
            } else if(pieceTwo.contains("Queen")) {
         
               Queen q = getQueenInPosition(pieceTwo);
               q.xPos = 134;
               q.yPos = 134;
            
            }
   
   }
   
   public Pawn getPawnInPosition(String name) {
   
      Pawn p = pawns[0];
      
      for (int i = 0; i < 16; i++) {
      
         String objectName = pawns[i].name;
         
         if(objectName.equals(name)) {
         
            p = pawns[i];
            
         }
      
      }
      return p;
   
   }
   
   public Rook getRookInPosition(String name) {
   
      Rook r = rooks[0];
      
      for (int i = 0; i < 4; i++) {
      
         String objectName = rooks[i].name;
         
         if(objectName.equals(name)) {
         
            r = rooks[i];
            
         }
      
      }
      return r;
   
   }
   
   public Bishop getBishopInPosition(String name) {
   
      Bishop b = bishops[0];
      
      for (int i = 0; i < 4; i++) {
      
         String objectName = bishops[i].name;
         
         if(objectName.equals(name)) {
         
            b = bishops[i];
            
         }
      
      }
      return b;
   
   }
   
   public Knight getKnightInPosition(String name) {
   
      Knight k = knights[0];
      
      for (int i = 0; i < 4; i++) {
      
         String objectName = knights[i].name;
         
         if(objectName.equals(name)) {
         
            k = knights[i];
            
         }
      
      }
      return k;
   
   }
   
   public King getKingInPosition(String name) {
   
      King k = kings[0];
      
      for (int i = 0; i < 2; i++) {
      
         String objectName = kings[i].name;
         
         if(objectName.equals(name)) {
         
            k = kings[i];
            
         }
      
      }
      return k;
   
   }
   
   public Queen getQueenInPosition(String name) {
   
      Queen q = queens.get(0);
      
      for (int i = 0; i < queens.size(); i++) {
      
         String objectName = (queens.get(i)).name;
         
         if(objectName.equals(name)) {
         
            q = queens.get(i);
            
         }
      
      }
      return q;
   
   }
   
   

}