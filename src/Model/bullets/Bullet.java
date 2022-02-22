/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.bullets;

import Model.BombType;
import Model.Grid;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Muhammad
 */
public abstract class Bullet {

    public enum Direction {
        up, down, right, left
    }
    Point position;
    Grid grid;
    String imgPath;

    public Bullet(Point point, String imgPath, int bulletsLeft, int maxBullets, Grid grid) {
        this.bulletsLeft = bulletsLeft;
        this.maxBullets = maxBullets;
        this.grid = grid;
        this.imgPath = imgPath;
        this.position = point;
    }
    int bulletsLeft;
    int maxBullets;

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public int getBulletsLeft() {
        return bulletsLeft;
    }

    public void setBulletsLeft(int bulletsLeft) {
        this.bulletsLeft = bulletsLeft;
    }

    public int getMaxBullets() {
        return maxBullets;
    }

    public void setMaxBullets(int maxBullets) {
        this.maxBullets = maxBullets;
    }
    boolean fired = false;
    public Timer timer;

    int oldJ;
    int oldI;

    public void fire(Direction dir) {
        fired = true;
        oldJ = grid.plane.j;
        oldI = grid.plane.i;
        this.position = new Point(grid.plane.j * 30, grid.plane.i * 30);
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int newX = (int) getPosition().getX();
                int newY = (int) getPosition().getY();
                switch (dir) {
                    case up: {
                        if (oldI - 1 < 0 || grid.isWall(oldI - 1, oldJ)) {
                            fired = false;
                            timer.stop();
                        }
                        newY -= 30;
                        setPosition(new Point(newX, newY));
                        if (grid.isBomb(oldI - 1, oldJ)) {
                            fired = false;
                            grid.removeBomb(oldI - 1, oldJ);
                            timer.stop();
                        }
                        oldI--;
                        break;
                    }
                    case down: {
                        if (grid.isWall(oldI + 1, oldJ)) {
                            fired = false;
                            timer.stop();
                        }
                        newY += 30;
                        setPosition(new Point(newX, newY));
                        if (grid.isBomb(oldI + 1, oldJ)) {
                            fired = false;
                            grid.removeBomb(oldI + 1, oldJ);
                            timer.stop();

                        }
                        oldI++;
                        break;
                    }

                    case right: {
                        if (grid.isWall(oldI, oldJ + 1)) {
                            fired = false;
                            timer.stop();
                        }
                        newX += 30;
                        setPosition(new Point(newX, newY));
                        if (grid.isBomb(oldI, oldJ + 1)) {
                            fired = false;
                            grid.removeBomb(oldI, oldJ + 1);
                            timer.stop();
                        }
                        oldJ++;
                        break;
                    }
                    case left: {
                        if (oldJ - 1 < 0 || grid.isWall(oldI, oldJ - 1)) {
                            fired = false;
                            timer.stop();
                        }
                        newX -= 30;
                        setPosition(new Point(newX, newY));
                        if (grid.isBomb(oldI, oldJ - 1)) {
                            fired = false;
                            grid.removeBomb(oldI, oldJ - 1);
                            timer.stop();
                        }
                        oldJ--;
                        break;
                    }
                }
            }
        });
        timer.start();
    }

    public static BufferedImage readImg(String path) {
        try {
            File test = new File(path);
            BufferedImage img = ImageIO.read(test);
            return img;
        } catch (IOException ex) {
            System.out.println("Invalid path for image.");
        }
        return null;
    }

    public void draw(Graphics g) {
        if (!fired) {
            return;
        }
        g.drawImage(readImg(imgPath), (int) getPosition().getX(), (int) getPosition().getY(), null);
    }
}
