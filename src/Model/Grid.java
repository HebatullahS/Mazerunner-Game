package Model;

import static Model.Maze.maze;
import Model.bullets.SuperBullet;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.Game;

public class Grid {

    private Sprite[][] maze1;
    public static int[][] maze = new int[30][30];
    public BrickWall wall;
    public Bomb bomb;
    public Gift gift;
    public Character plane;
    public Game game;
    public Coin coin;
    public SuperBullet testBullet;

    public Grid(BrickWall wall, Bomb bomb, Gift gift, Coin coin) {
        this.wall = wall;
        this.bomb = bomb;
        this.gift = gift;
        this.coin = coin;
        maze1 = new Sprite[30][30];
        if (Game.flag == 0) {
            readfile("maze.txt");
            for (int i = 0; i < 30; i++) {
                for (int j = 0; j < 30; j++) {
                    int x = maze[i][j];
                    double randomNumber = Math.random();
                    if (x == 0) {
                        maze1[i][j] = wall;
                    } else if (x == 2) {
                        maze1[i][j] = bomb;
                    } else if (randomNumber < 0.08) {
                        maze1[i][j] = gift;
                    } else if (randomNumber < 0.1) {
                        maze1[i][j] = coin;
                    }

                }
            }
            int i = 29;
            for (int j = 0; j < 30; j++) {
                if (maze1[i][j] == null) {
                    plane = new Character(i, j);
                    break;
                }
            }

        } else if (Game.flag == 2) {
            readfile("save.txt");
            System.out.println("Model.Grid.<init>()");
            for (int i = 0; i < 30; i++) {
                for (int j = 0; j < 30; j++) {
                    int x = maze[i][j];;
                    if (x == 0) {
                        maze1[i][j] = wall;
                    } else if (x == 2) {
                        maze1[i][j] = bomb;
                    } else if (x == 3) {
                        maze1[i][j] = gift;
                    } else if (x == 4) {
                        maze1[i][j] = plane;
                    }

                }

            }
        }
    }

    public void drawGrid(Graphics g) {
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {

                if (maze1[i][j] != null) {
                    g.drawImage(maze1[i][j].image, j * 900 / 30, i * 900 / 30, 900 / 30, 900 / 30, null);

                }
            }

        }
        int i = plane.i;
        int j = plane.j;
        g.drawImage(plane.image, j * 900 / 30, i * 900 / 30, 900 / 30, 900 / 30, null);

        if (testBullet != null) {
            testBullet.draw(g);
        }

    }

    public boolean isBomb(int i, int j) {
        return maze1[i][j] instanceof Bomb;
    }

    public void removeBomb(int i, int j) {
        maze[i][j] = 0;
        maze1[i][j] = null;
    }

    public boolean isWall(int i, int j) {
        return maze1[i][j] instanceof BrickWall;
    }

    public boolean isGift(int i, int j) {
        return maze1[i][j] instanceof Gift;
    }

    public boolean isCharacter(int i, int j) {
        return maze1[i][j] instanceof Character;
    }

    public void readfile(String filename) {
        int i = 0, j = 0;
        try {
            try (Scanner sc = new Scanner(new File(filename))) {
                System.out.println("Model.Maze.file()");
                for (i = 0; i < 30; i++) {
                    for (j = 0; j < 30; j++) {
                        maze[i][j] = sc.nextInt();

                    }
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Maze.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
}
