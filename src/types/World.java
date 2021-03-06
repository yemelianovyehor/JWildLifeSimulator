package types;


import program.C;



public class World{
	
	public int height;
	public int width;
	
	public Tile[][] map;
	
	public Population animals;
	
	
	public String getTile(int x, int y) {
		return map[y][x].getTile();
	}
	
	
	public World(int width, int height, Population animals){
		this.height=height;
		this.width=width;
		map = new Tile[height][width];
		this.animals = animals;
	}


	public void clear() {
		for(int x = 0; x < C.WIDTH; x++) {
			for(int y = 0; y < C.HEIGHT; y++) {
				map[y][x] = new Tile(y,x);
			}
		}
	}
	
	public void update() {
		
		this.clear();
		
		for(Predator predator : animals.predators) {
			map[predator.position.y][predator.position.x]
					.predators.add(predator);
		}
		for(Pray pray : animals.prays) {
			map[pray.position.y][pray.position.x]
					.prays.add(pray);
		}
		
	}
	
	public String draw() {
		
		update();
		
		String text="";
		
		for(Tile[] row : map) {
			for (Tile tile : row) {
				text+=tile.getTile()+"\t";
			}
			text+="\n";
		}
		
		return text;
	}
}
