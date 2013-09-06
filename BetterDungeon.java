   import java.util.*;

   public class BetterDungeon{
      private int dungeonWidth;
      private int dungeonHeight;
      private Tile[][] dungeon;
      private int roomNumber;
   	
      public BetterDungeon(int width, int height){
         if(width % 2 == 1){dungeonWidth = width;}
         else{dungeonWidth = width + 1;}
         if(height % 2 == 1){dungeonHeight = height;}
         else{dungeonHeight = height + 1;}
         dungeon = new Tile[dungeonWidth][dungeonHeight];
         roomNumber = (dungeonWidth * dungeonHeight) / 333;
      	
      	//random room placement
         for(int i = 0;i < roomNumber; i++){
            int x, y, xSize, ySize;
            boolean check = true;
            int done = 0;
            while(check){
               done = 0;
               x = ((int)(Math.random()*dungeonWidth));
               y = ((int)(Math.random()*dungeonHeight));
					xSize = (((int)(Math.random()*4)*2)+7);
					ySize = (((int)(Math.random()*4)*2)+7);
					if(x % 2 == 0){done++;}
               if(y % 2 == 0){done++;}
            	if(Math.abs(xSize-ySize) < 7){done++;}
					for(int xCheck = 0;xCheck =< xSize;xCheck++;){
					}
            }
         }
      }
   	
   	
      public String getDungeonTileType(int x, int y){
      	//System.out.println(x);
      	//System.out.println(y);
         if (dungeon[x][y] == null){
            return " ";
         }
         else {
         	//System.out.println(dungeon[x][y].getTileType());
            return "" + ((int)dungeon[x][y].getTileType());
         }
      }
   	
      public boolean getDungeonTileOccupied(int x, int y){
         return dungeon[x][y].getIsOccupied();
      }
   }