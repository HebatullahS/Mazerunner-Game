package view;

import Model.Bomb;
import Model.BrickWall;
import Model.Coin;
import Model.Gift;
import Model.Grid;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

    public Grid currentGrid;
    public int dimension = 30;
    public Grid grid;

    public GamePanel() {
        currentGrid = new Grid(new BrickWall(), new Bomb(), new Gift(), new Coin());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        currentGrid.drawGrid(g);
        
    }
   


}
