/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import view.Game;


public class GameObserver {
    Game game;

    public GameObserver(Game game) {
        this.game = game;
    }
    
    public void gameOver()
    {
       game.removeListener();
        JOptionPane.showMessageDialog(new JPanel(),"Game Over","Ops", JOptionPane.ERROR_MESSAGE);
    }

}
