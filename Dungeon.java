   import java.util.*;

   public class Dungeon{
      private int dungeonWidth;
      private int dungeonHeight;
      private Tile[][] dungeon;
      private int roomNumber;
   	
      public Dungeon(int width, int height){
         dungeonWidth = width;
         dungeonHeight = height;
         dungeon = new Tile[dungeonWidth][dungeonHeight];
         roomNumber = ((width * height)/100)*66;
			int xRoomSize = roomNumber / ((dungeonWidth+dungeonHeight)/2);
			int kRoomSize = xRoomSize * 3;
			int yRoomSize = kRoomSize / xRoomSize;
         int lastTileType;
         int nextRoomDir;
         int lastRoomDir = 0;
      	
      	//making the first room
         int roomWidth = (3+((int)(Math.random()*3)));
         int roomHeight = (3+((int)(Math.random()*3)));
      	//System.out.println(roomWidth);
      	//System.out.println(roomHeight);
         int lastRoomWidth = roomWidth;
         int lastRoomHeight = roomHeight;
         int totalWidth = roomWidth;
         int totalHeight = roomHeight;
         for (int x = 0;x < roomWidth;x++){
            for (int y = 0; y < roomHeight;y++){
            	//System.out.println(x);
            	//System.out.println(y);
               dungeon[x][y] = new Tile((char)1);
               lastTileType = 1;
               roomNumber--;
            }
         }
      	
      	//Second Room
			xRoomSize = roomNumber / ((dungeonWidth+dungeonHeight)/2);
			yRoomSize = (int)(kRoomSize / xRoomSize);
			//System.out.println(yRoomSize + " " + kRoomSize + " " + xRoomSize);
         nextRoomDir = (int)(Math.random()*2);
         if (nextRoomDir == 0){
         
         	//making a hallway
				roomWidth = (3+((int)(Math.random()*yRoomSize)));
            roomHeight = (3+((int)(Math.random()*yRoomSize)));
            dungeon[totalWidth-(lastRoomWidth/2)-1][totalHeight] = new Tile((char)1);
            dungeon[totalWidth-(lastRoomWidth/2)-1][totalHeight+1] = new Tile((char)1);
            totalHeight = totalHeight+2;
         	
         	//making a room
            totalWidth = Math.max(totalWidth, roomWidth);
            totalHeight = totalHeight+roomHeight;
            for (int x = 0;x < roomWidth;x++){
               for (int y = 0; y < roomHeight;y++){
                  dungeon[totalWidth-roomWidth+x][totalHeight-roomHeight+y] = new Tile((char)1);
                  lastTileType = 1;
                  roomNumber--;
               }
            }
            lastRoomWidth = roomWidth;
            lastRoomHeight = roomHeight;
            lastRoomDir = 0;
         }
         if (nextRoomDir == 1){
         
         	//making a hallway
				roomWidth = (3+((int)(Math.random()*yRoomSize)));
            roomHeight = (3+((int)(Math.random()*yRoomSize)));
            dungeon[totalWidth][totalHeight-(roomHeight/2)-1] = new Tile((char)1);
            dungeon[totalWidth+1][totalHeight-(roomHeight/2)-1] = new Tile((char)1);
            totalWidth = totalWidth+2;
         	
         	//making a room
            totalWidth = totalWidth+roomWidth;
            totalHeight = Math.max(totalHeight, roomHeight);
            for (int x = 0;x < roomWidth;x++){
               for (int y = 0; y < roomHeight;y++){
                  dungeon[totalWidth-roomWidth+x][totalHeight-roomHeight+y] = new Tile((char)1);
                  lastTileType = 1;
                  roomNumber--;
               }
            }
            lastRoomWidth = roomWidth;
            lastRoomHeight = roomHeight;
            lastRoomDir = 1;
         }
      	
      	//More Rooms
         while(roomNumber > 0){
				xRoomSize = roomNumber / ((dungeonWidth+dungeonHeight)/2);
				yRoomSize = (int)(kRoomSize / xRoomSize);
				//System.out.println(yRoomSize + " " + kRoomSize + " " + xRoomSize);
            nextRoomDir = (int)(Math.random()*2);
            if ((nextRoomDir == 0 && lastRoomDir == 0 && ((int)(Math.random()*100) > 25)) || (nextRoomDir == 0 && lastRoomDir != 0)){
            	
            	//making a hallway
					roomWidth = (3+((int)(Math.random()*yRoomSize)));
               roomHeight = (3+((int)(Math.random()*yRoomSize)));
               if(totalHeight+2 < dungeonHeight){
                  dungeon[totalWidth-(roomWidth/2)-1][totalHeight] = new Tile((char)1);
            		dungeon[totalWidth-(roomWidth/2)-1][totalHeight+1] = new Tile((char)1);;
                  totalHeight = totalHeight+2;
               }
               else{
                  break;}
            	
            	//making a room
               totalWidth = Math.max(totalWidth, roomWidth);
               totalHeight = totalHeight+roomHeight;
               if(totalHeight < dungeonHeight){
                  for (int x = 0;x < roomWidth;x++){
                     for (int y = 0; y < roomHeight;y++){
                        dungeon[totalWidth-roomWidth+x][totalHeight-roomHeight+y] = new Tile((char)1);
                        lastTileType = 1;
                        roomNumber--;
                     }
                  }
               }
               else{
                  break;}
               lastRoomWidth = roomWidth;
               lastRoomHeight = roomHeight;
               lastRoomDir = 0;
            }
            if ((nextRoomDir == 1 && lastRoomDir == 1 && ((int)(Math.random()*100) > 25)) || (nextRoomDir == 1 && lastRoomDir != 1)){
            
            	//making a hallway
					roomWidth = (3+((int)(Math.random()*yRoomSize)));
               roomHeight = (3+((int)(Math.random()*yRoomSize)));
               if(totalWidth+2 < dungeonWidth){
                  dungeon[totalWidth][totalHeight-(roomHeight/2)-1] = new Tile((char)1);
            		dungeon[totalWidth+1][totalHeight-(roomHeight/2)-1] = new Tile((char)1);
                  totalWidth = totalWidth+2;
               }
               else{
                  break;}
            	//making a room
               totalWidth = totalWidth+roomWidth;
               totalHeight = Math.max(totalHeight, roomHeight);
               if(totalWidth < dungeonWidth){
                  for (int x = 0;x < roomWidth;x++){
                     for (int y = 0; y < roomHeight;y++){
                        dungeon[totalWidth-roomWidth+x][totalHeight-roomHeight+y] = new Tile((char)1);
                        lastTileType = 1;
                        roomNumber--;
                     }
                  }
               }
               else{
                  break;}
               lastRoomWidth = roomWidth;
               lastRoomHeight = roomHeight;
               lastRoomDir = 1;
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