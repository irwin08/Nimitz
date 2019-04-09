import java.util.HashSet;
import java.util.Set;

public class Board {

    private int width;
    private int height;

    //tile types
    HashSet<Tuple<Integer, Integer>> misses;
    HashSet<Tuple<Integer, Integer>> shipTiles;
    HashSet<Ship> ships;

    public Board(int w, int h){
        width = w;
        height = h;

        misses = new HashSet<>();
        shipTiles = new HashSet<>();
        ships = new HashSet<>();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean addShip(Ship ship){
        //check that ship is ok
        for(Tuple<Integer,Integer>tile : ship.getCoords()){
            if(tile.x < 0 || tile.x >= width)
                return false;
            if(tile.y < 0 || tile.y >= height)
                return false;
            if(shipTiles.contains(tile))
                return false;
        }

        //add ship
        for(Tuple<Integer,Integer>tile : ship.getCoords()){
            shipTiles.add(tile);
        }
        ships.add(ship);
        return true;
    }

    public boolean shoot(Tuple<Integer,Integer> coord){

        for(Ship ship : ships) {
            if (ship.update(coord)) {

                return true;
            }
        }
        misses.add(coord);
        return false;
    }

    public Set<Tuple<Integer,Integer>> getAllHit(){
        HashSet<Tuple<Integer,Integer>> hits = new HashSet<>();
        for (Ship ship : ships){
            if(ship.isSunk())
                continue;
            hits.addAll(ship.getHits());
        }

        return hits;
    }

    public Set<Tuple<Integer,Integer>> getAllSunk(){
        HashSet<Tuple<Integer,Integer>> hits = new HashSet<>();
        for (Ship ship : ships){
            if(ship.isSunk())
                hits.addAll(ship.getHits());;
        }

        return hits;
    }

}
