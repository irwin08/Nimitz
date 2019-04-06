import java.util.ArrayList;
import java.util.HashSet;

public class Board {

    int width;
    int height;

    //tile types
    HashSet<Tuple<Integer, Integer>> misses;
    HashSet<Tuple<Integer, Integer>> hits;
    HashSet<Tuple<Integer, Integer>> sinks;
    HashSet<Tuple<Integer, Integer>> ships;

    public Board(int w, int h){
        width = w;
        height = h;
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
            if(ships.contains(tile))
                return false;
        }
        //add ship
        for(Tuple<Integer,Integer>tile : ship){
            ships.add(tile);
        }
        return true;
    }

}
