package sample;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ColorPicker
{

    int height;
    int width;
    int size;
    Color fill;

    static protected GridPane grid = Main.colors;

    public ColorPicker(int height, int width, int size, Color fill)
    {
        this.height = height;
        this.width = width;
        this.size = size;
        this.fill = fill;
    }

    public Rectangle build()
    {
        Rectangle rec = new Rectangle();
        rec.setWidth(size);
        rec.setHeight(size);
        rec.setFill(fill);
       //rec.setStroke(Color.GREY);

        rec.setOnMouseClicked( event -> {
           Main.newcolor = fill;
        });


        return rec;
    }

    private void newfill()
    {
        Main.newcolor = fill;
    }




}
