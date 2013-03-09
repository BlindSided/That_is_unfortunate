   public class Tile{
      private char tileType;
      private boolean isOccupied;
   	
      public Tile(){
         tileType=0;
         isOccupied=false;
      }
   	public Tile(char type){
			tileType = type;
			isOccupied=false;
		}
   	public char getTileType(){
			return tileType;
		}
		public void setTileType(char type){
			this.tileType=type;   
		}
   	public boolean getIsOccupied(){
			return isOccupied;
		}
		public void setIsOccupied(boolean occupied){
			this.isOccupied=occupied;
		}
   }