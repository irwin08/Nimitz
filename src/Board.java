import java.util.ArrayList;
import java.util.HashSet;

public class Board {

    private int width;
    private int height;

    //tile types
    HashSet<Tuple<Integer, Integer>> misses;
    HashSet<Tuple<Integer, Integer>> hits;
    HashSet<Tuple<Integer, Integer>> sinks;
    HashSet<Tuple<Integer, Integer>> shipTiles;
    HashSet<ArrayList<Tuple<Integer, Integer>>> ships;

    public Board(int w, int h){
        width = w;
        height = h;

        misses = new HashSet<>();
        hits = new HashSet<>();
        sinks = new HashSet<>();
        shipTiles = new HashSet<>();
        ships = new HashSet<>();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean addShip(ArrayList<Tuple<Integer, Integer>> ship){
        //check that ship is ok
        for(Tuple<Integer,Integer>tile : ship){
            if(tile.x < 0 || tile.x >= width)
                return false;
            if(tile.y < 0 || tile.y >= height)
                return false;
            if(shipTiles.contains(tile))
                return false;
        }

        //add ship
        for(Tuple<Integer,Integer>tile : ship){
            shipTiles.add(tile);
        }
        ships.add(ship);
        return true;
    }

    public boolean shoot(Tuple<Integer,Integer> coord){
        if(shipTiles.contains(coord)) {
            hits.add(coord);

            //TODO: check if whole ship is sunk

            return true;
        }
        else {
            misses.add(coord);
            return false;
        }
    }

}
