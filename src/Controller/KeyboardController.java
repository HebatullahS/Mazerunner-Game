package Controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardController extends KeyAdapter {

    MovementObserver movementobserver;

    public KeyboardController(MovementObserver movementobserver) {
        this.movementobserver = movementobserver;
    }

    @Override
    public void keyPressed(KeyEvent ke) {

        int keyCode = ke.getKeyCode();
        movementobserver.move(keyCode);
    }
}
