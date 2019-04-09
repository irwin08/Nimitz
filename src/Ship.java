import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Ship {

    private HashMap<Tuple<Integer, Integer>, Boolean> coords;

    private boolean sunk;

    public Ship(ArrayList<Tuple<Integer, Integer>> coords){
        this.coords = new HashMap<>();
        for(Tuple<Integer,Integer> coord : coords){
            this.coords.put(coord,false);
        }
        sunk = false;
    }

    public Set<Tuple<Integer, Integer>> getCoords() {
        return coords.keySet();
    }

    public boolean isSunk(){
        return sunk;
    }

    public Set<Tuple<Integer,Integer>> getHits(){
        HashSet<Tuple<Integer,Integer>> hits = new HashSet<>();
        for(Tuple<Integer,Integer> coord : coords.keySet()){
            if(coords.get(coord))
                hits.add(coord);
        }

        return hits;
    }

    //returns true if hit
    public boolean update(Tuple<Integer, Integer> coord){
        if (coords.keySet().contains(coord)){
            coords.replace(coord,true);
            if(allHit())
                sunk = true;

            return true;
        }

        return false;
    }

    private boolean allHit(){
        for(Tuple<Integer,Integer> coord : coords.keySet()){
            if(!coords.get(coord))
                return false;
        }
        return true;
    }
}
