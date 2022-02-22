/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Grid;
import Model.bullets.Bullet;
import Model.bullets.SuperBullet;
import java.awt.Point;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Dina Alaa
 */
public class MovementObserver {

    Grid grid;
    String lastDirection;
    GameObserver gameObserver;
    public static int Lives = 5, Score = 0;

    public MovementObserver(Grid grid, GameObserver gameObserver) {
        this.grid = grid;
        this.gameObserver = gameObserver;
        lastDirection = "right";
    }

    public void move(int keyCode) {

        int oldJ = grid.plane.j;
        int oldI = grid.plane.i;

        switch (keyCode) {
            case KeyEvent.VK_UP:
                lastDirection = "up";
                if (oldI - 1 < 0) {
                    break;
                } else if (grid.isBomb(oldI - 1, oldJ)) {
                    Lives--;
                    grid.plane.i = oldI - 1;
                    if (Lives == 0) {
                        gameObserver.gameOver();
                    }

                } else if (grid.isWall(oldI - 1, oldJ)) {
                    break;
                } else {
                    grid.plane.i = oldI - 1;
                }

                break;
            case KeyEvent.VK_DOWN:
                lastDirection = "down";
                if (oldI + 1 > 29) {
                    break;
                } else if (grid.isBomb(oldI + 1, oldJ)) {
                    Lives--;
                    grid.plane.i = oldI + 1;

                    if (Lives == 0) {
                        gameObserver.gameOver();
                    }

                } else if (grid.isWall(oldI + 1, oldJ)) {
                    break;
                } else {
                    grid.plane.i = oldI + 1;
                }
                break;
            case KeyEvent.VK_LEFT:
                lastDirection = "left";
                if (oldJ - 1 < 0) {
                    break;
                } else if (grid.isBomb(oldI, oldJ - 1)) {
                    Lives--;
                    grid.plane.j = oldJ - 1;

                    if (Lives == 0) {
                        gameObserver.gameOver();
                    }

                } else if (grid.isWall(oldI, oldJ - 1)) {
                    break;
                } else {
                    grid.plane.j = oldJ - 1;
                }
                break;
            case KeyEvent.VK_RIGHT:
                lastDirection = "right";
                if (oldJ + 1 > 29) {
                    break;
                } else if (grid.isBomb(oldI, oldJ + 1)) {
                    Lives--;
                    grid.plane.j = oldJ + 1;

                    if (Lives == 0) {
                        gameObserver.gameOver();
                    }

                } else if (grid.isWall(oldI, oldJ + 1)) {
                    break;
                } else {
                    grid.plane.j = oldJ + 1;
                }
                break;
            case KeyEvent.VK_W: {
                grid.testBullet = new SuperBullet(grid);
                grid.testBullet.fire(Bullet.Direction.up);
                break;
            }
            case KeyEvent.VK_S: {
                grid.testBullet = new SuperBullet(grid);
                grid.testBullet.fire(Bullet.Direction.down);
                break;
            }
            case KeyEvent.VK_D: {
                grid.testBullet = new SuperBullet(grid);
                grid.testBullet.fire(Bullet.Direction.right);
                break;
            }
            case KeyEvent.VK_A: {
                grid.testBullet = new SuperBullet(grid);
                grid.testBullet.fire(Bullet.Direction.left);
                break;
            }

        }

    }

}
