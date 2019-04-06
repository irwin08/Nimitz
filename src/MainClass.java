import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class MainClass extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


        int width = 10;
        int height = 10;

        primaryStage.setTitle("Nimitz");

        StackPane root = new StackPane();

        GridPane grid = new GridPane();



        for(int row = 0; row < height; row++){
            for(int col = 0; col < width; col++){
                Rectangle rec = new Rectangle();
                rec.setWidth(25);
                rec.setHeight(25);
                rec.setFill(Color.WHITE);
                GridPane.setRowIndex(rec,row);
                GridPane.setColumnIndex(rec,col);
                grid.getChildren().addAll(rec);
            }
        }

        grid.setGridLinesVisible(true);
        Scene scene = new Scene(grid, 350, 250);


        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
