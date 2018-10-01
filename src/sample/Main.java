package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    protected static GridPane grid = new GridPane();
    protected static GridPane colors = new GridPane();
    static BorderPane layout = new BorderPane();

    protected static Color original = Color.WHITE;
    protected static Color newcolor;

    @Override
    public void start(Stage primaryStage) throws Exception{

        int width = 1280; int height = 720;

        //  Tracks colors


        //  Color Picker
        Color picker[][] = {
            {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.INDIGO, Color.VIOLET},
            {Color.WHITE, Color.BLACK, Color.BROWN, Color.FUCHSIA, Color.CYAN, Color.MAGENTA, Color.GREY}
        };

        //  Boxes
        HBox hb = new HBox();
        VBox v1 = new VBox();
        VBox v2 = new VBox();

        v1.setMinSize(width/4, height);
        v2.setMinSize(width/4, height);

        colors.minHeight(20);
        colors.minWidth(70);

        //  Fill our layout
        layout.setCenter(grid);
        layout.setRight(v2);
        layout.setLeft(v1);
        layout.setTop(colors);


        VBox spacer = new VBox();
        spacer.setMinWidth((width/2) - (0.5)*(20*7));
        colors.add(spacer, 0, 0);
        //  Build our grids
        for(int i = 1; i < 8; i++)
        {
            for(int j = 1; j < 3; j++)
            {
                ColorPicker p = new ColorPicker(i, j, 20, picker[j-1][i-1]);
                Rectangle pick = p.build();
                colors.add(pick, i, j);
            }
        }

        for(int i = 0; i < 64; i++)
        {
            for(int j = 0; j < 64; j++)
            {
                Box b = new Box(i, j, 10, original);
                Rectangle rec = b.build();
            }
        }

        Scene scene = new Scene(layout,  width, height);

        primaryStage.setMinHeight(640);
        primaryStage.setMinWidth(640);

        primaryStage.setScene(scene);
        primaryStage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
}
