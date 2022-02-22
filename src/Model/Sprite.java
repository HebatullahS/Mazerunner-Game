/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public abstract class Sprite {
    BufferedImage image;
    int elementDimension;
    
    public Sprite(String fileName) {
        try{
            image=ImageIO.read(new File(fileName));
            elementDimension=1;
        }
        catch(Exception e)
        {
            System.out.println("Image Not Found");
        }
    }
    
}
