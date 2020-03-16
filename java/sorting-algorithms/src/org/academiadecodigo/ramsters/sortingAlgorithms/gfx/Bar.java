package org.academiadecodigo.ramsters.sortingAlgorithms.gfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Bar {

    int item;

    Rectangle rectangle;

    Canvas canvas;

    public Bar(int x, Canvas canvas) {

        this.canvas = canvas;

        item = (int) (Math.ceil(Math.random() * canvas.getRows()));

        int y = canvas.getRows() - item;

        rectangle = new Rectangle(

                Grid.colToX(x) + Grid.PADDING, Grid.rowToY(y) + Grid.PADDING, Grid.CELL_SIZE, Grid.rowToY(item)

        );

        rectangle.setColor(Color.BLUE);

        rectangle.draw();

    }

    public void replace(int to) {

        rectangle.translate(to, 0);

    }

    public int getItem() {

        return item;

    }

}
