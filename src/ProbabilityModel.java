import java.util.HashMap;

public class ProbabilityModel {

    private HashMap<Integer,Boolean> shipsSunk;
    private int width;
    private int height;
    private Board board;
    private int probabilityBoard[][];


    public ProbabilityModel(Board board){

        shipsSunk = new HashMap<>();

        for(Ship ship : board.getShips()){
            shipsSunk.put(ship.getSize(), false);
        }

        width = board.getWidth();
        height = board.getHeight();

        probabilityBoard = new int[width][height];

        this.board = board;

    }

    // find all squares that can fit a ship of given size, add to probability model
    public void updatePossibleSize(int size){
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                if((size-1) + i < width){
                    //potentially fits, now check for no misses
                    boolean containsMiss = false;
                    for(int k = 0; k < size; k++){
                        if(board.getMisses().contains(new Tuple<>(i+k,j)))
                            containsMiss = true;
                    }
                    if(!containsMiss){
                        for(int k = 0; k < size; k++){
                           probabilityBoard[i+k][j]++;
                        }
                    }
                }

                if((size-1) + j < height){
                    //potentially fits, now check for no misses
                    boolean containsMiss = false;
                    for(int k = 0; k < size; k++){
                        if(board.getMisses().contains(new Tuple<>(i,j+k)))
                            containsMiss = true;
                    }
                    if(!containsMiss){
                        for(int k = 0; k < size; k++){
                            probabilityBoard[i][j+k]++;
                        }
                    }
                }
            }
        }
    }
}
