package sample;

import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Box
{

    int height;
    int width;
    int size;
    Color oldcolor;
    Color newcolor;
    protected static GridPane grid = Main.grid;

    public Box(int height, int width, int size, Color oldcolor)
    {
        this.height = height;
        this.width = width;
        this.size = size;
        this.oldcolor = oldcolor;
        newcolor = Main.newcolor;

    }

    public Rectangle build()
    {
        Rectangle rec = new Rectangle();
        rec.setWidth(size);
        rec.setHeight(size);
        rec.setFill(oldcolor);

        //rec.setStroke(Color.GREY);

        rec.setOnMouseEntered( event -> {
            rec.setFill(Main.newcolor);
        });

        rec.setOnMouseExited( event -> {
            rec.setFill(oldcolor);
        });

        rec.setOnMouseClicked( event -> {
            rec.setFill(Main.newcolor);
            newOld(Main.newcolor);
        });


        GridPane.setRowIndex(rec, width);
        GridPane.setColumnIndex(rec, height);
        grid.getChildren().addAll(rec);

        return rec;
    }

    private void newOld(Color c)
    {
        oldcolor = c;
    }


}
