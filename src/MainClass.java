import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class MainClass extends Application {

    List<Tuple<Integer,Integer>> shots = new ArrayList<>();
    int counter = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Board board = new Board(10,10);
        BoardGUI boardGUI = new BoardGUI(board);

        primaryStage.setTitle("Nimitz");

        StackPane root = new StackPane();




        primaryStage.setScene(boardGUI.getScene());

        primaryStage.show();

        ArrayList<Tuple<Integer, Integer>> aircraftCarrier = new ArrayList<>(); //5
        ArrayList<Tuple<Integer, Integer>> battleship = new ArrayList<>(); //4
        ArrayList<Tuple<Integer, Integer>> destroyer = new ArrayList<>(); //2
        ArrayList<Tuple<Integer, Integer>> cruiser = new ArrayList<>(); //3
        ArrayList<Tuple<Integer, Integer>> submarine = new ArrayList<>(); //3

        aircraftCarrier.add(new Tuple<>(0,0));
        aircraftCarrier.add(new Tuple<>(0,1));
        aircraftCarrier.add(new Tuple<>(0,2));
        aircraftCarrier.add(new Tuple<>(0,3));
        aircraftCarrier.add(new Tuple<>(0,4));

        battleship.add(new Tuple<>(3,3));
        battleship.add(new Tuple<>(4,3));
        battleship.add(new Tuple<>(5,3));
        battleship.add(new Tuple<>(6,3));

        destroyer.add(new Tuple<>(8,8));
        destroyer.add(new Tuple<>(8,9));

        cruiser.add(new Tuple<>(1,9));
        cruiser.add(new Tuple<>(2,9));
        cruiser.add(new Tuple<>(3,9));

        submarine.add(new Tuple<>(5,5));
        submarine.add(new Tuple<>(5,6));
        submarine.add(new Tuple<>(5,7));




        board.addShip(new Ship(aircraftCarrier));
        board.addShip(new Ship(battleship));
        board.addShip(new Ship(destroyer));
        board.addShip(new Ship(cruiser));
        board.addShip(new Ship(submarine));

        int turn = 1;

        System.out.println("Turn " + turn);

        System.out.println("Continue?");
        ;

        board.shoot(new Tuple<Integer,Integer>(5,5));
        board.shoot(new Tuple<Integer,Integer>(5,6));
        board.shoot(new Tuple<Integer,Integer>(5,7));
        board.shoot(new Tuple<Integer,Integer>(0,0));
        board.shoot(new Tuple<Integer,Integer>(9,9));

        boardGUI.update();
    }
}
