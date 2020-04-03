package org.academiadecodigo.ramsters.sortingAlgorithms.gfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Bar {

    int item;

    Rectangle rectangle;

    Canvas canvas;

    int x;

    int y;

    public Bar(int x, Canvas canvas) {

        this.x = x;

        this.canvas = canvas;

        item = (int) (Math.ceil(Math.random() * canvas.getRows()));

        this.y = canvas.getRows() - item;

        rectangle = new Rectangle(

                Grid.colToX(x) + Grid.PADDING, Grid.rowToY(y) + Grid.PADDING, Grid.WIDTH_UNIT, Grid.rowToY(item)

        );

        rectangle.setColor(Color.WHITE);

        rectangle.draw();

    }

    public void replace(int newItem) {

        this.item = newItem;

        this.y = canvas.getRows() - item;

        rectangle.delete();

        rectangle = new Rectangle(

                Grid.colToX(x) + Grid.PADDING, Grid.rowToY(y) + Grid.PADDING, Grid.WIDTH_UNIT, Grid.rowToY(item)

        );

        rectangle.setColor(Color.GREEN);

        rectangle.draw();

    }

    public int getItem() {

        return item;

    }


}
