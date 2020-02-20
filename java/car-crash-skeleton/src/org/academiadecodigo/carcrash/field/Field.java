package org.academiadecodigo.carcrash.field;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.input.KeyMappingProfile;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.ScreenCharacterStyle;
import com.googlecode.lanterna.screen.ScreenWriter;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;
import com.googlecode.lanterna.terminal.swing.TerminalAppearance;
import org.academiadecodigo.carcrash.cars.Car;
import org.academiadecodigo.carcrash.cars.CarType;

public final class Field {

    private static int width;
    private static int height;

    // Used to write to screen
    private static Screen screen;

    // Screen wrapper that preserves default options
    private static ScreenWriter screenWriter;

    private static ScreenWriter roadWriter;

    //This class is not supposed to be instantiated
    private Field() {
    }

    /**
     * Initializes the Screen
     *
     * @param width  screen width
     * @param height screen height
     */
    public static void init(int width, int height) {

        // Create the GUI
        screen = TerminalFacade.createScreen();

        // Set field size
        Field.width = width;
        Field.height = height;
        screen.setCursorPosition(null);
        screen.getTerminal().getTerminalSize().setColumns(width);
        screen.getTerminal().getTerminalSize().setRows(height);

        // Default screen writing options
        screenWriter = new ScreenWriter(screen);
        screenWriter.setBackgroundColor(Terminal.Color.BLUE);
        screenWriter.setForegroundColor(Terminal.Color.WHITE);

        // Road screen writer
        roadWriter = new ScreenWriter(screen);
        roadWriter.setBackgroundColor(Terminal.Color.WHITE);
        roadWriter.setForegroundColor(Terminal.Color.BLACK);

        screen.startScreen();

    }

    /**
     * Displays a group of cars in the screen
     *
     * @param cars an array of cars
     */
    public static void draw(Car[] cars) {

        screen.clear();

        for (Car c : cars) {

            switch (c.getLastMove()) {

                case UP:
                case DOWN:

                    for (int i = 0; i < Field.getHeight(); i++) {

                        roadWriter.drawString(c.getPos().getCol(), i, "\n|\n");

                    }

                    break;

                case RIGHT:
                case LEFT:

                    for (int i = 0; i < Field.getWidth(); i++) {

                        roadWriter.drawString(i, c.getPos().getRow(), "-");

                    }

                    break;

            }

        }

        for (Car c : cars) {

            if (c.isCrashed() != CarType.CRASHED) {

                screenWriter.drawString(c.getPos().getCol(), c.getPos().getRow(), c.toString());

            } else {

                screen.putString(c.getPos().getCol(), c.getPos().getRow(), c.toString(), Terminal.Color.WHITE, Terminal.Color.RED, ScreenCharacterStyle.Blinking);

            }

        }

        screen.refresh();

    }

    public static int getWidth() {

        return width;

    }

    public static int getHeight() {

        return height;

    }

}
