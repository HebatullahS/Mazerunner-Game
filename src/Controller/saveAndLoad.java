/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Grid;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author first
 */
public class saveAndLoad {

    Grid grid;

    public saveAndLoad(Grid grid) {
        this.grid = grid;
    }

    public void save() throws IOException {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                if (grid.isWall(i, j)) {
                    builder.append("0 ");
                } else if (grid.isBomb(i, j)) {
                    builder.append("2 ");
                } else if (grid.isGift(i, j)) {
                    builder.append("3 ");
                } else if (grid.isCharacter(i, j)) {
                    builder.append("4 ");
                } else {
                    builder.append("1 ");
                }

            }
            builder.append("\n");
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("save.txt"));
        writer.write(builder.toString());//save the string representation of the board
        writer.close();

    }
}
