/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.bullets;

import Model.Grid;
import java.awt.Point;

/**
 *
 * @author Muhammad
 */
public class SuperBullet extends Bullet {

    public SuperBullet(Grid grid) {
        super(new Point(grid.plane.j * 30, grid.plane.i * 30), "src/Images/bullet.png", 10, 10, grid);
    }

}
