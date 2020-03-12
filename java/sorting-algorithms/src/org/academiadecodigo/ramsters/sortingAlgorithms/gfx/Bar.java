package org.academiadecodigo.ramsters.sortingAlgorithms.gfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Bar {

    int item;

    Rectangle rectangle;

    public Bar(int x, int y) {

        item = (int) (Math.ceil(Math.random() * 80));

        rectangle = new Rectangle(Grid.colToX(x), Grid.rowToY(y), Grid.CELL_SIZE, Grid.rowToY(item));

        rectangle.setColor(Color.BLUE);

        rectangle.fill();

    }

}
