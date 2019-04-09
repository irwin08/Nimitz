import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.HashMap;

public class BoardGUI {

    private int height;
    private int width;

    GridPane grid;

    Board board;

    HashMap<Tuple<Integer, Integer>, Rectangle> rectangles;

    private Scene scene;

    public BoardGUI(Board board){

        this.board = board;

        rectangles = new HashMap<>();

        height = board.getHeight();
        width = board.getWidth();

        grid = new GridPane();

        for(int row = 0; row < height; row++){
            for(int col = 0; col < width; col++){
                Rectangle rec = new Rectangle();
                rec.setWidth(25);
                rec.setHeight(25);
                rec.setFill(Color.WHITE);
                //todo: figure this out
                rectangles.put(new Tuple<Integer,Integer>(row,col), rec);
                GridPane.setRowIndex(rec,row);
                GridPane.setColumnIndex(rec,col);
                grid.getChildren().addAll(rec);
            }
        }

        grid.setGridLinesVisible(true);
        scene = new Scene(grid, 350, 250);
    }

    public void update(){
        //ships
        for (Tuple<Integer,Integer>coord : board.shipTiles){
            rectangles.get(coord).setFill(Color.BLUE);
        }

        //misses
        for (Tuple<Integer,Integer>coord : board.misses){
            rectangles.get(coord).setFill(Color.GRAY);
        }

        //hits
        for(Tuple<Integer,Integer> coord : board.getAllHit()){
            rectangles.get(coord).setFill(Color.RED);
        }

        //sunk
        for(Tuple<Integer,Integer> coord : board.getAllSunk()){
            rectangles.get(coord).setFill(Color.DARKRED);
        }
    }

    public Scene getScene() {
        return scene;
    }
}
