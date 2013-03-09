   import java.util.*;
	import java.io.*;

   public class DnDgen{
      public static void main(String[] args)throws IOException{
         int width = 10;
         int height = 10;
         boolean retry = true;
			String dir = System.getProperty("user.home") + "/Desktop/";
			PrintWriter printer = new PrintWriter(dir + "dungeon.txt");			
      
      //input dungeon Size(width, height)
         Scanner sc = new Scanner(System.in);
         while(retry){
            try{
               System.out.println("Width: ");
               width = sc.nextInt();
               retry = false;
            }
               catch(InputMismatchException e){
                  System.out.println("Please input a valid integer.");
                  sc.nextLine();
                  retry = true;
               }
         }
         retry = true;
         while(retry){
            try{
               System.out.println("Height: ");
               height = sc.nextInt();
               retry = false;
            }
               catch(InputMismatchException e){
                  System.out.println("Please input a valid integer.");
                  sc.nextLine();
                  retry = true;
               }
         }
      	
      	//print dungeon size
         System.out.println("The size of the dungeon will be " + width + " tiles by " + height + " tiles.");
			System.out.println("Generating...");
			
			//generate dungeon
			Dungeon dungeon = new Dungeon(width, height);
			
			//export dungeon
			System.out.println("Exporting to dungeon.txt...");
			for(int y = height-1;y > 0;y--){
				for(int x = 0;x < width;x++){
					//System.out.println(x);
					//System.out.println(y);
					printer.print(dungeon.getDungeonTileType(x, y));
				}
				printer.println();
			}
			printer.close();
      }
   }